package com.headstrong.dozer.poc;


import java.io.ByteArrayInputStream;
import java.io.File;







import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;















import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.DozerEventListener;
import org.dozer.Mapper;
import org.dozer.classmap.MappingFileData;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.headstrong.npi.raas.JAXBContextProvider;
import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.Case;
import com.headstrong.npi.raas.cobs.xml.pojo.ChallengeCase;
import com.headstrong.npi.raas.cobs.xml.pojo.Company;
import com.headstrong.npi.raas.cobs.xml.pojo.Entity;
import com.headstrong.npi.raas.cobs.xml.pojo.FormationCase;
import com.headstrong.npi.raas.cobs.xml.pojo.FullReviewCase;
import com.headstrong.npi.raas.engine.converter.dozer.AdditionalElementEventMapper;
import com.headstrong.npi.raas.engine.utility.XmlUtil;
import com.headstrong.npi.raas.xml.pojo.Country;
import com.headstrong.npi.raas.xml.pojo.Entity.BearerShares;
import com.headstrong.npi.raas.xml.pojo.Entity.BusinessActivities;
import com.headstrong.npi.raas.xml.pojo.Entity.CoreInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.EntityNames;
import com.headstrong.npi.raas.xml.pojo.Entity.FinancialInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.Formation;
import com.headstrong.npi.raas.xml.pojo.Entity.LegalHierachy;
import com.headstrong.npi.raas.xml.pojo.Entity.LicenseInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.ListedInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.PlaceOfBusiness;
import com.headstrong.npi.raas.xml.pojo.Entity.RegistrationInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.RegulatedInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.RegulatorInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.TradingInformation;
import com.headstrong.npi.raas.xml.pojo.EntityAliases;
//import com.headstrong.npi.raas.cobs.xml.pojo.CobCmData;
//import com.headstrong.npi.raas.cobs.xml.pojo.EntityProfile;
import com.headstrong.npi.raas.xml.pojo.RemediationFile;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile.ProfileStatusInfo;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile.RefData;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile.Risk;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile.Risk.CalculatedRisk;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile.Risk.FinalRisk;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile.Risk.OriginalRisk;
import com.headstrong.npi.raas.xml.pojo.RequestType;
import com.headstrong.npi.raas.xml.pojo.TaxInfo;

public class BeanConvertionPOC {

	
	public static void main(String... args) throws JAXBException, DatatypeConfigurationException, ParserConfigurationException, TransformerException, SAXException, IOException {

		System.out.println();
//		System.out.println(toUnsignedString(104 , 7));
//		DozerBeanMapper m = (DozerBeanMapper)DozerBeanMapperSingletonWrapper.getInstance();
//		List<DozerEventListener> l= new ArrayList<DozerEventListener>();
//		AdditionalElementEventMapper eventMapper = new AdditionalElementEventMapper();
//		l.add(eventMapper);
//		m.setEventListeners(l);
//		Object obj = getCobsBean();
//		RemediationProfile r = null;
//		ProfileStatusInfo info = new ProfileStatusInfo();
//		System.out.println((obj instanceof FullReviewCase));
//		r = m.map(obj, RemediationProfile.class);
//		if(obj instanceof ChallengeCase) {
//			Case challenge = ((ChallengeCase)obj);
//			r = m.map(challenge, RemediationProfile.class);
//			info.setRequestType(RequestType.CHALLENGE);
//		} else if (obj instanceof FormationCase) {
//			Case formation = ((FormationCase)obj);
//			r = m.map(formation, RemediationProfile.class);
//			info.setRequestType(RequestType.FORMATION);
//		} else if(obj instanceof FullReviewCase) {
//			Case fullReview = ((FullReviewCase)obj);
//			r = m.map(fullReview, RemediationProfile.class);
//			info.setRequestType(RequestType.FULL_REVIEW);
//		}
//		
//		r.setProfileStatusInfo(info);
//		
//		System.out.println(r);
//		Case cobsCase= null;  
//		if(r.getProfileStatusInfo() == null) {
////			return null;
//		}
//		RequestType type = r.getProfileStatusInfo().getRequestType();
//		if(type.value().equalsIgnoreCase(RequestType.CHALLENGE.value())) {
//			cobsCase = m.map(r, ChallengeCase.class);
//		} else if(type.value().equalsIgnoreCase(RequestType.FORMATION.value())) {
//			cobsCase = m.map(r, FormationCase.class);
//		} else if(type.value().equalsIgnoreCase(RequestType.FULL_REVIEW.value())) {
//			cobsCase = m.map(r, FullReviewCase.class);
//		}
//		
//		System.out.println(cobsCase);
//		
		
//		Object obj = getCobsBean();
//		Document document = convertCaseBeanToXMLDoc((Case)obj);
//		String s = domToString(document);
//		System.out.println(s);
//		document = stringToDom(s);
//		System.out.println(document);
	}
	
	/**
     * Convert the integer to an unsigned number.
     */
    private static String toUnsignedString(int i, int shift) {
	char[] buf = new char[32];
	int charPos = 32;
	int radix = 1 << shift;
	int mask = radix - 1;
	do {
	    buf[--charPos] = digits[i & mask];
	    i >>>= shift;
	} while (i != 0);

	return new String(buf, charPos, (32 - charPos));
    }
    
    /**
     * All possible chars for representing a number as a String
     */
    final static char[] digits = {
	'0' , '1' , '2' , '3' , '4' , '5' ,
	'6' , '7' , '8' , '9' , 'a' , 'b' ,
	'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
	'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
	'o' , 'p' , 'q' , 'r' , 's' , 't' ,
	'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
	
	
	protected static String domToString(Document _document)
            throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(_document);
        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        transformer.transform(source, result);
        return sw.toString();
    }
	
