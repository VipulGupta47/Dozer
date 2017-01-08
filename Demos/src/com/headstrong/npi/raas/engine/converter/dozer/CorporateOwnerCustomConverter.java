package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeAddress;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeBoolean;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBearerShare;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBeneficialOwner;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyBusinessActivityIndustryCode;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyFormation;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyGovernmentOwnership;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyListedInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeCompanyRegulatedInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryExchange;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDictionaryRegulator;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDouble;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeString;
import com.headstrong.npi.raas.cobs.xml.pojo.Boolean;
import com.headstrong.npi.raas.cobs.xml.pojo.Company;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyBearerShare;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyBeneficialOwner;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyFormation;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyGovernmentOwnership;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyListedInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.CompanyRegulatedInfo;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryCountry;
import com.headstrong.npi.raas.cobs.xml.pojo.DictionaryRegulator;
import com.headstrong.npi.raas.cobs.xml.pojo.Entity;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.CmAttributeString;
import com.headstrong.npi.raas.xml.pojo.Country;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipCorporate;
import com.headstrong.npi.raas.xml.pojo.IndustryClassification;


/**
 * 	protected List<Entity.Ownership.OwnershipCorporate> ownershipCorporate;
 * 				protected Integer id;
	            protected CmAttributeString type;
	            protected CmAttributeString level;
	            protected CmAttributeString percentageOfOwnership;
	            protected CmAttributeString legalName;
	            protected CmAttributeString mei;
	            protected List<Address> address;
	            protected CmAttributeLegalForm legalForm;
	            protected CmAttributeCountry countryOfIncorporation;
	            protected CmAttributeBoolean listedStatus;
	            protected CmAttributeString listedExchange;
	            protected CmAttributeBoolean approvedExchange;
	            protected CmAttributeBoolean regulatedStatus;
	            protected CmAttributeString regulator;
	            protected CmAttributeBoolean approvedRegulator;
	            protected CmAttributeBoolean govtInterstDirectOrIndirect;
	            protected CmAttributeString govtIdentity;
	            protected CmAttributeString govtIDInfo;
	            protected CmAttributeString bearerSharerInfo;
	            
	protected List<AttributeCompanyBeneficialOwner> beneficialOwner; 	           
                protected AttributeString wealthSource;
				protected AttributeString level;
				protected AttributeDouble percentageOwnership;
				protected Entity entity;
 * 
 * 
 * @author 400219569
 *
 */
