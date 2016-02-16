/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.TripDTOList;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class CommonUtil {

    public static void updateTripsFile(String filePath)
            throws JAXBException, ParserConfigurationException, SAXException, IOException {
        File file = new File(filePath);
        TripDTOList trips = DBUtilities.getAllTrips();
        if (!file.exists()) {
            XMLUtilities.JAXBMarshalling(trips, file);
        } else {
            Document doc = XMLUtilities.parseFileToDOM(file);
            if (doc != null) {

            }
        }
    }
}
