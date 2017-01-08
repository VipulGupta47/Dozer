package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeAddress;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryState;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeString;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryEntityAddressType;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryState;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.AddressType;
/**
 * Address
		
			protected String id;
		    protected String addressLine1;
		    protected String addressLine2;
		    protected String city;
		    protected String state;
		    protected String country;
		    protected String zipCode;
		    protected AddressType type; 
			
			protected List<AttributeAddress> addresses;   protected Address value;
			
			protected DictionaryEntityAddressType addressType;
			protected AttributeString addressLine1;
			protected AttributeString addressLine2;
			protected AttributeString addressLine3;
			protected AttributeString city;
			protected AttributeDictionaryState state;
			protected AttributeDictionaryCountry country;
			protected AttributeString zip;

 * @author 400219569
 *
 */
public class AddressCustomConverter implements CustomConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		
		if( source == null || ((List<?>)source).size() < 1 ) {
			return null;
		}
		List<Address> raasAddress = null;
		List<AttributeAddress> cobsContacts = null;
		if(((List<?>)source).get(0) instanceof Address){
		
		 raasAddress = ((List<Address>)source);
		 cobsContacts = ((List<AttributeAddress>)destination);
		 if(cobsContacts == null) {
			 cobsContacts = new ArrayList<AttributeAddress>();
		 }
		
		return mapProfileAddressToCobsAddress(raasAddress, cobsContacts);
		} else if(((List<?>)source).get(0) instanceof AttributeAddress){
			cobsContacts = ((List<AttributeAddress>)source);
			 raasAddress = ((List<Address>)destination);
			 if(raasAddress == null) {
				 raasAddress = new ArrayList<Address>();
			 }
			return mapCobsContactAddressToProfileAddress(cobsContacts , raasAddress);
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
	public Object mapProfileAddressToCobsAddress(List<Address> source , List<AttributeAddress> destination) {

		for (Address a : source) {
			 
			AttributeAddress address = new AttributeAddress();
			com.headstrong.npi.raas.cobs.xml.pojo.Address cobsAddress = new com.headstrong.npi.raas.cobs.xml.pojo.Address();
			AttributeString a1 = new AttributeString();
			a1.setValue(Utils.isNotEmpty(a.getAddressLine1()) ? a.getAddressLine1() :"");
			cobsAddress.setAddressLine1(a1);
			
			AttributeString a2 = new AttributeString();
			a2.setValue(Utils.isNotEmpty(a.getAddressLine2()) ? a.getAddressLine2() :"");
			cobsAddress.setAddressLine2(a2);
			
			if(Utils.isNotEmpty(a.getCountry())) {
				AttributeDictionaryCountry cobsCountry = new AttributeDictionaryCountry();
				cobsCountry.setValue(DictionaryCountry.fromValue(a.getCountry()));
				cobsAddress.setCountry(cobsCountry);
			}
			
			AttributeString cobsCity = new AttributeString();
			cobsCity.setValue(a.getCity());
			cobsAddress.setCity(cobsCity);
			
			if(Utils.isNotEmpty(a.getState())) {
				AttributeDictionaryState cobsState = new AttributeDictionaryState();
				cobsState.setValue(DictionaryState.fromValue(a.getState()));
				cobsAddress.setState(cobsState);
			}
			
			AttributeString cobsZipCode = new AttributeString();
			cobsZipCode.setValue(Utils.isNotEmpty(a.getZipCode()) ? a.getZipCode() :"");
			cobsAddress.setZip(cobsZipCode);

			if(a.getType().value().equalsIgnoreCase(AddressType.DOMICILE.value()))
				cobsAddress.setAddressType(DictionaryEntityAddressType.DOMICILE);
			else if(a.getType().value().equalsIgnoreCase(AddressType.MAILING.value()))
				cobsAddress.setAddressType(DictionaryEntityAddressType.MAILING);
			else if(a.getType().value().equalsIgnoreCase(AddressType.PRINCIPAL_BUSINESS.value()))
				cobsAddress.setAddressType(DictionaryEntityAddressType.PRINCIPAL);
			else if(a.getType().value().equalsIgnoreCase(AddressType.REGISTERED.value()))
				cobsAddress.setAddressType(DictionaryEntityAddressType.REGISTERED);
			else if(a.getType().value().equalsIgnoreCase(AddressType.CUSTODIAN.value()))
				cobsAddress.setAddressType(DictionaryEntityAddressType.CUSTODIAN);
			else if(a.getType().value().equalsIgnoreCase(AddressType.RESIDENTIAL.value()))
				cobsAddress.setAddressType(DictionaryEntityAddressType.RESIDENTIAL);
			
			address.setValue(cobsAddress);
			
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(a, address);
			destination.add(address);
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
	public Object mapCobsContactAddressToProfileAddress(List<AttributeAddress>source , List<Address> destination) {
	
//		int  i = 0;
		for (AttributeAddress a : source) {
			
			Address raasAddress = new Address();
			raasAddress.setAddressLine1((a.getValue().getAddressLine1() != null) ? a.getValue().getAddressLine1().getValue() : "");
			raasAddress.setAddressLine2((a.getValue().getAddressLine2() != null) ? a.getValue().getAddressLine2().getValue() : "");
			raasAddress.setCity((a.getValue().getCity() != null) ? a.getValue().getCity().getValue() : "");
			if(a.getValue().getState() != null)
				raasAddress.setState(a.getValue().getState().getValue().value());
			raasAddress.setZipCode((a.getValue().getZip() != null) ? a.getValue().getZip().getValue() :"");
			if(a.getValue().getCountry() != null)
			raasAddress.setCountry(a.getValue().getCountry().getValue().value());
			
			if(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.DOMICILE.value()))
					raasAddress.setType(AddressType.DOMICILE);
			else if(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.MAILING.value()))
				raasAddress.setType(AddressType.MAILING);
			else if(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.PRINCIPAL.value()))
				raasAddress.setType(AddressType.PRINCIPAL_BUSINESS);
			else if(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.REGISTERED.value()))
				raasAddress.setType(AddressType.REGISTERED);
			else if(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.CUSTODIAN.value()))
				raasAddress.setType(AddressType.CUSTODIAN);
			else if(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.RESIDENTIAL.value()))
				raasAddress.setType(AddressType.RESIDENTIAL);
			
//			Additional Attributes Added.
			AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(a, raasAddress);
			destination.add(raasAddress);
			
//			i++;
		}
		return destination;

	}
}
