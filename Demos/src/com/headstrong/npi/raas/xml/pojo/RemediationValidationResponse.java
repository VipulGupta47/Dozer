//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.20 at 04:30:32 PM EDT 
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="FilePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProcessingDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Status" type="{www.headstrong.com/RemidiationValidationResponse}status"/>
 *         &lt;element name="ValidationErrors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ValidationError" type="{www.headstrong.com/RemidiationValidationResponse}validationMessage" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ValidationWarnings" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ValidationWarning" type="{www.headstrong.com/RemidiationValidationResponse}validationMessage" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InputData" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "filePath",
    "processingDateTime",
    "status",
    "validationErrors",
    "validationWarnings",
    "inputData"
})
@XmlRootElement(name = "RemediationValidationResponse")
public class RemediationValidationResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FilePath", required = true)
    protected String filePath;
    @XmlElement(name = "ProcessingDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processingDateTime;
    @XmlElement(name = "Status", required = true)
    protected Status status;
    @XmlElement(name = "ValidationErrors")
    protected RemediationValidationResponse.ValidationErrors validationErrors;
    @XmlElement(name = "ValidationWarnings")
    protected RemediationValidationResponse.ValidationWarnings validationWarnings;
    @XmlElement(name = "InputData", required = true)
    protected String inputData;
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
     * Gets the value of the filePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the value of the filePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePath(String value) {
        this.filePath = value;
    }

    /**
     * Gets the value of the processingDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessingDateTime() {
        return processingDateTime;
    }

    /**
     * Sets the value of the processingDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessingDateTime(XMLGregorianCalendar value) {
        this.processingDateTime = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the validationErrors property.
     * 
     * @return
     *     possible object is
     *     {@link RemediationValidationResponse.ValidationErrors }
     *     
     */
    public RemediationValidationResponse.ValidationErrors getValidationErrors() {
        return validationErrors;
    }

    /**
     * Sets the value of the validationErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemediationValidationResponse.ValidationErrors }
     *     
     */
    public void setValidationErrors(RemediationValidationResponse.ValidationErrors value) {
        this.validationErrors = value;
    }

    /**
     * Gets the value of the validationWarnings property.
     * 
     * @return
     *     possible object is
     *     {@link RemediationValidationResponse.ValidationWarnings }
     *     
     */
    public RemediationValidationResponse.ValidationWarnings getValidationWarnings() {
        return validationWarnings;
    }

    /**
     * Sets the value of the validationWarnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemediationValidationResponse.ValidationWarnings }
     *     
     */
    public void setValidationWarnings(RemediationValidationResponse.ValidationWarnings value) {
        this.validationWarnings = value;
    }

    /**
     * Gets the value of the inputData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputData() {
        return inputData;
    }

    /**
     * Sets the value of the inputData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputData(String value) {
        this.inputData = value;
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
     *         &lt;element name="ValidationError" type="{www.headstrong.com/RemidiationValidationResponse}validationMessage" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "validationError"
    })
    public static class ValidationErrors
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "ValidationError", required = true)
        protected List<ValidationMessage> validationError;

        /**
         * Gets the value of the validationError property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the validationError property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValidationError().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ValidationMessage }
         * 
         * 
         */
        public List<ValidationMessage> getValidationError() {
            if (validationError == null) {
                validationError = new ArrayList<ValidationMessage>();
            }
            return this.validationError;
        }

        public void setValidationError(List<ValidationMessage> value) {
            this.validationError = value;
        }

    }


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
     *         &lt;element name="ValidationWarning" type="{www.headstrong.com/RemidiationValidationResponse}validationMessage" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "validationWarning"
    })
    public static class ValidationWarnings
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "ValidationWarning", required = true)
        protected List<ValidationMessage> validationWarning;

        /**
         * Gets the value of the validationWarning property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the validationWarning property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValidationWarning().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ValidationMessage }
         * 
         * 
         */
        public List<ValidationMessage> getValidationWarning() {
            if (validationWarning == null) {
                validationWarning = new ArrayList<ValidationMessage>();
            }
            return this.validationWarning;
        }

        public void setValidationWarning(List<ValidationMessage> value) {
            this.validationWarning = value;
        }

    }

}
