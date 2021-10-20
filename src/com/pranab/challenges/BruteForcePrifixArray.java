package com.pranab.challenges;

import java.util.Scanner;

/*
 * The method finds the longest length of prefix equivalent to it's suffix in substring of the string .
 */
public class BruteForcePrifixArray {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the String");
		String text=sc.nextLine();
		int[] prefixArray=generateThePreFixArray(text);
		System.out.println("done");
	}

	private static int[] generateThePreFixArray(String text) {
		int[] prefixArray=new int[text.length()];
		for(int lengthIndex=1;lengthIndex<text.length();lengthIndex++) {
			int longestPreFix=0;
			for(int prefixLength=0;prefixLength<lengthIndex;prefixLength++) {
				String prefix=text.substring(0, prefixLength+1);
				String sufix=text.substring(lengthIndex-prefixLength, lengthIndex+1);
				if(prefix.equals(sufix)) {
					longestPreFix=prefixLength+1;
				}
			}
			prefixArray[lengthIndex]=longestPreFix;	
		}
		return prefixArray;
	}
}
