/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linhnguyen
 */
public class Travelduration2 implements Runnable {
    
    public void run(){
        
        
        ScheduledThreadPoolExecutor TravelPool = new ScheduledThreadPoolExecutor(2);
     
        TravelPool.scheduleAtFixedRate(new TravelDuration(), 0, 5, TimeUnit.SECONDS);
    }
    
    
        
        
        
    }
    

}
