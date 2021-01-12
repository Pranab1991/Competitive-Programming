package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KaprekarNumbers {

	// Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		boolean kaprekarNumbers_Exists=false;
		for (int num = p; num <= q; num++) {
				long num_sqr = (long) Math.pow(num, 2);
				String num_sqr_str = String.valueOf(num_sqr);
				int digit_len = String.valueOf(num).length();
				int first_digit = 0;
				String last_digit_str = "";
				if (num_sqr_str.length() == 2 * digit_len) {
					first_digit = Integer.valueOf(num_sqr_str.substring(digit_len, num_sqr_str.length()));
					last_digit_str = num_sqr_str.substring(0, digit_len);
				} else {
					first_digit = Integer.valueOf(num_sqr_str.substring(digit_len - 1, num_sqr_str.length()));
					last_digit_str = num_sqr_str.substring(0, digit_len - 1);
				}
				int last_digit = Integer.valueOf("".equals(last_digit_str) ? "0" : last_digit_str);
				if ((first_digit + last_digit) == num) {
					kaprekarNumbers_Exists=true;
					System.out.print(num + " ");
				}
		}
		if(!kaprekarNumbers_Exists) {
			System.out.print("INVALID RANGE");
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * int p = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * int q = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * kaprekarNumbers(p, q);
		 * 
		 * scanner.close();
		 */

		kaprekarNumbers(1,99999);
	}
}
