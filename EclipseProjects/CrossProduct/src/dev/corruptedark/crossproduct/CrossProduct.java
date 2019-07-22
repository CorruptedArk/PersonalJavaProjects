package dev.corruptedark.crossproduct;

import java.util.Scanner;

public class CrossProduct {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char again;
		do{ 	// The main loop, everything is called from here. 
			double[] u = new double[3], v = new double[3],w;
			print("Enter a vector in R" + "\u00b3"+": "); 
			for(int i = 0; i < 3; i++)
				u[i] = scan.nextDouble();
			print("Enter a second vector in R" + "\u00b3"+": ");
			for(int i = 0; i < 3; i++)
				v[i] = scan.nextDouble();
			w = crossProduct(u,v);
			print("The cross product is: ");
			print(w);
			print("\nContinue?(Y/N): ");
			again = scan.next().charAt(0);
		}while(again == 'y' || again == 'Y');
		return;
	}
	
	/**
	 * Calculates a cross product of two vectors.
	 * @param u The first vector
	 * @param v The second vector
	 * @return The cross product vector
	 */
	static double[] crossProduct(double[] u, double[] v){
		double[] w = new double[3];
		double[][] crossMatrix = {{1,-1,1},u,v};
		
		for(int i = 0; i < 3; i++)
			w[i] = crossMatrix[0][i]*det(minor(crossMatrix,0,i));
		
		
		return w;
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
	 * Calculates the transpose of a matrix.
	 * @param A The input matrix
	 * @return The transpose of matrix A
	 */
	static double[][] transpose(double[][] A){
		double[][] B = new double[A[0].length][A.length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				B[j][i] = A[i][j];
			}
		}
		return B;
	}
	
	/**
	 * Recursively calculates the determinant of a matrix.
	 * @param A The input matrix
	 * @return The determinant of matrix A
	 */
	static double det(double[][] A){
		double det = 0;
		if(A.length == 1){
			det = A[0][0];
		}else{
			for(int i = 0; i < A.length; i++){
				det += Math.pow(-1,i)*det(minor(A,i,0))*A[i][0];
			}
		}
		return det;
	}
	
	/**
	 * Calculates the minor of a matrix for given indices
	 * @param A The matrix
	 * @param i The first index
	 * @param j The second index
	 * @return The minor matrix
	 */
	static double[][] minor(double[][] A, int i, int j){
		double[][] minor = new double[A.length-1][A.length-1];
		int n = 0, m = 0; 
		for(int k = 0; k < A.length; k++){
			if(k == i)
				continue;
			for(int l = 0; l < A.length; l++){
				if(l == j)
					continue;
				minor[n][m] = A[k][l];
				m++;
			}
			n++;
			m = 0;
		}
		return minor;
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

