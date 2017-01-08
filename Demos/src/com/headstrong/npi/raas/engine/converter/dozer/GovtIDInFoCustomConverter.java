package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;

import com.headstrong.npi.raas.DateConversion;
import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyGovernmentIDInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDate;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryGovernmentIssuedIDType;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyGovernmentIDInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryGovernmentIssuedIDType;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.GovtIDInfo;

public class GovtIDInFoCustomConverter  implements CustomConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		
		if( source == null || ((List<?>)source).size() < 1 ) {
			return null;
		}
		List<GovtIDInfo> raasGovtIdInfo = null;
		List<AttributeCompanyGovernmentIDInfo> cobsGovtIdInfo = null;
		if(((List<?>)source).get(0) instanceof Address){
		
		 raasGovtIdInfo = ((List<GovtIDInfo>)source);
		 cobsGovtIdInfo = ((List<AttributeCompanyGovernmentIDInfo>)destination);
		 if(cobsGovtIdInfo == null) {
			 cobsGovtIdInfo = new ArrayList<AttributeCompanyGovernmentIDInfo>();
		 }
		
		return mapProfileGovtInfoToCobsGovtInfo(raasGovtIdInfo, cobsGovtIdInfo);
		} else if(((List<?>)source).get(0) instanceof AttributeCompanyGovernmentIDInfo){
			cobsGovtIdInfo = ((List<AttributeCompanyGovernmentIDInfo>)source);
			 raasGovtIdInfo = ((List<GovtIDInfo>)destination);
			 if(raasGovtIdInfo == null) {
				 raasGovtIdInfo = new ArrayList<GovtIDInfo>();
			 }
			return mapCobsGovtInfoToProfileGovtInfo(cobsGovtIdInfo , raasGovtIdInfo);
		}
//		 else {
//				throw new MappingException("Converter AddressCustomConverter "
//						+ "used incorrectly. Arguments passed in were:"
//						+ destination + " and " + source);
//			}
		return null;
	}

	/**
	 * Map Address to Cob Address. 
	 * @param source
	 * @param destination
	 * @return List of {@code Contact}
	 */
	public Object mapProfileGovtInfoToCobsGovtInfo(List<GovtIDInfo> source , List<AttributeCompanyGovernmentIDInfo> destination) {

		for (GovtIDInfo raasGovtInfo : source) {
			 
			AttributeCompanyGovernmentIDInfo cobaAttrCompanyGovt = new AttributeCompanyGovernmentIDInfo();
			CompanyGovernmentIDInfo cobaCompanyGovt = new CompanyGovernmentIDInfo();
			
			AttributeDictionaryGovernmentIssuedIDType issuedIDType = null;
			if(Utils.isNotEmpty(raasGovtInfo.getGovtIDType())) {
				issuedIDType = new AttributeDictionaryGovernmentIssuedIDType();
				issuedIDType.setValue(DictionaryGovernmentIssuedIDType.fromValue(raasGovtInfo.getGovtIDType()));
			}
			cobaCompanyGovt.setIdType(issuedIDType);
			
			cobaCompanyGovt.setIdNumber(Utils.getAttributeStringValue(Utils.isNotEmpty(raasGovtInfo.getGovtIDNum()) ? raasGovtInfo.getGovtIDNum(): null));
			
			AttributeDate attributeDate = null;
			if(Utils.isNotEmpty(raasGovtInfo.getGovtIDApplDate())) {
				attributeDate = new AttributeDate();
				Date date = DateConversion.convertStringToDate(raasGovtInfo.getGovtIDApplDate() ,DateConversion.getDateTimeFormatUs4());
				if(date == null)return null;
				attributeDate.setValue(DateConversion.asXMLGregorianCalendar(date));
			}
			cobaCompanyGovt.setAppliedForDate(attributeDate);
			
			cobaAttrCompanyGovt.setValue(cobaCompanyGovt);
			
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(raasGovtInfo, cobaAttrCompanyGovt);
			
			destination.add(cobaAttrCompanyGovt);
		}
		return destination;
	}

	/**
	 * Map cobs Address to raas Address. 
	 * 
	 * @param source
	 * @param destination
	 * @return List of raas Address
	 */
	public Object mapCobsGovtInfoToProfileGovtInfo(List<AttributeCompanyGovernmentIDInfo>source , List<GovtIDInfo> destination) {
		
		for (AttributeCompanyGovernmentIDInfo cobaAttrCompanyGovt : source) {
			 
			CompanyGovernmentIDInfo cobaCompanyGovt = cobaAttrCompanyGovt.getValue();
			GovtIDInfo raasGovtInfo = new GovtIDInfo();
			if(cobaCompanyGovt != null) {
				raasGovtInfo.setGovtIDNum((cobaCompanyGovt.getIdNumber()!=null) ? cobaCompanyGovt.getIdNumber().getValue() : null);
				raasGovtInfo.setGovtIDType((cobaCompanyGovt.getIdType()!=null) ? cobaCompanyGovt.getIdType().getValue().value() : null);
				String date = null;
				if(cobaCompanyGovt.getAppliedForDate()!=null) {
					date = DateConversion.XMLGregorianCalendartoString(cobaCompanyGovt.getAppliedForDate().getValue() , DateConversion.getDateTimeFormatUs4());
				}
				raasGovtInfo.setGovtIDApplDate(date);
			}
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(cobaAttrCompanyGovt, raasGovtInfo);
			destination.add(raasGovtInfo);
		}
		return destination;

	}
}
