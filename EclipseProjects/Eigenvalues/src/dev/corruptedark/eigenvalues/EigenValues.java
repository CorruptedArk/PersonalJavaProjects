package dev.corruptedark.eigenvalues;

import java.util.Scanner;

public class EigenValues {

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
			
			print("\nContinue?(Y/N): ");
			again = scan.next().charAt(0);
		}while(again == 'y' || again == 'Y');
		return;
	}
	
	static double[] eigenValues(double[][] A){
		double[] values = new double[A.length];
		
		String[][] stringA = new String[A.length][A.length];
		for(int i = 0; i < A.length; i++)
			for(int j = 0; j < A.length; j++){
				
				if(i == j)
					stringA[i][j] = String.valueOf(A[i][j]) + " - x";
				else
					stringA[i][j] = String.valueOf(A[i][j]);
					
			}
		
		return values;
			
	}
	
	static double[][] add(double[][] matrix1, double[][] matrix2){
		double[][] sum = new double[matrix1.length][matrix1[0].length];
		for(int i = 0; i < sum.length; i++)
			for(int j = 0; j < sum[0].length; j++)
				sum[i][j] = matrix1[i][j] + matrix2[i][j];
		
		return sum;
	}
	
	static double[][] subtract(double[][] matrix1, double[][] matrix2){
		double[][] diff = new double[matrix1.length][matrix1[0].length];
		for(int i = 0; i < diff.length; i++)
			for(int j = 0; j < diff[0].length; j++)
				diff[i][j] = matrix1[i][j] - matrix2[i][j];
		
		return diff;
	}
	
	static double[][] inverse(double[][] A){
		double[][] B;
		double detA = det(A);
		if(A.length == 1){
			B = new double[1][1];
			B[0][0] = 1/detA;
		}else{
			B = new double[A.length][A.length];
			B = transpose(cofactor(A));
			for(int i = 0; i < B.length; i++){
				for(int j = 0; j < B.length; j++){
					B[i][j] = B[i][j]/detA;
				}
			}
		}
		
		
		return B;
	}
	
	static double[][] cofactor(double[][] A){
		double[][] B = new double[A.length][A.length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A.length; j++){
				B[i][j] = Math.pow(-1,i+j)*det(minor(A,i,j));
			}
		}
		return B;
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
