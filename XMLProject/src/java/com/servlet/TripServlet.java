/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.DTO.Bus;
import com.DTO.Car;
import com.DTO.Trip;
import com.util.DBUtilities;
import com.util.TripXMLCommonUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM1
 */
public class TripServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("btnAction");
            
            boolean result = false;
            switch (action) {
                case "AddTrip": {
                    String bus = request.getParameter("ddlBus");
                    String date = request.getParameter("ddlDate");
                    String hour = request.getParameter("txtHour");
                    String min = request.getParameter("txtMin");
                    String numberPlate = request.getParameter("ddlCar");
                    String tripID = bus + date.replace("-", "") + hour + min;
                    String time = hour + ":" + min + ":00";
                    Trip trip = new Trip();
                    trip.setId(tripID);
                    trip.setIsAvailable(String.valueOf(true));
                    trip.setBus(Bus.valueOf(bus));
                    trip.setDate(date);
                    trip.setTime(time);
                    Car car = new Car();
                    car.setNumberPlate(numberPlate);
                    trip.setCar(car);
                    result = DBUtilities.addNewTrip(trip);
                    break;
                }
                case "StartTrip": {
                    String tripID = request.getParameter("txtTripID");
                    try {
                        int totalSeats = TripXMLCommonUtil.countTotalSeats(tripID);
                        result = DBUtilities.startTrip(tripID, totalSeats);
                    } catch (ParserConfigurationException | SAXException | IOException e) {
                        log(TripServlet.class.getName(), e);
                    }
                    break;
                }
                case "CancelTrip": {
                    String tripID = request.getParameter("txtTripID");
                    result = DBUtilities.startTrip(tripID, 0);
                    break;
                }
            }
            if (result) {
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
