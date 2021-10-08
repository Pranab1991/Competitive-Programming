package com.pranab.challenges;

import java.util.Scanner;

public class RollingHash {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		System.out.println("#hash# : "+genrateRollingHash(input));
	}

	private static long genrateRollingHash(String input) {
		long mod= 10000000007L;
		long p=31;
		long power=1;
		long hash=0;
		for(int index=0;index<input.length();index++) {
			hash=(hash+((input.charAt(index)-'a'+1))*power)%mod;
			power=(p*power)%mod;
		}
		return hash;
	}
}
