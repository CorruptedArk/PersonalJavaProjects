package com.corruptedark.cypher;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Cypher {
	static Scanner input = new Scanner(System.in);
	static String filePath;
	static ReadFile reader, scouter;
	static WriteFile writer;
	static String[] startText, endText;
	static Decrypter decrypter = new Decrypter();
	static Encrypter encrypter = new Encrypter();
	static Random random = new Random();

	public static void main(String[] args) {
		while(true){
			System.out.println("Enter the file path of a file you want to encrypt or decrypt: ");
			filePath = input.nextLine();
			System.out.println("Processing...");
			
			reader = new ReadFile(filePath);
			
			int k = 1; 
			boolean fileExists = true;
			String newPath = "";
			 
			while(fileExists){
				
				String[] name = filePath.split("\\.");
				
				newPath = name[0] + "-" + k + ".txt";
				
				scouter = new ReadFile(newPath);
				try{
					scouter.openFile();
					fileExists = true;
					k++;
				}catch(Exception e){
					fileExists = false;
				}
				
			}
			
			writer = new WriteFile(newPath);
			
			try {
				startText = reader.openFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(startText[0].equalsIgnoreCase("ENCRYPTED")){
				decrypt();
			}else if(startText[0].equalsIgnoreCase("UNENCRYPTED")){
				encrypt();
			}
			
			System.out.println("The new file was named: " + newPath);
			System.out.println("The new file says the following:");
			System.out.println();
			for(int i=0; i<endText.length; i++){
				try {
					writer.writeToFile(endText[i]);
					System.out.println(endText[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println();
			System.out.println("Finished processing.");
			System.out.println();
		}
	}
	
	static void decrypt(){
		
		endText = new String[startText.length];
		
		endText[0] = "UNENCRYPTED";
		
		for(int i=1; i < startText.length; i++){
			
			String[] temp = startText[i].split(" ");
			
			for(int j=0; j < temp.length; j++){
				try{
					temp[j] = decrypter.decryptNumber(Integer.parseInt(temp[j]));
				}catch(NumberFormatException e){
					if(!decrypter.decryptLetter(temp[j]).contentEquals("?")){
						temp[j] = decrypter.decryptLetter(temp[j]);
					}else{
					    temp[j] = decrypter.decryptOther(temp[j]);	
					}
				}
			}
			
			String line = "";
			for(int k=0; k < temp.length; k++){
				line = line + temp[k];
			}
			endText[i] = line;
		}
		
	}
	
	static void encrypt(){
		endText = new String[startText.length];
		
		endText[0] = "ENCRYPTED";
		
		for(int i=1; i < startText.length; i++){
			
			String[] temp = startText[i].split("");
			
			for(int j=0; j < temp.length; j++){
				try{
					Integer.parseInt(temp[j]);
					temp[j] = encrypter.encryptNumber(temp[j]) + " ";
				}catch(NumberFormatException e){
					if(!encrypter.encryptLetter(temp[j]).contentEquals("?")){
						temp[j] = encrypter.encryptLetter(temp[j]) + " ";
					}else{
					    temp[j] = encrypter.encryptOther(temp[j]) + " ";	
					}
				}
			}
			
			String line = "";
			for(int k=0; k < temp.length; k++){
				line = line + temp[k];
			}
			endText[i] = line;
			
		}
	}

}
