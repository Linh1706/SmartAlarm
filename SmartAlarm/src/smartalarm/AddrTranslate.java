/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;
import static smartalarm.TravelDuration.key;

/**
 *
 * @author linhnguyen
 */
public class AddrTranslate {
    
    static Double lng;
    static Double lat;
    
    public void longlat (Double lng, Double lat){
        this.lng = lng;
        this.lat = lat;
        
    }
    public Double getlng(){
        return lng;
    }
    
    public Double getlat(){
        return lat;
    }
    
    public static void addressTranslate(String addr) throws Exception {
        String s = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        
        String a = s + URLEncoder.encode(addr, "UTF-8") +"&key" +key;
        
        URL url = new URL (a);
        
        String str;
        try (Scanner scan = new Scanner(url.openStream())) {
            str = new String();
            while (scan.hasNextLine()){
                str += scan.nextLine();
            }
        }
        
        JSONObject obj = new JSONObject(str);
        if (! obj.getString("status").equals("OK"))
            return;
        
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        System.out.println(res.getString("formatted_address"));
        JSONObject loc =
        res.getJSONObject("geometry").getJSONObject("location");
        System.out.println("lat: " + loc.getDouble("lat") +
                        ", lng: " + loc.getDouble("lng"));
        
        lng = loc.getDouble("lng");
        lat = loc.getDouble("lat");
    }
    
}
