package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeedleInHayStack {
     
	private static final int RELATIVEPRIME=31;
	private static final int MODULOPRIME=1000000007;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the HayStack");
		String hayStack=sc.nextLine();
		long[] stringHashesAtIndex=new long[hayStack.length()];
		long[] moduloInverse=new long[hayStack.length()];
		subStringHashing(hayStack,stringHashesAtIndex,moduloInverse);
		System.out.println("Enter the needle");
		String needle=sc.nextLine();
		long[] stringHashesAtIndexNeedle=new long[needle.length()];
		long[] moduloInverseNeedle=new long[needle.length()];
		subStringHashing(needle,stringHashesAtIndexNeedle,moduloInverseNeedle);
		List<Integer> neddles=findNeedleInHayStack(stringHashesAtIndex,moduloInverse,stringHashesAtIndexNeedle[needle.length()-1],needle.length());
		System.out.println(neddles);
	}
	
	

	private static List<Integer> findNeedleInHayStack(long[] stringHashesAtIndex, long[] moduloInverse, long needleHash,
			int needleLength) {
		List<Integer> matches=new ArrayList<>();
		long initialHash=stringHashesAtIndex[needleLength-1];
		if(initialHash==needleHash) {
			matches.add(0);
		}
		for(int hayStackIndex=1;hayStackIndex<=(stringHashesAtIndex.length-needleLength);hayStackIndex++) {
			long hashWithContribution=(stringHashesAtIndex[hayStackIndex+needleLength-1]-stringHashesAtIndex[hayStackIndex-1]+MODULOPRIME)%MODULOPRIME;
			long hashContributionRemoved=(hashWithContribution*moduloInverse[hayStackIndex])%MODULOPRIME;
			if(hashContributionRemoved==needleHash) {
				matches.add(hayStackIndex);
			}
		}
		return matches;
	}



	private static void subStringHashing(String hayStack, long[] stringHashesAtIndex, long[] moduloInverse) {
		stringHashesAtIndex[0]=hayStack.charAt(0)-96;
		moduloInverse[0]=1;
		long power=RELATIVEPRIME;
		for(int index=1;index<hayStack.length();index++) {
			int charValueAtIndex=hayStack.charAt(index)-96;
			if(charValueAtIndex<0) {
				charValueAtIndex=27;
			}
			long subStringHashesAtIndex=(stringHashesAtIndex[index-1]+charValueAtIndex*power)%MODULOPRIME;
			stringHashesAtIndex[index]=subStringHashesAtIndex;
			long moduloInverseOfPowerAtIndedx=modularExponentiation(power,MODULOPRIME-2,MODULOPRIME);
			moduloInverse[index]=moduloInverseOfPowerAtIndedx;
			power=(power*RELATIVEPRIME)%MODULOPRIME;
		}
	}

	private static long modularExponentiation(long base, int power, int modulo) {
		long modularExponentiationVal=1;
		while(power!=0) {
			if(power%2==1) {
				modularExponentiationVal=(modularExponentiationVal*base)%modulo;
				power--;
			}else {
				base=(base*base)%modulo;
				power/=2;
			}
		}
		return modularExponentiationVal;
	}
	
	
}
