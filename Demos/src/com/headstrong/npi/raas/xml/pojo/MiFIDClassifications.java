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
 * <p>Java class for MiFIDClassifications.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MiFIDClassifications">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Eligible Counterparty"/>
 *     &lt;enumeration value="Professional Counterparty"/>
 *     &lt;enumeration value="Retail Client"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MiFIDClassifications")
@XmlEnum
public enum MiFIDClassifications {

    @XmlEnumValue("Eligible Counterparty")
    ELIGIBLE_COUNTERPARTY("Eligible Counterparty"),
    @XmlEnumValue("Professional Counterparty")
    PROFESSIONAL_COUNTERPARTY("Professional Counterparty"),
    @XmlEnumValue("Retail Client")
    RETAIL_CLIENT("Retail Client");
    private final String value;

    MiFIDClassifications(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MiFIDClassifications fromValue(String v) {
        for (MiFIDClassifications c: MiFIDClassifications.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}