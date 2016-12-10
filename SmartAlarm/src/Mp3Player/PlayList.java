/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mp3Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import Mp3Player.MusicGui;

/**
 *
 * @author linhnguyen
 */
public class PlayList {
    String playlist = "Playlist.txt";
    
    public void writeList(){
//        Path path = Paths.get(playlist);
//        if(Files.exists(path)) { 
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(playlist,false));
                //PrintWriter pw = new PrintWriter(bw);
                for (int i=0;i<MusicGui.tones.size();i++)
                {
                    bw.write(MusicGui.tones.get(i).toString()+"\n");
                }
                bw.close();
            } catch (IOException ex) {
                
            }                
       
}
    public void readList() {
        String line;
        try {
        BufferedReader rl = new BufferedReader(new FileReader(playlist));
        if (!rl.ready()){
        }
        
        while ((line=rl.readLine())!=null){
            MusicGui.tones.add(line);
        }
        }
        catch (IOException ex){
            
        }
    }
    
    public void default_tone (){
        int counter=0;
        for (int i=0;i<MusicGui.tones.size();i++){
            
            if (MusicGui.tones.get(i)=="nothingatall.mp3"){
                counter++;
            }
            
        }
        if (counter==0){
            MusicGui.tones.add("nothingatall.mp3");
        }
    }
    
}
