package com.pranab.challenges;

import java.util.Scanner;

public class FibonacciUsingMatExponentiation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Kth sequence to find : ");
		int kthSequence = sc.nextInt();
		int power = kthSequence - 2;
		int[][] transitionMat = { { 0, 1 }, { 1, 1 } };
		int[][] transitionMatTimesAfterPow = matrixPower(2, transitionMat, power);
		int[][] initialMat = { { 1, 1 } };
		int[][] result = multiplyMatrix(initialMat, transitionMatTimesAfterPow, initialMat.length, initialMat[0].length,
				transitionMatTimesAfterPow.length, transitionMatTimesAfterPow[0].length);
		System.out.println(result[0][1]); 
		sc.close();
	}

	private static int[][] matrixPower(int dim, int[][] inputArray, int power) {
		int[][] identityArray = new int[dim][dim];
		for (int rowIndex = 0; rowIndex < dim; rowIndex++) {
			for (int columnIndex = 0; columnIndex < dim; columnIndex++) {
				if (rowIndex == columnIndex) {
					identityArray[rowIndex][columnIndex] = 1;
				}
			}
		}
		while (power != 0) {
			if (power % 2 == 1) {
				power--;
				identityArray = multiplySquareMatrix(identityArray, inputArray, dim);
			} else {
				inputArray = multiplySquareMatrix(inputArray, inputArray, dim);
				power /= 2;
			}
		}
		return identityArray;
	}

	private static int[][] multiplySquareMatrix(int[][] identityArray, int[][] inputArray, int dim) {
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
		identityArray = resultArray.clone();
		return identityArray;
	}

	private static int[][] multiplyMatrix(int[][] firstMat, int[][] secondMat, int firstRow, int firstColumn,
			int secondRow, int secondColumn) {
		int[][] resultArray = new int[firstRow][secondColumn];
		if (firstColumn == secondRow) {
			for (int rowIndex = 0; rowIndex < firstRow; rowIndex++) {
				for (int columnIndex = 0; columnIndex < firstColumn; columnIndex++) {
					resultArray[rowIndex][columnIndex] = 0;
					for (int iterator = 0; iterator < firstColumn; iterator++) {
						resultArray[rowIndex][columnIndex] += secondMat[iterator][columnIndex]
								* firstMat[rowIndex][iterator];
					}
				}
			}
		}
		return resultArray;
	}
}
