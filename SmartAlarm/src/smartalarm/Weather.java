/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Melissa
 */
public class Weather implements Runnable{
     File weather = new File("Weather.xml");
     File weatherdata = new File("WeatherData.txt");
     private static String weatherstring= "";
     String [] weatherlocations;
     
     public Weather(String StartLocation){
         weatherlocations = new String[]{StartLocation,"Troy,AL"};
     }
     private void storedweatherdata(String weatherinfo){
         
        try { 
                FileWriter writer = new FileWriter(weatherdata,true);
                writer.write(weatherinfo+ System.getProperty("line.separator"));
                writer.flush();
                writer.close();
                
        } catch (IOException ex) {
            Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
     public int getWeathertime(){
         int weathertime =-1;
         Pattern p = Pattern.compile("Clear|Sunny"); 
         Matcher m = p.matcher(weatherstring);
         if(m.find()){
             weathertime=0;
         }
         p = Pattern.compile("Rain.|Overcast");
         m = p.matcher(weatherstring);
         if(m.find()){
             weathertime=10;
         }
         p = Pattern.compile("Snow.|Ice|Hail|Sleet|Freezing Rain");
         m = p.matcher(weatherstring);
         if(m.find()){
             weathertime=20;
         }
         p = Pattern.compile("Cloud.|Fog");
         m = p.matcher(weatherstring);
         if(m.find()){
             weathertime =5;
         }
         p = Pattern.compile("Strom");
         m = p.matcher(weatherstring);
         if(m.find()){
             weathertime = 15;
         }
         
         
         return weathertime;
     }
     
     public void run() {
         while(!Thread.interrupted()){
             if(weatherdata.exists()){
                  weatherdata.delete();
              }
             try {
                 weatherdata.createNewFile();
             } catch (IOException ex) {
                 Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
             }
           for(int w=0; w<weatherlocations.length;w++){
         //Build the URI template to pass to the API
                URI uri;
                 try {
                    uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("api.wunderground.com")
                    .setPath("/api/046b4ff5947720c4/conditions/q/" + weatherlocations[w] + ".xml")
                    .build();
                    HttpGet httpget = new HttpGet(uri);
                    //System.out.println(httpget.getURI());
                    CloseableHttpClient httpclient = HttpClients.createDefault();
                    CloseableHttpResponse response = null;
                    //Execute URI and store results in a file 
                    try {
                            response = httpclient.execute(httpget);
                            HttpEntity entity = response.getEntity();
                             if ( entity != null ) {
                                ByteArrayOutputStream os = new ByteArrayOutputStream();
                                    try {
                                        entity.writeTo(os);
                                        //String test = os.toString();
                                        FileOutputStream FileOut = new FileOutputStream(weather);
                                        os.writeTo(FileOut);
                                    } catch (IOException e1) {
                                    }
                                
                                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                                    Document doc = dBuilder.parse(weather);
                                    doc.getDocumentElement().normalize();
                                    NodeList observations = doc.getElementsByTagName("weather");
                                    if(observations.getLength() == 0){
                                        JOptionPane.showMessageDialog(null,"Weather Location not found! Please try another location.", "Weather Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    else{
                                        Node wea = observations.item(0);
                                        weatherstring = wea.getTextContent();
                                        int time = getWeathertime();
                                        
                                        //UNCOMMENT TO TEST WEATHER 
                                        //System.out.println(weatherlocations[w]+ ": "+ weatherstring + " "+ time );
                                        storedweatherdata(weatherlocations[w]+ ": "+ weatherstring + " "+ time);
                                        //To be written to the database
                                    }
                                    
                             }
            }catch(IOException | SAXException | ParserConfigurationException e ){
                    Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, e);
                 }
                 }catch(URISyntaxException ex) {
                    System.out.print("failed " + ex.toString());
                    Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
                 }
               try{
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().stop();
                }
           }
           try{
             Thread.sleep(1800000);
         } catch (InterruptedException ex) {
             Thread.currentThread().stop();
         }
         } 
     }
}
