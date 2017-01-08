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
 * <p>Java class for Region.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Region">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Select One"/>
 *     &lt;enumeration value="North America"/>
 *     &lt;enumeration value="EMEA"/>
 *     &lt;enumeration value="LATAM"/>
 *     &lt;enumeration value="Asia-Pac"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Region")
@XmlEnum
public enum Region {

    @XmlEnumValue("Select One")
    SELECT_ONE("Select One"),
    @XmlEnumValue("North America")
    NORTH_AMERICA("North America"),
    EMEA("EMEA"),
    LATAM("LATAM"),
    @XmlEnumValue("Asia-Pac")
    ASIA_PAC("Asia-Pac");
    private final String value;

    Region(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Region fromValue(String v) {
        for (Region c: Region.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
