/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchformatter;


import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
        DateFormat formatter = DateFormat.getDateTimeInstance();
        Calendar cal = Calendar.getInstance();
        for(int i=0; i < punches.size(); i++){
            Punch punch = punches.get(i);
            cal.setTimeInMillis(punch.time);
            punchStrings[i] = punch.direction + " " + 
                              formatter.format(cal.getTime()) + " " +
                              punch.formattedRemaining + " " +
                              punch.lateString + ";\n";
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
