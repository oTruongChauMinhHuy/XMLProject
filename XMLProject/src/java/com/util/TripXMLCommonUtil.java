/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.Trip;
import com.DTO.Trips;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class TripXMLCommonUtil {

    private final static String tripXMLFilePath = "trips.xml";
    private static int countSeat = 0;

    public static String getRealFilePath(String realPath) {
        return realPath + TripXMLCommonUtil.tripXMLFilePath;
    }

    public static void createTripXMLFile(String realPath) throws JAXBException {
        File file = new File(TripXMLCommonUtil.getRealFilePath(realPath));
        if (!file.exists()) {
            Trips trips = DBUtilities.getAllTrips();
            if (trips != null) {
                XMLUtilities.JAXBMarshalling(trips, file);
            }
        }
    }

    public static void updateTripsFile(String realPath)
            throws JAXBException, ParserConfigurationException, SAXException, IOException {
        StAXCursor.updateAvailableTrips(TripXMLCommonUtil.getRealFilePath(realPath));
        File file = new File(TripXMLCommonUtil.getRealFilePath(realPath));
        Trips newTrips = DBUtilities.getAllTrips();
        if (newTrips != null) {
            Trips trips = (Trips) XMLUtilities.JAXBUnmarshalling(Trips.class, TripXMLCommonUtil.getRealFilePath(realPath));
            for (Trip trip : newTrips.getTrip()) {
                if (trips.getTripbyID(trip.getId()) == null) {
                    trips.getTrip().add(trip);
                }
            }
            XMLUtilities.JAXBMarshalling(trips, file);
        }
    }

    public static void updateTripStatus(String tripID, String status, String realPath)
            throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Document document = XMLUtilities.parseFileToDOM(new File(getRealFilePath(realPath)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String expression = "/trips/trip[@id = '" + tripID + "']";
        try {
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);
            node.getAttributes().getNamedItem("isAvailable").setNodeValue(status);

            XMLUtilities.transformDOMToFile(document, getRealFilePath(realPath));
        } catch (XPathExpressionException ex) {
            Logger.getLogger(TripXMLCommonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String checkSeatStatus(String tripID, String seatID, String realPath)
            throws ParserConfigurationException, SAXException, IOException {
        String status = null;
        Document document = XMLUtilities.parseFileToDOM(new File(getRealFilePath(realPath)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String expression = "/trips/trip[@id = '" + tripID + "']/seats/seat[@id = '" + seatID + "']/@available";
        try {
            status = (String) xPath.evaluate(expression, document, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            Logger.getLogger(TripXMLCommonUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return status;
    }

    public static void updateSeatStatus(String tripID, String seatID, String status, String realPath)
            throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Document document = XMLUtilities.parseFileToDOM(new File(getRealFilePath(realPath)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String expression = "/trips/trip[@id = '" + tripID + "']/seats/seat[@id = '" + seatID + "']";
        try {
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);
            node.getAttributes().getNamedItem("available").setNodeValue(status);

            XMLUtilities.transformDOMToFile(document, getRealFilePath(realPath));
        } catch (XPathExpressionException ex) {
            Logger.getLogger(TripXMLCommonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int countTotalSeats(String tripID, String realPath)
            throws ParserConfigurationException, SAXException, IOException {
        Document document = XMLUtilities.parseFileToDOM(new File(getRealFilePath(realPath)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String expression = "/trips/trip[@id = '" + tripID + "']";
        countSeat = 0;
        try {
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);
            countSeat(node);
        } catch (Exception e) {
        }
        return countSeat;
    }

    private static void countSeat(Node node) {
        if (node == null) {
            return;
        }
        if (node.getNodeName().equals("seat")) {
            String status = node.getAttributes().getNamedItem("available").getNodeValue();
            if (status.equals("false")) {
                countSeat++;
            }
        }
        NodeList list = node.getChildNodes();
        int i = 0;
        while (i < list.getLength()) {
            countSeat(list.item(i++));
        }
    }
}
