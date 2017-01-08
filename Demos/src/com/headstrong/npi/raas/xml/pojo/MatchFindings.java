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
 * <p>Java class for MatchFindings.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MatchFindings">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="True Match"/>
 *     &lt;enumeration value="Potential Match"/>
 *     &lt;enumeration value="No Match"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MatchFindings")
@XmlEnum
public enum MatchFindings {

    @XmlEnumValue("True Match")
    TRUE_MATCH("True Match"),
    @XmlEnumValue("Potential Match")
    POTENTIAL_MATCH("Potential Match"),
    @XmlEnumValue("No Match")
    NO_MATCH("No Match");
    private final String value;

    MatchFindings(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MatchFindings fromValue(String v) {
        for (MatchFindings c: MatchFindings.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
