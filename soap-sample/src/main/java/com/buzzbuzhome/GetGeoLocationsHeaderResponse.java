
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
 *         &lt;element name="GetGeoLocationsHeaderResult" type="{http://buzzbuzhome.com/}ArrayOfString" minOccurs="0"/&gt;
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
    "getGeoLocationsHeaderResult"
})
@XmlRootElement(name = "GetGeoLocationsHeaderResponse")
public class GetGeoLocationsHeaderResponse {

    @XmlElement(name = "GetGeoLocationsHeaderResult")
    protected ArrayOfString getGeoLocationsHeaderResult;

    /**
     * Ruft den Wert der getGeoLocationsHeaderResult-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetGeoLocationsHeaderResult() {
        return getGeoLocationsHeaderResult;
    }

    /**
     * Legt den Wert der getGeoLocationsHeaderResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetGeoLocationsHeaderResult(ArrayOfString value) {
        this.getGeoLocationsHeaderResult = value;
    }

}
