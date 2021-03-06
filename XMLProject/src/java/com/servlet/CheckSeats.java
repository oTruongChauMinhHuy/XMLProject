/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.util.TimerSeats;
import com.util.TripXMLCommonUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM1
 */
public class CheckSeats extends HttpServlet {

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
            String tripID = request.getParameter("txtTripID");
            String[] seats = request.getParameterValues("seats");
            boolean result = true;
            String realPath = this.getServletContext().getRealPath("/");
            for (String seat : seats) {
                try {
                    String status = TripXMLCommonUtil.checkSeatStatus(tripID, seat, realPath);
                    if (!status.equals("true")) {
                        String message = "Ghế số " + seat + " hiện đang bận!\n";
                        out.println(message);
                        result = false;
                    } else {
                        TripXMLCommonUtil.updateSeatStatus(tripID, seat, "pending", realPath);
                    }
                } catch (ParserConfigurationException | SAXException | TransformerException ex) {
                    Logger.getLogger(CheckSeats.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException e) {
                    out.println("Vui lòng chọn ghế!");
                }
                if (result) {
                    out.println(result);
                }
            }
            Timer timer = new Timer();
            timer.schedule(new TimerSeats(seats, tripID, realPath), 35 * 1000);
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
