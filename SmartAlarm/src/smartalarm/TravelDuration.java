/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.net.URL;
import java.util.Scanner;
import org.json.*;
/**
 *
 * @author linhnguyen
 */
public class TravelDuration {
    public static void duration (String origin, String destination) throws Exception {
        String s = "http://maps.googleapis.com/maps/api/directions/json?";
        String key = "AIzaSyCW8qcjq1CGbbRG0ELfkbWZKYqegMPqMN8";
        String a = s +"origin="+origin+"&destination="+destination+"&key"+key;
        
        URL url =  new URL(a);
        
        String str;
        try (Scanner scan = new Scanner(url.openStream())) {
            str = new String();
            while (scan.hasNextLine()){
                str += scan.nextLine();
            }
        }
//        System.out.println(str);
        JSONObject obj = new JSONObject(str);
        if (!obj.getString("status").equals("OK"))
            return;
        
        JSONObject arr = obj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration");
        //System.out.println(arr);
        //System.out.println(arr.getString("text"));        
        System.out.println("From "+origin+" to "+destination);
        System.out.println("duration in seconds: "+arr.getInt("value")+ " seconds");
        System.out.println("duration in minutes: "+arr.getString("text"));
       
    }
    
    
    public static void main (String[] args) throws Exception{

        String origin = "Montgomery,AL";
        String destination = "Troy,AL";
        
        duration(origin,destination);
        
        
    }
    
}
