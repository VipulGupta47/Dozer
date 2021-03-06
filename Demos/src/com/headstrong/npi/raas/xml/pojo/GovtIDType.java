//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.22 at 12:19:25 PM IST 
//


package com.headstrong.npi.raas.xml.pojo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovtIDType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GovtIDType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tax ID/EIN"/>
 *     &lt;enumeration value="Registration ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GovtIDType")
@XmlEnum
public enum GovtIDType {

    @XmlEnumValue("Tax ID/EIN")
    TAX_ID_EIN("Tax ID/EIN"),
    @XmlEnumValue("Registration ID")
    REGISTRATION_ID("Registration ID");
    private final String value;

    GovtIDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GovtIDType fromValue(String v) {
        for (GovtIDType c: GovtIDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
