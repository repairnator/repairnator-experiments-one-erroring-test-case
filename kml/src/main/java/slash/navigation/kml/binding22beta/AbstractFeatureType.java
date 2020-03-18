//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.10.12 at 02:39:09 PM CEST 
//


package slash.navigation.kml.binding22beta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for AbstractFeatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractFeatureType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://earth.google.com/kml/2.2}AbstractObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}name" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}visibility" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}open" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2005/Atom}author" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2005/Atom}link" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}address" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressDetails" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}phoneNumber" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}Snippet" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}description" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}AbstractViewGroup" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}AbstractTimePrimitiveGroup" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}styleUrl" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}AbstractStyleSelectorGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}Region" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://earth.google.com/kml/2.2}Metadata" minOccurs="0"/>
 *           &lt;element ref="{http://earth.google.com/kml/2.2}ExtendedData" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractFeatureType", propOrder = {
    "nameElement",
    "visibility",
    "open",
    "author",
    "link",
    "address",
    "addressDetails",
    "phoneNumber",
    "snippet",
    "description",
    "abstractViewGroup",
    "abstractTimePrimitiveGroup",
    "styleUrl",
    "abstractStyleSelectorGroup",
    "region",
    "metadata",
    "extendedData"
})
public abstract class AbstractFeatureType
    extends AbstractObjectType
{

    @XmlElement(name = "name")
    protected String nameElement;
    @XmlElement(defaultValue = "1")
    protected Boolean visibility;
    @XmlElement(defaultValue = "0")
    protected Boolean open;
    @XmlElement(namespace = "http://www.w3.org/2005/Atom")
    protected AtomPersonConstruct author;
    @XmlElement(namespace = "http://www.w3.org/2005/Atom")
    protected Link link;
    protected String address;
    @XmlElement(name = "AddressDetails", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    protected AddressDetails addressDetails;
    protected String phoneNumber;
    @XmlElement(name = "Snippet")
    protected SnippetType snippet;
    protected String description;
    @XmlElementRef(name = "AbstractViewGroup", namespace = "http://earth.google.com/kml/2.2", type = JAXBElement.class)
    protected JAXBElement<? extends AbstractViewType> abstractViewGroup;
    @XmlElementRef(name = "AbstractTimePrimitiveGroup", namespace = "http://earth.google.com/kml/2.2", type = JAXBElement.class)
    protected JAXBElement<? extends AbstractTimePrimitiveType> abstractTimePrimitiveGroup;
    protected String styleUrl;
    @XmlElementRef(name = "AbstractStyleSelectorGroup", namespace = "http://earth.google.com/kml/2.2", type = JAXBElement.class)
    protected List<JAXBElement<? extends AbstractStyleSelectorType>> abstractStyleSelectorGroup;
    @XmlElement(name = "Region")
    protected RegionType region;
    @XmlElement(name = "Metadata")
    protected MetadataType metadata;
    @XmlElement(name = "ExtendedData")
    protected ExtendedDataType extendedData;

    /**
     * Gets the value of the nameElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameElement() {
        return nameElement;
    }

    /**
     * Sets the value of the nameElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameElement(String value) {
        this.nameElement = value;
    }

    /**
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVisibility(Boolean value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the open property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOpen() {
        return open;
    }

    /**
     * Sets the value of the open property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpen(Boolean value) {
        this.open = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link AtomPersonConstruct }
     *     
     */
    public AtomPersonConstruct getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link AtomPersonConstruct }
     *     
     */
    public void setAuthor(AtomPersonConstruct value) {
        this.author = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link Link }
     *     
     */
    public Link getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link Link }
     *     
     */
    public void setLink(Link value) {
        this.link = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the addressDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AddressDetails }
     *     
     */
    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the value of the addressDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressDetails }
     *     
     */
    public void setAddressDetails(AddressDetails value) {
        this.addressDetails = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the snippet property.
     * 
     * @return
     *     possible object is
     *     {@link SnippetType }
     *     
     */
    public SnippetType getSnippet() {
        return snippet;
    }

    /**
     * Sets the value of the snippet property.
     * 
     * @param value
     *     allowed object is
     *     {@link SnippetType }
     *     
     */
    public void setSnippet(SnippetType value) {
        this.snippet = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the abstractViewGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CameraType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractViewType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LookAtType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractViewType> getAbstractViewGroup() {
        return abstractViewGroup;
    }

    /**
     * Sets the value of the abstractViewGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CameraType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractViewType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LookAtType }{@code >}
     *     
     */
    public void setAbstractViewGroup(JAXBElement<? extends AbstractViewType> value) {
        this.abstractViewGroup = value;
    }

    /**
     * Gets the value of the abstractTimePrimitiveGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeStampType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeSpanType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractTimePrimitiveType> getAbstractTimePrimitiveGroup() {
        return abstractTimePrimitiveGroup;
    }

    /**
     * Sets the value of the abstractTimePrimitiveGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeStampType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeSpanType }{@code >}
     *     
     */
    public void setAbstractTimePrimitiveGroup(JAXBElement<? extends AbstractTimePrimitiveType> value) {
        this.abstractTimePrimitiveGroup = value;
    }

    /**
     * Gets the value of the styleUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyleUrl() {
        return styleUrl;
    }

    /**
     * Sets the value of the styleUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyleUrl(String value) {
        this.styleUrl = value;
    }

    /**
     * Gets the value of the abstractStyleSelectorGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractStyleSelectorGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractStyleSelectorGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link StyleMapType }{@code >}
     * {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractStyleSelectorType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractStyleSelectorType>> getAbstractStyleSelectorGroup() {
        if (abstractStyleSelectorGroup == null) {
            abstractStyleSelectorGroup = new ArrayList<>();
        }
        return this.abstractStyleSelectorGroup;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link RegionType }
     *     
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegionType }
     *     
     */
    public void setRegion(RegionType value) {
        this.region = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataType }
     *     
     */
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     *     
     */
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the extendedData property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedDataType }
     *     
     */
    public ExtendedDataType getExtendedData() {
        return extendedData;
    }

    /**
     * Sets the value of the extendedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedDataType }
     *     
     */
    public void setExtendedData(ExtendedDataType value) {
        this.extendedData = value;
    }

}
