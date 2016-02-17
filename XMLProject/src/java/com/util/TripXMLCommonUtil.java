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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class TripXMLCommonUtil {

    public final static String tripXMLFilePath = "web/WEB-INF/trips.xml";

    public static void updateTripsFile()
            throws JAXBException, ParserConfigurationException, SAXException, IOException {
        File file = new File(TripXMLCommonUtil.tripXMLFilePath);
        TripDTOList newTrips = DBUtilities.getAllTrips();
        if (!file.exists()) {
            XMLUtilities.JAXBMarshalling(newTrips, file);
        } else {
            TripDTOList trips = (TripDTOList) XMLUtilities.JAXBUnmarshalling(TripDTOList.class, TripXMLCommonUtil.tripXMLFilePath);
            for (TripDTO trip : newTrips.getTrips()) {
                trips.getTrips().add(trip);
            }
            XMLUtilities.JAXBMarshalling(trips, file);
        }
    }

    public static void updateTripStatus(String tripID, String status)
            throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Document document = XMLUtilities.parseFileToDOM(new File(tripXMLFilePath));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String expression = "/trips/trip[@id = " + tripID + "]";
        try {
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);
            node.getAttributes().getNamedItem("isAvailable").setNodeValue(status);

            XMLUtilities.transformDOMToFile(document, tripXMLFilePath);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(TripXMLCommonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateSeatStatus(String tripID, String seatID, String status)
            throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Document document = XMLUtilities.parseFileToDOM(new File(tripXMLFilePath));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String expression = "/trips/trip[@id = " + tripID + "]/seats/seat[@id = " + seatID + "]";
        try {
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);
            node.getAttributes().getNamedItem("available").setNodeValue(status);

            XMLUtilities.transformDOMToFile(document, tripXMLFilePath);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(TripXMLCommonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
