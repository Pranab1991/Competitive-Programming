package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ThreeDSurfaceArea {

	// Complete the timeInWords function below.
	static int surfaceArea(int[][] A) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				// System.out.println(A[i][j]);
				int unit_tsa = 0;
				if (A[i][j] > 1) {
					unit_tsa = (A[i][j] * 6 - 2*(A[i][j] - 1));
				} else {
					unit_tsa = A[i][j] * 6;
				}
				if (!((i - 1) < 0)) {
					if (A[i][j] > A[i - 1][j]) {
						unit_tsa -= A[i - 1][j];
					} else {
						unit_tsa -= A[i][j];
					}
				}
				if (((i + 1) < A.length)) {
					if (A[i][j] > A[i + 1][j]) {
						unit_tsa -= A[i + 1][j];
					} else {
						unit_tsa -= A[i][j];
					}
				}
				if (!((j - 1) < 0)) {
					if (A[i][j] > A[i][j - 1]) {
						unit_tsa -= A[i][j-1];
					} else {
						unit_tsa -= A[i][j];
					}
				}
				if (((j + 1) < A[i].length)) {
					if (A[i][j] > A[i][j + 1]) {
						unit_tsa -= A[i][j + 1];
					} else {
						unit_tsa -= A[i][j];
					}
				}
				result += unit_tsa;
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println(surfaceArea(new int[][] { { 1, 3, 4 }, { 2, 2, 3 }, { 1, 2, 4 } }));
	}
}
