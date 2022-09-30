//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.28 at 04:48:56 PM ICT 
//


package bifast.library.iso20022.prxy002;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProxyRegistrationResponseV01 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProxyRegistrationResponseV01"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:prxy.002.001.01}GroupHeader60"/&gt;
 *         &lt;element name="OrgnlGrpInf" type="{urn:iso:std:iso:20022:tech:xsd:prxy.002.001.01}OriginalGroupInformation3"/&gt;
 *         &lt;element name="RegnRspn" type="{urn:iso:std:iso:20022:tech:xsd:prxy.002.001.01}ProxyRegistrationResponse1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProxyRegistrationResponseV01", propOrder = {
    "grpHdr",
    "orgnlGrpInf",
    "regnRspn",
    "splmtryData"
})
public class ProxyRegistrationResponseV01 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader60 grpHdr;
    @XmlElement(name = "OrgnlGrpInf", required = true)
    protected OriginalGroupInformation3 orgnlGrpInf;
    @XmlElement(name = "RegnRspn", required = true)
    protected ProxyRegistrationResponse1 regnRspn;
    @XmlElement(name = "SplmtryData")
    protected List<BISupplementaryData1> splmtryData;

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
     * Gets the value of the orgnlGrpInf property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupInformation3 }
     *     
     */
    public OriginalGroupInformation3 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * Sets the value of the orgnlGrpInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupInformation3 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupInformation3 value) {
        this.orgnlGrpInf = value;
    }

    /**
     * Gets the value of the regnRspn property.
     * 
     * @return
     *     possible object is
     *     {@link ProxyRegistrationResponse1 }
     *     
     */
    public ProxyRegistrationResponse1 getRegnRspn() {
        return regnRspn;
    }

    /**
     * Sets the value of the regnRspn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyRegistrationResponse1 }
     *     
     */
    public void setRegnRspn(ProxyRegistrationResponse1 value) {
        this.regnRspn = value;
    }

	public List<BISupplementaryData1> getSplmtryData() {
		return splmtryData;
	}

	public void setSplmtryData(List<BISupplementaryData1> splmtryData) {
		this.splmtryData = splmtryData;
	}

}
