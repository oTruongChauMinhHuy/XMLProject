/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.DTO.CarDTO;
import com.DTO.CarDTOList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        } catch (Exception e) {
            System.out.println("DBUtilities: " + e.getMessage());
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
            } catch (Exception e) {
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
                CarDTO car = new CarDTO();
                car.setNumberPlate(numberPlate);
                car.setDriver("a");
                car.setNumberOfSeats(Integer.valueOf(24));
                cars.getCar().add(car);
            }
            return cars;
        } catch (Exception e) {
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
            } catch (Exception e) {
            }
        }
        return null;
    }
}
