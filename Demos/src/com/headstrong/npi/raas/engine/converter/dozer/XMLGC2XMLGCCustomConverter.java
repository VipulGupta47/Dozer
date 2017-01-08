package com.headstrong.npi.raas.engine.converter.dozer;

import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.DozerConverter;

public class XMLGC2XMLGCCustomConverter extends
DozerConverter<XMLGregorianCalendar, XMLGregorianCalendar> {
	
	public XMLGC2XMLGCCustomConverter() {
		super(XMLGregorianCalendar.class, XMLGregorianCalendar.class);
	}

	@Override
	public XMLGregorianCalendar convertFrom(XMLGregorianCalendar src,
	XMLGregorianCalendar dest) {
		return src;
	}
	@Override
	public XMLGregorianCalendar convertTo(XMLGregorianCalendar src,
	XMLGregorianCalendar dest) {
		return dest;
	}
}
