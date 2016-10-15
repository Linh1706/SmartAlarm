package mp3player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Mp3Class 
{
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    
    public long PauseLocation;
    public long SongTotalLength;
    public String fileLocation;
    
    public void Stop()
    {
        if (player != null)
        {
            player.close();
            PauseLocation = 0;
            SongTotalLength = 0;
            MP3PlayerGUI.Display.setText("");
        }
    }
        public void Stop2()
    {
        if (player != null)
        {
            player.close();
        }
    }
    
    public void Pause()
    {
        if (player != null)
        {
            try 
            {
                PauseLocation = FIS.available();
                player.close();
            } 
            catch (IOException ex) 
            {
                
            }
        }
    }
    
    public void Play(String path)
    {
        if (PauseLocation == 0) 
        {
            try
            {
                FIS = new FileInputStream(path);
                BIS = new BufferedInputStream(FIS);

                player = new Player(BIS);
                SongTotalLength = FIS.available();
                fileLocation = path + "";
            }
            catch (FileNotFoundException | JavaLayerException ex)
            {
            
            } 
            catch (IOException ex) 
            {
            
            }
        }
        else 
        {
            try
            {
                FIS = new FileInputStream(fileLocation);
                BIS = new BufferedInputStream(FIS);

                player = new Player(BIS);
                FIS.skip(SongTotalLength - PauseLocation);
            }
            catch (FileNotFoundException | JavaLayerException ex)
            {
            
            } 
            catch (IOException ex) 
            {
            
            }
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
    
    
}
