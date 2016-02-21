/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.AccountDTO;
import com.DTO.Bus;
import com.DTO.Car;
import com.DTO.CarDTOList;
import com.DTO.Seat;
import com.DTO.Trip;
import com.DTO.Trips;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;

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

    public static boolean createNewUser(AccountDTO account) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = makeConnection();
            String sql = "INSERT INTO Accounts (username, password) "
                    + "VALUES(?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());

            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
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

    public static Trips getAllTrips() {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = makeConnection();
            String sql = "SELECT * FROM Trips WHERE isAvailable = 1";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            Trips trips = new Trips();
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
                    seat.setAvailable(Boolean.toString(true));
                    seats.getSeat().add(seat);
                }
                boolean isAvailable = rs.getBoolean("isAvailable");
                if (Boolean.valueOf(isAvailable)) {
                    trip.setIsAvailable("true");
                } else {
                    trip.setIsAvailable("false");
                }
                trip.setSeats(seats);
                //add trip
                trips.getTrip().add(trip);
            }
            return trips;
        } catch (ClassNotFoundException | SQLException | ParseException | DatatypeConfigurationException e) {
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

    public static boolean addNewTrip(Trip trip) 
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = makeConnection();
            String sql = "INSERT INTO Trips(tripID, bus, date, time, numberPlate, isAvailable) "
                    + "VALUES(?,?,?,?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, trip.getId());
            statement.setString(2, trip.getBus().toString());
            statement.setDate(3, Date.valueOf(trip.getDate()));
            statement.setTime(4, Time.valueOf(trip.getTime()));
            statement.setString(5, trip.getCar().getNumberPlate());
            statement.setBoolean(6, Boolean.valueOf(trip.getIsAvailable()));

            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            try {
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

    public static boolean startTrip(String tripID, int totalSeats) 
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = makeConnection();
            String sql;
            if (totalSeats >= 0) {
                sql = "UPDATE Trips SET isAvailable = 0, totalSeats = ? WHERE tripID = ?";
                statement = con.prepareStatement(sql);
                statement.setInt(1, totalSeats);
                statement.setString(2, tripID);
            } else {
                sql = "DELETE FROM Trips WHERE tripID = ?";
                statement = con.prepareCall(sql);
                statement.setString(1, tripID);
            }

            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } finally {
            try {
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
}
