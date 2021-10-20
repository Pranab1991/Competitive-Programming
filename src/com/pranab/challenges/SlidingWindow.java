package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlidingWindow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the text");
		String text = sc.nextLine();
		System.out.println("Please enter the pattern");
		String pattern = sc.nextLine();
		List<Integer> patternMatchIndexes = slidingWindow(text, pattern);
		System.out.println(patternMatchIndexes);
		sc.close();
	}

	private static List<Integer> slidingWindow(String text, String pattern) {
		List<Integer> patternMatchIndexes = new ArrayList<>();
		for (int textIndex = 0; textIndex <= (text.length() - pattern.length()); textIndex++) {
			boolean patternfound = true;
			for (int charecterIndex = 0; charecterIndex < pattern.length(); charecterIndex++) {
				if (text.charAt(textIndex + charecterIndex) != pattern.charAt(charecterIndex)) {
					patternfound = false;
					break;
				}
			}
			if (patternfound) {
				patternMatchIndexes.add(textIndex);
			}
		}
		return patternMatchIndexes;
	}
}
