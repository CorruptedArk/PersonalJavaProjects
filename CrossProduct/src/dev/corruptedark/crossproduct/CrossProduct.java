package dev.corruptedark.crossproduct;

import java.util.Scanner;

public class CrossProduct {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char again;
		do{
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
	
	static double[] crossProduct(double[] u, double[] v){
		double[] w = new double[3];
		double[][] crossMatrix = {{1,-1,1},u,v};
		
		for(int i = 0; i < 3; i++)
			w[i] = crossMatrix[0][i]*det(minor(crossMatrix,0,i));
		
		
		return w;
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
	
	
	static void print(String output){
		System.out.print(output);
	}
	
	static void print(int output){
		System.out.print(output);
	}
	
	static void print(double output){
		System.out.print(output);
	}
	
	static void print(double[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			print("[");
			for(int j = 0; j < matrix[i].length; j++){
				print(matrix[i][j] + " ");
			}
			print("]\n");
		}
	}
	
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

