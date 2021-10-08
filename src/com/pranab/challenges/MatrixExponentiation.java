package com.pranab.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixExponentiation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimension");
		int dim = sc.nextInt();
		sc.nextLine();
		int[][] inputArray = new int[dim][dim];
		System.out.println("Enter the elements");
		for (int rowIndex = 0; rowIndex < dim; rowIndex++) {
			String[] inputElements = sc.nextLine().split(" ");
			for (int columnIndex = 0; columnIndex < dim; columnIndex++) {
				inputArray[rowIndex][columnIndex] = Integer.parseInt(inputElements[columnIndex]);
			}
		}
		System.out.println("Enter the power");
		int power = sc.nextInt();
		matrixPower(dim, inputArray, power);

	}

	private static void matrixPower(int dim, int[][] inputArray, int power) {
		int[][] identityArray = new int[dim][dim];
		for (int rowIndex = 0; rowIndex < dim; rowIndex++) {
			for (int columnIndex = 0; columnIndex < dim; columnIndex++) {
				if (rowIndex == columnIndex) {
					identityArray[rowIndex][columnIndex] = 1;
				}
			}
		}
		/*for (int powerMul = 1; powerMul <= power; powerMul++) {
			identityArray=multiply(identityArray, inputArray, dim);
		}*/
		while(power!=0) {
			if(power%2==1) {
				power--;
				identityArray=multiply(identityArray, inputArray, dim);
			}else {
				inputArray=multiply(inputArray, inputArray, dim);
				power/=2;
			}
		}
		print(identityArray,dim);
		System.out.println("done");
	}

	private static void print(int[][] identityArray,int dim) {
		for (int rowIndex = 0; rowIndex < dim; rowIndex++) {
			for (int columnIndex = 0; columnIndex < dim; columnIndex++) {
					System.out.print(identityArray[rowIndex][columnIndex]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] multiply(int[][] identityArray, int[][] inputArray, int dim) {
		int[][] resultArray = new int[dim][dim];
		for (int rowIndex = 0; rowIndex < dim; rowIndex++) {
			for (int columnIndex = 0; columnIndex < dim; columnIndex++) {
				resultArray[rowIndex][columnIndex] = 0;
				for (int iterator = 0; iterator < dim; iterator++) {
					resultArray[rowIndex][columnIndex] += identityArray[iterator][columnIndex]
							* inputArray[rowIndex][iterator];
				}
			}
		}
		identityArray=resultArray.clone();
		return identityArray;
	}

	
}
