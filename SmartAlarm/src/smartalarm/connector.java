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
import java.sql.Statement;

import javax.swing.*;

public class connector {
//final static string 
static String DBUserName = "root";
static String DBPassword = "";
private Statement stmt;
private String db;
private Connection conn;

//Connection
static String driver = "com.mysql.jdbc.Driver";
static String url = "jdbc:mysql://localhost:3306/db_alarm";

public connector(String DBUserName, String DBPassword, String db_alarm){
    connector.DBUserName=DBUserName;
    connector.DBPassword=DBPassword;
    this.db = db_alarm;
    connect();
}
       
//public static void main (String[] args) {
private void connect(){
    try{
      Connection conn = DriverManager.getConnection( url, DBUserName, DBPassword);
      if (conn != null){
          System.out.println("Connected to the database");
      }
        }
    catch(SQLException e){
        System.out.println("AN ERROR OCCURED WHEN CONNECTING TO DATABASE");
        JOptionPane.showMessageDialog(null, e);
    }
}
 public void close() throws SQLException {
        conn.close();
    }


    
    /**
     *
     * @param t
     * @return
     */
    public boolean insert(tone t){
        String query = "INSERT INTO table VALUES ('"+t.getId()+"','"+t.getName()+"','"+t.getURL()+"');";
        try{
            stmt.execute(query);
            
        }
        catch (SQLException e){
            return false;
        }
    return true;
    }
    
    
}


