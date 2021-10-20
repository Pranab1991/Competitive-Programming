package com.pranab.challenges;

import java.util.Scanner;

public class RollingHashes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String inputString = sc.nextLine();
		System.out.println(rollingHash(inputString));
		sc.close();
	}

	public static long rollingHash(String inputString) {
		long hashValue=0;
		final int RELATIVEPRIME=31;
		final long MODULOPRIME=1000000007;
		for (int index = 0; index < inputString.length(); index++) {
			int charecterAtIndex=(inputString.charAt(index)-96);
			long valueAfterModularExponentiation=modularExponentiation(RELATIVEPRIME,index,MODULOPRIME);
			hashValue=(hashValue+(charecterAtIndex*valueAfterModularExponentiation))%MODULOPRIME;
		}
		return hashValue;
	}
	
	public static long modularExponentiation(long base,int power,long modulo) {
		long exponentiationUnderModulo=1;
		while(power!=0) {
			if(power%2==1) {
				exponentiationUnderModulo=(exponentiationUnderModulo*base)%modulo;
				power--;
			}else {
				base=(base*base)%modulo;
				power/=2;
			}
		}
		return exponentiationUnderModulo;
	}
}
