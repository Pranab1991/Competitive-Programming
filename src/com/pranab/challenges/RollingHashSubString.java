package com.pranab.challenges;

import java.util.Scanner;

public class RollingHashSubString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the test to be hashed");
		String textToBeHashed=sc.nextLine();
		long[] subStringHashesAtIndex=new long[textToBeHashed.length()];
		long[] moduloInversesAtIndex=new long[textToBeHashed.length()];
		rollingHashOfSubStrings(textToBeHashed,subStringHashesAtIndex,moduloInversesAtIndex);
		System.out.println("Start Index");
		int startIndex=sc.nextInt();
		System.out.println("End Index");
		int endIdex=sc.nextInt();
		long hashValue=calculateTheHashOfSubstringAtIndexes(startIndex,endIdex,subStringHashesAtIndex,moduloInversesAtIndex);
		System.out.println(hashValue);
	}

	private static long calculateTheHashOfSubstringAtIndexes(int startIndex, int endIdex, long[] subStringHashesAtIndex,
			long[] moduloInversesAtIndex) {
		final long MODULOPRIME=1000000007;
		long hashWithExtraContribution=0;
		if(startIndex==0) {
			hashWithExtraContribution=subStringHashesAtIndex[endIdex];	
		}else {
		    hashWithExtraContribution=(subStringHashesAtIndex[endIdex]-subStringHashesAtIndex[startIndex-1]+MODULOPRIME)%MODULOPRIME;
		}
		long rollingHash=(hashWithExtraContribution*moduloInversesAtIndex[startIndex])%MODULOPRIME;
		return rollingHash;
	}

	private static void rollingHashOfSubStrings(String textToBeHashed, long[] subStringHashesAtIndex, long[] moduloInversesAtIndex) {
		final int RELATIVEPRIME=31;
		final long MODULOPRIME=1000000007;
		subStringHashesAtIndex[0]=textToBeHashed.charAt(0)-96;
		moduloInversesAtIndex[0]=1;
		long power=RELATIVEPRIME;
		for(int index=1;index<subStringHashesAtIndex.length;index++) {
			int charAtIndexValue=textToBeHashed.charAt(index)-96;
			if(charAtIndexValue<0) {
				charAtIndexValue=27;
			}
			long hashAtIndex=(subStringHashesAtIndex[index-1]+(charAtIndexValue*power))%MODULOPRIME;
			subStringHashesAtIndex[index]=hashAtIndex;
			long moduloInverse=modularExponentiation(power,MODULOPRIME-2,MODULOPRIME);
			moduloInversesAtIndex[index]=moduloInverse;
			power=(power*RELATIVEPRIME)%MODULOPRIME;			
		}
		
	}


	private static long modularExponentiation(long base, long power, long modulo) {
		long modularExponent=1;
		while(power!=0) {
			if(power%2==1) {
				modularExponent=(modularExponent*base)%modulo;
				power--;
			}else {
				base=(base*base)%modulo;
				power/=2;
			}
		}
		return modularExponent;
	}
	
	
	
}
