
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
 *         &lt;element name="LocationID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "locationID"
})
@XmlRootElement(name = "AddLocationHit")
public class AddLocationHit {

    @XmlElement(name = "LocationID")
    protected int locationID;

    /**
     * Ruft den Wert der locationID-Eigenschaft ab.
     * 
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Legt den Wert der locationID-Eigenschaft fest.
     * 
     */
    public void setLocationID(int value) {
        this.locationID = value;
    }

}
