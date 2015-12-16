package com.corruptedark.cypher2;

import java.io.IOException;
import java.util.Scanner;


public class Cypher2 {
	static Scanner input = new Scanner(System.in);
	static String filePath, key;
	static ReadFile reader, scouter;
	static WriteFile writer;
	static String[] startText, endText;
	static Decrypter decrypter = new Decrypter();
	static Encrypter encrypter = new Encrypter();
	
	
	public static void main(String[] args) {
		while(true){
			System.out.println("Enter the file path of a file you want to encrypt or decrypt: ");
			filePath = input.nextLine();
			System.out.println("Now, enter the key for encrypting or decrypting the file.");
			key = input.nextLine();
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
			if(startText[0].equalsIgnoreCase("UNENCRYPTED")){
				System.out.println("Keep track of the key you used, you'll need it to decrypt this message.");
			}
			System.out.println();
		}
	}

	public static void decrypt(){
		
	}
	
	public static void encrypt(){
		String[] message = new String[startText.length - 1];
		for(int i = 0; i < message.length; i++){
			message[i] = startText[i+1];
		}
		endText = encrypter.encrypt(message, key);
	}
	
}
