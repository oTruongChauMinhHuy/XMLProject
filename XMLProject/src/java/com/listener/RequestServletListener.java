/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listener;

import com.DTO.CarDTOList;
import com.DTO.Trips;
import com.util.DBUtilities;
import com.util.TripXMLCommonUtil;
import com.util.XMLUtilities;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Web application lifecycle listener.
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class RequestServletListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
//        CarDTOList cars = DBUtilities.getAllCars();
//        String xmlCars = null;
//        try {
//            if (cars != null) {
//                xmlCars = XMLUtilities.marshallToString(cars);
//            }
//            System.out.println(xmlCars);
//            String realPath = sre.getServletContext().getRealPath("/");
//        } catch (JAXBException ex) {
//            Logger.getLogger(RequestServletListener.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (xmlCars != null) {
//            sre.getServletRequest().setAttribute("CARS", xmlCars);
//        }
    }
}
