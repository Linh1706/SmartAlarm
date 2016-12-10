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
public class tone {
    private int tone_id;
    private String tone_name;
    private String tone_url;
    
    //constructor to set private variable
    public tone(int tone_id, String tone_name, String tone_url){
            this.tone_id=tone_id;
            this.tone_name=tone_name;
            this.tone_url=tone_url;
    }
    
    //getters to access the private variables
    public int getId(){ //gettone_id???
        return tone_id;
    }
    public String getName(){
        return tone_name;
    }
    public String getURL(){
        return tone_url;
    }
    @Override
    public String toString(){
        return "Tone"+tone_id + "\nName" +tone_name+"\nURL" + tone_url;
    }
    
    
}
    

