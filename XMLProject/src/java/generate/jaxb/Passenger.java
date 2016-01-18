
package generate.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for passenger complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="passenger">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seatNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="passengerName" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "passenger", propOrder = {
    "seatNumber",
    "passengerName"
})
public class Passenger {

    protected int seatNumber;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String passengerName;

    /**
     * Gets the value of the seatNumber property.
     * 
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Sets the value of the seatNumber property.
     * 
     */
    public void setSeatNumber(int value) {
        this.seatNumber = value;
    }

    /**
     * Gets the value of the passengerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Sets the value of the passengerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerName(String value) {
        this.passengerName = value;
    }

}
