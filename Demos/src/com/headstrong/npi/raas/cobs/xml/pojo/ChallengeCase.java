//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.16 at 11:38:43 AM IST 
//


package com.headstrong.npi.raas.cobs.xml.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChallengeCase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChallengeCase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.markit.com}Case">
 *       &lt;sequence>
 *         &lt;element name="challengeUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="challengeSubscriber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="document" type="{http://www.markit.com}Document" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChallengeCase", propOrder = {
    "challengeUser",
    "challengeSubscriber",
    "document"
})
public class ChallengeCase
    extends Case
{

    @XmlElement(required = true)
    protected String challengeUser;
    @XmlElement(required = true)
    protected String challengeSubscriber;
    protected List<Document> document;

    /**
     * Gets the value of the challengeUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeUser() {
        return challengeUser;
    }

    /**
     * Sets the value of the challengeUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeUser(String value) {
        this.challengeUser = value;
    }

    /**
     * Gets the value of the challengeSubscriber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeSubscriber() {
        return challengeSubscriber;
    }

    /**
     * Sets the value of the challengeSubscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeSubscriber(String value) {
        this.challengeSubscriber = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Document }
     * 
     * 
     */
    public List<Document> getDocument() {
        if (document == null) {
            document = new ArrayList<Document>();
        }
        return this.document;
    }

    public void setDocument(List<Document> value) {
        this.document = value;
    }

}
