//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.28 at 06:01:02 PM MEZ 
//


package slash.navigation.geonames.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="code" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="postalcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="lng" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="adminCode1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adminName1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adminCode2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adminName2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adminCode3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adminName3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="geoname" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="lng" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="geonameId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fcl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="status" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="message" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "code",
    "geoname",
    "status"
})
@XmlRootElement(name = "geonames")
public class Geonames {

    protected List<Geonames.Code> code;
    protected List<Geonames.Geoname> geoname;
    protected Geonames.Status status;

    /**
     * Gets the value of the code property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the code property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Geonames.Code }
     * 
     * 
     */
    public List<Geonames.Code> getCode() {
        if (code == null) {
            code = new ArrayList<>();
        }
        return this.code;
    }

    /**
     * Gets the value of the geoname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geoname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeoname().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Geonames.Geoname }
     * 
     * 
     */
    public List<Geonames.Geoname> getGeoname() {
        if (geoname == null) {
            geoname = new ArrayList<>();
        }
        return this.geoname;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Geonames.Status }
     *     
     */
    public Geonames.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Geonames.Status }
     *     
     */
    public void setStatus(Geonames.Status value) {
        this.status = value;
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
     *         &lt;element name="postalcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="lng" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="adminCode1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="adminName1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="adminCode2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="adminName2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="adminCode3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="adminName3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
        "postalcode",
        "name",
        "countryCode",
        "lat",
        "lng",
        "adminCode1",
        "adminName1",
        "adminCode2",
        "adminName2",
        "adminCode3",
        "adminName3",
        "distance"
    })
    public static class Code {

        @XmlElement(required = true)
        protected String postalcode;
        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String countryCode;
        @XmlElement(required = true)
        protected BigDecimal lat;
        @XmlElement(required = true)
        protected BigDecimal lng;
        @XmlElement(required = true)
        protected String adminCode1;
        @XmlElement(required = true)
        protected String adminName1;
        @XmlElement(required = true)
        protected String adminCode2;
        @XmlElement(required = true)
        protected String adminName2;
        @XmlElement(required = true)
        protected String adminCode3;
        @XmlElement(required = true)
        protected String adminName3;
        @XmlElement(required = true)
        protected BigDecimal distance;

        /**
         * Gets the value of the postalcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPostalcode() {
            return postalcode;
        }

        /**
         * Sets the value of the postalcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPostalcode(String value) {
            this.postalcode = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the countryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Sets the value of the countryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        /**
         * Gets the value of the lat property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLat() {
            return lat;
        }

        /**
         * Sets the value of the lat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLat(BigDecimal value) {
            this.lat = value;
        }

        /**
         * Gets the value of the lng property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLng() {
            return lng;
        }

        /**
         * Sets the value of the lng property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLng(BigDecimal value) {
            this.lng = value;
        }

        /**
         * Gets the value of the adminCode1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdminCode1() {
            return adminCode1;
        }

        /**
         * Sets the value of the adminCode1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdminCode1(String value) {
            this.adminCode1 = value;
        }

        /**
         * Gets the value of the adminName1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdminName1() {
            return adminName1;
        }

        /**
         * Sets the value of the adminName1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdminName1(String value) {
            this.adminName1 = value;
        }

        /**
         * Gets the value of the adminCode2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdminCode2() {
            return adminCode2;
        }

        /**
         * Sets the value of the adminCode2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdminCode2(String value) {
            this.adminCode2 = value;
        }

        /**
         * Gets the value of the adminName2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdminName2() {
            return adminName2;
        }

        /**
         * Sets the value of the adminName2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdminName2(String value) {
            this.adminName2 = value;
        }

        /**
         * Gets the value of the adminCode3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdminCode3() {
            return adminCode3;
        }

        /**
         * Sets the value of the adminCode3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdminCode3(String value) {
            this.adminCode3 = value;
        }

        /**
         * Gets the value of the adminName3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdminName3() {
            return adminName3;
        }

        /**
         * Sets the value of the adminName3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdminName3(String value) {
            this.adminName3 = value;
        }

        /**
         * Gets the value of the distance property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDistance() {
            return distance;
        }

        /**
         * Sets the value of the distance property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDistance(BigDecimal value) {
            this.distance = value;
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
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="lng" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="geonameId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fcl" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
        "name",
        "lat",
        "lng",
        "geonameId",
        "countryCode",
        "countryName",
        "fcl",
        "fcode",
        "distance"
    })
    public static class Geoname {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected BigDecimal lat;
        @XmlElement(required = true)
        protected BigDecimal lng;
        @XmlSchemaType(name = "unsignedInt")
        protected long geonameId;
        @XmlElement(required = true)
        protected String countryCode;
        @XmlElement(required = true)
        protected String countryName;
        @XmlElement(required = true)
        protected String fcl;
        @XmlElement(required = true)
        protected String fcode;
        @XmlElement(required = true)
        protected BigDecimal distance;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the lat property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLat() {
            return lat;
        }

        /**
         * Sets the value of the lat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLat(BigDecimal value) {
            this.lat = value;
        }

        /**
         * Gets the value of the lng property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getLng() {
            return lng;
        }

        /**
         * Sets the value of the lng property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setLng(BigDecimal value) {
            this.lng = value;
        }

        /**
         * Gets the value of the geonameId property.
         * 
         */
        public long getGeonameId() {
            return geonameId;
        }

        /**
         * Sets the value of the geonameId property.
         * 
         */
        public void setGeonameId(long value) {
            this.geonameId = value;
        }

        /**
         * Gets the value of the countryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Sets the value of the countryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        /**
         * Gets the value of the countryName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryName() {
            return countryName;
        }

        /**
         * Sets the value of the countryName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryName(String value) {
            this.countryName = value;
        }

        /**
         * Gets the value of the fcl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFcl() {
            return fcl;
        }

        /**
         * Sets the value of the fcl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFcl(String value) {
            this.fcl = value;
        }

        /**
         * Gets the value of the fcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFcode() {
            return fcode;
        }

        /**
         * Sets the value of the fcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFcode(String value) {
            this.fcode = value;
        }

        /**
         * Gets the value of the distance property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDistance() {
            return distance;
        }

        /**
         * Sets the value of the distance property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDistance(BigDecimal value) {
            this.distance = value;
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
     *       &lt;attribute name="message" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Status {

        @XmlAttribute(required = true)
        protected String message;
        @XmlAttribute(required = true)
        @XmlSchemaType(name = "unsignedByte")
        protected short value;

        /**
         * Gets the value of the message property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessage() {
            return message;
        }

        /**
         * Sets the value of the message property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessage(String value) {
            this.message = value;
        }

        /**
         * Gets the value of the value property.
         * 
         */
        public short getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(short value) {
            this.value = value;
        }

    }

}
