package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeAddress;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBeneficialOwner;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDate;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryDesignation;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryIndividualGovernmentIdType;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeIndividualGovernmentIDInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyBeneficialOwner;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryDesignation;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryIndividualGovernmentIdType;
import com.headstrong.npi.raas.cobs.xml.pojo.Entity;
import com.headstrong.npi.raas.cobs.xml.pojo.Individual;
import com.headstrong.npi.raas.cobs.xml.pojo.IndividualCitizenship;
import com.headstrong.npi.raas.cobs.xml.pojo.IndividualGovernmentIDInfo;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.AddressType;
import com.headstrong.npi.raas.xml.pojo.CmAttributeDate;
import com.headstrong.npi.raas.xml.pojo.CmAttributeGender;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipCorporate;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipIndividual;
import com.headstrong.npi.raas.xml.pojo.GenderType;

/**
 * protected List<Entity.Ownership.OwnershipIndividual> ownershipIndividual;
        		protected Integer id;
	            protected CmAttributeString type;
	            protected CmAttributeString level;
	            protected CmAttributeString percentageOfOwnership;
	            protected CmAttributeString firstName;
	            protected CmAttributeString middleName;
	            protected CmAttributeString lastName;
	            protected CmAttributeString mei;
	            protected CmAttributeString aliases;
	            protected CmAttributeGender gender;
	            protected List<Address> address;
	            protected CmAttributeCountry countryOfCitzenship;
	            protected CmAttributeCountry countryOfDomicile;
	            protected CmAttributeDate birthDate;
	            protected CmAttributeString govtIssuedIdType;
	            protected CmAttributeString govtIssuedIdNumber;
	            protected CmAttributeString sourceOfWealth;
	            protected CmAttributeBoolean isBOWealthCommensurate;
	            protected CmAttributeString designation;
	            protected CmAttributeString position;
	            
	            protected AttributeString wealthSource;
				protected AttributeString level;
				protected AttributeDouble percentageOwnership;
				protected Entity entity;
 * 
 * @author 400219569
 *
 */
