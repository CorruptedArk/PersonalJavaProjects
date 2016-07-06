package com.corruptedark.matrixtranspose;

import java.util.Scanner;

public class MatrixTranspose {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char again;
		int n, m;
		do{
			print("Enter the dimensions of the matrix: ");
			n = scan.nextInt();
			m = scan.nextInt();
			double[][] matrix = new double[n][m];
			print("\nEnter the data for the matrix: \n");
			input(matrix);
			print("\nThe transpose is:\n");
			print(transpose(matrix));
			print("Would you like to continue?(Y/N): ");
			again = scan.next().charAt(0);
		}while(again == 'y' || again == 'Y');
		return;
	}

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
	
	static double[][] transpose(double[][] A){
		double[][] B = new double[A[0].length][A.length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				B[j][i] = A[i][j];
			}
		}
		return B;
	}
	
	static void input(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			
			for(int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = scan.nextDouble();
			}
			
		}
	}
	
	static void print(String outPut){
		System.out.print(outPut);
	}
	
	static void print(int outPut){
		System.out.print(outPut);
	}
	
	static void print(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			print("[");
			for(int j = 0; j < matrix[i].length; j++){
				print(matrix[i][j] + " ");
			}
			print("]");
			print("\n");
		}
	}
}
