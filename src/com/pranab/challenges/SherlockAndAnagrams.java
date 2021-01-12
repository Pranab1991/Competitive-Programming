package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		int matching_string = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int word_length = 2; word_length <= s.length(); word_length++) {
			for (int start_index = 0, end_index = (word_length - 1); end_index <= s
					.length(); start_index++, end_index++) {
				String str = s.substring(start_index, end_index);
				char[] arr = str.toCharArray();
				Arrays.sort(arr);
				String sort_str = String.valueOf(arr);
				if (!map.containsKey(sort_str)) {
					map.put(sort_str, 1);
				} else {
					map.put(sort_str, (map.get(sort_str) + 1));
				}
			}
		}

		for (int num : map.values()) {
			if (num >= 2) {
				matching_string += single_combo(num);
			}
		}
		return matching_string;
	}

	private static int single_combo(int total_count) {
		int total_val = 0;
		for (int i = 1; i < total_count; i++) {
			total_val += i;
		}
		return total_val;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int q = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int qItr = 0; qItr < q; qItr++) { String s = scanner.nextLine();
		 * 
		 * int result = sherlockAndAnagrams(s);
		 * 
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine(); }
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
		System.out.println(sherlockAndAnagrams("ifailuhkqq"));
	}

}
