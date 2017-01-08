package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyIndustryIdentifier;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyIndustryIdentifier;
import com.headstrong.npi.raas.xml.pojo.CmAttributeString;
import com.headstrong.npi.raas.xml.pojo.ExternalIdentifiers;
import com.headstrong.npi.raas.xml.pojo.Identifier;



/**
 * 
 * externalIdentifier
		    protected CmAttributeString lei;
    		protected List<Identifier> identifier;
		protected String id;
		protected CmAttributeString value;
		protected CmAttributeString type;
		
		protected List<AttributeCompanyIndustryIdentifier> industryIdentifier;     
		protected CompanyIndustryIdentifier value;
		
		protected String identifierType;
		protected String identifierValue;

 * 
 * @author 400219569
 *
 */
public class IdentifierConverter implements CustomConverter {

	
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {

		if( source == null) {
			return null;
		}
		ExternalIdentifiers raasIdentifier = null;
		List<AttributeCompanyIndustryIdentifier> cobsIdentifier = null;
		if(source instanceof ExternalIdentifiers) {
			
			raasIdentifier = ((ExternalIdentifiers)source);	// checked cast as this class is only for Identifier
			cobsIdentifier = ((List<AttributeCompanyIndustryIdentifier>)destination);
			if(cobsIdentifier == null) {
				cobsIdentifier = new ArrayList<AttributeCompanyIndustryIdentifier>();
			} 
			
			return mapProfileIdentifierToCobsIdentifier(raasIdentifier, cobsIdentifier);
			
		} else if(((List<?>)source).size() > 0 && ((List<?>)source).get(0) instanceof AttributeCompanyIndustryIdentifier){
			cobsIdentifier = ((List<AttributeCompanyIndustryIdentifier>)source);
			raasIdentifier = ((ExternalIdentifiers)destination);	// checked cast as this class is only for Identifiers
			
			if(raasIdentifier == null) {
				raasIdentifier = new ExternalIdentifiers();
			} 
			
			return mapCobsIdentifierToRaasIdentifier(cobsIdentifier , raasIdentifier);
		}
//		 else {
//				throw new MappingException("Converter IdentifierConverter"
//						+ "used incorrectly. Arguments passed in were:"
//						+ source + " and " + destination);
//			}
		return null;
	}

	/**
	 * Copy data from {@code Identifier} Class to {@code AttributeCompanyIndustryIdentifier} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapProfileIdentifierToCobsIdentifier(ExternalIdentifiers source , List<AttributeCompanyIndustryIdentifier> destination) {
		
		for (Identifier c : source.getIdentifier()) {
			
			AttributeCompanyIndustryIdentifier identifier = new AttributeCompanyIndustryIdentifier();
			CompanyIndustryIdentifier cobsIdentifier = new CompanyIndustryIdentifier();
			
			if(c.getType() != null && c.getType().getValue() != null ) {
				
				if(c.getType().getValue().equalsIgnoreCase("LEI")) {
					if(source.getLei()!= null) {
						cobsIdentifier.setIdentifierValue(Utils.isNotEmpty(source.getLei().getValue()) ? source.getLei().getValue() : "");
					}
					cobsIdentifier.setIdentifierType("LEI");
				}else {
					if(c.getValue() != null) {
						cobsIdentifier.setIdentifierValue(Utils.isNotEmpty(c.getValue().getValue()) ? c.getValue().getValue() : "");
					}
					cobsIdentifier.setIdentifierType(Utils.isNotEmpty(c.getType().getValue()) ? c.getType().getValue() : "");
				}
			}
			
			identifier.setValue(cobsIdentifier);
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(c, identifier);
			destination.add(identifier);
			
		}
		return destination;
	
	}
	
	/**
	 * Copy data from cobs {@code AttributeCompanyIndustryIdentifier} Class to raas {@code Identifier} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapCobsIdentifierToRaasIdentifier(List<AttributeCompanyIndustryIdentifier> source , ExternalIdentifiers destination) {
		List<Identifier> identifiers = new ArrayList<Identifier>();
		for (AttributeCompanyIndustryIdentifier c : source) {
			CompanyIndustryIdentifier cobsIdentifier = c.getValue();
			Identifier raaSIdentifier = new Identifier();
//			Cobs element does not inherit super type Attribute
			if(cobsIdentifier != null && Utils.isNotEmpty(cobsIdentifier.getIdentifierType())) {
				if(cobsIdentifier.getIdentifierType().equalsIgnoreCase("LEI")) {
					raaSIdentifier.setType(Utils.getCmAttrString("LEI"));
					destination.setLei(Utils.getCmAttrString((Utils.isNotEmpty(cobsIdentifier.getIdentifierValue())) ? cobsIdentifier.getIdentifierValue() : ""));
				} else {
					raaSIdentifier.setValue(Utils.getCmAttrString((Utils.isNotEmpty(cobsIdentifier.getIdentifierValue())) ? cobsIdentifier.getIdentifierValue() : ""));
					raaSIdentifier.setType(Utils.getCmAttrString(cobsIdentifier.getIdentifierType()));
				}
			}
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(c, raaSIdentifier);
			identifiers.add(raaSIdentifier);
		}
		
		return destination;
	}

}
