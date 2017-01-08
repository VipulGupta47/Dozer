//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.22 at 12:19:25 PM IST 
//


package com.headstrong.npi.raas.xml.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityAliases complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntityAliases">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PreviousNames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradeStyle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DoingBusinessAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityAliases", propOrder = {
    "previousNames",
    "shortName",
    "tradeStyle",
    "doingBusinessAs"
})
public class EntityAliases
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PreviousNames")
    protected List<String> previousNames;
    @XmlElement(name = "ShortName")
    protected String shortName;
    @XmlElement(name = "TradeStyle")
    protected String tradeStyle;
    @XmlElement(name = "DoingBusinessAs")
    protected String doingBusinessAs;

    /**
     * Gets the value of the previousNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previousNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreviousNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPreviousNames() {
        if (previousNames == null) {
            previousNames = new ArrayList<String>();
        }
        return this.previousNames;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the tradeStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeStyle() {
        return tradeStyle;
    }

    /**
     * Sets the value of the tradeStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeStyle(String value) {
        this.tradeStyle = value;
    }

    /**
     * Gets the value of the doingBusinessAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoingBusinessAs() {
        return doingBusinessAs;
    }

    /**
     * Sets the value of the doingBusinessAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoingBusinessAs(String value) {
        this.doingBusinessAs = value;
    }

    public void setPreviousNames(List<String> value) {
        this.previousNames = value;
    }

}