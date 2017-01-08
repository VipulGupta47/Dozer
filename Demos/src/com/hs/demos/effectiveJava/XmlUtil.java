package com.hs.demos.effectiveJava;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;
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
		
		if (context != null && (schemaFile != null && schemaFile.trim().length() > 0)) {
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);	// thread- safe 
			marshaller.setSchema(sf.newSchema(new File(schemaFile)));	// validate jaxb context against schema 
			ByteArrayOutputStream sos = new ByteArrayOutputStream();	// for XML output into string

			marshaller.marshal(object, sos);
			xmlFormOfBean = sos.toString();
			
		}
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
	
	@SuppressWarnings("unchecked")
	public static  <T> T setEmptyIfNullObject(final Object value) {
		return (T) (value == null ? "" : value.getClass().cast(value));
	}
	
	public static void main(String... args) {
//		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		InputStream configStream = Class.getResourceAsStream("wof.txt");
//		BufferedReader configReader = new BufferedReader(new InputStreamReader(configStream, "UTF-8"));
//		sf.newSchema();
//		XmlUtil x = new XmlUtil();
		System.out.println(Long.valueOf(""));
//		System.out.println(x.getC());
//		System.out.println("check value :"+setEmptyIfNullObject()+" dsnfjksd");
		
	}
	
	static class  che {
		private String che;

		public String getChe() {
			return che;
		}

		public void setChe(String che) {
			this.che = che;
		}
		
		
	}
	XmlUtil.che c;
	public che getC() {
		return this.c;
	}


}
