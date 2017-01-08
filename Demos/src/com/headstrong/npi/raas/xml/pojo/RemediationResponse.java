//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.20 at 04:27:13 PM EDT 
//


package com.headstrong.npi.raas.xml.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RemediationProfile" type="{www.headstrong.com/RemidiationResponse}ResponseRemediationProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ResponsePublicationDateTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ResponseFileId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RecordCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "remediationProfile"
})
@XmlRootElement(name = "RemediationResponse", namespace = "www.headstrong.com/RemidiationResponse")
public class RemediationResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "RemediationProfile")
    protected List<ResponseRemediationProfile> remediationProfile;
    @XmlAttribute(name = "ResponsePublicationDateTime")
    protected String responsePublicationDateTime;
    @XmlAttribute(name = "ResponseFileId")
    protected String responseFileId;
    @XmlAttribute(name = "RecordCount")
    protected Integer recordCount;

    /**
     * Gets the value of the remediationProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remediationProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemediationProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseRemediationProfile }
     * 
     * 
     */
    public List<ResponseRemediationProfile> getRemediationProfile() {
        if (remediationProfile == null) {
            remediationProfile = new ArrayList<ResponseRemediationProfile>();
        }
        return this.remediationProfile;
    }

    /**
     * Gets the value of the responsePublicationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsePublicationDateTime() {
        return responsePublicationDateTime;
    }

    /**
     * Sets the value of the responsePublicationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsePublicationDateTime(String value) {
        this.responsePublicationDateTime = value;
    }

    /**
     * Gets the value of the responseFileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseFileId() {
        return responseFileId;
    }

    /**
     * Sets the value of the responseFileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseFileId(String value) {
        this.responseFileId = value;
    }

    /**
     * Gets the value of the recordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the value of the recordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecordCount(Integer value) {
        this.recordCount = value;
    }

    public void setRemediationProfile(List<ResponseRemediationProfile> value) {
        this.remediationProfile = value;
    }

}
