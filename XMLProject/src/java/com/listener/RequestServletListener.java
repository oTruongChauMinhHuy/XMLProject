/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listener;

import com.DTO.CarDTOList;
import com.util.DBUtilities;
import com.util.XMLUtilities;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

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
        CarDTOList cars = DBUtilities.getAllCars();
        String xml = XMLUtilities.marshallToString(cars);
        sre.getServletRequest().setAttribute("CARS", xml);
    }
}
