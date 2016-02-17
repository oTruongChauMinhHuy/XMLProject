/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.Bus;
import com.DTO.Car;
import com.DTO.CarDTOList;
import com.DTO.Seat;
import com.DTO.Trip;
import com.DTO.TripDTOList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
public class DBUtilities {

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TripManager;instanceName=MSSQL2012";
        return DriverManager.getConnection(url, "sa", "123456789");
    }

    public static boolean checkLogin(String username, String password) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = makeConnection();
            String sql = "SELECT * FROM Accounts WHERE username = ? AND password = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

    public static CarDTOList getAllCars() {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = makeConnection();
            String sql = "SELECT * FROM Cars";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            CarDTOList cars = new CarDTOList();
            while (rs.next()) {
                String numberPlate = rs.getString("numberPlate");
                Car car = new Car();
                car.setNumberPlate(numberPlate);
                cars.getCar().add(car);
            }
            return cars;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    public static TripDTOList getAllTrips() {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = makeConnection();
            String sql = "SELECT * FROM Trips WHERE isAvailable = 1";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            
            TripDTOList trips = new TripDTOList();
            while (rs.next()) {                
                String tripID = rs.getString("tripID");
                Trip trip = new Trip();
                trip.setId(tripID);
                String bus = rs.getString("bus");
                trip.setBus(Bus.valueOf(bus));
                String date = rs.getString("date");
                trip.setDate(XMLUtilities.toXMLGregorianDate(date));
                String time = rs.getString("time");
                trip.setTime(XMLUtilities.toXMLGregorianTime(time));
                Car car = new Car();
                car.setNumberPlate(rs.getString("numberPlate"));
                
                trip.setCar(car);
                Trip.Seats seats = new Trip.Seats();
                //initial seat
                for (int i = 1; i <= car.getNumberOfSeats(); i++) {
                    Seat seat = new Seat();
                    seat.setId(String.valueOf(i));
                    seats.getSeat().add(seat);
                }
                trip.setIsAvailable(rs.getString("isAvailable"));
                trip.setSeats(seats);
                //add trip
                trips.getTrips().add(trip);
            }
            return trips;
        } catch (Exception e) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
}
