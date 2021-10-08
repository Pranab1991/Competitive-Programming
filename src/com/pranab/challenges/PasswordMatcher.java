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

class Result31 {

	/*
	 * Complete the 'minimumNumber' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. STRING password
	 */

	public static int minimumNumber(int n, String password) {
		// Return the minimum number of characters to make the password strong
		int upperCaseFound = 1, lowerCaseFound = 1, specialCharFound = 1, digitFound = 1, requiredLength = 0;
		String[] passwordChars = password.split("");
		for (String passwordChar : passwordChars) {
			if (upperCaseFound != 0 && ((passwordChar.charAt(0) <= 90) && (passwordChar.charAt(0) >= 65))) {
				upperCaseFound = 0;
			}
			if (lowerCaseFound != 0 && ((passwordChar.charAt(0) <= 122) && (passwordChar.charAt(0) >= 97))) {
				lowerCaseFound = 0;
			}
			if (digitFound != 0 && ((passwordChar.charAt(0) <= 57) && (passwordChar.charAt(0) >= 48))) {
				digitFound = 0;
			}
			if (specialCharFound != 0) {
				Pattern special = Pattern.compile("[!@#$%^&*()\\-\\+]");
				Matcher hasSpecial = special.matcher(password);
				if (hasSpecial.find()) {
					specialCharFound = 0;
				}
			}
		}
		requiredLength = 6 - password.length();
		int totalmismatch = upperCaseFound + lowerCaseFound + specialCharFound + digitFound;
		if (totalmismatch > requiredLength) {
			return totalmismatch;
		} else {
			return requiredLength;
		}
	}

}

public class PasswordMatcher {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		String password = bufferedReader.readLine();

		int answer = Result31.minimumNumber(n, password);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
