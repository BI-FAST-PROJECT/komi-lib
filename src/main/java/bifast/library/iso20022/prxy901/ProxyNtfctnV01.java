//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.28 at 04:51:03 PM ICT 
//


package bifast.library.iso20022.prxy901;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProxyNtfctnV01 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProxyNtfctnV01"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:prxy.901.001.01}GroupHeader60"/&gt;
 *         &lt;element name="Ntfctn" type="{urn:iso:std:iso:20022:tech:xsd:prxy.901.001.01}ProxyNtfctn1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProxyNtfctnV01", propOrder = {
    "grpHdr",
    "ntfctn"
})
public class ProxyNtfctnV01 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader60 grpHdr;
    @XmlElement(name = "Ntfctn", required = true)
    protected ProxyNtfctn1 ntfctn;

    /**
     * Gets the value of the grpHdr property.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader60 }
     *     
     */
    public GroupHeader60 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Sets the value of the grpHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader60 }
     *     
     */
    public void setGrpHdr(GroupHeader60 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the ntfctn property.
     * 
     * @return
     *     possible object is
     *     {@link ProxyNtfctn1 }
     *     
     */
    public ProxyNtfctn1 getNtfctn() {
        return ntfctn;
    }

    /**
     * Sets the value of the ntfctn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyNtfctn1 }
     *     
     */
    public void setNtfctn(ProxyNtfctn1 value) {
        this.ntfctn = value;
    }

}
