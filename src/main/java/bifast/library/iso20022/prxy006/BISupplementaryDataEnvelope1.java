//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.28 at 04:50:39 PM ICT 
//


package bifast.library.iso20022.prxy006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BI_SupplementaryDataEnvelope1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BI_SupplementaryDataEnvelope1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cstmr" type="{urn:iso:std:iso:20022:tech:xsd:prxy.006.001.01}BI_AddtlCstmrInf" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BISupplementaryDataEnvelope1", propOrder = {
    "dtl"
})
public class BISupplementaryDataEnvelope1 {

    @XmlElement(name = "Dtl")
    protected BISupplementaryDetail1 dtl;

	public BISupplementaryDetail1 getDtl() {
		return dtl;
	}

	public void setDtl(BISupplementaryDetail1 dtl) {
		this.dtl = dtl;
	}


}
