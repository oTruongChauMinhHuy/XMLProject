/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DTO;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trip"
})
@XmlRootElement(name = "trips")
public class TripDTOList {
    
    @XmlElement(required = true)
    private List<TripDTO> trip;

    public TripDTOList() {
    }

    public List<TripDTO> getTrips() {
        if (trip == null) {
            trip = new ArrayList<>();
        }
        return trip;
    }
    
}
