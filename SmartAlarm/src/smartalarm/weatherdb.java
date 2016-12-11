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
public class weatherdb {
    private int weather_id;
    private String weather_uptodate;
    
    
     //constructor to set private variable
    public weatherdb(int weather_id, String weather_uptodate){
            this.weather_id=weather_id;
            this.weather_uptodate=weather_uptodate;
         
    }
    //getters to access the private variables
    public int getweatherId(){ 
        return weather_id;
    }
    public String getweatherup(){ 
        return weather_uptodate;
    }
    
    
    
}
