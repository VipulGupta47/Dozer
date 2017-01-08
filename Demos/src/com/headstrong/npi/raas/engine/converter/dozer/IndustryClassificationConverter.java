package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBusinessActivityIndustryCode;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryIndustryCodeType;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeString;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyBusinessActivityIndustryCode;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryIndustryCodeType;
import com.headstrong.npi.raas.xml.pojo.CmAttributeString;
import com.headstrong.npi.raas.xml.pojo.IndustryClassification;
import com.headstrong.npi.raas.xml.pojo.IndustryClassificationType;


/**
 * protected List<Entity.BusinessActivities.IndustryClassifications.IndustryClassification> industryClassification;
       	  	      protected String id;
			    protected IndustryClassificationType type;
			    protected CmAttributeString value;
			    protected CmAttributeString desc;
			    protected CmAttributeOption isPrimary;
			    protected CmAttributeString code;
 * 
 *  protected List<AttributeCompanyBusinessActivityIndustryCode> businessActivityIndustryCode;
            protected CompanyBusinessActivityIndustryCode value;
           protected AttributeString industryCode;
	    protected AttributeDictionaryIndustryCodeType industryCodeType;
	    protected AttributeString industryCodeDescription; 
 * 
 * @author 400219569
 *
 */
public class IndustryClassificationConverter implements CustomConverter {

	
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {

		if( source == null || ((List<?>)source).size() < 1) {	// source is always list
			return null;
		}
		List<IndustryClassification> raasIndustryInfo = null;
		List<AttributeCompanyBusinessActivityIndustryCode> cobsIndustryCode = null;
		if(((List<?>)source).get(0) instanceof IndustryClassification) {
			
			raasIndustryInfo = ((List<IndustryClassification>)source);	// checked cast as this class is only for IndustryClassification
			cobsIndustryCode = ((List<AttributeCompanyBusinessActivityIndustryCode>)destination);
			if(cobsIndustryCode == null) {
				cobsIndustryCode = new ArrayList<AttributeCompanyBusinessActivityIndustryCode>();
			} 
			
			return mapProfileIndustryToCobsIndustryCode(raasIndustryInfo, cobsIndustryCode);
			
		} else if(((List<?>)source).get(0) instanceof AttributeCompanyBusinessActivityIndustryCode){
			cobsIndustryCode = ((List<AttributeCompanyBusinessActivityIndustryCode>)source);
			raasIndustryInfo = ((List<IndustryClassification>)destination);	// checked cast as this class is only for IndustryClassification
			
			if(raasIndustryInfo == null) {
				raasIndustryInfo = new ArrayList<IndustryClassification>();
			} 
			
			return mapCobsIndustryCodeToRaasIndustry(cobsIndustryCode , raasIndustryInfo);
		}
//		else {
//			throw new MappingException("Converter IndustryClassificationConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ source + " and " + destination);
//		}
		return null;
	}

	/**
	 * Copy data from {@code IndustryClassification} Class to {@code AttributeCompanyBusinessActivityIndustryCode} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapProfileIndustryToCobsIndustryCode(List<IndustryClassification> source , List<AttributeCompanyBusinessActivityIndustryCode> destination) {
		
		for (IndustryClassification c : source) {
			
			AttributeCompanyBusinessActivityIndustryCode industryCode = new AttributeCompanyBusinessActivityIndustryCode();
			CompanyBusinessActivityIndustryCode cobsIndustryCode = new CompanyBusinessActivityIndustryCode();

			if(c.getCode() != null) {
				cobsIndustryCode.setIndustryCode(Utils.getAttributeStringValue(c.getCode()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(c.getCode(), cobsIndustryCode.getIndustryCode());
			}
			if(c.getDesc() != null) {
				cobsIndustryCode.setIndustryCodeDescription(Utils.getAttributeStringValue(c.getDesc()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(c.getDesc(), cobsIndustryCode.getIndustryCodeDescription());
			}
//			Enum don`t have super class CmAttribute
			if(c.getType() != null) {

				AttributeDictionaryIndustryCodeType industryCodeType = new AttributeDictionaryIndustryCodeType();
				industryCodeType.setValue(DictionaryIndustryCodeType.fromValue(c.getType().value()));
				cobsIndustryCode.setIndustryCodeType(industryCodeType);
				industryCode.setValue(cobsIndustryCode);
				
			}
			
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(c, industryCode);
			
			destination.add(industryCode);
			
		}
		return destination;
	
	}
	
	/**
	 * Copy data from cobs {@code AttributeCompanyBusinessActivityIndustryCode} Class to raas {@code IndustryClassification} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapCobsIndustryCodeToRaasIndustry(List<AttributeCompanyBusinessActivityIndustryCode> source , List<IndustryClassification> destination) {
		for (AttributeCompanyBusinessActivityIndustryCode c : source) {
			
			CompanyBusinessActivityIndustryCode cobsIndustryCode = c.getValue();
			IndustryClassification raaSIndustry = new IndustryClassification();
			
			if(cobsIndustryCode.getIndustryCodeDescription() != null) {
				raaSIndustry.setDesc(Utils.getCmAttrString(cobsIndustryCode.getIndustryCodeDescription().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(cobsIndustryCode.getIndustryCodeDescription(), raaSIndustry.getDesc());
			}
			if(cobsIndustryCode.getIndustryCode() != null) {
				raaSIndustry.setCode(Utils.getCmAttrString(cobsIndustryCode.getIndustryCode().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(cobsIndustryCode.getIndustryCode(), raaSIndustry.getCode());
			}
//			Enum dont have super class CmAttribute
			if(cobsIndustryCode.getIndustryCodeType() != null && cobsIndustryCode.getIndustryCodeType().getValue() != null) {
				raaSIndustry.setType(IndustryClassificationType.fromValue(cobsIndustryCode.getIndustryCodeType().getValue().value()));
			}
			
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(c, raaSIndustry);
			destination.add(raaSIndustry);
		}
		return destination;
	}

}
