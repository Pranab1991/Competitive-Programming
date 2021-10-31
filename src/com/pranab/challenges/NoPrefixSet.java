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

import com.pranab.challenges.Result91.TriNode91;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result92 {

	static class TriNode91 {
		boolean isLeaf = false;
		TriNode91[] charArr = new TriNode91[26];
		int prefixcount = 0;
	}

	public static final TriNode91 ROOT = new TriNode91();

	public static void noPrefix(List<String> words) {
		for (String word : words) {
			boolean isPrefixPresent = add(word);
			if (isPrefixPresent) {
				System.out.println("BAD SET");
				System.out.println(word);
				return;
			}
		}
		System.out.println("GOOD SET");
	}

	public static boolean add(String contact) {
		TriNode91 temp = ROOT;
		for (int index = 0; index < contact.length(); index++) {
			int charIndex = contact.charAt(index) - 97;
			if (temp.charArr[charIndex] == null) {
				TriNode91 newTri = new TriNode91();
				newTri.prefixcount++;
				temp.charArr[charIndex] = newTri;
			} else {
				temp.charArr[charIndex].prefixcount++;
				if (temp.charArr[charIndex].isLeaf) {
					return true;
				}
			}
			temp = temp.charArr[charIndex];
		}
		temp.isLeaf = true;
		if (temp.prefixcount > 1) {
			return true;
		} else {
			return false;
		}
	}
}

public class NoPrefixSet {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> words = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		Result92.noPrefix(words);

		bufferedReader.close();
	}
}
