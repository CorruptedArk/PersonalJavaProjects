/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puncheditor;

/**
 *
 * @author Noah
 */
public class Punch {
    
    String direction;
    long time;
    long remaining;
    String formattedRemaining;
    String lateString;
    boolean late;
    
    public Punch(String direction, long time, long remaining, boolean late){
        this.direction = direction;
        this.time = time;
        this.remaining = remaining;
        format();
        this.late = late;
        if(late){
            lateString = "late";
        }else{
            lateString = "okay";
        }
    }
   
   private void format(){
       TimeMath timeMath = new TimeMath();
       if(remaining < 0){
            timeMath.set(TimeMath.SECOND, (int) (-remaining/1000));      
            formattedRemaining = "-" + String.format("%02d",timeMath.get(TimeMath.HOUR)) + 
               ":" + String.format("%02d",timeMath.get(TimeMath.MINUTE))+ ":" + 
               String.format("%02d",timeMath.get(TimeMath.SECOND));
       }else{
            timeMath.set(TimeMath.SECOND, (int) (remaining/1000));      
            formattedRemaining = String.format("%02d",timeMath.get(TimeMath.HOUR)) + 
               ":" + String.format("%02d",timeMath.get(TimeMath.MINUTE))+ ":" + 
               String.format("%02d",timeMath.get(TimeMath.SECOND)); 
       }
       
    }
}
