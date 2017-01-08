//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.16 at 11:38:43 AM IST 
//


package com.headstrong.npi.raas.cobs.xml.pojo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaseResponseStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CaseResponseStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Completed with Missing Information"/>
 *     &lt;enumeration value="Rejected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CaseResponseStatus")
@XmlEnum
public enum CaseResponseStatus {

    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("Completed with Missing Information")
    COMPLETED_WITH_MISSING_INFORMATION("Completed with Missing Information"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected");
    private final String value;

    CaseResponseStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CaseResponseStatus fromValue(String v) {
        for (CaseResponseStatus c: CaseResponseStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}