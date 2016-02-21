package com.DTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.fpt.edu.vn/project/trip}trip" maxOccurs="unbounded"/>
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
    "trip"
})
@XmlRootElement(name = "trips")
public class Trips {

    @XmlElement(required = true)
    protected List<Trip> trip;

    /**
     * Gets the value of the trip property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the trip property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrip().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Trip }
     *
     *
     * @return
     */
    public List<Trip> getTrip() {
        if (trip == null) {
            trip = new ArrayList<>();
        }
        return this.trip;
    }

    public Trip getTripbyID(String tripID) {
        Iterator<Trip> iter = this.getTrip().iterator();
        while (iter.hasNext()) {
            Trip trip1 = iter.next();
            if (trip1.getId().equals(tripID)) {
                return trip1;
            }
        }
        return null;
    }

}
