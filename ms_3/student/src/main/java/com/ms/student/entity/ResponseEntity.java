//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.08 at 04:43:35 PM IST 
//


package com.ms.student.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="English-grade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Science-grade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Maths-grade" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "englishGrade",
    "scienceGrade",
    "mathsGrade"
})
@XmlRootElement(name = "ResponseEntity")
public class ResponseEntity {

    @XmlElement(name = "English-grade", required = true)
    protected String englishGrade;
    @XmlElement(name = "Science-grade", required = true)
    protected String scienceGrade;
    @XmlElement(name = "Maths-grade", required = true)
    protected String mathsGrade;

    /**
     * Gets the value of the englishGrade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishGrade() {
        return englishGrade;
    }

    /**
     * Sets the value of the englishGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishGrade(String value) {
        this.englishGrade = value;
    }

    /**
     * Gets the value of the scienceGrade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScienceGrade() {
        return scienceGrade;
    }

    /**
     * Sets the value of the scienceGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScienceGrade(String value) {
        this.scienceGrade = value;
    }

    /**
     * Gets the value of the mathsGrade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMathsGrade() {
        return mathsGrade;
    }

    /**
     * Sets the value of the mathsGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMathsGrade(String value) {
        this.mathsGrade = value;
    }

}
