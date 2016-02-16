/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car", propOrder = {
    "driver",
    "numberOfSeats"
})
@XmlRootElement(name = "car")
public class CarDTO implements Serializable {

    @XmlAttribute(required = true)
    private String numberPlate;
    @XmlElement(required = false)
    private String driver;
    @XmlElement(required = true, defaultValue = "24")
    private Integer numberOfSeats;

    public CarDTO() {
    }

    public CarDTO(String numberPlate) {
        this.numberPlate = numberPlate;
        this.numberOfSeats = 24;
    }
    
    public CarDTO(String numberPlate, String driver, Integer numberOfSeats) {
        this.numberPlate = numberPlate;
        this.driver = driver;
        this.numberOfSeats = numberOfSeats;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