public class IndividualOwnerCustomConverter implements CustomConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination,
			Object source, Class<?> destinationClass,
			Class<?> sourceClass) {
	
		if( source == null || ((List<?>)source).size() < 1) {	// source is always list
			return null;
		}
		List<OwnershipIndividual> raasOwnershipIndividuals = null;
		List<AttributeCompanyBeneficialOwner> cobsBeneficialOwners = null;
		if(((List<?>)source).get(0) instanceof OwnershipIndividual) {
			
			raasOwnershipIndividuals = ((List<OwnershipIndividual>)source);	// checked cast as this class is only for OwnershipIndividual
			cobsBeneficialOwners = ((List<AttributeCompanyBeneficialOwner>)destination);
			if(cobsBeneficialOwners == null) {
				cobsBeneficialOwners = new ArrayList<AttributeCompanyBeneficialOwner>();
			} 
			
			return mapOwnersToCobsBeneficial(raasOwnershipIndividuals, cobsBeneficialOwners);
			
		} else if(((List<?>)source).get(0) instanceof AttributeCompanyBeneficialOwner){
			cobsBeneficialOwners = ((List<AttributeCompanyBeneficialOwner>)source);
			raasOwnershipIndividuals = ((List<OwnershipIndividual>)destination);	// checked cast as this class is only for OwnershipIndividual
			
			if(raasOwnershipIndividuals == null) {
				raasOwnershipIndividuals = new ArrayList<OwnershipIndividual>();
			} 
			
			return mapCobsBeneficialToOwners(cobsBeneficialOwners , raasOwnershipIndividuals);
		} 
//		else {
//			throw new MappingException("Converter IndividualOwnerCustomConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ source + " and " + destination);
//		}
		return null;
		
	}

	/**
	 * 			protected Integer id;
	            protected CmAttributeString type;
	            protected CmAttributeString level;
	            protected CmAttributeString percentageOfOwnership;
	            protected CmAttributeString firstName;
	            protected CmAttributeString middleName;
	            protected CmAttributeString lastName;
	            protected CmAttributeString mei;
	            protected CmAttributeString aliases;
	            protected CmAttributeGender gender;
	            protected List<Address> address;
	            protected CmAttributeCountry countryOfCitzenship;
	            protected CmAttributeCountry countryOfDomicile;
	            protected CmAttributeDate birthDate;
	            protected CmAttributeString govtIssuedIdType;
	            protected CmAttributeString govtIssuedIdNumber;
	            protected CmAttributeString sourceOfWealth;
	            protected CmAttributeBoolean isBOWealthCommensurate;
	            protected CmAttributeString designation;
	            protected CmAttributeString position;
	            
	            protected AttributeString wealthSource;
				protected AttributeString level;
				protected AttributeDouble percentageOwnership;
				protected Entity entity;
	 * 
	 * 
	 * @param sourceList
	 * @param destinationList
	 * @return
	 */
	public Object mapCobsBeneficialToOwners(List<AttributeCompanyBeneficialOwner> sourceList, List<OwnershipIndividual> destinationList) {
		
		for(AttributeCompanyBeneficialOwner beneficialOwner : sourceList) {
			CompanyBeneficialOwner companyBeneficialOwner =  beneficialOwner.getValue();
			Entity cobsEntity = companyBeneficialOwner.getEntity();
			if(cobsEntity instanceof Individual) {
				OwnershipIndividual individual = new OwnershipIndividual();
				Individual individualOwner = (Individual)cobsEntity;
				
				individual.setType(Utils.getCmAttrString("Individual"));
				if(companyBeneficialOwner.getLevel() != null) {
					individual.setLevel(Utils.getCmAttrString(companyBeneficialOwner.getLevel().getValue()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(companyBeneficialOwner.getLevel(), individual.getLevel());				
				}
				if(companyBeneficialOwner.getPercentageOwnership() != null) {
					individual.setPercentageOfOwnership(Utils.getCmAttrString((!Double.isNaN(companyBeneficialOwner.getPercentageOwnership().getValue())) ? String.valueOf(companyBeneficialOwner.getPercentageOwnership().getValue()) : null));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(companyBeneficialOwner.getPercentageOwnership(), individual.getPercentageOfOwnership());				
					
				}
				if(individualOwner.getFirstName() != null) {
					individual.setFirstName(Utils.getCmAttrString(individualOwner.getFirstName().getValue()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(individualOwner.getFirstName(), individual.getFirstName());				
					
				}
				if(individualOwner.getLastName() != null) {
					individual.setLastName(Utils.getCmAttrString(individualOwner.getLastName().getValue()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(individualOwner.getLastName(), individual.getLastName());				
					
				}
				if(individualOwner.getMiddleName() != null) {
					individual.setMiddleName(Utils.getCmAttrString(individualOwner.getMiddleName().getValue()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(individualOwner.getMiddleName(), individual.getMiddleName());				
					
				}
				individual.setMEI(Utils.getCmAttrString(individualOwner.getMei()));
				
				CmAttributeGender attributeGender = null;
				if(individualOwner.getGender() != null) {
					attributeGender = new CmAttributeGender();
					attributeGender.setValue(GenderType.fromValue(individualOwner.getGender().getValue()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(individualOwner.getGender(), attributeGender);				
				}
				individual.setGender(attributeGender);
				
				individual.setAliases(Utils.getCmAttrString((individualOwner.getAliases() != null) ? individualOwner.getAliases().getValue(): null));
				List<AttributeAddress> addressList= individualOwner.getAddresses();
				if(addressList != null 
						&& (addressList.size() > 0)) {
					AddressCustomConverter converter = new AddressCustomConverter();
					List<Address> addresses = new ArrayList<Address>();
					converter.mapCobsContactAddressToProfileAddress(addressList,addresses);
					individual.setAddress(addresses);
				}
				
				individual.setCountryOfCitzenship(Utils.getCmAttrCountry((individualOwner.getCitizenship()!= null && individualOwner.getCitizenship().size() > 0) ? individualOwner.getCitizenship().get(0).getCountry().getValue().value() :null));
				for(Address value :individual.getAddress()) {
					if(value.getType().value().equals(AddressType.DOMICILE)) {
						individual.setCountryOfDomicile(Utils.getCmAttrCountry(value.getCountry()));
						break;
					}
				}
				
				CmAttributeDate attributeDate = null;
				if(individualOwner.getDob() != null) {
					attributeDate = new CmAttributeDate();
					attributeDate.setValue(individualOwner.getDob().getValue());
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(individualOwner.getDob(), attributeDate);				
				}
				individual.setBirthDate(attributeDate);
//				TODO need to map Additional Attribute in List
				individual.setGovtIssuedIdType(Utils.getCmAttrString((individualOwner.getGovernmentIDInfo()!= null && individualOwner.getGovernmentIDInfo().size() > 0) ? individualOwner.getGovernmentIDInfo().get(0).getValue().getIdType().getValue().value() : null));
				individual.setGovtIssuedIdNumber(Utils.getCmAttrString((individualOwner.getGovernmentIDInfo()!= null && individualOwner.getGovernmentIDInfo().size() > 0) ? individualOwner.getGovernmentIDInfo().get(0).getValue().getIdNumber().getValue() : null));
				
				if(companyBeneficialOwner.getWealthSource() != null) {
					individual.setSourceOfWealth(Utils.getCmAttrString(companyBeneficialOwner.getWealthSource().getValue()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(companyBeneficialOwner.getWealthSource(), individual.getSourceOfWealth());				
				}
				if(individualOwner.getDesignation() != null) {
					individual.setDesignation(Utils.getCmAttrString(individualOwner.getDesignation().getValue().value()));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(individualOwner.getDesignation(), individual.getDesignation());				
				}
//				Additional Attributes Added
				AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(beneficialOwner, individual);
				destinationList.add(individual);
			}
		}
		return destinationList;
	}

	public Object mapOwnersToCobsBeneficial(List<OwnershipIndividual> sourceList, List<AttributeCompanyBeneficialOwner> destinationList) {

		for(OwnershipIndividual ownershipIndividual : sourceList) {
			AttributeCompanyBeneficialOwner cobsEntity = new AttributeCompanyBeneficialOwner();
			CompanyBeneficialOwner beneficialOwner = new CompanyBeneficialOwner();
			Individual individual = new Individual();
			
			if(ownershipIndividual.getLevel() != null) {
				beneficialOwner.setLevel(Utils.getAttributeStringValue(ownershipIndividual.getLevel().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getLevel(), beneficialOwner.getLevel());
			}
			
			if(ownershipIndividual.getPercentageOfOwnership() != null) {
				beneficialOwner.setPercentageOwnership(Utils.getAttributeDoubleValue(ownershipIndividual.getPercentageOfOwnership().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getPercentageOfOwnership(), beneficialOwner.getPercentageOwnership());
			}
			if(ownershipIndividual.getFirstName() != null) {
				individual.setFirstName(Utils.getAttributeStringValue(ownershipIndividual.getFirstName().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getFirstName(), individual.getFirstName());
				
			}
			if(ownershipIndividual.getMiddleName() != null) {
				individual.setMiddleName(Utils.getAttributeStringValue(ownershipIndividual.getMiddleName().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getMiddleName(), individual.getMiddleName());
				
			}
			if(ownershipIndividual.getLastName() != null) {
				individual.setLastName(Utils.getAttributeStringValue(ownershipIndividual.getLastName().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getLastName(), individual.getLastName());
				
			}
			individual.setMei((ownershipIndividual.getMEI() != null)?ownershipIndividual.getMEI().getValue() : null);
			
			List<Address> addresses = ownershipIndividual.getAddress();
			if(addresses != null 
					&& (addresses.size() > 0)) {
				AddressCustomConverter converter = new AddressCustomConverter();
				List<AttributeAddress> addressList = new ArrayList<AttributeAddress>();
				converter.mapProfileAddressToCobsAddress(addresses, addressList);
				individual.setAddresses(addressList);
			}
			
			if(ownershipIndividual.getGender()!= null) {
				individual.setGender(Utils.getAttributeStringValue(ownershipIndividual.getGender().getValue().value()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getGender(), individual.getGender());
				
			}
			if(ownershipIndividual.getAliases() != null) {
				individual.setAliases(Utils.getAttributeStringValue(ownershipIndividual.getAliases().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getAliases(), individual.getAliases());
			}
			
			IndividualCitizenship individualCitizenship = new IndividualCitizenship();
			AttributeDictionaryCountry dictionaryCountry = new AttributeDictionaryCountry();
			dictionaryCountry.setValue(DictionaryCountry.fromValue(ownershipIndividual.getCountryOfCitzenship().getValue().value()));
			com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getCountryOfCitzenship(), dictionaryCountry);
			individualCitizenship.setCountry(dictionaryCountry);
			individual.getCitizenship().add(individualCitizenship);
			
			AttributeDate date = null;
			if(ownershipIndividual.getBirthDate() != null){
				date = new AttributeDate();
				date.setValue(ownershipIndividual.getBirthDate().getValue());
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getBirthDate(), date);
			}
			individual.setDob(date);
			
			AttributeIndividualGovernmentIDInfo idInfo = new AttributeIndividualGovernmentIDInfo();
			IndividualGovernmentIDInfo info = new IndividualGovernmentIDInfo();
			AttributeDictionaryIndividualGovernmentIdType type = new AttributeDictionaryIndividualGovernmentIdType();
			
			if(ownershipIndividual.getGovtIssuedIdType()!= null) {
				type.setValue(DictionaryIndividualGovernmentIdType.fromValue(ownershipIndividual.getGovtIssuedIdType().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getGovtIssuedIdType(), type);
				
			}
			if(ownershipIndividual.getGovtIssuedIdNumber() != null) {
				info.setIdNumber(Utils.getAttributeStringValue(ownershipIndividual.getGovtIssuedIdNumber().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getGovtIssuedIdNumber(), info.getIdNumber());
			}
			
			info.setIdType(type);
			idInfo.setValue(info);
			individual.getGovernmentIDInfo().add(idInfo);
	
			AttributeDictionaryDesignation dictionaryDesignation = new AttributeDictionaryDesignation();
			dictionaryDesignation.setValue(DictionaryDesignation.fromValue(ownershipIndividual.getDesignation().getValue()));
			com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getDesignation(), dictionaryDesignation);
			individual.setDesignation(dictionaryDesignation);
			
			if(ownershipIndividual.getSourceOfWealth() != null) {
				beneficialOwner.setWealthSource(Utils.getAttributeStringValue(ownershipIndividual.getSourceOfWealth().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipIndividual.getSourceOfWealth(), beneficialOwner.getWealthSource());
				
			}

			beneficialOwner.setEntity(individual);
			cobsEntity.setValue(beneficialOwner);
//			Additional Attributes Added
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(ownershipIndividual, cobsEntity);
			destinationList.add(cobsEntity);
			
		}
		return destinationList;
	}
	
}
