package com.headstrong.npi.raas.engine.converter.dozer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headstrong.npi.raas.cobs.xml.pojo.Attribute;
import com.headstrong.npi.raas.engine.converter.dozer.AdditionalElementsCustomConverter;
import com.headstrong.npi.raas.xml.pojo.CmAttribute;

public class Utils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	

	public static CmAttribute mapAttrToCmAttr(Attribute source ,  CmAttribute dest) {
		return AdditionalElementsCustomConverter.mapElementsFromCobsToRaas(source, dest);
	}
	
	public static Attribute mapCmAttrToAttr(CmAttribute source , Attribute dest) {
		return AdditionalElementsCustomConverter.mapElementsFromRaasToCobs(source, dest);
	}
	
	
	
}
