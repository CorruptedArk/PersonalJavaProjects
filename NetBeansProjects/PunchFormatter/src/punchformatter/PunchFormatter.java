/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchformatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Noah
 */
public class PunchFormatter {

    static ArrayList<Punch> punches;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ReadByteFile reader = new ReadByteFile("punches.png");
       try {
           punches = reader.openFile();
       } catch (IOException ex) {
           Logger.getLogger(PunchFormatter.class.getName()).log(Level.SEVERE, null, ex);
       }
       WriteByteFile writer = new WriteByteFile("punches.txt");
        try {
            writer.writeToFile(punches);
        } catch (IOException ex) {
            Logger.getLogger(PunchFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
