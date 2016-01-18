/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import generate.jaxb.Car;
import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/**
 *
 * @author HuyTCM1
 */
public class XMLUtilities {
    public static void XJCGenerateJavaObj(String output, String fileSchemaURI, String packageName) {
        try {
            SchemaCompiler schemaCompiler = XJC.createSchemaCompiler();
            schemaCompiler.setErrorListener(new ErrorListener() {

                @Override
                public void error(SAXParseException saxpe) {
                    System.out.println("error: " + saxpe.getMessage());
                }

                @Override
                public void fatalError(SAXParseException saxpe) {
                    System.out.println("fatal: " + saxpe.getMessage());
                }

                @Override
                public void warning(SAXParseException saxpe) {
                    System.out.println("warning: " + saxpe.getMessage());
                }

                @Override
                public void info(SAXParseException saxpe) {
                    System.out.println("info: " + saxpe.getMessage());
                }
            });
            schemaCompiler.forcePackageName(packageName);
            File schema = new File(fileSchemaURI);
            InputSource inputSource = new InputSource(schema.toURI().toString());
            schemaCompiler.parseSchema(inputSource);
            S2JJAXBModel s2JJAXBModel = schemaCompiler.bind();
            JCodeModel jCodeModel = s2JJAXBModel.generateCode(null, null);
            jCodeModel.build(new File(output));
            System.out.println("Finished!");
        } catch (Exception e) {
            System.out.println("XMLUtilities - XJCGenerateJavaObj: " + e.getMessage());
        }
    }
    
    public static void JAXBUnmarshalling(Class insClass, String fileSource) {
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(insClass);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            
            File file = new File(fileSource);
            Car car = (Car)unmarshaller.unmarshal(file);
            
            System.out.println("NumberPlate: " + car.getNumberPlate());
            System.out.println("NumberOfSeats: " + car.getNumberOfSeats());
        } catch (Exception e) {
        }
    }
    
    public static void JAXBMarshalling(Object object, String output) {
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            marshaller.marshal(object, new File(output));
        } catch (Exception e) {
        }
    }
    
     public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
        }
        return xmlCalendar;
    }
}
