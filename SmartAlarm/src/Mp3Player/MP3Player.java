package Mp3Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class MP3Player 
{
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;
    
    public void Stop2()
    {
        if (player != null)
        {
            
            player.close();
            
        }
    }
    public void Stop()
    {
        if (player != null)
        {
            pauseLocation = 0;
            songTotalLength = 0;
            player.close();
            //MP3PlayerGUI.DisplayName.setText("Smart Alarm");
        }
    }
    
    public void Play(String path)
    {
        try
        {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            songTotalLength = FIS.available();
            fileLocation = path;
        }
        catch (FileNotFoundException | JavaLayerException ex)
        {
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread ()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                } 
                
                catch (JavaLayerException ex) 
                {
                    
                }
            }
        } .start();
    }
    
    public void Pause()
    {
        if (player != null)
        {
            try {
                pauseLocation = FIS.available();
                player.close();
            } 
            catch (IOException ex) 
            {
                
            }
        }
            
    }
    
     public void Resume()
    {
        try
        {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            FIS.skip(songTotalLength - pauseLocation);
        }
        catch (FileNotFoundException | JavaLayerException ex)
        {
            
        } catch (IOException ex) 
        {
            
        }
        
        new Thread ()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                } 
                
                catch (JavaLayerException ex) 
                {
                    
                }
            }
        } .start();
    }
     
     public void PlayResume(String path)
     {
         
         
         if (pauseLocation ==0 ) 
         {
            Play(path);
            //MP3PlayerGUI.DisplayName.setText("When you say nothing at all");
         }
         else Resume();
         
     }
        
}
