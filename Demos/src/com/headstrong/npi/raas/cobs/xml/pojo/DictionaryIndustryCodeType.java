//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.16 at 11:38:43 AM IST 
//


package com.headstrong.npi.raas.cobs.xml.pojo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DictionaryIndustryCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DictionaryIndustryCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NAICS"/>
 *     &lt;enumeration value="NACE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DictionaryIndustryCodeType")
@XmlEnum
public enum DictionaryIndustryCodeType {

    NAICS,
    NACE;

    public String value() {
        return name();
    }

    public static DictionaryIndustryCodeType fromValue(String v) {
        return valueOf(v);
    }

}
