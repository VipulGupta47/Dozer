//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.16 at 11:38:43 AM IST 
//


package com.headstrong.npi.raas.cobs.xml.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeCompanyGovernmentOwnership complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributeCompanyGovernmentOwnership">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.markit.com}Attribute">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.markit.com}CompanyGovernmentOwnership"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeCompanyGovernmentOwnership", propOrder = {
    "value"
})
public class AttributeCompanyGovernmentOwnership
    extends Attribute
{

    @XmlElement(required = true)
    protected CompanyGovernmentOwnership value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyGovernmentOwnership }
     *     
     */
    public CompanyGovernmentOwnership getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyGovernmentOwnership }
     *     
     */
    public void setValue(CompanyGovernmentOwnership value) {
        this.value = value;
    }

}
