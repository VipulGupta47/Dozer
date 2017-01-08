package com.headstrong.npi.raas.engine.converter.dozer;


import java.util.ArrayList;
import java.util.List;




















import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.Address;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeAddress;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyContact;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeString;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyContact;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryEntityAddressType;
import com.headstrong.npi.raas.cobs.xml.pojo.Individual;
import com.headstrong.npi.raas.cobs.xml.pojo.IndividualCitizenship;
import com.headstrong.npi.raas.xml.pojo.AddressType;
import com.headstrong.npi.raas.xml.pojo.ContactInfo;

/**
 * Class Specific to Contact List Conversion
 *  Contacts 
		    protected Entity.ContactInformation contactInformation;
				
			protected List<Address> address;
			protected List<ContactInfo> contacts;
			
			protected String id;
		    protected String role;
		    protected String position;
		    protected String firstName;
		    protected String middleName;
		    protected String lastName;
		    protected String countryOfDomicile;
		    protected String countryOfCitizenship;
		    protected String address;
		    protected String phone;
		    protected String fax;
		    protected String email;
		    
		
		    protected List<AttributeCompanyContact> contact;     protected CompanyContact value;
		    protected AttributeString role;
		    protected AttributeString position;
		    protected AttributeString phone;
		    protected AttributeString fax;
		    protected AttributeString email;
		    protected Individual individual;
		    
		    protected AttributeDictionaryDesignation designation;
		    protected AttributeString firstName;
		    protected AttributeString middleName;
		    protected AttributeString lastName;
		    protected AttributeString gender;
		    protected AttributeDate dob;
		    protected AttributeString aliases;
		    protected List<IndividualCitizenship> citizenship;
		    protected List<AttributeIndividualGovernmentIDInfo> governmentIDInfo;
 * @author Nitin Kumar
 * 			
 *
 */
public class ContactCustomConverter  implements CustomConverter {

	
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {

		if( source == null || ((List<?>)source).size() < 1) {	// source is always list
			return null;
		}
		List<ContactInfo> raasContactInfo = null;
		List<AttributeCompanyContact> cobsContacts = null;
		if(((List<?>)source).get(0) instanceof ContactInfo) {
//			System.out.println("contactInfo");
			
			raasContactInfo = ((List<ContactInfo>)source);	// checked cast as this class is only for ContactInfo
			cobsContacts = ((List<AttributeCompanyContact>)destination);
			if(cobsContacts == null) {
				cobsContacts = new ArrayList<AttributeCompanyContact>();
			} 
			
			return mapProfileContactToCobsContact(raasContactInfo, cobsContacts);
			
		} else if(((List<?>)source).get(0) instanceof AttributeCompanyContact){
			cobsContacts = ((List<AttributeCompanyContact>)source);
			raasContactInfo = ((List<ContactInfo>)destination);	// checked cast as this class is only for ContactInfo
			
			if(raasContactInfo == null) {
				raasContactInfo = new ArrayList<ContactInfo>();
			} 
			
			return mapCobsContactToRaasContact(cobsContacts , raasContactInfo);
		} 
//		else {
//			throw new MappingException("Converter ContactCustomConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ source + " and " + destination);
//		}
		return null;
	}

