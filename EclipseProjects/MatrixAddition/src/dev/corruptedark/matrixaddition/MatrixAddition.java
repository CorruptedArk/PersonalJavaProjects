package dev.corruptedark.matrixaddition;

import java.util.Scanner;

public class MatrixAddition {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char again;
		int n,m;
		
		do{
			print("Enter the dimensions of the matrices: ");
			n = scan.nextInt();
			m = scan.nextInt();
			
			
			double[][] matrix1 = new double[n][m];
			double[][] matrix2 = new double[n][m];
			
			print("Enter the data for the first matrix: \n");
			input(matrix1);
			print("\nEnter data for the second matrix: \n");
			input(matrix2);
			
			print("The sum matrix is: \n");
			print(add(matrix1,matrix2));
			print("\n");
				
			print("Would you like to continue?(Y/N): ");
			again = scan.next().charAt(0);
		}while(again == 'y' || again == 'Y');
		return;
	}
	
	/**
	 * Adds two matrices.
	 * @param matrix1 The first matrix
	 * @param matrix2 The second matrix
	 * @return The matrix sum
	 */
	static double[][] add(double[][] matrix1, double[][] matrix2){
		double[][] sum = new double[matrix1.length][matrix1[0].length];
		for(int i = 0; i < sum.length; i++)
			for(int j = 0; j < sum[0].length; j++)
				sum[i][j] = matrix1[i][j] + matrix2[i][j];
		
		return sum;
	}
	
	/**
	 * Subtracts two matrices
	 * @param matrix1 The first matrix
	 * @param matrix2 The second matrix
	 * @return The matrix difference
	 */
	static double[][] subtract(double[][] matrix1, double[][] matrix2){
		double[][] diff = new double[matrix1.length][matrix1[0].length];
		for(int i = 0; i < diff.length; i++)
			for(int j = 0; j < diff[0].length; j++)
				diff[i][j] = matrix1[i][j] - matrix2[i][j];
		
		return diff;
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
	
	/**
	 * Prints out a vector to the console
	 * @param vector The vector to print
	 */
	static void print(double[] vector){
		print("[");
		for(int i = 0; i < vector.length; i++){
			print(vector[i]);
			if(i != vector.length - 1)
				print(",");
		}
		print("]\n");
	}

}
