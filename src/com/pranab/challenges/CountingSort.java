package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result26 {

	/*
	 * Complete the 'countSort' function below.
	 *
	 * The function accepts 2D_STRING_ARRAY arr as parameter.
	 */

	public static void countSort(List<List<String>> arr) {
		LocalTime start = LocalTime.now();
		List<Integer> counter = new ArrayList<>();
		List<String> result = new ArrayList<>();
		int midval = arr.size() / 2, midcounter = arr.size() - 1;
		for (int i = 0; i < 100; i++) {
			counter.add(0);
		}
		for (List<String> list : arr) {
			int index = Integer.parseInt(list.get(0));
			int value = counter.get(index);
			counter.set(index, (value + 1));
			result.add("");
		}
		for (int i = 1; i < 100; i++) {
			int prevIndexVal = counter.get(i - 1);
			int currentIndexVal = counter.get(i);
			counter.set(i, prevIndexVal + currentIndexVal);
		}
		for (int i = (arr.size() - 1); i >= 0; i--) {
			String val = "";
			int num = Integer.parseInt(arr.get(i).get(0));
			if (midcounter < midval) {
				val = "-";				
			} else {
				val = arr.get(i).get(1);
			}
			int resultIndex = counter.get(num);
			counter.set(num, --resultIndex);
			result.set(resultIndex, val);
			midcounter--;
		}
		StringBuilder sb=new StringBuilder();
		for (String string : result) {
			sb.append(string + " ");
		}				
		System.out.println(sb.toString());
		LocalTime end = LocalTime.now();
		Duration duration = Duration.between(start, end);
		System.out.println();
		System.out.println("Time duration : " + duration);
	}
}

public class CountingSort {
	public static void main(String[] args) throws IOException {
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("input05.txt"))));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		Result26.countSort(arr);

		bufferedReader.close();
	}
}
