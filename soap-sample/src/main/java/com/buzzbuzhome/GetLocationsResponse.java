
package com.buzzbuzhome;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetLocationsResult" type="{http://buzzbuzhome.com/}ArrayOfBBHLocation" minOccurs="0"/&gt;
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
    "getLocationsResult"
})
@XmlRootElement(name = "GetLocationsResponse")
public class GetLocationsResponse {

    @XmlElement(name = "GetLocationsResult")
    protected ArrayOfBBHLocation getLocationsResult;

    /**
     * Ruft den Wert der getLocationsResult-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBBHLocation }
     *     
     */
    public ArrayOfBBHLocation getGetLocationsResult() {
        return getLocationsResult;
    }

    /**
     * Legt den Wert der getLocationsResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBBHLocation }
     *     
     */
    public void setGetLocationsResult(ArrayOfBBHLocation value) {
        this.getLocationsResult = value;
    }

}
