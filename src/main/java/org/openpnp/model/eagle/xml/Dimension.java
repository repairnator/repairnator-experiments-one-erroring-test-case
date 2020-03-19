//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.10.23 at 08:50:01 AM PDT
//


package org.openpnp.model.eagle.xml;

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
@XmlType(name = "")
@XmlRootElement(name = "dimension")
public class Dimension {

    @XmlAttribute(name = "x1", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String x1;
    @XmlAttribute(name = "y1", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String y1;
    @XmlAttribute(name = "x2", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String x2;
    @XmlAttribute(name = "y2", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String y2;
    @XmlAttribute(name = "x3", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String x3;
    @XmlAttribute(name = "y3", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String y3;
    @XmlAttribute(name = "layer", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String layer;
    @XmlAttribute(name = "dtype")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dtype;
    @XmlAttribute(name = "width", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String width;
    @XmlAttribute(name = "extwidth")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String extwidth;
    @XmlAttribute(name = "extlength")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String extlength;
    @XmlAttribute(name = "extoffset")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String extoffset;
    @XmlAttribute(name = "textsize", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String textsize;
    @XmlAttribute(name = "textratio")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String textratio;
    @XmlAttribute(name = "unit")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String unit;
    @XmlAttribute(name = "precision")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String precision;
    @XmlAttribute(name = "visible")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String visible;

    /**
     * Gets the value of the x1 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getX1() {
        return x1;
    }

    /**
     * Sets the value of the x1 property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setX1(String value) {
        this.x1 = value;
    }

    /**
     * Gets the value of the y1 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getY1() {
        return y1;
    }

    /**
     * Sets the value of the y1 property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setY1(String value) {
        this.y1 = value;
    }

    /**
     * Gets the value of the x2 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getX2() {
        return x2;
    }

    /**
     * Sets the value of the x2 property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setX2(String value) {
        this.x2 = value;
    }

    /**
     * Gets the value of the y2 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getY2() {
        return y2;
    }

    /**
     * Sets the value of the y2 property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setY2(String value) {
        this.y2 = value;
    }

    /**
     * Gets the value of the x3 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getX3() {
        return x3;
    }

    /**
     * Sets the value of the x3 property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setX3(String value) {
        this.x3 = value;
    }

    /**
     * Gets the value of the y3 property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getY3() {
        return y3;
    }

    /**
     * Sets the value of the y3 property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setY3(String value) {
        this.y3 = value;
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
     * Gets the value of the dtype property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDtype() {
        if (dtype == null) {
            return "parallel";
        }
        else {
            return dtype;
        }
    }

    /**
     * Sets the value of the dtype property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setDtype(String value) {
        this.dtype = value;
    }

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
     * Gets the value of the extwidth property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getExtwidth() {
        if (extwidth == null) {
            return "0";
        }
        else {
            return extwidth;
        }
    }

    /**
     * Sets the value of the extwidth property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setExtwidth(String value) {
        this.extwidth = value;
    }

    /**
     * Gets the value of the extlength property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getExtlength() {
        if (extlength == null) {
            return "0";
        }
        else {
            return extlength;
        }
    }

    /**
     * Sets the value of the extlength property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setExtlength(String value) {
        this.extlength = value;
    }

    /**
     * Gets the value of the extoffset property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getExtoffset() {
        if (extoffset == null) {
            return "0";
        }
        else {
            return extoffset;
        }
    }

    /**
     * Sets the value of the extoffset property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setExtoffset(String value) {
        this.extoffset = value;
    }

    /**
     * Gets the value of the textsize property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getTextsize() {
        return textsize;
    }

    /**
     * Sets the value of the textsize property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setTextsize(String value) {
        this.textsize = value;
    }

    /**
     * Gets the value of the textratio property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getTextratio() {
        if (textratio == null) {
            return "8";
        }
        else {
            return textratio;
        }
    }

    /**
     * Sets the value of the textratio property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setTextratio(String value) {
        this.textratio = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getUnit() {
        if (unit == null) {
            return "mm";
        }
        else {
            return unit;
        }
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the precision property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getPrecision() {
        if (precision == null) {
            return "2";
        }
        else {
            return precision;
        }
    }

    /**
     * Sets the value of the precision property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setPrecision(String value) {
        this.precision = value;
    }

    /**
     * Gets the value of the visible property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getVisible() {
        if (visible == null) {
            return "no";
        }
        else {
            return visible;
        }
    }

    /**
     * Sets the value of the visible property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setVisible(String value) {
        this.visible = value;
    }

}
