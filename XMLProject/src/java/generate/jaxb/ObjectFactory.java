
package generate.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generate.jaxb package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generate.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link Driver }
     * 
     */
    public Driver createDriver() {
        return new Driver();
    }

    /**
     * Create an instance of {@link Car.Passengers }
     * 
     */
    public Car.Passengers createCarPassengers() {
        return new Car.Passengers();
    }

    /**
     * Create an instance of {@link Passenger }
     * 
     */
    public Passenger createPassenger() {
        return new Passenger();
    }

}
