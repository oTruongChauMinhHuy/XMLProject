
import com.util.XMLUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HuyTCM1
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String output = "src/java/";
        String fileSchemaURI = "web/WEB-INF/Car.xsd";
        String packageName = "generate.jaxb";
        
        XMLUtilities.XJCGenerateJavaObj(output, fileSchemaURI, packageName);
        
//        XMLUtilities.JAXBUnmarshalling(Car.class, "web/WEB-INF/Car.xml");
//        
//        Car car = new Car();
//        Driver driver = new Driver();
//        driver.setId("123");
//        driver.setName("Abc");
//        Date date = new Date();
//        XMLGregorianCalendar xml = XMLUtilities.toXMLGregorianCalendar(date);
//        xml.toGregorianCalendar().getTime();
//        driver.setDOB(xml);
//        driver.setSalary(BigDecimal.TEN);
//        
//        car.setDriver(driver);
//        car.setNumberPlate("123123");
//        car.setNumberOfSeats(23);
//        
//        XMLUtilities.JAXBMarshalling(car, "web/WEB-INF/Cars.xml");
    }
}
