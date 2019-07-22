package dev.corruptedark.matrixtrace;

import java.util.Scanner;

public class MatrixTrace {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char again;
		int n;
		do{
			print("Enter the dimension of the matrix: ");
			n = scan.nextInt();
			double[][] matrix = new double[n][n];
			print("\nEnter the matrix data:\n");
			input(matrix);
			print("The trace of the matrix is: " + trace(matrix));
			print("\nContinue?(Y/N): ");
			again = scan.next().charAt(0);
		}while(again == 'y' || again == 'Y');
		return;
	}
	
	/**
	 * Computes the trace of a matrix.
	 * @param matrix The matrix
	 * @return The trace
	 */
	static double trace(double[][] matrix){
		double trace = 0;
		for(int i = 0; i < matrix.length; i++)
			trace += matrix[i][i];
		return trace;
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
