package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlmostSorted {

	// Complete the almostSorted function below.
	static void almostSorted(int[] arr) {
		String checkSorted = checkSorted(arr);
		String swapIndex = "";
		if (checkSorted.equals("no")) {
			swapIndex = checkSwap(arr);
			System.out.println(swapIndex);
			if (!swapIndex.equals("noswap")) {
				swap(arr, swapIndex);
			}
		}

		String checkSortedafterSwap = checkSorted(arr);
		if (checkSortedafterSwap.equals("yes")) {
			System.out.println("yes");
			String[] swapNum = swapIndex.split(":");
			System.out.println(
					"swap " + (Integer.parseInt(swapNum[0]) + 1) + " " + (Integer.parseInt(swapNum[1]) + 1) + "");
		} else {
			swap(arr, swapIndex);
			String reverseIndex = checkReverse(arr);
			// System.out.println(reverseIndex);
			if (!reverseIndex.equals("noreverse")) {
				reverse(arr, reverseIndex);
			}
			String checkSortedafterReverse = checkSorted(arr);
			if (checkSortedafterReverse.equals("yes")) {
				System.out.println("yes");
				String[] reverseNum = reverseIndex.split(":");
				if (!(Integer.parseInt(reverseNum[0]) + 1 == Integer.parseInt(reverseNum[1]))) {
					System.out.println("reverse " + (Integer.parseInt(reverseNum[0]) + 1) + " "
							+ (Integer.parseInt(reverseNum[1]) + 1) + "");
				} else {
					System.out.println("swap " + (Integer.parseInt(reverseNum[0]) + 1) + " "
							+ (Integer.parseInt(reverseNum[1]) + 1) + "");
				}
			} else {
				System.out.println("no");
			}
		}

	}

	public static String checkSorted(int[] arr) {
		int previousElem = -1;
		for (int i = 0; i < arr.length; i++) {
			if (previousElem > arr[i]) {
				return "no";
			}
			previousElem = arr[i];
		}
		return "yes";
	}

	public static String checkReverse(int[] arr) {
		int previousElem = -1;
		int startIndex = -1, lastIndex = -1;
		outerloop: for (int i = 0; i < arr.length; i++) {
			if (previousElem > arr[i]) {
				startIndex = i - 1;
				for (; i < arr.length; i++) {
					if (previousElem < arr[i]) {
						lastIndex = i - 1;
						break outerloop;
					}
					previousElem = arr[i];
				}
				lastIndex = i - 1;
				break outerloop;
			}
			previousElem = arr[i];
		}
		if (startIndex != -1) {
			return startIndex + ":" + lastIndex;
		} else {
			return "noreverse";
		}
	}

	public static void swap(int[] arr, String swapIndex) {
		String[] num = swapIndex.split(":");
		int startParseIndex = Integer.parseInt(num[0]);
		int endParseIndex = Integer.parseInt(num[1]);
		int temp = arr[startParseIndex];
		arr[startParseIndex] = arr[endParseIndex];
		arr[endParseIndex] = temp;
	}

	public static void reverse(int[] arr, String reverseIndex) {
		String[] num = reverseIndex.split(":");
		int startParseIndex = Integer.parseInt(num[0]);
		int endParseIndex = Integer.parseInt(num[1]);
		for (int i = startParseIndex, j = endParseIndex; i <= j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public static String checkSwap(int[] arr) {
		int previousElem = -1;
		int startIndex = -1, lastIndex = -1;
		boolean checked = false;
		for (int i = 0; i < arr.length; i++) {
			if (previousElem > arr[i]) {
				if (startIndex == -1) {
					startIndex = i - 1;
				}
				if (lastIndex == -1 && checked) {
					lastIndex = i;
				}
				checked = true;
			}
			previousElem = arr[i];
		}
		if (startIndex != -1) {
			if (lastIndex == -1) {
				lastIndex = arr.length - 1;
			}
			return startIndex + ":" + lastIndex;
		} else {
			return "noswap";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		almostSorted(arr);

		scanner.close();
	}
}