	public static Document convertCaseBeanToXMLDoc(Case reqXml) throws JAXBException, ParserConfigurationException {
		
		JAXBContext context = JAXBContextProvider.COBCMDATA_INSTANCE.getContext();
		Marshaller m = context.createMarshaller();
		QName qname = new QName("www.markit.com", "case");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		JAXBElement<Case> rootElement = new JAXBElement<Case>(qname, Case.class, reqXml);
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(rootElement, document);
		return document;
	}
	
	 protected static Document stringToDom(String xmlSource)
	            throws SAXException, ParserConfigurationException, IOException {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        ByteArrayInputStream inputStream = new ByteArrayInputStream(
	                xmlSource.getBytes("UTF-8"));
	        Document document = builder.parse(inputStream);
	        return document;
	    }
	
	@SuppressWarnings("rawtypes")
	public static Object getCobsBean() throws JAXBException {
		File f = new File("D:/Users/400219569/RAAS/Document/XSD/cobs xml/Sample/cob_cm_full_review_sample_4.xml");
		JAXBContext context = JAXBContextProvider.COBCMDATA_INSTANCE.getContext();
		Object file =  context.createUnmarshaller().unmarshal(f);
		return ((JAXBElement)file).getValue();
	}
	
//	@SuppressWarnings("unused")
//	private RemediationFile createRemediationFromCobsFile(Case caseObj) {
//		RemediationFile remediationFile = new RemediationFile();
//		if (caseObj != null ) {
//			String date = XmlUtil.XMLGregorianCalendartoString(caseObj.getCreatedDT());
//			remediationFile.setPublicationDateTime(date == null ? "" : date);
////			if(info.getReferenceId().trim().length() > 0 ) 
////			remediationFile.setPublicationId(Integer.parseInt(info.getReferenceId()));
////			remediationFile.setRequestType(M);
////			remediationFile.setClient(Utils.setEmptyIfNull(info.getSenderIdentification()));
//			
//			RemediationProfile remediationProfile = new RemediationProfile();
//			Entity caseEntity = caseObj.getEntityProfile().getValue();
//			if(null != caseEntity) {
//				com.headstrong.npi.raas.xml.pojo.Entity raasEntity = new com.headstrong.npi.raas.xml.pojo.Entity();
//				
//				CoreInformation raasCoreInformation = new CoreInformation();
//				raasCoreInformation.setLegalName(Utils.getCmAttrString(((Company)caseEntity).getLegalName().getValue()));
//				raasCoreInformation.setEntityAliases(new EntityAliases());
//				raasCoreInformation.setIndustryClassifications(new com.headstrong.npi.raas.xml.pojo.Entity.CoreInformation.IndustryClassifications());
//				raasCoreInformation.setTaxInfo(new TaxInfo());
//				
//				raasEntity.setCoreInformation(raasCoreInformation);
//				raasEntity.setAddresses(new Addresses());
//				raasEntity.setTradingInformation(new TradingInformation());
//				raasEntity.setEntityNames(new EntityNames());
//				
//				Formation formation = new Formation();
//				formation.setEntityId(Utils.getCmAttrString(((Company)caseEntity).getMei()));
//				formation.setLegalName(Utils.getCmAttrString(((Company)caseEntity).getLegalName().getValue()));
//				formation.setEntityType(Utils.getCmAttrEntityType(((Company)caseEntity).getEntityType().getValue().value()));
//				raasEntity.setFormation(formation);
//				
//				raasEntity.setRegistrationInformation(new RegistrationInformation());
//				raasEntity.setListedInformation(new ListedInformation());
//				raasEntity.setLicenseInformation(new LicenseInformation());
//				raasEntity.setLegalHierachy(new LegalHierachy());
//				raasEntity.setRegulatedInformation(new RegulatedInformation());
//				raasEntity.setRegulatorInformation(new RegulatorInformation());
//				raasEntity.setProductInformation(new ProductInformation());
//				raasEntity.setBearerShares(new BearerShares());
//				
//				BusinessActivities businessActivities = new BusinessActivities();
//				raasEntity.setBusinessActivities(businessActivities);
//				raasEntity.setPlaceOfBusiness(new PlaceOfBusiness());
//				raasEntity.setFinancialInformation(new FinancialInformation());
//				remediationProfile.setEntity(raasEntity);
//				
//				RefData refData = new RefData();
//				refData.setJurisdiction(Country.fromValue(caseObj.getBookingJurisdiction().get(0).value()));
//				refData.setProducts(new Products());
//				remediationProfile.setRefData(refData);
//				
//				Risk risk = new Risk();
//				OriginalRisk originalRisk = new OriginalRisk();
//				originalRisk.setRiskValue("Low");
//				risk.setOriginalRisk(originalRisk);
//				CalculatedRisk calculatedRisk = new CalculatedRisk();
//				calculatedRisk.setRiskValue("Low");
//				risk.setCalculatedRisk(calculatedRisk);
//				FinalRisk finalRisk = new FinalRisk();
//				finalRisk.setRiskValue("Low");
//				risk.setFinalRisk(finalRisk);
//				remediationProfile.setRisk(risk);
//				
//				ProfileStatusInfo profileStatusInfo = new ProfileStatusInfo();
//				remediationProfile.setProfileStatusInfo(profileStatusInfo);
//				
//				remediationProfile.setAdditionalAttribute(new AdditionalAttribute());
//			}
//			remediationFile.setRemediationProfile(remediationProfile);
//		}
//		return remediationFile;
//		
//	}
//	
//	
}
