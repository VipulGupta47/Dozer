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
 *         &lt;element name="FileStatusInfo" type="{www.headstrong.com}FileStatusInfo"/>
 *         &lt;element name="RemediationProfile" type="{www.headstrong.com}RemediationProfile" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PublicationDateTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PublicationId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RecordCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Group" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Client" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fileStatusInfo",
    "remediationProfile"
})
@XmlRootElement(name = "RemediationFile", namespace = "www.headstrong.com")
public class RemediationFile
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FileStatusInfo", required = true)
    protected FileStatusInfo fileStatusInfo;
    @XmlElement(name = "RemediationProfile")
    protected RemediationProfile remediationProfile;
    @XmlAttribute(name = "PublicationDateTime")
    protected String publicationDateTime;
    @XmlAttribute(name = "PublicationId")
    protected Integer publicationId;
    @XmlAttribute(name = "RecordCount")
    protected Integer recordCount;
    @XmlAttribute(name = "Group")
    protected String group;
    @XmlAttribute(name = "Client")
    protected String client;
    @XmlAttribute
    protected Integer id;

    /**
     * Gets the value of the fileStatusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FileStatusInfo }
     *     
     */
    public FileStatusInfo getFileStatusInfo() {
        return fileStatusInfo;
    }

    /**
     * Sets the value of the fileStatusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileStatusInfo }
     *     
     */
    public void setFileStatusInfo(FileStatusInfo value) {
        this.fileStatusInfo = value;
    }

    /**
     * Gets the value of the remediationProfile property.
     * 
     * @return
     *     possible object is
     *     {@link RemediationProfile }
     *     
     */
    public RemediationProfile getRemediationProfile() {
        return remediationProfile;
    }

    /**
     * Sets the value of the remediationProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemediationProfile }
     *     
     */
    public void setRemediationProfile(RemediationProfile value) {
        this.remediationProfile = value;
    }

    /**
     * Gets the value of the publicationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationDateTime() {
        return publicationDateTime;
    }

    /**
     * Sets the value of the publicationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationDateTime(String value) {
        this.publicationDateTime = value;
    }

    /**
     * Gets the value of the publicationId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPublicationId() {
        return publicationId;
    }

    /**
     * Sets the value of the publicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPublicationId(Integer value) {
        this.publicationId = value;
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

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClient(String value) {
        this.client = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

}
