
package com.DTO;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.DTO package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.DTO
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Trip }
     * 
     */
    public Trip createTrip() {
        return new Trip();
    }

    /**
     * Create an instance of {@link Trips }
     * 
     */
    public Trips createTrips() {
        return new Trips();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link Trip.Seats }
     * 
     */
    public Trip.Seats createTripSeats() {
        return new Trip.Seats();
    }

    /**
     * Create an instance of {@link Seat }
     * 
     */
    public Seat createSeat() {
        return new Seat();
    }

}
