package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.DozerConverter;

public class FiscalYearEndMonthConverter extends
DozerConverter<Integer, XMLGregorianCalendar> {
	
	public FiscalYearEndMonthConverter() {
		super(Integer.class, XMLGregorianCalendar.class);
	}

	@Override
	public XMLGregorianCalendar convertTo(Integer source,
			XMLGregorianCalendar destination) {
		return destination;
	}

	@Override
	public Integer convertFrom(XMLGregorianCalendar source, Integer destination) {
		return source.getMonth()+1;
	}

}
