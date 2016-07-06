package com.corruptedark.matrixmultiplication;

import java.util.Scanner;

public class MatrixMultiplication {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int m1,n1,m2,n2;
		char again;
		
		do{
			print("Enter the dimensions of the first matrix: ");
			n1 = scan.nextInt();
			m1 = scan.nextInt();
			print("Enter the dimensions of the second matrix: ");
			n2 = scan.nextInt();
			m2 = scan.nextInt();
			
			if(m1 == n2){
				double[][] matrix1 = new double[n1][m1];
				double[][] matrix2 = new double[n2][m2];
				double[][] matrix3 = new double[n1][m2];
				
				print("Enter the data for the first matrix: \n");
				input(matrix1);
				print("\nEnter data for the second matrix: \n");
				input(matrix2);
				
				matrix3 = multiply(matrix1,matrix2);
				
				print("The product matrix is: \n");
				print(matrix3);
				print("\n");
				
			}
			else{
				print("The dimensions are invalid.\n");
			}
			
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
