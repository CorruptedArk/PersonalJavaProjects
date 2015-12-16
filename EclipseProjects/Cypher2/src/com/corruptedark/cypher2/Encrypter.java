package com.corruptedark.cypher2;

import java.util.Random;


public class Encrypter {

	public String[] encrypt(String[] message, String key){
		
		Random random = new Random();
		
		String[] saltedMessage = new String[message.length + 1];
		saltedMessage[0] = String.valueOf(random.nextInt(100000));
		for(int i=0; i<message.length; i++){
			saltedMessage[i+1] = message[i];
		}
		
		byte[][] saltyBytes = convertToByteMatrix(saltedMessage);
		
		
		
		
		String[] cipherText = new String[saltedMessage.length + 1];
		cipherText[0] = "ENCRYPTED";
		return cipherText;
	}
	
	public byte[][] convertToByteMatrix(String[] strings){
		
		byte[][] matrix = new byte[strings.length][];
		for(int i=0; i<strings.length; i++){
			matrix[i] = strings[i].getBytes();
		}
		
		return matrix;
	}
	
	public String[] convertToStringArray(byte[][] matrix){
		String[] strings = new String[matrix.length];
		for(int i=0; i<matrix.length; i++){
			strings[i] = new String(matrix[i]);
		}
		
		return strings;
	}
	
}
