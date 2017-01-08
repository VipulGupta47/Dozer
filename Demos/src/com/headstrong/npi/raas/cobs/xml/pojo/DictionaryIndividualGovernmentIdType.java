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
 * <p>Java class for DictionaryIndividualGovernmentIdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DictionaryIndividualGovernmentIdType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Passport"/>
 *     &lt;enumeration value="Government Issued ID (e.g., Voter ID, Mexican Matricula, Armed Forces ID, Alien ID, National ID card, Driver's License)"/>
 *     &lt;enumeration value="Utility bill issued within the last 3 months"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DictionaryIndividualGovernmentIdType")
@XmlEnum
public enum DictionaryIndividualGovernmentIdType {

    @XmlEnumValue("Passport")
    PASSPORT("Passport"),
    @XmlEnumValue("Government Issued ID (e.g., Voter ID, Mexican Matricula, Armed Forces ID, Alien ID, National ID card, Driver's License)")
    GOVERNMENT_ISSUED_ID_E_G_VOTER_ID_MEXICAN_MATRICULA_ARMED_FORCES_ID_ALIEN_ID_NATIONAL_ID_CARD_DRIVER_S_LICENSE("Government Issued ID (e.g., Voter ID, Mexican Matricula, Armed Forces ID, Alien ID, National ID card, Driver's License)"),
    @XmlEnumValue("Utility bill issued within the last 3 months")
    UTILITY_BILL_ISSUED_WITHIN_THE_LAST_3_MONTHS("Utility bill issued within the last 3 months");
    private final String value;

    DictionaryIndividualGovernmentIdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DictionaryIndividualGovernmentIdType fromValue(String v) {
        for (DictionaryIndividualGovernmentIdType c: DictionaryIndividualGovernmentIdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}