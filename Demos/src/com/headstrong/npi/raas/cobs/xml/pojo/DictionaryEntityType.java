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
 * <p>Java class for DictionaryEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DictionaryEntityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Broker Dealer - Securities or Commodities"/>
 *     &lt;enumeration value="Credit Union"/>
 *     &lt;enumeration value="Futures Commission Merchant/Commodity Pool Operator/Commodity"/>
 *     &lt;enumeration value="Insurance"/>
 *     &lt;enumeration value="Investment Management"/>
 *     &lt;enumeration value="Trading Advisor"/>
 *     &lt;enumeration value="Trust"/>
 *     &lt;enumeration value="Other NBFI"/>
 *     &lt;enumeration value="Corporation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DictionaryEntityType")
@XmlEnum
public enum DictionaryEntityType {

    @XmlEnumValue("Broker Dealer - Securities or Commodities")
    BROKER_DEALER_SECURITIES_OR_COMMODITIES("Broker Dealer - Securities or Commodities"),
    @XmlEnumValue("Credit Union")
    CREDIT_UNION("Credit Union"),
    @XmlEnumValue("Futures Commission Merchant/Commodity Pool Operator/Commodity")
    FUTURES_COMMISSION_MERCHANT_COMMODITY_POOL_OPERATOR_COMMODITY("Futures Commission Merchant/Commodity Pool Operator/Commodity"),
    @XmlEnumValue("Insurance")
    INSURANCE("Insurance"),
    @XmlEnumValue("Investment Management")
    INVESTMENT_MANAGEMENT("Investment Management"),
    @XmlEnumValue("Trading Advisor")
    TRADING_ADVISOR("Trading Advisor"),
    @XmlEnumValue("Trust")
    TRUST("Trust"),
    @XmlEnumValue("Other NBFI")
    OTHER_NBFI("Other NBFI"),
    @XmlEnumValue("Corporation")
    CORPORATION("Corporation");
    private final String value;

    DictionaryEntityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DictionaryEntityType fromValue(String v) {
        for (DictionaryEntityType c: DictionaryEntityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}