	/**
	 * Copy data from {@code ContactInfo} Class to {@code Contact} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapProfileContactToCobsContact(List<ContactInfo> source , List<AttributeCompanyContact> destination) {
		
		for (ContactInfo c : source) {
			
			AttributeCompanyContact contact = new AttributeCompanyContact();
			CompanyContact cobsContact = new CompanyContact();
			Individual individual = new Individual();
			cobsContact.setEmail(Utils.getAttributeStringValue(c.getEmail()));
			
			// Custom converter convert String to Enum only or vice-versa.
			// Need to create custom Data type instance.
			
			if(Utils.isNotEmpty(c.getCountryOfCitizenship())) {
				
				AttributeDictionaryCountry country = new AttributeDictionaryCountry();
				country.setValue((DictionaryCountry) DozerFactoryCustomConverter.convert(c.getCountryOfCitizenship(), DictionaryCountry.class));
				IndividualCitizenship  ind = new IndividualCitizenship();
				ind.setCountry(country);
				individual.getCitizenship().add(ind);
			}
			
			com.headstrong.npi.raas.xml.pojo.Address raasAddress = c.getAddress();
			if(raasAddress != null ) {
				List<com.headstrong.npi.raas.xml.pojo.Address> raasAddressList = new ArrayList<com.headstrong.npi.raas.xml.pojo.Address>();
				raasAddressList.add(raasAddress);
				AddressCustomConverter converter = new AddressCustomConverter();
				List<AttributeAddress> addressList = new ArrayList<AttributeAddress>();
				converter.mapProfileAddressToCobsAddress(raasAddressList, addressList);
				individual.setAddresses(addressList);
			}
			
			individual.setFirstName(Utils.getAttributeStringValue(c.getFirstName()));
			individual.setLastName(Utils.getAttributeStringValue(c.getLastName()));
			individual.setMiddleName(Utils.getAttributeStringValue(c.getMiddleName()));
			AttributeAddress address = new AttributeAddress();
			Address value = new Address();
			address.setValue(value);
			
			cobsContact.setPhone(Utils.getAttributeStringValue(c.getPhone()));
			cobsContact.setPosition(Utils.getAttributeStringValue(c.getPosition()));
			cobsContact.setRole(Utils.getAttributeStringValue(c.getRole()));
			cobsContact.setFax(Utils.getAttributeStringValue(c.getFax()));
			
			
			cobsContact.setIndividual(individual);
			contact.setValue(cobsContact);
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(raasAddress, contact);
			destination.add(contact);
		}
		return destination;
	
	}
	
	/**
	 * Copy data from cobs {@code Contact} Class to raas {@code ContactInfo} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapCobsContactToRaasContact(List<AttributeCompanyContact> source , List<ContactInfo> destination) {
		int i = 0;
		for (AttributeCompanyContact c : source) {
			CompanyContact contact = c.getValue();
			if(contact != null) {
				
				ContactInfo raaSContact = new ContactInfo();
				
				raaSContact.setEmail(Utils.getStringValueFromAttributeString(contact.getEmail()));
				String countryVal = null;
				Individual individual = contact.getIndividual();
				List<com.headstrong.npi.raas.xml.pojo.Address> addresses = null;
				if(individual != null ) {
					
					if(individual.getCitizenship().size() > 0
							&& individual.getCitizenship().get(i).getCountry()!= null) {
						
						countryVal = individual.getCitizenship().get(i).getCountry().getValue().value();
					}
					raaSContact.setCountryOfCitizenship(countryVal);

					List<AttributeAddress> addressList= individual.getAddresses();
					if(addressList != null && (addressList.size() > 0)) {
						
						AddressCustomConverter converter = new AddressCustomConverter();
						addresses = new ArrayList<com.headstrong.npi.raas.xml.pojo.Address>();
						converter.mapCobsContactAddressToProfileAddress(addressList,addresses);
					}

					if(addresses != null && addresses.size() > 0) {
						for(com.headstrong.npi.raas.xml.pojo.Address address : addresses) {
							if(address.getType().value().equals(AddressType.REGISTERED.value())) {
								raaSContact.setAddress(address);
								break;
							}
						}
					}
					
					raaSContact.setFirstName(Utils.getStringValueFromAttributeString(individual.getFirstName()));
					raaSContact.setLastName(Utils.getStringValueFromAttributeString(individual.getLastName()));
					raaSContact.setMiddleName(Utils.getStringValueFromAttributeString(individual.getMiddleName()));
				}
				
				raaSContact.setFax(Utils.getStringValueFromAttributeString(contact.getFax()));
				raaSContact.setPhone(Utils.getStringValueFromAttributeString(contact.getPhone()));
				raaSContact.setPosition(Utils.getStringValueFromAttributeString(contact.getPosition()));
				raaSContact.setRole(Utils.getStringValueFromAttributeString(contact.getRole()));
				
//				Additional Attributes Added.
				AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(c, raaSContact);
				
				i++;
				destination.add(raaSContact);
				
			}
		}
		return destination;
	}
}