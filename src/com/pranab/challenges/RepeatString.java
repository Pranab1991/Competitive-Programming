package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatString {
	static long repeatedString(String s, long n) {
		long string_length=s.length(),
			reminder_length=(n%string_length),
			total_repetation= (n/string_length),
			letter_count=0,rem_count=0;
		
		for(int index=0;index<string_length;index++) {
			if(s.charAt(index)=='a') {
				letter_count++;
				if(index<reminder_length) {
					rem_count++;
				}
			}
		}
		return ((letter_count*total_repetation)+rem_count);		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();*/
		System.out.println(repeatedString("a", 1000000000000L));
	}
}
