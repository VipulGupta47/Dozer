package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeAddress;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBeneficialOwner;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyControllerDirector;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDate;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryDesignation;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryIndividualGovernmentIdType;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeIndividualGovernmentIDInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyControllerDirector;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryDesignation;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryIndividualGovernmentIdType;
import com.headstrong.npi.raas.cobs.xml.pojo.Individual;
import com.headstrong.npi.raas.cobs.xml.pojo.IndividualCitizenship;
import com.headstrong.npi.raas.cobs.xml.pojo.IndividualGovernmentIDInfo;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.AddressType;
import com.headstrong.npi.raas.xml.pojo.CmAttributeDate;
import com.headstrong.npi.raas.xml.pojo.CmAttributeGender;
import com.headstrong.npi.raas.xml.pojo.Entity.ControllerAndDirector.ControllersAndDirectors;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipCorporate;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipIndividual;
import com.headstrong.npi.raas.xml.pojo.GenderType;

public class ControllerAndDirectorCustomConverter implements CustomConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination,
			Object source, Class<?> destinationClass,
			Class<?> sourceClass) {
	
		if( source == null || ((List<?>)source).size() < 1) {	// source is always list
			return null;
		}
		List<ControllersAndDirectors> raasControllersAndDirectors = null;
		List<AttributeCompanyControllerDirector> cobsControllersAndDirectors = null;
		if(((List<?>)source).get(0) instanceof ControllersAndDirectors) {
			
			raasControllersAndDirectors = ((List<ControllersAndDirectors>)source);	// checked cast as this class is only for OwnershipIndividual
			cobsControllersAndDirectors = ((List<AttributeCompanyControllerDirector>)destination);
			if(cobsControllersAndDirectors == null) {
				cobsControllersAndDirectors = new ArrayList<AttributeCompanyControllerDirector>();
			} 
			
			return mapOwnersToCobsBeneficial(raasControllersAndDirectors, cobsControllersAndDirectors);
			
		} else if(((List<?>)source).get(0) instanceof AttributeCompanyControllerDirector){
			cobsControllersAndDirectors = ((List<AttributeCompanyControllerDirector>)source);
			raasControllersAndDirectors = ((List<ControllersAndDirectors>)destination);	// checked cast as this class is only for OwnershipIndividual
			
			if(raasControllersAndDirectors == null) {
				raasControllersAndDirectors = new ArrayList<ControllersAndDirectors>();
			} 
			
			return mapCobsBeneficialToOwners(cobsControllersAndDirectors , raasControllersAndDirectors);
		} 
//		else {
//			throw new MappingException("Converter ControllerAndDirectorCustomConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ source + " and " + destination);
//		}
		return null;
	}
	
	/**
	 * 			protected CmAttributeString type;
	            protected CmAttributeString level;
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
	            protected CmAttributeString position;
	            protected CmAttributeString designation;
	 * 
	 * 
	 * @param sourceList
	 * @param destList
	 * @return
	 */
	public Object mapCobsBeneficialToOwners(List<AttributeCompanyControllerDirector> sourceList, List<ControllersAndDirectors> destList) {
		
		for(AttributeCompanyControllerDirector controllerDirector : sourceList) {
			CompanyControllerDirector director = controllerDirector.getValue();
			Individual individual = (Individual)director.getEntity();
			ControllersAndDirectors raasCnD = new ControllersAndDirectors();
			
			raasCnD.setType(Utils.getCmAttrString("ControllersAndDirector"));
			raasCnD.setFirstName(Utils.getCmAttrString((individual.getFirstName()!= null)?individual.getFirstName().getValue() : null));
			raasCnD.setMiddleName(Utils.getCmAttrString((individual.getMiddleName()!= null)?individual.getMiddleName().getValue() : null));
			raasCnD.setLastName(Utils.getCmAttrString((individual.getLastName()!= null)?individual.getLastName().getValue() : null));
			raasCnD.setMEI(Utils.getCmAttrString(individual.getMei()));
			raasCnD.setAliases(Utils.getCmAttrString(individual.getAliases().getValue()));
			
			CmAttributeGender gender = new CmAttributeGender();
			gender.setValue(GenderType.fromValue(individual.getGender().getValue()));
			raasCnD.setGender(gender);
			if(individual.getCitizenship() != null 
					&& individual.getCitizenship().size() > 0) {
				raasCnD.setCountryOfCitzenship(Utils.getCmAttrCountry((individual.getCitizenship().get(0).getCountry()!= null)?individual.getCitizenship().get(0).getCountry().getValue().value() : null));			}
			
			List<AttributeAddress> addressList= individual.getAddresses();
			if(addressList != null 
					&& (addressList.size() > 0)) {
				AddressCustomConverter converter = new AddressCustomConverter();
				List<Address> addresses = new ArrayList<Address>();
				converter.mapCobsContactAddressToProfileAddress(addressList,addresses);
				raasCnD.setAddress(addresses);
			}
			
			for(Address value :raasCnD.getAddress()) {
				if(value.getType().value().equals(AddressType.DOMICILE)) {
					raasCnD.setCountryOfDomicile(Utils.getCmAttrCountry(value.getCountry()));
					break;
				}
			}
			
			CmAttributeDate date = null;
			if(individual.getDob() != null) {
				date = new CmAttributeDate();
				date.setValue(individual.getDob().getValue());
			}
			raasCnD.setBirthDate(date);
			
			raasCnD.setPosition(Utils.getCmAttrString((director.getPosition()!= null)?director.getPosition().getValue() : null));
			raasCnD.setDesignation(Utils.getCmAttrString((individual.getDesignation()!= null)?individual.getDesignation().getValue().value() :null));
//			Additional Attributes added
			AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(controllerDirector, raasCnD);
			destList.add(raasCnD);
			
		}
		
		return destList;
	}

	public Object mapOwnersToCobsBeneficial(List<ControllersAndDirectors> sourceList , List<AttributeCompanyControllerDirector> destList) {

		for(ControllersAndDirectors raasCnD : sourceList) {
			
			AttributeCompanyControllerDirector director = new AttributeCompanyControllerDirector();
			CompanyControllerDirector companyControllerDirector = new CompanyControllerDirector();
			Individual individual = new Individual();
			if(raasCnD.getFirstName() != null) {
				individual.setFirstName(Utils.getAttributeStringValue(raasCnD.getFirstName()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getFirstName() , individual.getFirstName());
				
			}
			if(raasCnD.getMiddleName() != null) {
				individual.setMiddleName(Utils.getAttributeStringValue((raasCnD.getMiddleName()!= null)?raasCnD.getMiddleName().getValue(): null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getMiddleName() , individual.getMiddleName());
				
			}
			if(raasCnD.getLastName() != null) {
				individual.setLastName(Utils.getAttributeStringValue((raasCnD.getLastName()!= null)?raasCnD.getLastName().getValue(): null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getLastName() , individual.getLastName());
				
			}
			individual.setMei((raasCnD.getMEI()!= null)?raasCnD.getMEI().getValue(): "");
			
			if(raasCnD.getAliases()!= null) {
				individual.setAliases(Utils.getAttributeStringValue((raasCnD.getAliases()!=null)?raasCnD.getAliases().getValue() : null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getAliases() , individual.getAliases());
				
			}
			
			if(raasCnD.getGender()!= null) {
				individual.setGender(Utils.getAttributeStringValue(raasCnD.getGender().getValue().value()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getGender() , individual.getGender());
			}
			if(raasCnD.getCountryOfCitzenship()!= null) {
				IndividualCitizenship citizenship = new IndividualCitizenship();
				AttributeDictionaryCountry dictionaryCountry = new AttributeDictionaryCountry();
				dictionaryCountry.setValue(DictionaryCountry.fromValue(raasCnD.getCountryOfCitzenship().getValue().value()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getCountryOfCitzenship() , dictionaryCountry);
				citizenship.setCountry(dictionaryCountry);
				individual.getCitizenship().add(citizenship);
			}
			
			List<Address> addresses = raasCnD.getAddress();
			if(addresses != null 
					&& (addresses.size() > 0)) {
				AddressCustomConverter converter = new AddressCustomConverter();
				List<AttributeAddress> addressList = new ArrayList<AttributeAddress>();
				converter.mapProfileAddressToCobsAddress(addresses, addressList);
				individual.setAddresses(addressList);
			}
			AttributeDate attributeDate = null;
			if(raasCnD.getBirthDate()!= null) {
				attributeDate = new AttributeDate();
				attributeDate.setValue(raasCnD.getBirthDate().getValue());
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getBirthDate() , attributeDate);
				
			}
			individual.setDob(attributeDate);
			AttributeDictionaryDesignation value = null;
			if(raasCnD.getDesignation()!= null) {
				value = new AttributeDictionaryDesignation();
				value.setValue(DictionaryDesignation.fromValue(raasCnD.getDesignation().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getDesignation() , value);
			}
			individual.setDesignation(value);
			
			if(raasCnD.getPosition() != null) {
				companyControllerDirector.setPosition(Utils.getAttributeStringValue(raasCnD.getPosition()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(raasCnD.getPosition() , companyControllerDirector.getPosition());
			}
			companyControllerDirector.setEntity(individual);
			director.setValue(companyControllerDirector);
//			Additional Attributes added
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(raasCnD, director);
			destList.add(director);
			
		}
		
		return destList;
		
	}
	
}
