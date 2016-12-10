/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

/**
 *
 * @author Linh
 */

//edited by sailuja
//import java.sql.SQLException;
//import java.util.ArrayList;


public class SmartAlarm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Added by Sailuja
        connector dbhandler = new connector("root","","db_alarm");
        
        //to insert tone into table
        tone t = new tone(4,"second","url of music file here");
        dbhandler.insert(t);
    }
    
}
