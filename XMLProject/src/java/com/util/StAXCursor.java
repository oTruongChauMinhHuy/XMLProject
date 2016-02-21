/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author HuyTCM1
 */
public class StAXCursor {

    public static void updateAvailableTrips(String filePath) {
        FileInputStream inputFile;
        FileOutputStream outputFile;

        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            File file = new File(filePath);
            inputFile = new FileInputStream(file);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputFile);

            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            File newFile = new File(filePath + "_temp");
            outputFile = new FileOutputStream(newFile);
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(outputFile);

            boolean isIgnore = false;
            while (reader.hasNext()) {
                int eventType = reader.getEventType();
                switch (eventType) {
                    case XMLStreamConstants.START_DOCUMENT:
                        writer.writeStartDocument();
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        int attrCounts = reader.getAttributeCount();
                        if (elementName.equals("trip")) {
                            String isAvailable = reader.getAttributeValue(null, "isAvailable");
                            if (!isAvailable.equals("1")) {
                                isIgnore = true;
                            }
                        }
                        if (!isIgnore) {
                            writer.writeStartElement(elementName);
                            if (attrCounts > 0) {
                                for (int i = 0; i < attrCounts; i++) {
                                    writer.writeAttribute(reader.getAttributeLocalName(i),
                                            reader.getAttributeValue(i));
                                }
                            }
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (!isIgnore) {
                            writer.writeCharacters(reader.getText());
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (!isIgnore) {
                            writer.writeEndElement();
                        } else {
                            String endElement = reader.getLocalName();
                            if (endElement.equals("trip")) {
                                isIgnore = false;
                            }
                        }
                        break;
                }
                reader.next();
            }
            int eventType = reader.getEventType();
            if (eventType == XMLStreamConstants.END_DOCUMENT) {
                reader.close();
                writer.writeEndDocument();
                writer.flush();
                writer.close();
            }
            //rename file
            reWriteFile(newFile, file);
        } catch (IOException | XMLStreamException ex) {
            Logger.getLogger(StAXCursor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void reWriteFile(File source, File target)
            throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(source);
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(reader);

        FileWriter fileWriter = new FileWriter(target);
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(fileWriter);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
