package com.hs.demos.effectiveJava;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.dom.DOMResult;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.headstrong.npi.raas.JAXBContextProvider;
import com.headstrong.npi.raas.xml.pojo.Option;

public class ConnectPOC {
	
	public static void main(String... args) {
		
		/*
			
With reference to our recent telephonic conversation, please accept my thanks for providing me the opportunity for joining ‘Capgemini’. I would like to know few things before we can agree upon

-	What is the joining bonus offered? Any clause, if any (especially bond period).
-	How much is the relocation allowance?
-	The salary structure offered. Does it contain any variable (or similar) component, which can impact on total in-hand.
-	% hike. I would appreciate an offer of 9 LPA (not negotiable), under the assumption, that there are no variable component and post-tax complete salary can be carried in-hand.

Also, I would like to correct my statement regarding my notice period in current Organization. My probation period(Dec-13 to Feb-14) is already over, and now the notice period is 2 month.
Please consider the above information in consideration.

		*/
		/*Connection c = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://10.101.10.34:3306/cobs_raas", "root", "root");
			System.out.println("Connection created : "+c);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		//"12/26/2013 11:01:30"
//		try {
//			XMLGregorianCalendar a = stringToXMLGregorianCalendar("12/26/2013 11:01:30");
//			String s = XMLGregorianCalendartoString(a);
//			System.out.println(a.toString());
//			System.out.println("String : "+s);
//		} catch (DatatypeConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		overloadedMethod(null);
//		ConnectPOC c = new ConnectPOC();
//		Addresses a = c.new Addresses();
//		
//		for(Field f : a.getClass().getDeclaredFields()) {
//			System.out.println(f.getName());
//		}

		
		
		
	}

	
	public static void m1(boolean a) {
		System.out.println(a);
	}
//	public static void overloadedMethod(String s) {
//		System.out.println("String method !");
//	}
//
//	public static void overloadedMethod(Object s) {
//		System.out.println("Object method !");
//	}
//
//class Addresses
//     implements Serializable
// {
//
//     private final static long serialVersionUID = 1L;
//     protected String registeredAddress;
//     protected String principalBusinessAddress;
//     protected String mailingAddress;
//     protected String domicileAddress;
// }
//	
	/**
	 * parse string to Xml GregorianCalendar in this 'MM/dd/yyyy hh:mm:ss'
	 * @param s
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws DatatypeConfigurationException
	 * @throws ParseException
	 */
	/*public static XMLGregorianCalendar stringToXMLGregorianCalendar(String s) 
		     throws DatatypeConfigurationException, ParseException {
			if(s != null && s.trim().length() > 0) {
				 XMLGregorianCalendar result = null;
				 Date date;
				 SimpleDateFormat simpleDateFormat;
				 GregorianCalendar gregorianCalendar;
				 
				 simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss" , Locale.US);
				                date = simpleDateFormat.parse(s);       
				                gregorianCalendar = 
				                    (GregorianCalendar)GregorianCalendar.getInstance();
				                gregorianCalendar.setTime(date);
				                result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
				                return result;
				
			}
			return null;
	}*/
	
//	/**
//	 * XML GregorianCalendar to String 
//	 * @param xmlCalendar
//	 * @return
//	 */
//	public static String XMLGregorianCalendartoString(XMLGregorianCalendar xmlCalendar) {
//		GregorianCalendar calendar = xmlCalendar.toGregorianCalendar();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss" , Locale.US);
//		return simpleDateFormat.format(calendar.getTime());
//	}
//	
//	public static void readSchemaFromJarFile() {
//		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		factory.newSchema
//	}

	public static void method(Class<?> c) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method m = c.getDeclaredMethod("value");
		System.out.println(m.invoke(null));
		
	}
	
	
}
