/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.*;

/**
 *
 * @author linhnguyen
 */

public class TravelDuration {
    
    static String key = "AIzaSyCW8qcjq1CGbbRG0ELfkbWZKYqegMPqMN8"; 
    
    public static void duration (String origin, String destination) throws Exception {
        String s = "http://maps.googleapis.com/maps/api/directions/json?";
        
        String a = s +"origin="+origin+"&destination="+destination+"&key"+key;
        
        URL url =  new URL(a);
        
        //get the json data returned from google
        String str;
        try (Scanner scan = new Scanner(url.openStream())) {
            str = new String();
            while (scan.hasNextLine()){
                str += scan.nextLine();
            }
        }
        
        //put data received to an object.
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

        Double origin_lat;
        Double origin_lng;
        Double destination_lat;
        Double destination_lng;
        //the Destination address will be passed to this function.
        // This address is for Troy University in Troy.
        // These lines will translate the address to longtitude and latitude.
        AddrTranslate dest = new AddrTranslate();
        
        dest.addressTranslate("600 University Ave, Troy, AL 36082");
        destination_lat = dest.getlat();
        System.out.println(destination_lat);
        destination_lng = dest.getlng();
        System.out.println(destination_lng);
        
        //the Origin address.
        //This address is Troy campus in Montgomery.
        AddrTranslate ori = new AddrTranslate();
        ori.addressTranslate("231 Montgomery St, Montgomery, AL 36104");
//        These codes below is to connect with the 
//        setRoute ori = new setRoute();
//        ori.getStartLocation();
//        AddrTranslate.addressTranslate(ori);
        origin_lat = ori.getlat();
        System.out.println(origin_lat);
        origin_lng = ori.getlng();
        System.out.println(origin_lng);
        
        //Preparing to calculate the duration using longtitude and latitude
        String origin = origin_lat+","+origin_lng;
        System.out.println(origin);
        String destination = destination_lat+","+destination_lng;
        
        //Call the method
        duration(origin,destination);
    }
    
}
