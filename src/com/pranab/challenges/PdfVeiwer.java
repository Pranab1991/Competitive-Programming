package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PdfVeiwer {

	// Complete the designerPdfViewer function below.
	static int designerPdfViewer(int[] h, String word) {
		int offset = 97, max_height = 0;
		for (int index = 0; index < word.length(); index++) {
			int height = h[word.charAt(index) - offset];
			if (height > max_height) {
				max_height = height;
			}
		}
		return word.length() * max_height;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		List<String> a= Arrays.asList("Rdasd","Hrsas","Rasda","Chu");
		display(a);
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int[] h = new int[26];
		 * 
		 * String[] hItems = scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int i = 0; i < 26; i++) { int hItem = Integer.parseInt(hItems[i]); h[i]
		 * = hItem; }
		 * 
		 * String word = scanner.nextLine();
		 * 
		 * int result = designerPdfViewer(h, word);
		 * 
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
		System.out.println(designerPdfViewer(
				new int[] { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7 }, "zaba"));
	}

	private static void display(List<String> a) {
		boolean count=(23&1)==1;
		System.out.println(count);
	}
}
