//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.07 at 02:40:39 PM CET 
//


package nl.b3p.topnl.top100nl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VlakOfLijnPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VlakOfLijnPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://register.geostandaarden.nl/gmlapplicatieschema/top100nl/1.1.0}VlakOfLijn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VlakOfLijnPropertyType", namespace = "http://register.geostandaarden.nl/gmlapplicatieschema/top100nl/1.1.0", propOrder = {
    "vlakOfLijn"
})
public class VlakOfLijnPropertyType {

    @XmlElement(name = "VlakOfLijn", required = true)
    protected VlakOfLijnType vlakOfLijn;

    /**
     * Gets the value of the vlakOfLijn property.
     * 
     * @return
     *     possible object is
     *     {@link VlakOfLijnType }
     *     
     */
    public VlakOfLijnType getVlakOfLijn() {
        return vlakOfLijn;
    }

    /**
     * Sets the value of the vlakOfLijn property.
     * 
     * @param value
     *     allowed object is
     *     {@link VlakOfLijnType }
     *     
     */
    public void setVlakOfLijn(VlakOfLijnType value) {
        this.vlakOfLijn = value;
    }

}
