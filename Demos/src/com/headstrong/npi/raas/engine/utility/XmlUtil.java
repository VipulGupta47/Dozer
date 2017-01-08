package com.headstrong.npi.raas.engine.utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

//import com.headstrong.npi.raas.cobs.xml.pojo.CobCmData;
/**
 * 
 * Utility class for XML.
 * Need not require Object for this class as all methods we go in this class as <em>static</em> method.
 * @author 400219569
 *
 */
public class XmlUtil {
	
	// can`t create object outside
	private XmlUtil(){};
	
	/**
	 * Generic method to Validate XML file while marshalling against their schema.
	 * 
	 * @param context
	 * @param schemaFile
	 * @param object
	 * @return
	 * @throws SAXException
	 * @throws JAXBException
	 */
	public static String validateAndMarshallXML(JAXBContext context, String schemaFile , Object object) throws SAXException, JAXBException {
		String xmlFormOfBean = null;
		
//		if (context != null && (schemaFile != null && schemaFile.trim().length() > 0)) {
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			QName qname = new QName("www.genpact.com","CobCmData");
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "www.genpact.com cob_cm.xsd ");
//			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);	// thread- safe 
//			marshaller.setSchema(sf.newSchema(new File(schemaFile)));	// validate jaxb context against schema 
			ByteArrayOutputStream sos = new ByteArrayOutputStream();	// for XML output into string

//			JAXBElement<CobCmData> rootElement = new JAXBElement<CobCmData>(qname,CobCmData.class,(CobCmData)object);
//			marshaller.marshal(rootElement, sos);  
//			xmlFormOfBean = sos.toString();
			
//		}
		return xmlFormOfBean;
	}
	
	/**
	 * Generic method to Validate XML file while unmarshalling against their schema.
	 * 
	 * @param context
	 * @param schemaFile
	 * @param object
	 * @return
	 * @throws SAXException
	 * @throws JAXBException
	 */
	public static Object validateAndUnmarshallXML(JAXBContext context, String schemaFile , InputStream fio) throws SAXException, JAXBException {
		
		if (context != null && (schemaFile != null && schemaFile.trim().length() > 0)) {
			Unmarshaller unMarshaller = context.createUnmarshaller();
			
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);	// thread- safe 
			unMarshaller.setSchema(sf.newSchema(new File(schemaFile)));	// validate jaxb context against schema 

			return unMarshaller.unmarshal(fio);
			
		}
		return null;
	}
	
	/**
	 *  Convert date from String to Xml GregorianCalendar in this 'MM/dd/yyyy hh:mm:ss'
	 * @param s
	 * @return
	 * @throws DatatypeConfigurationException
	 * @throws ParseException
	 */
	public static XMLGregorianCalendar stringToXMLGregorianCalendar(String s) 
		     throws DatatypeConfigurationException, ParseException {
			if(s != null && !(s.trim().length() < 1)) {
				 XMLGregorianCalendar result = null;
				 Date date;
				 SimpleDateFormat simpleDateFormat;
				 GregorianCalendar gregorianCalendar;
				 
				 simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                date = simpleDateFormat.parse(s);        
                gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
                gregorianCalendar.setTime(date);
                result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
                return result;
				
			}
			return null;
	}
	
	/**
	 * Convert date from XML GregorianCalendar to String in 'MM/dd/yyyy hh:mm:ss'
	 * 
	 * @param xmlCalendar
	 * @return String
	 */
	public static String XMLGregorianCalendartoString(XMLGregorianCalendar xmlCalendar) {
		GregorianCalendar calendar = xmlCalendar.toGregorianCalendar();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		return simpleDateFormat.format(calendar.getTime());
	}

}
