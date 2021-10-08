package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LarryArray {

	// Complete the larrysArray function below.
	static String larrysArray(int[] A) {
		elementProcess(A);
		//System.out.println(checkSorted(A));
		return checkSorted(A);
	}

	static void elementProcess(int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				int distanceForIndex = findistance(A, i + 1);
				//System.out.println(distanceForIndex);
				int startIndex = -1, endIndex = -1;
				while(distanceForIndex>2) {
					endIndex=i+distanceForIndex;
					startIndex=endIndex-2;
					rotateIterator(A, 2, startIndex, endIndex);
					distanceForIndex-=2;
				}
				if (distanceForIndex == 2) {
					startIndex = i;
					endIndex = startIndex + 2;
					rotateIterator(A, distanceForIndex, startIndex, endIndex);
				}
				if (distanceForIndex == 1) {
					startIndex = i;
					endIndex = startIndex + 2;
					if(endIndex>=A.length) {
						break;
					}
					rotateIterator(A, distanceForIndex, startIndex, endIndex);
				}
				
			}
		}
	}

	private static void rotateIterator(int[] A, int distanceForIndex, int startIndex, int endIndex) {
		for (int j = 0; j < distanceForIndex; j++) {
			rotateLeft(A, startIndex, endIndex);
		}
	}

	private static int findistance(int[] A, int j) {
		for (int i = j; i < A.length; i++) {
			if (A[i] == j) {
				return i - j + 1;
			}
		}
		return 0;
	}

	static void rotateLeft(int[] A, int start, int end) {
		int temp = A[end];
		A[end] = A[start];
		A[start] = A[end - 1];
		A[end - 1] = temp;
	}

	public static String checkSorted(int[] arr) {
		int previousElem = -1;
		for (int i = 0; i < arr.length; i++) {
			if (previousElem > arr[i]) {
				return "NO";
			}
			previousElem = arr[i];
		}
		return "YES";
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("outputLarry.txt")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] A = new int[n];

			String[] AItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int AItem = Integer.parseInt(AItems[i]);
				A[i] = AItem;
			}

			String result = larrysArray(A);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
