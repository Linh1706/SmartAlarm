/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mp3Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linhnguyen
 */
public class WindowsSound {
    
    public static void powershell() throws IOException, InterruptedException {
        String psfile = "pshell.txt";
        String line;
        String pscode="\n";
       
        BufferedReader br = new BufferedReader(new FileReader(psfile));
        
        while((line=br.readLine())!=null){
            pscode+=(br.readLine()+"\n");
        }
        br.close();
      
        
        
        System.out.print(pscode);
        //System.out.println();
        String unmute = "[audio]::Mute=$false";
        String Vol_value = "[audio]::Volume=0.8"; // Set value from 0.0 - 1.0
        
       final Process p = Runtime.getRuntime().exec("powershell.exe");
       new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
       new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
       PrintWriter commands = new PrintWriter(p.getOutputStream(),true);
       commands.println("Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy Unrestricted");
       //commands.println("A");
       commands.println("./pshell.ps1");
       commands.println("Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy Restricted");
       commands.flush();
       //commands.println(unmute);
       //commands.println(Vol_value);
       
       commands.close();
       int returnCode = p.waitFor();
       System.out.println(returnCode);
    }
    
    
    
    public static void main(String[] args) {
        try {
            //String a = powershell();
            powershell();
        } catch (IOException ex) {
            
        } catch (InterruptedException ex) {
            
        }
    }
    
}
