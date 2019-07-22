package com.corruptedark.cypher2;

public class Decrypter {

	
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
