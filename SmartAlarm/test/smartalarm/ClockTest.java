/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Melissa
 */
public class ClockTest {
    
    static Clock C1;
    
    public ClockTest() {
   
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        C1 = new Clock(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Clock.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Clock.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   public int currenthour(){
       Calendar cal = new GregorianCalendar();
       return cal.get(Calendar.HOUR);
   }
    public String getcurrenttime(){
       Calendar cal = new GregorianCalendar();
         int hour = cal.get(Calendar.HOUR);
         int min = cal.get(Calendar.MINUTE);
         int AM_PM = cal.get(Calendar.AM_PM);
         if(hour == 0){
            hour = 12;
        }
        String night_day;

        if(AM_PM == 0){
            night_day = "AM";
        }
        else{
            night_day = "PM";
        }
        String time = String.format("%02d",hour) + ":" + String.format("%02d",min) + " " + night_day;
        return time;
    }
    public String getcurrentday(){
        Calendar cal = new GregorianCalendar();
         int day = cal.get(Calendar.DAY_OF_WEEK);
        String dayofweek ="";
                    switch(day){
                        case 1:
                            dayofweek = "Sunday";
                            break;
                        case 2:
                            dayofweek = "Monday";
                            break;
                        case 3:
                            dayofweek = "Tuesday";
                            break;
                        case 4:
                            dayofweek = "Wednesday";
                            break;
                        case 5:
                            dayofweek = "Thursday";
                            break;
                        case 6:
                            dayofweek = "Friday";
                            break;
                        case 7:
                            dayofweek = "Saturday";
                            break;
                    }
                    return dayofweek;
    }
    @Test
    public void testcheckAlarm_wrongtime(){
        //get current time and add one hour to ensure the time is wrong
        int min = 45;
        String night_day = "PM";
        String Alarmtime =String.format("%02d",(currenthour()+1)) + ":" + String.format("%02d",min) + " " + night_day;
        ArrayList<String>daysofalarm = new ArrayList();
        daysofalarm.add("Tuesday");
        Alarm testAlarm = new Alarm("test",daysofalarm,Alarmtime,false,0,"none");
        C1.Alarms.add(testAlarm);
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_wrongtime: ");
        System.out.println("Expected: false Actual: " + C1.Alarmsound);
        assertFalse(C1.Alarmsound);
    }
    
    @Test
    public void testcheckAlarm_enabled(){
         ArrayList<String>daysofalarm = new ArrayList();
        daysofalarm.add("Tuesday");
        Alarm testAlarm = new Alarm("test",daysofalarm,getcurrenttime(),false,0,"none");
        testAlarm.setenabled(false);
        C1.Alarms.add(testAlarm);
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_enabled: ");
        System.out.println("Expected: false Actual: " + C1.Alarmsound);
        assertFalse(C1.Alarmsound);
    }
    
     @Test
    public void testcheckAlarm_noday(){
        ArrayList<String>daysofalarm = new ArrayList();
        Alarm testAlarm = new Alarm("test",daysofalarm,getcurrenttime(),false,0, "none");
        C1.Alarms.add(testAlarm);
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_noday: ");
        System.out.println("Expected: false Actual: " + C1.Alarmsound);
        assertFalse(C1.Alarmsound);
    }
    
    @Test
    public void testcheckAlarm_daynotmatch(){
        String day="Monday";
         if(day.compareToIgnoreCase(getcurrentday())==0){
             day= "Tuesday";
         }
        ArrayList<String>daysofalarm = new ArrayList();
        daysofalarm.add(day);
        Alarm testAlarm = new Alarm("test",daysofalarm,getcurrenttime(),false,0,"none");
        C1.Alarms.add(testAlarm);
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_daynotmatch: ");
        System.out.println("Expected: false Actual: " + C1.Alarmsound);
        assertFalse(C1.Alarmsound);
    }
    
    @Test
    public void testcheckAlarm_soundalarm(){
        ArrayList<String>daysofalarm = new ArrayList();
        daysofalarm.add(getcurrentday());
        Alarm testAlarm = new Alarm("test",daysofalarm,getcurrenttime(),false,0,"none");
        C1.Alarms.add(testAlarm);
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_soundalarm: ");
        System.out.println("Expected: -1 Actual: " + C1.currentAlarm);
        System.out.println("Expected: true Actual: " + C1.Alarmsound);
        assertEquals(-1,C1.currentAlarm);
        assertTrue(C1.Alarmsound);
        
    }
    
    @Test
    public void testcheckAlarm_disableaftersoundifnotrepeat(){
        ArrayList<String>daysofalarm = new ArrayList();
        daysofalarm.add(getcurrentday());
        Alarm testAlarm = new Alarm("test",daysofalarm,getcurrenttime(),false,0,"none");
        C1.Alarms.add(testAlarm);
        assertEquals(true,testAlarm.getEnabled());
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_soundalarm: ");
        System.out.println("Expected: true Actual: " + C1.Alarmsound);
        System.out.println("Expected: fasle Actual: " + testAlarm.getEnabled());
        assertTrue(C1.Alarmsound);
        assertEquals(false,testAlarm.getEnabled());
    }
    
    @Test
    public void testcheckAlarm_ifrepeatalarmnotchange(){
        ArrayList<String>daysofalarm = new ArrayList();
        daysofalarm.add(getcurrentday());
        Alarm testAlarm = new Alarm("test",daysofalarm,getcurrenttime(),true,0,"none");
        C1.Alarms.add(testAlarm);
        assertEquals(true,testAlarm.getEnabled());
        C1.checkAlarm(getcurrenttime(), getcurrentday());
        System.out.println("testcheckAlarm_soundalarm: ");
        System.out.println("Expected: true Actual: " + C1.Alarmsound);
        System.out.println("Expected: true Actual: " + testAlarm.getEnabled());
        assertTrue(C1.Alarmsound);
        assertEquals(true,testAlarm.getEnabled());
        assertEquals(0,C1.currentAlarm);
    }
}
