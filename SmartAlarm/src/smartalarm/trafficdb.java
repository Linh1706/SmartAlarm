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
public class trafficdb {
    private int traffic_id;
    private String route;
    
    public trafficdb(int traffic_id, String route){
        this.traffic_id=traffic_id;
        this.route=route;
        
    }
    
    public int gettrafId(){
        return traffic_id;
    }
    
    public String getroute(){
        return route;
    }
    
}
