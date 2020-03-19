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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"vertex"})
@XmlRootElement(name = "polygon")
public class Polygon {

    @XmlAttribute(name = "width", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String width;
    @XmlAttribute(name = "layer", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String layer;
    @XmlAttribute(name = "spacing")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String spacing;
    @XmlAttribute(name = "pour")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String pour;
    @XmlAttribute(name = "isolate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String isolate;
    @XmlAttribute(name = "orphans")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String orphans;
    @XmlAttribute(name = "thermals")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String thermals;
    @XmlAttribute(name = "rank")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rank;
    protected List<Vertex> vertex;

    /**
     * Gets the value of the width property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the layer property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLayer() {
        return layer;
    }

    /**
     * Sets the value of the layer property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setLayer(String value) {
        this.layer = value;
    }

    /**
     * Gets the value of the spacing property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSpacing() {
        return spacing;
    }

    /**
     * Sets the value of the spacing property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setSpacing(String value) {
        this.spacing = value;
    }

    /**
     * Gets the value of the pour property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getPour() {
        if (pour == null) {
            return "solid";
        }
        else {
            return pour;
        }
    }

    /**
     * Sets the value of the pour property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setPour(String value) {
        this.pour = value;
    }

    /**
     * Gets the value of the isolate property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getIsolate() {
        return isolate;
    }

    /**
     * Sets the value of the isolate property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setIsolate(String value) {
        this.isolate = value;
    }

    /**
     * Gets the value of the orphans property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOrphans() {
        if (orphans == null) {
            return "no";
        }
        else {
            return orphans;
        }
    }

    /**
     * Sets the value of the orphans property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setOrphans(String value) {
        this.orphans = value;
    }

    /**
     * Gets the value of the thermals property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getThermals() {
        if (thermals == null) {
            return "yes";
        }
        else {
            return thermals;
        }
    }

    /**
     * Sets the value of the thermals property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setThermals(String value) {
        this.thermals = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getRank() {
        if (rank == null) {
            return "0";
        }
        else {
            return rank;
        }
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setRank(String value) {
        this.rank = value;
    }

    /**
     * Gets the value of the vertex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the vertex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getVertex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Vertex }
     * 
     * 
     */
    public List<Vertex> getVertex() {
        if (vertex == null) {
            vertex = new ArrayList<>();
        }
        return this.vertex;
    }

}
