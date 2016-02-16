/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trip", propOrder = {
    "bus",
    "date",
    "time",
    "car",
    "seats"
})
public class TripDTO {

    @XmlAttribute(required = true)
    private String id;
    @XmlElement(required = true)
    private String bus;
    @XmlElement(required = true)
    private String date;
    @XmlElement(required = true)
    private String time;
    @XmlElement(required = true)
    private CarDTO car;
    @XmlElement(required = false)
    private SeatDTOList seats;

    public TripDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public SeatDTOList getSeats() {
        return seats;
    }

    public void setSeats(SeatDTOList seats) {
        this.seats = seats;
    }

}
