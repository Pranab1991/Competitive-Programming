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

class Result11 {

	/*
	 * Complete the 'fairRations' function below.
	 *
	 * The function is expected to return a STRING. The function accepts
	 * INTEGER_ARRAY B as parameter.
	 */

	public static String fairRations(List<Integer> B) {
		// Write your code here
		 int count = 0;
	        for (int i = 0; i < B.size() - 1; i++) {
	            if (B.get(i) % 2 != 0) {
	                B.set((i+1),(B.get(i + 1))+1);
	                count += 2;
	            }
	        }
	        if (B.get(B.size() - 1) % 2 == 0) {
	            return count+"";
	        }
	        else {
	            return "NO";
	        }
	}

}

public class Fair_Ration {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		String result = Result11.fairRations(B);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
