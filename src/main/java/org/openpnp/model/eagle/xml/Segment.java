//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.10.23 at 08:50:01 AM PDT
//


package org.openpnp.model.eagle.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"pinrefOrPortrefOrWireOrJunctionOrLabel"})
@XmlRootElement(name = "segment")
public class Segment {

    @XmlElements({@XmlElement(name = "pinref", type = Pinref.class),
            @XmlElement(name = "portref", type = Portref.class),
            @XmlElement(name = "wire", type = Wire.class),
            @XmlElement(name = "junction", type = Junction.class),
            @XmlElement(name = "label", type = Label.class)})
    protected List<Object> pinrefOrPortrefOrWireOrJunctionOrLabel;

    /**
     * Gets the value of the pinrefOrPortrefOrWireOrJunctionOrLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the pinrefOrPortrefOrWireOrJunctionOrLabel
     * property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getPinrefOrPortrefOrWireOrJunctionOrLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Pinref } {@link Portref }
     * {@link Wire } {@link Junction } {@link Label }
     * 
     * 
     */
    public List<Object> getPinrefOrPortrefOrWireOrJunctionOrLabel() {
        if (pinrefOrPortrefOrWireOrJunctionOrLabel == null) {
            pinrefOrPortrefOrWireOrJunctionOrLabel = new ArrayList<>();
        }
        return this.pinrefOrPortrefOrWireOrJunctionOrLabel;
    }

}
