package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CloudJump {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int jump_numbers = 0,cloud = 0;
		boolean is_One_Jump_Possible = false, is_Two_Jump_Possible = false;
		while(cloud < c.length) {
			if ((cloud + 1 < c.length) && (c[cloud + 1] == 0)) {
				is_One_Jump_Possible = true;
			}else {
				is_One_Jump_Possible=false;
			}
			if ((cloud + 2 < c.length) && (c[cloud + 2] == 0)) {
				is_Two_Jump_Possible = true;
			}else {
				is_Two_Jump_Possible=false;
			}
			if (is_Two_Jump_Possible) {
				cloud += 2;
			} else {
				cloud += 1;
			}
			if (is_Two_Jump_Possible || is_One_Jump_Possible) {
				jump_numbers++;
			}
		}
		return jump_numbers;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int n = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * int[] c = new int[n];
		 * 
		 * String[] cItems = scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int i = 0; i < n; i++) { int cItem = Integer.parseInt(cItems[i]); c[i] =
		 * cItem; }
		 * 
		 * int result = jumpingOnClouds(c);
		 * 
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 0, 0, 1, 0 }));
	}
}
