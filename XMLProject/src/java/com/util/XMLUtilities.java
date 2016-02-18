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
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author HuyTCM1
 */
public class XMLUtilities {

    public static void XJCGenerateJavaObj(String output, String fileSchemaURI,
            String packageName)
            throws IOException {
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
    }

    public static <T> Object JAXBUnmarshalling(Object insClass, String fileSource)
            throws JAXBException {
        JAXBContext jAXBContext = JAXBContext.newInstance(insClass.getClass());
        Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();

        File file = new File(fileSource);
        Object object = unmarshaller.unmarshal(file);
        return object;
    }

    public static <T> void JAXBMarshalling(T object, File output)
            throws JAXBException {
        JAXBContext jAXBContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jAXBContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(object, output);
    }

    public static <T> String marshallToString(T object)
            throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        StringWriter sw = new StringWriter();
        mar.marshal(object, sw);

        return sw.toString();
    }

    public static String toXMLGregorianDate(String date)
            throws ParseException, DatatypeConfigurationException {
//        GregorianCalendar gCalendar = new GregorianCalendar();
//        String[] parts = date.split("/");
//        gCalendar.set(Integer.valueOf(parts[0]), (Integer.valueOf(parts[1]) - 1), Integer.valueOf(parts[2]));
//        gCalendar.clear(Calendar.ZONE_OFFSET);
//        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        return date.replace("/", "-");
    }

    public static String toXMLGregorianTime(String time)
            throws ParseException, DatatypeConfigurationException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        GregorianCalendar gCalendar = new GregorianCalendar();
//        gCalendar.setTime(dateFormat.parse(time));
//        gCalendar.clear(Calendar.ZONE_OFFSET);
//        gCalendar.clear(Calendar.MILLISECOND);
//        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        return time;
    }
    
    public static Document parseFileToDOM(File xmlFile)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        return doc;
    }

    public static void transformDOMToFile(Node node, String filePath)
            throws TransformerConfigurationException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        Source source = new DOMSource(node);
        File file = new File(filePath);
        Result result = new StreamResult(file);

        transformer.transform(source, result);
    }
}
