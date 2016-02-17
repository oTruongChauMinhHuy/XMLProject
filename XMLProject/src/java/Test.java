
import com.DTO.CarDTO;
import com.DTO.SeatDTO;
import com.DTO.SeatDTOList;
import com.DTO.TripDTO;
import com.DTO.TripDTOList;
import com.util.CommonUtil;
import com.util.StAXCursor;
import com.util.XMLUtilities;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

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

        //XMLUtilities.XJCGenerateJavaObj(output, fileSchemaURI, packageName);
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
        TripDTOList trips = new TripDTOList();
        for (int i = 0; i < 3; i++) {
            TripDTO trip = new TripDTO();
            trip.setId(String.valueOf(i));
            trip.setBus("SG");
            CarDTO car = new CarDTO("60B2-134.30");
            trip.setCar(car);
            trip.setDate("2015/02/16");
            trip.setTime("08:00");
            SeatDTOList seats = new SeatDTOList();
            for (int j = 0; j < 10; j++) {
                SeatDTO seat = new SeatDTO();
                seat.setId(String.valueOf(j));
                seats.getSeats().add(seat);
            }
            trip.setSeats(seats);
            trips.getTrips().add(trip);
        }
        String xml;
        String filePath = "web/WEB-INF/trips.xml";
        try {
//            CommonUtil.updateTripsFile(filePath);
            StAXCursor.updateAvailableTrips(filePath);
//        try {
//            TripDTOList oldTrips = (TripDTOList) XMLUtilities.JAXBUnmarshalling(TripDTOList.class, filePath);
//            for (TripDTO trip : trips.getTrips()) {
//                trip.setBus("SG");
//                oldTrips.getTrips().add(trip);
//            }
//            XMLUtilities.JAXBMarshalling(oldTrips, new File(filePath));
//            try {
//
//                xml = XMLUtilities.marshallToString(oldTrips);
//                System.out.println(xml);
//            } catch (JAXBException ex) {
//                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            for (TripDTO trip : trips.getTrips()) {
//                Element element = XMLUtilities.JAXBMarshalling(trip);
//                System.out.println(element);
//            }
//            xml = XMLUtilities.marshallToString(trips);
//            System.out.println(xml);
//        } catch (JAXBException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
