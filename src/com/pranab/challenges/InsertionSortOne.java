package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result22 {

	/*
	 * Complete the 'insertionSort1' function below.
	 *
	 * The function accepts following parameters: 1. INTEGER n 2. INTEGER_ARRAY arr
	 */

	public static void insertionSort2(int n, List<Integer> arr) {
		for (int j = 1; j < arr.size(); j++) {
			int key = arr.get(j);
			for (int i = j-1; i >= 0; i--) {
				if (key < arr.get(i)) {
					arr.set((i + 1), arr.get(i));
				} else {
					arr.set((i + 1), key);
					break;
				}
			}
			if (key < arr.get(0)) {
				arr.set(0, key);				
			}
			print(arr);
		}
	}

	private static void print(List<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}

}

public class InsertionSortOne {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result22.insertionSort2(n, arr);

		bufferedReader.close();
	}
}
