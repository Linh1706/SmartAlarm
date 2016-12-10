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
public class location {
    private int loc_id;
    private String current_loc;
    private String dest_loc;
        
    //constructor to set private variable
    public location(int loc_id, String current_loc, String dest_loc){
            this.current_loc=current_loc;
            this.dest_loc=dest_loc;
            this.loc_id=loc_id;
    }
    
    //getters to access the private variables
    public int getId(){ 
        return loc_id;
    }
    public String getName(){
        return current_loc;
    }
    public String getURL(){
        return dest_loc;
    }
   
    
    
    
}
