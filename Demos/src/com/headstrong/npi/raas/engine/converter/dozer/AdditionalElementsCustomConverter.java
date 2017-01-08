package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.Attribute;
import com.headstrong.npi.raas.cobs.xml.pojo.Comment;
import com.headstrong.npi.raas.cobs.xml.pojo.Document;
import com.headstrong.npi.raas.cobs.xml.pojo.Exception;
import com.headstrong.npi.raas.xml.pojo.CmAttribute;
import com.headstrong.npi.raas.xml.pojo.CommentType;
import com.headstrong.npi.raas.xml.pojo.Comments;
import com.headstrong.npi.raas.xml.pojo.ReferenceDocuments;

public class AdditionalElementsCustomConverter implements CustomConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdditionalElementsCustomConverter.class);
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		
		if(source == null) {
			return null;
		}
		CmAttribute cmAttribute = null;
		Attribute attribute = null;
		if(source instanceof CmAttribute) {
			cmAttribute = (CmAttribute)source;
			attribute = (Attribute)destination;
			if(attribute == null) {
				try {
//					lazy creation of instance.
					attribute  = (Attribute)destClass.newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
					LOGGER.error("creation of Attribute instance in AdditionalElementsCustomConverter : "+e.getMessage());
				} catch (IllegalAccessException e) {
					LOGGER.error("Access of Attribute instance in AdditionalElementsCustomConverter : "+e.getMessage());
				}
			}
			return mapElementsFromRaasToCobs(cmAttribute , attribute);
		} else if (source instanceof Attribute) {
			attribute = (Attribute)source;
			cmAttribute = (CmAttribute)destination;
			if(cmAttribute == null) {
				try {
//					lazy creation of instance.
					cmAttribute  = (CmAttribute)destClass.newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
					LOGGER.error("creation of CmAttribute instance in AdditionalElementsCustomConverter : "+e.getMessage());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					LOGGER.error("Access of CmAttribute instance in AdditionalElementsCustomConverter : "+e.getMessage());
				}
			}
			return mapElementsFromCobsToRaas(attribute, cmAttribute);
		}
		
		return null;
		
	}
	
	public static Attribute mapElementsFromRaasToCobs(CmAttribute source , Attribute dest)	{
		
		if(source != null && dest != null) {
//			ReferenceDocument
			ReferenceDocuments referenceDoc = source.getReferenceDocuments();
			List<Document> cobsDocList = new ArrayList<Document>();
			if(referenceDoc != null) {
				
				List<com.headstrong.npi.raas.xml.pojo.ReferenceDocuments.Document> raasDoc = referenceDoc.getDocument();
				if(raasDoc != null && raasDoc.size() > 0) {
//				From Remediation map the first document as primary in COBS
					int  i = 0;
					for(com.headstrong.npi.raas.xml.pojo.ReferenceDocuments.Document document : raasDoc) {
						Document cobsDoc = new Document();
						if(i==0) {
							cobsDoc.setPrimary(true);
						} else {
							cobsDoc.setPrimary(false);
						}
						cobsDoc.setReference(document.getMCPID());
						cobsDoc.setName(document.getName());
						
						cobsDocList.add(cobsDoc);
						i++;
						
					}
				}
			}
//			ChallengeComment
			if(Utils.isNotEmpty(source.getChallengeComment())) {
				dest.setChallengeComment(source.getChallengeComment());
			}
//			Comments
			List<Comments> raasComList = source.getComments();
			List<Exception> exceptionList = new ArrayList<Exception>();
			List<Comment> commentList = new ArrayList<Comment>();
			if(raasComList != null && raasComList.size() > 0) {
				for(Comments comments : raasComList) {
					if(comments.getType().equals(CommentType.MISSING_INFO)) {
						Exception cobsExceptions = new Exception();
						cobsExceptions.setDate(comments.getDate());
						cobsExceptions.setException(comments.getComment());
						cobsExceptions.setUser(comments.getBy());
						exceptionList.add(cobsExceptions);
					} else {
						Comment cobsComments = new Comment();
						cobsComments.setDate(comments.getDate());
						cobsComments.setComment(comments.getComment());
						cobsComments.setUser(comments.getBy());
						commentList.add(cobsComments);
					}
					
				}
			}
			dest.setDocument(cobsDocList);
			dest.setComment(commentList);
			dest.setException(exceptionList);
		}
		return dest;
		
	}
	
	public static CmAttribute mapElementsFromCobsToRaas(Attribute source , CmAttribute dest) {
		
		if(source != null && dest != null) {
			
//			Document 
			List<Document> documents = source.getDocument();
			// From COBS find the document marked as primary["true"] and map that as the first Document in Remediation.
			int i = 1;	
			ReferenceDocuments ref = new ReferenceDocuments();
			if(documents != null && documents.size() > 0 ) {
				List<com.headstrong.npi.raas.xml.pojo.ReferenceDocuments.Document> raasDocList = new ArrayList<com.headstrong.npi.raas.xml.pojo.ReferenceDocuments.Document>();
				for(Document doc: documents) {
					com.headstrong.npi.raas.xml.pojo.ReferenceDocuments.Document raasDoc = new com.headstrong.npi.raas.xml.pojo.ReferenceDocuments.Document();
					raasDoc.setMCPID(doc.getReference());
					raasDoc.setName(doc.getName());
					if(doc.isPrimary()) {
						raasDocList.add(0,raasDoc);
					} else {
						raasDocList.add(i,raasDoc);
						i++;
					}
					
				}
				ref.setDocument(raasDocList);
			}
			

//			challengeComment
			if(Utils.isNotEmpty(source.getChallengeComment())) {
				dest.setChallengeComment(source.getChallengeComment());
			}

//			Missing Info Comment
			List<com.headstrong.npi.raas.cobs.xml.pojo.Exception> exceptionList = source.getException();
			List<Comments> raasCommList = new ArrayList<Comments>();
			if(exceptionList != null && exceptionList.size() > 0) {
				for(com.headstrong.npi.raas.cobs.xml.pojo.Exception  exception : exceptionList) {
					Comments raasComments = new Comments();
					raasComments.setDate(exception.getDate());
					raasComments.setComment(exception.getException());
					raasComments.setBy(exception.getUser());
					raasComments.setType(CommentType.MISSING_INFO);
					raasCommList.add(raasComments);
				}
			}
//			Bank Notes
			List<com.headstrong.npi.raas.cobs.xml.pojo.Comment> commentList = source.getComment();
			if(exceptionList != null && exceptionList.size() > 0) {
				for(com.headstrong.npi.raas.cobs.xml.pojo.Comment  cobsComment : commentList) {
					Comments bankNotes = new Comments();
					bankNotes.setDate(cobsComment.getDate());
					bankNotes.setComment(cobsComment.getComment());
					bankNotes.setBy(cobsComment.getUser());
					bankNotes.setType(CommentType.NOTES);
					raasCommList.add(bankNotes);
				}
			}
			
			dest.setReferenceDocuments(ref);
			dest.setComments(raasCommList);
			
			
		}
		return dest;
	}
	
	

}
