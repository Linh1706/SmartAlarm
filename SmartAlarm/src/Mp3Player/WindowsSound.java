/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mp3Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author linhnguyen
 */
public class WindowsSound {
    
    public static void powershell() throws IOException{
        String psfile = "pshell.txt";
        String line;
        String pscode="";
        BufferedReader br = new BufferedReader(new FileReader(psfile));
        
        while((line=br.readLine())!=null){
            pscode+=br.readLine();
        }
                
       
        
        String unmute = "[audio]::Mute = $false";
        String Vol_value = "[audio]::Volume  = 0.8"; // Set value from 0.0 - 1.0
        
        String[] ps = {"powershell.exe",pscode,unmute,Vol_value};
        ProcessBuilder pb = new ProcessBuilder(ps);
        Process p = pb.start();
    }
    
    
    
//    public static void main(String[] args) throws IOException{
//        //String a = powershell();
//        System.out.println(powershell());
//    }
    
}
