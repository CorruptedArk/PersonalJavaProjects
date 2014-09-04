/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numberordering;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Noah
 */
public class NumberOrdering {
    
    static Scanner scan = new Scanner(System.in);
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList list;
        int length;
        double sum;
        double mean;
        boolean running = true;
        
        while(running){
            list = ordering();
            length = list.size();
            sum = 0;
            for(int j=0; j < length; j++){
                sum = sum + (double)list.get(j);
            }
            mean = sum/length;
            System.out.print(length + " terms"
            + "\nThe sum is " + sum
            + "\nThe mean is " + mean);
            System.out.println();
            for(int i = 0; i < length; i++){
                System.out.println(list.get(i));
            }
            System.out.println("If you would like to enter another list of numbers, "
                    + "Press c");
            String nextIn = scan.next();
            running = nextIn.equalsIgnoreCase("c");
        }
    }
    
    public static ArrayList ordering(){
        ArrayList list = new ArrayList();
        
        boolean running = true;   
        double  num;
        
                
        while(running){
            System.out.println("Type a number to add it to the list:" +
                    "\nType anything else to display the ordered list:");
            
            if(scan.hasNextDouble()){
                num = scan.nextDouble();
                scan.nextLine();
                addDouble(list, num);
            }
            else{
                running = false;
                scan.nextLine();
            }
        }
        
        Collections.sort(list);
        
        return list; 
    }
    
            
    public static void addDouble(ArrayList list ,double nextNum){
        list.add(nextNum);
    }
}
