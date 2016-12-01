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
import java.sql.SQLException;
import java.sql.DriverManager;

import java.sql.*;
import javax.swing.*;



public class connector {

//final static string 
static String DBUserName = "root";
static String DBPassword = "";
private Statement stmt;
private ResultSet rs;

//Connection
static String driver = "com.mysql.jdbc.driver";
static String url = "jdbc:mysql://localhost:3306/db_alarm";
       private static String http;
       
public static Connection ConnectDb (){
    try{
        Class.forName (driver);
             Connection conn = DriverManager.getConnection(url,DBUserName,DBPassword);
        return conn;
        }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
     return null;
    }
}
    
    /**
     *
     * @param sr
     * @return
     * @throws SQLException
     */
}



