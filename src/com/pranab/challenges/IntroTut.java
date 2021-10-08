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

class Result21 {

	/*
	 * Complete the 'introTutorial' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER V 2. INTEGER_ARRAY arr
	 */

	public static int introTutorial(int V, List<Integer> arr) {
		Integer[] intArr = new Integer[arr.size()];
		arr.toArray(intArr);
		int smallTrackerIndex = -1;
		int key = arr.get(arr.size() - 1);
		for (int tracker = 0; tracker < (intArr.length - 1); tracker++) {
			if (intArr[tracker] < key) {
				smallTrackerIndex++;
				swapElement(smallTrackerIndex, tracker, intArr);
			}
		}
		int partitionIndex = ++smallTrackerIndex;
		swapElement(partitionIndex, intArr.length - 1, intArr);
		if (key == V) {
			return partitionIndex;
		}
		List<Integer> newInput = new ArrayList<>();
		if (V < key) {
			for (int i = 0; i < partitionIndex; i++) {
				newInput.add(intArr[i]);
			}
			return introTutorial(V, newInput);
		} else {
			for (int i = ++partitionIndex; i < intArr.length; i++) {
				newInput.add(intArr[i]);
			}
			return introTutorial(V, newInput);
		}
	}

	private static void swapElement(int smallTrackerIndex, int tracker, Integer[] arr) {
		int temp = arr[smallTrackerIndex];
		arr[smallTrackerIndex] = arr[tracker];
		arr[tracker] = temp;
	}

}

public class IntroTut {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int V = Integer.parseInt(bufferedReader.readLine().trim());

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = Result21.introTutorial(V, arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
