package com.headstrong.npi.raas.cobs.converter.dozer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.CustomConverter;
import org.dozer.MappingException;


/**
 * Date Conversion from String to XMLGregorianCalendar and vice-versa.
 * 
 * @author Nitin Kumar
 *
 */
public class DateCustomConverter implements CustomConverter {
	
private static final Set<String> DATE_FORMAT = new HashSet<String>();
private static final String REVERSE_DEFAULT_FORMAT = "MM/dd/yyyy";
private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("dozer");
	static {	// load format starting time
		
		DATE_FORMAT.add(BUNDLE.getString("MM/dd/yyyy"));
        DATE_FORMAT.add(BUNDLE.getString("dd.M.yyyy"));
        DATE_FORMAT.add(BUNDLE.getString("MM/dd/yyyyhhmmssa"));
        DATE_FORMAT.add(BUNDLE.getString("dd.MM.yyyyhhmmssa"));
        DATE_FORMAT.add(BUNDLE.getString("dd.MMM.yyyy"));
        DATE_FORMAT.add(BUNDLE.getString("dd-MMM-yyyy"));
	}

	 private DateFormat dateFormat;

	  public DateCustomConverter(DateFormat dateFormat) {
	    this.dateFormat = dateFormat;
	  }

	  public DateCustomConverter() {
	  }
	
	  /**
	   * Cache the DatatypeFactory because newInstance is very expensive.
	   */
	  private static DatatypeFactory dataTypeFactory;

	  /**
	   * Returns a new instance of DatatypeFactory, or the cached one if previously created.
	   *
	   * @return instance of DatatypeFactory
	   */
	  private static DatatypeFactory dataTypeFactory() {
	    if (dataTypeFactory == null) {
	      try {
	        dataTypeFactory = DatatypeFactory.newInstance();
	      } catch (DatatypeConfigurationException e) {
	        throw new MappingException(e);
	      }
	    }
	    return dataTypeFactory;
	  }

	
	/**
     * Convert String with various formats into java.util.Date
     * 
     * @param input
     *            Date as a string
     * @return java.util.Date object if input string is parsed 
     *          successfully else returns null
     */
    public static Date convertToDate(String input) {
        Date date = null;
        if(input == null || input.trim().length()<1) {
            return null;
        }
        for (String s : DATE_FORMAT) {
            try {
            	SimpleDateFormat format = new SimpleDateFormat(s);
                format.setLenient(false);
                date = format.parse(input);
            } catch (ParseException e) {
                
            }
            if (date != null) {
                break;
            }
        }
 
        return date;
    }
	
	@Override
	public Object convert(Object destinationFieldValue,Object sourceFieldValue, 
			Class<?> destinationClass,Class<?> sourceClass) {
		
		if(sourceFieldValue == null) {
			return null;
		}
		
		if(destinationClass.getSimpleName().equalsIgnoreCase("XMLGregorianCalendar")){
			
			Calendar result = new GregorianCalendar();
			Date date = convertToDate((String) sourceFieldValue);
			if(date == null)return null;
			result.setTime(date);
			
			return dataTypeFactory().newXMLGregorianCalendar((GregorianCalendar) result);
			
		} else if(destinationClass.getSimpleName().equalsIgnoreCase("String")) {
			return XMLGregorianCalendartoString((XMLGregorianCalendar)sourceFieldValue , null);
		} else {
			throw new MappingException("Converter DateCustomConverter "
					+ "used incorrectly. Arguments passed in were:"
					+ sourceFieldValue + " and " + destinationFieldValue);
		}
	}
	
	/**
	 * Convert date from XML GregorianCalendar to String in 'MM/dd/yyyy hh:mm:ss'
	 * 
	 * @param xmlCalendar XMLGregorianCalendar INSTANCE
	 * @return String
	 */
	public static String XMLGregorianCalendartoString(XMLGregorianCalendar xmlCalendar, DateFormat format) {
		if(xmlCalendar == null) {
			return null;
		}
		GregorianCalendar calendar = xmlCalendar.toGregorianCalendar();
		if(format == null) {
			format = new SimpleDateFormat(REVERSE_DEFAULT_FORMAT);
		}
		return format.format(calendar.getTime());
	}
	
}
