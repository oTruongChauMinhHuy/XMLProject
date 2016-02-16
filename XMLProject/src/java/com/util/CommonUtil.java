/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.TripDTO;
import com.DTO.TripDTOList;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class CommonUtil {

    public static void updateTripsFile(String filePath)
            throws JAXBException, ParserConfigurationException, SAXException, IOException {
        File file = new File(filePath);
        TripDTOList newTrips = DBUtilities.getAllTrips();
        if (!file.exists()) {
            XMLUtilities.JAXBMarshalling(newTrips, file);
        } else {
            TripDTOList trips = (TripDTOList)XMLUtilities.JAXBUnmarshalling(TripDTOList.class, filePath);
            for (TripDTO trip : newTrips.getTrips()) {
                trips.getTrips().add(trip);
            }
            XMLUtilities.JAXBMarshalling(trips, file);
        }
    }
}
