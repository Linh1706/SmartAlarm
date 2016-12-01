/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;


public class StudentClass {
    
    private String name;
    private String location;
    private int day;
    private String start;
    private String end;
    
    StudentClass(String Name, String Location, int Day, String Start, String End){
        this.name = Name;
        this.location = Location;
        this.day = Day;
        this.start = Start;
        this.end = End;
    }
    
    public String getname(){
        return name;
    }
    public String getstarttime(){
        return start;
    }
    public String getendtime(){
        return end;
    }
    public int getday(){
        return day;
    }
    public String getlocation(){
        return location;
    }
}
