/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.CarDTO;
import com.DTO.CarDTOList;
import com.DTO.SeatDTO;
import com.DTO.SeatDTOList;
import com.DTO.TripDTO;
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
                CarDTO car = new CarDTO(numberPlate);
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
                TripDTO trip = new TripDTO();
                trip.setId(tripID);
                trip.setBus(rs.getString("bus"));
                trip.setDate(rs.getString("date"));
                trip.setTime(rs.getString("time"));
                CarDTO car = new CarDTO(rs.getString("numberPlate"));
                trip.setCar(car);
                //initial seat
                SeatDTOList seats = new SeatDTOList();
                for (int i = 1; i <= car.getNumberOfSeats(); i++) {
                    SeatDTO seat = new SeatDTO();
                    seat.setId(String.valueOf(i));
                    seats.getSeats().add(seat);
                }
                trip.setSeats(seats);
                
                //add trip
                trips.getTrips().add(trip);
            }
            return trips;
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
}
