//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.20 at 04:30:32 PM EDT 
//


package com.headstrong.npi.raas.xml.pojo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="validationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Format"/>
 *     &lt;enumeration value="Data"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "validationType")
@XmlEnum
public enum ValidationType {

    @XmlEnumValue("Format")
    FORMAT("Format"),
    @XmlEnumValue("Data")
    DATA("Data");
    private final String value;

    ValidationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationType fromValue(String v) {
        for (ValidationType c: ValidationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
