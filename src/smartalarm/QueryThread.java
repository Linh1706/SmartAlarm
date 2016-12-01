/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

/**
 *
 * @author thapa
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QueryThread {
    public static void main(String[] args) {
 
        // creates three different Connection objects
        Connection conn = null;
        
 
        try {
            // connect
            String url = "jdbc:mysql://localhost:3306/db_alarm";
            String user = "root";
            String password = " ";
 
            conn = DriverManager.getConnection(url,user,password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred. Maybe user/password is invalid");
        }
    }
    
}
