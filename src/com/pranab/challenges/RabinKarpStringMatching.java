package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RabinKarpStringMatching {
	private static final int CONSTANTSUB = 96;
	private static final long RELATIVEPRIME = 31;
	private static final long MODULOPRIME = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the text : ");
		String text = sc.nextLine();
		long[] hashOfSubStringAtIndex = new long[text.length()];
		long[] powerAtIndex = new long[text.length()];
		calculateRollingHashOfAllSubStrings(text, hashOfSubStringAtIndex, powerAtIndex);
		System.out.println("Please Enter the text to be searched : ");
		String toBeSearchedText = sc.nextLine();
		long[] hashOfSearchedText = new long[text.length()];
		long[] powerAtIndexOfSearchedText = new long[text.length()];
		calculateRollingHashOfAllSubStrings(toBeSearchedText, hashOfSearchedText, powerAtIndexOfSearchedText);
		List<Integer> indexesOfSearchedText = findMatchOfTextSearched(hashOfSubStringAtIndex, powerAtIndex,
				hashOfSearchedText[toBeSearchedText.length() - 1], toBeSearchedText.length());
		System.out.println(indexesOfSearchedText);
	}

	private static List<Integer> findMatchOfTextSearched(long[] hashOfSubStringAtIndexOfText, long[] powerAtIndexOfText, long hashOfTheSearchedText,
			int lengthOfSearchedText) {
		List<Integer> indexesOfSearchedText=new ArrayList<>();
		long initialHash=hashOfSubStringAtIndexOfText[lengthOfSearchedText-1];
		if(hashOfTheSearchedText==initialHash) {
			indexesOfSearchedText.add(0);
		}
		for(int index=1;index<=(hashOfSubStringAtIndexOfText.length-lengthOfSearchedText);index++) {
			long hashValueWithContribution=(hashOfSubStringAtIndexOfText[index+lengthOfSearchedText-1]-hashOfSubStringAtIndexOfText[index-1]+MODULOPRIME)%MODULOPRIME;
			long hashValueOfTestWithPower=(hashOfTheSearchedText*powerAtIndexOfText[index])%MODULOPRIME;
			if(hashValueWithContribution==hashValueOfTestWithPower) {
				indexesOfSearchedText.add(index);
			}
		}
		return indexesOfSearchedText;
	}

	private static void calculateRollingHashOfAllSubStrings(String text, long[] hashOfSubStringAtIndex,
			long[] powerAtIndex) {
		hashOfSubStringAtIndex[0] = (text.charAt(0) - CONSTANTSUB);
		powerAtIndex[0] = 1;
		long power = RELATIVEPRIME;
		for (int index = 1; index < text.length(); index++) {
			int charValueAtIndex = (text.charAt(index) - CONSTANTSUB);
			if (charValueAtIndex < 0) {
				charValueAtIndex = 27;
			}
			long hashValueOfSubString = (hashOfSubStringAtIndex[index - 1] + charValueAtIndex * power) % MODULOPRIME;
			hashOfSubStringAtIndex[index] = hashValueOfSubString;
			powerAtIndex[index] = power;
			power = (power * RELATIVEPRIME) % MODULOPRIME;
		}

	}

}
