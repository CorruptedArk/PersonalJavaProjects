/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puncheditor;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Noah
 */
public class WriteByteFile {
    
    private String path;
    
    
    public WriteByteFile(String file_path){
        path = file_path;
    }
   
    
    public void writeToFile(ArrayList<Punch> punches) throws IOException {
        String[] punchStrings = new String[punches.size()];
        for(int i=0; i < punches.size(); i++){
            Punch punch = punches.get(i);
            punchStrings[i] = punch.direction + " " + 
                              String.valueOf(punch.time) + " " +
                              String.valueOf(punch.remaining) + " " +
                              punch.lateString + ";";
        }
        String doc = "";
        for(String line : punchStrings){
            doc = doc + line;
        }
        byte[] bytes = doc.getBytes("ISO-8859-1");
        FileOutputStream fos = new FileOutputStream(path,false);
        try{
            fos.write(bytes);
        }finally{
            fos.close();
        }
    }
}
