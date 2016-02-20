/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class TimerSeats extends TimerTask {

    private String[] seats;
    private String tripID;
    private String realPath;

    public TimerSeats(String[] seats, String tripID, String realPath) {
        this.seats = seats;
        this.realPath = realPath;
        this.tripID = tripID;
    }

    @Override
    public void run() {
        for (String seat : seats) {
            try {
                String status = TripXMLCommonUtil.checkSeatStatus(tripID, seat, realPath);
                if (status.equals("pending")) {
                    TripXMLCommonUtil.updateSeatStatus(tripID, seat, "true", realPath);
                }
            } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
                Logger.getLogger(TimerSeats.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}
