/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author HuyTCM1
 */
public class StAXCursor {

    public static void updateAvailableTrips(String filePath) {
        FileInputStream inputFile = null;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            File file = new File(filePath);
            inputFile = new FileInputStream(file);
            XMLEventReader reader = factory.createXMLEventReader(inputFile);
            
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement element = (StartElement) event;
                    if (element.getName().toString().equals("trip")) {
                        Iterator iter = element.getAttributes();
                        while (iter.hasNext()) {
                            Attribute attribute = (Attribute) iter.next();
                            if (attribute.getName().toString().equals("status") && 
                                    !attribute.getValue().contains("waiting")) {
                                System.out.println(element.getName());
                            }
                        }
                    }
                }
                
            }

        } catch (Exception ex) {
            Logger.getLogger(StAXCursor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
