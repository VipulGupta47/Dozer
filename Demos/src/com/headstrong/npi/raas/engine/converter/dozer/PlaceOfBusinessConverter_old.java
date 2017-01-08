package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeBoolean;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyCountryOfBusiness;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyIndustryIdentifier;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDouble;
import com.headstrong.npi.raas.cobs.xml.pojo.Boolean;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyCountryOfBusiness;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyIndustryIdentifier;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryCountry;
import com.headstrong.npi.raas.xml.pojo.CmAttributeCountry;
import com.headstrong.npi.raas.xml.pojo.CmAttributeDouble;
import com.headstrong.npi.raas.xml.pojo.CmAttributeOption;
import com.headstrong.npi.raas.xml.pojo.CmAttributeString;
import com.headstrong.npi.raas.xml.pojo.CountryOfBusiness;
import com.headstrong.npi.raas.xml.pojo.Identifier;
import com.headstrong.npi.raas.xml.pojo.Entity.PlaceOfBusiness;
import com.headstrong.npi.raas.xml.pojo.Option;
import com.headstrong.npi.raas.xml.pojo.Exchanges.Exchange;

/**
 * 
 * protected List<CountryOfBusiness> countriesOfBusiness;
        	protected String id;
            protected CmAttributeCountry country;
            protected CmAttributeString percenetageOfBusniess;
            
        protected CmAttributeCountry countryOfPrimaryOperation;
        protected CmAttributeString regionsOfBusiness;
        protected List<CountryOfBusiness> highRiskCountriesOfBusiness;
	        protected String id;
	        protected CmAttributeCountry country;
	        protected CmAttributeString percenetageOfBusniess;
        
        protected CmAttributeString numberOfEmployees;
        protected CmAttributeOption inEconomicSanctionedCountries;
		
		protected List<AttributeCompanyCountryOfBusiness> countryOfBusiness;  protected CompanyCountryOfBusiness value;
		
		protected AttributeDictionaryCountry country;
	    protected AttributeString region;
	    protected AttributeDouble percentageOfBusinessInHRC;
	    protected AttributeBoolean highRisk;

 * 
 * @author 400219569
 *
 */
public class PlaceOfBusinessConverter_old implements CustomConverter {

	
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {

		if( source == null) {	
			return null;
		}
		PlaceOfBusiness raasPlaceOfBusiness = null;
		List<AttributeCompanyCountryOfBusiness> cobsCountryOfBusiness = null;
		if(source instanceof PlaceOfBusiness) {
			
			raasPlaceOfBusiness = ((PlaceOfBusiness)source);	
			cobsCountryOfBusiness = ((List<AttributeCompanyCountryOfBusiness>)destination);
			if(cobsCountryOfBusiness == null) {
				cobsCountryOfBusiness = new ArrayList<AttributeCompanyCountryOfBusiness>();
			} 
			
			return mapProfilePlaceOfBusinessToCobsCountryOfBusiness(raasPlaceOfBusiness, cobsCountryOfBusiness);
			
		} else if(((List<?>)source).size() > 0 && ((List<?>)source).get(0) instanceof AttributeCompanyCountryOfBusiness){
			cobsCountryOfBusiness = ((List<AttributeCompanyCountryOfBusiness>)source);
			raasPlaceOfBusiness = ((PlaceOfBusiness)destination);	// checked cast as this class is only for Identifiers
			
			if(raasPlaceOfBusiness == null) {
				raasPlaceOfBusiness = new PlaceOfBusiness();
			} 
			
			return mapCobsIdentifierToRaasIdentifier(cobsCountryOfBusiness , raasPlaceOfBusiness);
		}
//		else {
//			throw new MappingException("Converter PlaceOfBusinessConverter"
//					+ "used incorrectly. Arguments passed in were:"
//					+ source + " and " + destination);
//		}
		return null;
	}

