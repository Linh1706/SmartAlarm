/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

/**
 *
 * @author Melissa
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeStringComparator implements Comparator<Alarm>{
   private DateFormat primaryFormat = new SimpleDateFormat("h:mm a");
   //private DateFormat secondaryFormat = new SimpleDateFormat("H:mm");

   @Override
   public int compare(Alarm alarm1, Alarm alarm2){
       String time1 = alarm1.getTime();
       String time2 = alarm2.getTime();
       return timeInMillis(time1) - timeInMillis(time2);
   }

   public int timeInMillis(String time){
       return timeInMillis(time, primaryFormat);
   }

   private int timeInMillis(String time, DateFormat format) {
        // you may need more advanced logic here when parsing the time if some times have am/pm and others don't.
       try{
            Date date = format.parse(time);
            return (int)date.getTime();
       }catch(ParseException e){
           /*if(format != secondaryFormat){
               return timeInMillis(time, secondaryFormat);
           }else{*/
               System.out.println(e);
               return -1;
           //}
       }
    }
}
