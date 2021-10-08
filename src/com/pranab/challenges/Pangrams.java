package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {

	// Complete the pangrams function below.
	static String pangrams(String s) {
		Set<Integer> charecterSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			int charNum = s.charAt(i);
			if (charNum >= 65 && charNum <= 90) {
				charecterSet.add(charNum+32);
			}
			if (charNum >= 97 && charNum <= 122) {
				charecterSet.add(charNum);
			}
		}
		if (charecterSet.size() == 26) {
			return "pangram";
		} else {
			return "not pangram";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = pangrams(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}