public class CorporateOwnerCustomConverter implements CustomConverter{

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination,
			Object source, Class<?> destinationClass,
			Class<?> sourceClass) {
	
		if( source == null || ((List<?>)source).size() < 1) {	// source is always list
			return null;
		}
		List<OwnershipCorporate> raasOwnershipCorporates = null;
		List<AttributeCompanyBeneficialOwner> cobsBeneficialOwners = null;
		if(((List<?>)source).get(0) instanceof OwnershipCorporate) {
			
			raasOwnershipCorporates = ((List<OwnershipCorporate>)source);	// checked cast as this class is only for OwnershipCorporate
			cobsBeneficialOwners = ((List<AttributeCompanyBeneficialOwner>)destination);
			if(cobsBeneficialOwners == null) {
				cobsBeneficialOwners = new ArrayList<AttributeCompanyBeneficialOwner>();
			} 
			
			return mapOwnersToCobsBeneficial(raasOwnershipCorporates, cobsBeneficialOwners, false);
			
		} else if(((List<?>)source).get(0) instanceof AttributeCompanyBeneficialOwner){
			cobsBeneficialOwners = ((List<AttributeCompanyBeneficialOwner>)source);
			raasOwnershipCorporates = ((List<OwnershipCorporate>)destination);	// checked cast as this class is only for OwnershipCorporate
			
			if(raasOwnershipCorporates == null) {
				raasOwnershipCorporates = new ArrayList<OwnershipCorporate>();
			} 
			
			return mapCobsBeneficialToOwners(cobsBeneficialOwners , raasOwnershipCorporates);
		} 
//		else {
//			throw new MappingException("Converter CorporateOwnerCustomConverter "
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
	            protected CmAttributeString legalName;
	            protected CmAttributeString mei;
	            protected List<Address> address;
	            protected CmAttributeLegalForm legalForm;
	            protected CmAttributeCountry countryOfIncorporation;
	            protected CmAttributeBoolean listedStatus;
	            protected CmAttributeString listedExchange;
	            protected CmAttributeBoolean approvedExchange;
	            protected CmAttributeBoolean regulatedStatus;
	            protected CmAttributeString regulator;
	            protected CmAttributeBoolean approvedRegulator;
	            protected CmAttributeBoolean govtInterstDirectOrIndirect;
	            protected CmAttributeString govtIdentity;
	            protected CmAttributeString govtIDInfo;
	            protected CmAttributeString bearerSharerInfo;
	            
		protected List<AttributeCompanyBeneficialOwner> beneficialOwner; 	           
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
	public Object mapCobsBeneficialToOwners(List<AttributeCompanyBeneficialOwner> sourceList, List<OwnershipCorporate> destinationList) {
		
		for(AttributeCompanyBeneficialOwner beneficialOwner : sourceList) {
			CompanyBeneficialOwner companyBeneficialOwner =  beneficialOwner.getValue();
			Entity cobsEntity = companyBeneficialOwner.getEntity();
			if(cobsEntity instanceof Company) {
				OwnershipCorporate corporate = new OwnershipCorporate();
				Company ownerCompany = (Company)cobsEntity;
				
				corporate.setType(Utils.getCmAttrString("Corporate"));
				
				if(companyBeneficialOwner.getLevel() != null) {
					corporate.setLevel(Utils.getCmAttrString((companyBeneficialOwner.getLevel() != null ? companyBeneficialOwner.getLevel().getValue() : null)));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(companyBeneficialOwner.getLevel(), corporate.getLevel());
				}
				if(companyBeneficialOwner.getPercentageOwnership() != null) {
					corporate.setPercentageOfOwnership(Utils.getCmAttrString((companyBeneficialOwner.getPercentageOwnership() != null) ? String.valueOf(companyBeneficialOwner.getPercentageOwnership().getValue()) : null));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(companyBeneficialOwner.getPercentageOwnership(), corporate.getPercentageOfOwnership());
				}
				if(ownerCompany.getLegalName() != null) {
					corporate.setLegalName(Utils.getCmAttrString((ownerCompany.getLegalName() != null) ? ownerCompany.getLegalName().getValue(): null));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(ownerCompany.getLegalName(), corporate.getLegalName());
				}
				corporate.setMEI(Utils.getCmAttrString(ownerCompany.getMei()));
				
				List<AttributeAddress> addressList= ownerCompany.getAddresses();
				if(addressList != null 
						&& (addressList.size() > 0)) {
					AddressCustomConverter converter = new AddressCustomConverter();
					List<Address> addresses = new ArrayList<Address>();
					converter.mapCobsContactAddressToProfileAddress(addressList,addresses);
					corporate.setAddress(addresses);
				}
				corporate.setLegalForm(Utils.getCmAttrLegalForm((ownerCompany.getLegalForm() != null) ? ownerCompany.getLegalForm().getValue(): null));
				if(ownerCompany.getFormation() != null) {
					AttributeDictionaryCountry country = ownerCompany.getFormation().getValue().getIncorporationCountry();
					if(country!= null){
						corporate.setCountryOfIncorporation(Utils.getCmAttrCountry(country.getValue().value()));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(country, corporate.getCountryOfIncorporation());
						
					}
				}
				if(ownerCompany.getListedInfo() != null) {
					CompanyListedInfo info = ownerCompany.getListedInfo().getValue();
					if(info != null) {
						corporate.setListedStatus(Utils.getCmAttrBoolean(String.valueOf((info.getIsPubliclyListed().getValue().value().equals(Boolean.YES) ? true:false))));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(info.getIsPubliclyListed(), corporate.getListedStatus());
						
						corporate.setListedExchange(Utils.getCmAttrString(info.getPrimaryExchange().getValue()));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(info.getPrimaryExchange(), corporate.getListedExchange());

						corporate.setApprovedExchange(Utils.getCmAttrBoolean(String.valueOf(info.getIsPrimaryExchangeApproved().getValue().equals(Boolean.YES) ? true:false)));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(info.getIsPrimaryExchangeApproved(), corporate.getApprovedExchange());
						
					}
				}
				if(ownerCompany.getRegulatedInfo() != null) {
					CompanyRegulatedInfo regulatedInfo =  ownerCompany.getRegulatedInfo().getValue();
					if(regulatedInfo != null) {
						corporate.setRegulatedStatus(Utils.getCmAttrBoolean(regulatedInfo.getRegulationStatus().getValue()));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(regulatedInfo.getRegulationStatus(), corporate.getRegulatedStatus());
						
						corporate.setRegulator(Utils.getCmAttrString(regulatedInfo.getRegulatoryAuthority().getValue().value()));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(regulatedInfo.getRegulatoryAuthority(), corporate.getRegulator());
						
						corporate.setApprovedRegulator(Utils.getCmAttrBoolean(String.valueOf(regulatedInfo.getIsApprovedRegulator().getValue().value().equals(Boolean.YES) ? true:false)));
						com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(regulatedInfo.getIsApprovedRegulator(), corporate.getApprovedRegulator());
					}
				}
				
				if(ownerCompany.getGovernmentOwnership()!=null) {
					CompanyGovernmentOwnership ownership = ownerCompany.getGovernmentOwnership().getValue();
					corporate.setGovtInterstDirectOrIndirect(Utils.getCmAttrBoolean((ownership.getGovernmentEntityIdentified()!=null)?ownership.getGovernmentEntityIdentified().getValue().value() : null));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(ownership.getGovernmentEntityIdentified(), corporate.getGovtInterstDirectOrIndirect());
					
					corporate.setGovtIdentity(Utils.getCmAttrString((ownership.getGovernmentEntityName()!=null)?ownership.getGovernmentEntityName().getValue() :null));
					com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(ownership.getGovernmentEntityName(), corporate.getGovtIdentity());
				}
				
				if(ownerCompany.getBearerShare() != null) {
					CompanyBearerShare bearerShare = ownerCompany.getBearerShare().getValue();
					if(bearerShare  != null) {
						if(bearerShare.getCustodianName() != null) {
							corporate.setBearerSharerInfo(Utils.getCmAttrString((bearerShare.getCustodianName() != null ? bearerShare.getCustodianName().getValue() : null)));
							com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapAttrToCmAttr(bearerShare.getCustodianName(), corporate.getBearerSharerInfo());
						}
					}
				}
//				Additional Attributes Added
				AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(beneficialOwner, corporate);
				destinationList.add(corporate);
			}
		}
		return destinationList;
	}
	
	public Object mapOwnersToCobsBeneficial( List<OwnershipCorporate> sourceList, List<AttributeCompanyBeneficialOwner> destinationList , boolean parent) {
		
		for(OwnershipCorporate ownershipCorporate : sourceList) {
			if(!parent) {	// check if it`s Immediate or Ultimate Parent
				CmAttributeString attr = ownershipCorporate.getLevel();
				if(attr!= null) {
				String level = attr.getValue();
					if(level.equalsIgnoreCase("Immediate") 
						|| level.equalsIgnoreCase("Ultimate") ) {
						
						continue;
					}
				}
			}
				
			AttributeCompanyBeneficialOwner cobsEntity = new AttributeCompanyBeneficialOwner();
			CompanyBeneficialOwner beneficialOwner = new CompanyBeneficialOwner();
			Company company = new Company();
			

			if(ownershipCorporate.getLevel() != null) {
				beneficialOwner.setLevel(Utils.getAttributeStringValue((ownershipCorporate.getLevel() != null)?ownershipCorporate.getLevel().getValue() :null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getLevel(), beneficialOwner.getLevel());
			}
			if(ownershipCorporate.getPercentageOfOwnership() != null) {
				beneficialOwner.setPercentageOwnership(Utils.getAttributeDoubleValue(ownershipCorporate.getPercentageOfOwnership().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getPercentageOfOwnership(), beneficialOwner.getPercentageOwnership());				
			}
			
			if(ownershipCorporate.getLegalName() != null) {
				company.setLegalName(Utils.getAttributeStringValue((ownershipCorporate.getLegalName() != null)?ownershipCorporate.getLegalName().getValue() : null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getLegalName(), company.getLegalName());
			}
			
			company.setMei((ownershipCorporate.getMEI() != null)?ownershipCorporate.getMEI().getValue() : null);
//			Already mapped additional Attribute
			List<Address> addresses = ownershipCorporate.getAddress();
			if(addresses != null 
					&& (addresses.size() > 0)) {
				AddressCustomConverter converter = new AddressCustomConverter();
				List<AttributeAddress> addressList = new ArrayList<AttributeAddress>();
				converter.mapProfileAddressToCobsAddress(addresses, addressList);
				company.setAddresses(addressList);
			}
			
			if(ownershipCorporate.getLegalForm() != null) {
				company.setLegalForm(Utils.getAttributeStringValue((ownershipCorporate.getLegalForm()!=null)?ownershipCorporate.getLegalForm().getValue().value():null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getLegalForm(), company.getLegalForm());
				
			}
			
			AttributeCompanyFormation formation = null;
			if(ownershipCorporate.getCountryOfIncorporation() != null) {
				formation = new AttributeCompanyFormation();
				CompanyFormation companyFormation = new CompanyFormation();
				AttributeDictionaryCountry country = new AttributeDictionaryCountry();
				country.setValue(DictionaryCountry.fromValue(ownershipCorporate.getCountryOfIncorporation().getValue().value()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getCountryOfIncorporation(), country);
				companyFormation.setIncorporationCountry(country);
				formation.setValue(companyFormation);
			}
			company.setFormation(formation);
			
			AttributeCompanyListedInfo listedInfo = new AttributeCompanyListedInfo();
			CompanyListedInfo companyListedInfo = new CompanyListedInfo();
			if(ownershipCorporate.getListedStatus()!=null) {
				companyListedInfo.setIsPubliclyListed(Utils.getAttributeBooleanValue(ownershipCorporate.getListedStatus().isValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getListedStatus(), companyListedInfo.getIsPubliclyListed());
				
			}

			AttributeDictionaryExchange exchange = new AttributeDictionaryExchange();
			if(ownershipCorporate.getListedExchange()!=null) {
				exchange.setValue(ownershipCorporate.getListedExchange().getValue());
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getListedExchange(), exchange);
				companyListedInfo.setPrimaryExchange(exchange);
				
			}
			if(ownershipCorporate.getApprovedExchange()!=null) {
				companyListedInfo.setIsPrimaryExchangeApproved(Utils.getAttributeBooleanValue(ownershipCorporate.getApprovedExchange().isValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getApprovedExchange(), companyListedInfo.getIsPrimaryExchangeApproved());
			}
			
			listedInfo.setValue(companyListedInfo);
			company.setListedInfo(listedInfo);
			
			AttributeCompanyRegulatedInfo regulatedInfo = new AttributeCompanyRegulatedInfo();
			CompanyRegulatedInfo companyRegulatedInfo = new CompanyRegulatedInfo();
			if(ownershipCorporate.getRegulatedStatus()!=null) {
				companyRegulatedInfo.setRegulationStatus(Utils.getAttributeStringValue(String.valueOf(ownershipCorporate.getRegulatedStatus().isValue())));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getRegulatedStatus(), companyRegulatedInfo.getRegulationStatus());
			}
			
			AttributeDictionaryRegulator regulator = new AttributeDictionaryRegulator();
			if(ownershipCorporate.getRegulator()!=null) {
				regulator.setValue(DictionaryRegulator.fromValue(ownershipCorporate.getRegulator().getValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getRegulator(), regulator);
				companyRegulatedInfo.setRegulatoryAuthority(regulator);
			}
			if(ownershipCorporate.getApprovedRegulator()!=null) {
				companyRegulatedInfo.setIsApprovedRegulator(Utils.getAttributeBooleanValue(ownershipCorporate.getApprovedRegulator().isValue()));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getApprovedRegulator(), companyRegulatedInfo.getIsApprovedRegulator());
			}
			
			regulatedInfo.setValue(companyRegulatedInfo);
			company.setRegulatedInfo(regulatedInfo);
			
			AttributeCompanyGovernmentOwnership ownership = new AttributeCompanyGovernmentOwnership();
			CompanyGovernmentOwnership governmentOwnership = new CompanyGovernmentOwnership();
			if(ownershipCorporate.getGovtInterstDirectOrIndirect()!= null) {
				governmentOwnership.setGovernmentEntityIdentified(Utils.getAttributeBooleanValue((ownershipCorporate.getGovtInterstDirectOrIndirect()!= null)?ownershipCorporate.getGovtInterstDirectOrIndirect().isValue() :null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getGovtInterstDirectOrIndirect(), governmentOwnership.getGovernmentEntityIdentified());
			}
			if(ownershipCorporate.getGovtIdentity() != null) {
				governmentOwnership.setGovernmentEntityName(Utils.getAttributeStringValue((ownershipCorporate.getGovtIdentity()!=null) ?ownershipCorporate.getGovtIdentity().getValue() :null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getGovtIdentity(), governmentOwnership.getGovernmentEntityName());
			}
			ownership.setValue(governmentOwnership);
			company.setGovernmentOwnership(ownership);
			
			AttributeCompanyBearerShare share = new AttributeCompanyBearerShare();
			CompanyBearerShare companyBearerShare = new CompanyBearerShare();
			if(ownershipCorporate.getBearerSharerInfo() != null) {
				companyBearerShare.setCustodianName(Utils.getAttributeStringValue((ownershipCorporate.getBearerSharerInfo()!=null)?ownershipCorporate.getBearerSharerInfo().getValue():null));
				com.headstrong.npi.raas.engine.converter.dozer.util.Utils.mapCmAttrToAttr(ownershipCorporate.getBearerSharerInfo(), companyBearerShare.getCustodianName());
			}
			share.setValue(companyBearerShare);
			company.setBearerShare(share);	
			
			beneficialOwner.setEntity(company);
			cobsEntity.setValue(beneficialOwner);
//			Additional Attributes Added
			AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(ownershipCorporate, cobsEntity);
			destinationList.add(cobsEntity);
				

		}
		return destinationList;

	}
}
