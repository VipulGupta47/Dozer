package com.headstrong.npi.raas.engine.converter.dozer;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.DateConversion;


/**
 * Date Conversion from String to XMLGregorianCalendar and vice-versa.
 * 
 * @author Nitin Kumar
 *
 */
public class DateCustomConverter implements CustomConverter {
	
	@Override
	public Object convert(Object destinationFieldValue,Object sourceFieldValue, 
			Class<?> destinationClass,Class<?> sourceClass) {
		
		if(sourceFieldValue == null) {
			return null;
		}
		
		if(destinationClass.getSimpleName().equalsIgnoreCase("XMLGregorianCalendar")){
			
			Date date = DateConversion.convertStringToDate((String) sourceFieldValue ,DateConversion.getDateTimeFormatUs4());
			if(date == null)return null;
			return DateConversion.asXMLGregorianCalendar(date);
			
		} else if(destinationClass.getSimpleName().equalsIgnoreCase("String")) {
			return DateConversion.XMLGregorianCalendartoString((XMLGregorianCalendar)sourceFieldValue , DateConversion.getDateTimeFormatUs4());
		} 
//		else {
//			throw new MappingException("Converter DateCustomConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ sourceFieldValue + " and " + destinationFieldValue);
//		}
		return null;
	}
	
	
	
}
