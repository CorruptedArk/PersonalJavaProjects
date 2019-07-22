/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchformatter;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Noah
 */
public class ReadByteFile {
    
    private String path;
    
    public ReadByteFile(String file_path){
        path = file_path;
    } 
    
    public ArrayList<Punch> openFile() throws IOException {
        Path filePath = Paths.get(path);
        byte[] bytes = Files.readAllBytes(filePath);
        String doc = new String(bytes,"ISO-8859-1");
        String[] docArray = doc.split(";");
        ArrayList<Punch> punches = new ArrayList<Punch>();
        for(String line : docArray){
            String[] parts = line.split(" ");
            punches.add(new Punch(parts[0],Long.parseLong(parts[1]),Long.parseLong(parts[2]),parts[3].equalsIgnoreCase("late")));
        }
        
        return punches;
    }
   
}
