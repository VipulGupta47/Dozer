package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompany;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBeneficialOwner;
import com.headstrong.npi.raas.cobs.xml.pojo.Company;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipCorporate;

public class UltimateParentCustomConverter implements CustomConverter {


	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination,Object source, 
			Class<?> destinationClass,Class<?> sourceClass) {
		
		if( source == null || ((List<?>)source).size() < 1) {	// source is always list
			return null;
		}
		List<OwnershipCorporate> raasOwnershipCorporates = null;
		List<AttributeCompany> cobsBeneficialOwners = null;
		if(((List<?>)source).get(0) instanceof OwnershipCorporate) {
			
			raasOwnershipCorporates = ((List<OwnershipCorporate>)source);	// checked cast as this class is only for OwnershipCorporate
			cobsBeneficialOwners = ((List<AttributeCompany>)destination);
			if(cobsBeneficialOwners == null) {
				cobsBeneficialOwners = new ArrayList<AttributeCompany>();
			} 
			
			return mapOwnersToCobsBeneficial(raasOwnershipCorporates, cobsBeneficialOwners);
			
		} else if(((List<?>)source).get(0) instanceof AttributeCompany){
			cobsBeneficialOwners = ((List<AttributeCompany>)source);
			raasOwnershipCorporates = ((List<OwnershipCorporate>)destination);	// checked cast as this class is only for OwnershipCorporate
			
			if(raasOwnershipCorporates == null) {
				raasOwnershipCorporates = new ArrayList<OwnershipCorporate>();
			} 
			
			return mapCobsBeneficialToOwners(cobsBeneficialOwners , raasOwnershipCorporates);
		} 
//		else {
//			throw new MappingException("Converter UltimateParentCustomConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ source + " and " + destination);
//		}
		return null;
	}

	public Object mapOwnersToCobsBeneficial(List<OwnershipCorporate> sourceList, List<AttributeCompany> destList) {
		
		for(OwnershipCorporate corporate: sourceList) {
			if(corporate.getLevel().getValue() == null 
					|| !(corporate.getLevel().getValue().equalsIgnoreCase("Ultimate"))) {
				continue;
			}
			List<OwnershipCorporate> CorporateList = new ArrayList<OwnershipCorporate>();
			CorporateList.add(corporate);
			CorporateOwnerCustomConverter corporateConverter = new CorporateOwnerCustomConverter();
			AttributeCompany attributeCompany = new AttributeCompany();
			Company company = new Company();

			corporateConverter.mapOwnersToCobsBeneficial(CorporateList,company.getBeneficialOwner(),true);
//			company.getBeneficialOwner().addAll(owners);
			attributeCompany.setValue(company);
			destList.add(attributeCompany);
			
		}
		return destList;
		
	}
	@SuppressWarnings("unchecked")
	public Object mapCobsBeneficialToOwners(List<AttributeCompany> sourceList, List<OwnershipCorporate> destList) {
		
		for(AttributeCompany company : sourceList){

			Company ownerCompany = company.getValue();
			List<AttributeCompanyBeneficialOwner> owners = ownerCompany.getBeneficialOwner();
			if(owners != null) {
				CorporateOwnerCustomConverter corporateConverter = new CorporateOwnerCustomConverter();
				destList = (List<OwnershipCorporate>)corporateConverter.mapCobsBeneficialToOwners(owners, destList);
			}
		}
		return destList;
	}
}
