
import com.DTO.Bus;
import com.DTO.Car;
import com.DTO.Seat;
import com.DTO.Trip;
import com.DTO.TripDTOList;
import com.util.TripXMLCommonUtil;
import com.util.XMLUtilities;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException, TransformerException, ParseException, DatatypeConfigurationException {
//        String output = "src/java/";
//        String fileSchemaURI = "web/WEB-INF/Trip.xsd";
//        String packageName = "com.DTO";
        
        TripXMLCommonUtil.updateTripStatus("LK070220150700", "false");
        TripXMLCommonUtil.updateSeatStatus("LK070220150700", "1", "pending");

//        XMLUtilities.JAXBMarshalling(car, "web/WEB-INF/Cars.xml");
//        TripDTOList trips = new TripDTOList();
//        for (int i = 0; i < 3; i++) {
//            String tripID = "LK07022015070" + i;
//            Trip trip = new Trip();
//            trip.setId(tripID);
//            String bus = "LK";
//            trip.setBus(Bus.valueOf(bus));
//            String date = "2015/02/16";
//            trip.setDate(XMLUtilities.toXMLGregorianDate(date));
//            String time = "08:00:00";
//            trip.setTime(XMLUtilities.toXMLGregorianTime(time));
//            Car car = new Car();
//            car.setNumberPlate("60B2-134.30");
//            trip.setCar(car);
//            Trip.Seats seats = new Trip.Seats();
//            //initial seat
//            for (int j = 1; j <= car.getNumberOfSeats(); j++) {
//                Seat seat = new Seat();
//                seat.setId(String.valueOf(j));
//                seat.setAvailable("true");
//                seats.getSeat().add(seat);
//            }
//            trip.setIsAvailable("true");
//            trip.setSeats(seats);
//            //add trip
//            trips.getTrips().add(trip);
//        }
//        File file = new File(TripXMLCommonUtil.tripXMLFilePath);
//        XMLUtilities.JAXBMarshalling(trips, file);
    }
}
