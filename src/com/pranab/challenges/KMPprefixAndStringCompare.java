package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMPprefixAndStringCompare {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the text");
		String inputString=sc.nextLine();
		System.out.println("Enter the String to be searched");
		String serchString=sc.next();
		String toBeProcessedString=serchString+"#"+inputString;
		int[] prefixArray=new int[toBeProcessedString.length()];
		evaluateThePrefixArray(toBeProcessedString,prefixArray);
		List<Integer> occurance=findOccurance(prefixArray,serchString.length());
		System.out.println(occurance);
	}

	private static List<Integer> findOccurance(int[] prefixArray, int length) {
		List<Integer> occurance=new ArrayList<>();
		for(int index=length+1;index<prefixArray.length;index++) {
			if(prefixArray[index]==length) {
				occurance.add(index-2*(length));
			}
		}
		return occurance;
	}

	private static void evaluateThePrefixArray(String inputString, int[] prefixArray) {
		for(int i=1;i<inputString.length();i++) {
			int j=prefixArray[i-1];
			while(j>0 && inputString.charAt(i)!=inputString.charAt(j)) {
				j=prefixArray[j-1];
			}
			if(inputString.charAt(i)==inputString.charAt(j)) {
				j++;
			}
			prefixArray[i]=j;
		}		
	}

}
