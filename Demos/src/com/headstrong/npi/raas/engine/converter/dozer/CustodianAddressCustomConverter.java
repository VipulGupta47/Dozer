package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;

import com.headstrong.npi.raas.cobs.xml.pojo.AttributeAddress;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryEntityAddressType;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.AddressType;

public class CustodianAddressCustomConverter  implements CustomConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		
		if( source == null) {
			return null;
		}
		
		Address raasAddress = null;
		List<AttributeAddress> custodianAddress = null;
		if(source instanceof Address){
		
		 raasAddress = (Address)source;
		 custodianAddress = ((List<AttributeAddress>)destination);
		 if(custodianAddress == null) {
			 custodianAddress = new ArrayList<AttributeAddress>();
		 }
		
		return mapProfileCustodianAddressToCobsAddresses(raasAddress, custodianAddress);
		} else if(((List<?>)source).size() > 0 && ((List<?>)source).get(0) instanceof AttributeAddress){
			custodianAddress = ((List<AttributeAddress>)source);
			 raasAddress = (Address)destination;
			 if(raasAddress == null) {
				 raasAddress = new Address();
			 }
			return mapCobsCustodianAddressToProfileCustodianAddress(custodianAddress , raasAddress);
		}
//		 else {
//				throw new MappingException("Converter AddressCustomConverter "
//						+ "used incorrectly. Arguments passed in were:"
//						+ destination + " and " + source);
//			}
		return null;
	}

	/**
	 * Already Mapped with Address 
	 * @param source
	 * @param destination
	 * @return List of {@code Contact}
	 */
	public Object mapProfileCustodianAddressToCobsAddresses(Address source , List<AttributeAddress> destination) {
		return destination;
	}

	/**
	 * Map cobs Address to raas Bearer Shares Custodian Address. 
	 * 
	 * @param source
	 * @param destination
	 * @return List of raas Address
	 */
	public Object mapCobsCustodianAddressToProfileCustodianAddress(List<AttributeAddress>source , Address destination) {
	
		for (AttributeAddress a : source) {
//			address Type should be Custodian Else continue;
			if(!(a.getValue().getAddressType().value().equalsIgnoreCase(DictionaryEntityAddressType.CUSTODIAN.value()))) {
				continue;
			}
			destination.setAddressLine1((a.getValue().getAddressLine1() != null) ? a.getValue().getAddressLine1().getValue() : "");
			destination.setAddressLine2((a.getValue().getAddressLine2() != null) ? a.getValue().getAddressLine2().getValue() : "");
			destination.setCity((a.getValue().getCity() != null) ? a.getValue().getCity().getValue() : "");
			if(a.getValue().getState() != null)
				destination.setState(a.getValue().getState().getValue().value());
			destination.setZipCode((a.getValue().getZip() != null) ? a.getValue().getZip().getValue() :"");
			if(a.getValue().getCountry() != null)
			destination.setCountry(a.getValue().getCountry().getValue().value());
			destination.setType(AddressType.CUSTODIAN);

//			Additional Attributes Added
			AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(a, destination);
			break;
		}
		
		return destination;

	}
}