	/**
	 * Copy data from {@code Identifier} Class to {@code AttributeCompanyIndustryIdentifier} class.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private Object mapProfilePlaceOfBusinessToCobsCountryOfBusiness(PlaceOfBusiness source , List<AttributeCompanyCountryOfBusiness> destination) {
		for (CountryOfBusiness country : source.getCountriesOfBusiness()) {
			
			AttributeCompanyCountryOfBusiness countryOfBusiness = new AttributeCompanyCountryOfBusiness();
			CompanyCountryOfBusiness cobscountryOfBusiness = new CompanyCountryOfBusiness();
			
			AttributeDictionaryCountry dictionaryCountry = new AttributeDictionaryCountry(); 
			dictionaryCountry.setValue((DictionaryCountry)DozerFactoryCustomConverter.convert(country.getCountry().getValue().value(), DictionaryCountry.class));
			cobscountryOfBusiness.setCountry(dictionaryCountry);
			
			cobscountryOfBusiness.setPercentageOfBusinessInHRC((AttributeDouble)DozerFactoryCustomConverter.convert(country.getPercenetageOfBusniess().getValue(), AttributeDouble.class));
			AttributeBoolean booleanValue = new AttributeBoolean();
			booleanValue.setValue(Boolean.NO);
			cobscountryOfBusiness.setHighRisk(booleanValue);
			
			countryOfBusiness.setValue(cobscountryOfBusiness);
			destination.add(countryOfBusiness);
			
		}
		for (CountryOfBusiness highCountry : source.getHighRiskCountriesOfBusiness()) {
			
			AttributeCompanyCountryOfBusiness countryOfBusiness = new AttributeCompanyCountryOfBusiness();
			CompanyCountryOfBusiness cobscountryOfBusiness = new CompanyCountryOfBusiness();
			
			AttributeDictionaryCountry dictionaryCountry = new AttributeDictionaryCountry(); 
			dictionaryCountry.setValue((DictionaryCountry)DozerFactoryCustomConverter.convert(highCountry.getCountry().getValue().value(), DictionaryCountry.class));
			cobscountryOfBusiness.setCountry(dictionaryCountry);
			
			cobscountryOfBusiness.setPercentageOfBusinessInHRC((AttributeDouble)DozerFactoryCustomConverter.convert(highCountry.getPercenetageOfBusniess().getValue(), AttributeDouble.class));
			AttributeBoolean booleanValue = new AttributeBoolean();
			booleanValue.setValue(Boolean.YES);
			cobscountryOfBusiness.setHighRisk(booleanValue);
			
			countryOfBusiness.setValue(cobscountryOfBusiness);
			destination.add(countryOfBusiness);
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
	private Object mapCobsIdentifierToRaasIdentifier(List<AttributeCompanyCountryOfBusiness> source , PlaceOfBusiness destination) {
		
		PlaceOfBusiness raaSPlaceOfBusiness = new PlaceOfBusiness();
		List<CountryOfBusiness> businesses = null;
		List<CountryOfBusiness>  highBusinesses = null;
		
			if(destination.getCountriesOfBusiness() == null) {
				businesses = new ArrayList<CountryOfBusiness>();
			} else {
				businesses = destination.getCountriesOfBusiness();
			}
			
			if(destination.getHighRiskCountriesOfBusiness() == null) {
				highBusinesses = new ArrayList<CountryOfBusiness>();
			} else {
				highBusinesses = destination.getHighRiskCountriesOfBusiness();
			}
		for (AttributeCompanyCountryOfBusiness c : source) {
			
			CompanyCountryOfBusiness cobsCompanyCountry = c.getValue();
			if(cobsCompanyCountry.getHighRisk().getValue().equals(Boolean.NO)) {
				CountryOfBusiness business = new CountryOfBusiness();
				business.setCountry((CmAttributeCountry)DozerFactoryCustomConverter.convert(cobsCompanyCountry.getCountry().getValue().value(), CmAttributeCountry.class));
				business.setPercenetageOfBusniess((CmAttributeString)DozerFactoryCustomConverter.convert(cobsCompanyCountry.getPercentageOfBusinessInHRC().getValue(), CmAttributeString.class));
				business.setChallengeComment(StringUtils.isNotEmpty(c.getChallengeComment()) ? c.getChallengeComment() : "" );
				businesses.add(business);
				
			} else {
				CountryOfBusiness highBusiness = new CountryOfBusiness();
				highBusiness.setCountry((CmAttributeCountry)DozerFactoryCustomConverter.convert(cobsCompanyCountry.getCountry().getValue().value(), CmAttributeCountry.class));
				highBusiness.setPercenetageOfBusniess((CmAttributeString)DozerFactoryCustomConverter.convert(cobsCompanyCountry.getPercentageOfBusinessInHRC().getValue(), CmAttributeString.class));
				highBusiness.setChallengeComment(StringUtils.isNotEmpty(c.getChallengeComment()) ? c.getChallengeComment() : "" );
				highBusinesses.add(highBusiness);
			}
			
			raaSPlaceOfBusiness.setCountriesOfBusiness(businesses);
			raaSPlaceOfBusiness.setHighRiskCountriesOfBusiness(highBusinesses);
			
		}
		return raaSPlaceOfBusiness;
	}

}
