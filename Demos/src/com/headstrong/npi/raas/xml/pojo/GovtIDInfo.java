//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.22 at 12:19:25 PM IST 
//


package com.headstrong.npi.raas.xml.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovtIDInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovtIDInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{www.headstrong.com/common}CmAttribute">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GovtIDType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GovtIDNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GovtIDApplDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovtIDInfo", propOrder = {
    "id",
    "govtIDType",
    "govtIDNum",
    "govtIDApplDate"
})
public class GovtIDInfo
    extends CmAttribute
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String id;
    @XmlElement(name = "GovtIDType", required = true)
    protected String govtIDType;
    @XmlElement(name = "GovtIDNum")
    protected String govtIDNum;
    @XmlElement(name = "GovtIDApplDate")
    protected String govtIDApplDate;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the govtIDType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovtIDType() {
        return govtIDType;
    }

    /**
     * Sets the value of the govtIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovtIDType(String value) {
        this.govtIDType = value;
    }

    /**
     * Gets the value of the govtIDNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovtIDNum() {
        return govtIDNum;
    }

    /**
     * Sets the value of the govtIDNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovtIDNum(String value) {
        this.govtIDNum = value;
    }

    /**
     * Gets the value of the govtIDApplDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovtIDApplDate() {
        return govtIDApplDate;
    }

    /**
     * Sets the value of the govtIDApplDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovtIDApplDate(String value) {
        this.govtIDApplDate = value;
    }

}
