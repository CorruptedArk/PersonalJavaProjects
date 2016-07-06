package com.corruptedark.polyderivative;

import java.util.Scanner;

public class PolyDerivative {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int degree;
		double[][] polyVector,derivative, matrix;
		String polyString;
		
		print("Enter the degree of the polynomial: ");
		degree = scan.nextInt();
		polyVector = new double[degree + 1][1];
		matrix = derivativeMatrix(degree);
		print("Enter the polynomial in standard form without spaces with the terms separated by \"+\": \n");
		// Example 2x^2+3x+3
		polyString = scan.next();
		String[] terms = polyString.split("\\+");
		for(int i = 0; i < terms.length; i++){
			if(terms[i].contains("x^")){
				if(terms[i].split("x\\^")[0].isEmpty()){
					polyVector[Integer.parseInt(terms[i].replace("x^", ""))][0] = 1;
				}else{
					polyVector[Integer.parseInt(terms[i].split("x\\^")[1])][0] = Double.parseDouble(terms[i].split("x\\^")[0]);
				}
			}else if(terms[i].contains("x")){
				if(terms[i].replace("x","").isEmpty()){
					polyVector[1][0] = 1;
				}else{
					polyVector[1][0] = Double.parseDouble(terms[i].replace("x",""));
				}
			}else{
				polyVector[0][0] = Double.parseDouble(terms[i]);
			}
		}
		derivative = multiply(matrix,polyVector);
		
		print("The derivative is ");
		
		for(int i = derivative.length-1; i >= 0; i--){
			if(derivative[i][0] == 0){
				
			}else if(i == 0){
				if(i != derivative.length-2)
					print(" + ");
				print(derivative[i][0]);
			}else if(i == 1){
				if(i != derivative.length-2)
					print(" + ");
				print(derivative[i][0] + "x");
			}else{
				if(i != derivative.length-2)
					print(" + ");
				print(derivative[i][0] + "x^" + i);
			}
		}
		
		

	}
	
	/**
	 * Generates the derivative matrix of a desired dimension
	 * @param degree The dimension of the matrix
	 * @return The derivative matrix
	 */
	static double[][] derivativeMatrix(int degree){
		double[][] matrix = new double[degree + 1][degree + 1];
		for(int i = 0; i < matrix.length; i++){
			for(int j =0; j < matrix.length; j++){
				if(i == j-1){
					matrix[i][j] = i + 1;
				}else{
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
	
	/**
	 * Multiplies two matrices in the standard basis.
	 * @param A The first matrix
	 * @param B The second matrix
	 * @return The product matrix
	 */
	static double[][] multiply(double[][] A, double[][] B){
		double[][] AB = new double[A.length][B[0].length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B[i].length; j++){
				for(int k = 0; k < B.length ; k++){
					AB[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return AB;
	}
	
	/**
	 * Fills a matrix from user input.
	 * @param matrix The matrix to be filled
	 */
	static void input(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			
			for(int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = scan.nextDouble();
			}
			
		}
	}
	
	/**
	 * Prints a string. Shorthand for System.out.print()
	 * @param output The String to print
	 */
	static void print(String output){
		System.out.print(output);
	}
	
	/**
	 * Prints an integer. Shorthand for System.out.print()
	 * @param output The integer to print
	 */
	static void print(int output){
		System.out.print(output);
	}
	
	/**
	 * Prints a double. Shorthand for System.out.print()
	 * @param output The double to print
	 */
	static void print(double output){
		System.out.print(output);
	}
	
	/**
	 * Prints out the matrix to the console.
	 * @param matrix The matrix to print
	 */
	static void print(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			print("[");
			for(int j = 0; j < matrix[i].length; j++){
				print(matrix[i][j] + " ");
			}
			print("]\n");
		}
	}

}
