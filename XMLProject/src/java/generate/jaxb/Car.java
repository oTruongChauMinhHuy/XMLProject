
package generate.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.fpt.edu.vn/project/driver}Driver"/>
 *         &lt;element name="numberOfSeats" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Passengers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="passenger" type="{http://www.fpt.edu.vn/project/car}passenger" maxOccurs="30"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="numberPlate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "driver",
    "numberOfSeats",
    "passengers"
})
@XmlRootElement(name = "Car")
public class Car {

    @XmlElement(name = "Driver", namespace = "http://www.fpt.edu.vn/project/driver", required = true)
    protected Driver driver;
    protected int numberOfSeats;
    @XmlElement(name = "Passengers", required = true)
    protected Car.Passengers passengers;
    @XmlAttribute(name = "numberPlate", required = true)
    protected String numberPlate;

    /**
     * Gets the value of the driver property.
     * 
     * @return
     *     possible object is
     *     {@link Driver }
     *     
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Sets the value of the driver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Driver }
     *     
     */
    public void setDriver(Driver value) {
        this.driver = value;
    }

    /**
     * Gets the value of the numberOfSeats property.
     * 
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Sets the value of the numberOfSeats property.
     * 
     */
    public void setNumberOfSeats(int value) {
        this.numberOfSeats = value;
    }

    /**
     * Gets the value of the passengers property.
     * 
     * @return
     *     possible object is
     *     {@link Car.Passengers }
     *     
     */
    public Car.Passengers getPassengers() {
        return passengers;
    }

    /**
     * Sets the value of the passengers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Car.Passengers }
     *     
     */
    public void setPassengers(Car.Passengers value) {
        this.passengers = value;
    }

    /**
     * Gets the value of the numberPlate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberPlate() {
        return numberPlate;
    }

    /**
     * Sets the value of the numberPlate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberPlate(String value) {
        this.numberPlate = value;
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
     *         &lt;element name="passenger" type="{http://www.fpt.edu.vn/project/car}passenger" maxOccurs="30"/>
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
        "passenger"
    })
    public static class Passengers {

        @XmlElement(required = true)
        protected List<Passenger> passenger;

        /**
         * Gets the value of the passenger property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the passenger property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPassenger().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Passenger }
         * 
         * 
         */
        public List<Passenger> getPassenger() {
            if (passenger == null) {
                passenger = new ArrayList<Passenger>();
            }
            return this.passenger;
        }

    }

}
