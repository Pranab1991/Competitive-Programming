package com.pranab.challenges;

import java.util.Scanner;

public class FermitPrimalityTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		long number=sc.nextInt();
		System.out.println("Enter the iteration number");
		long iterations=sc.nextInt();
		boolean isPrime=true;
		for(long iteration=0;iteration<iterations;iteration++) {
			long base=(1+(long)(Math.random()*(number-3)));
			if((!gcdIsOne(base,number))||(!modularExponentiation(base,number-1,number))) {
				isPrime=false;
				break;
			}
		}
		System.out.println(isPrime);
		sc.close();
	}
	
	public static boolean modularExponentiation(long base,long power,long modulo) {
		long result=1;
		while(power!=0) {
			if(power%2==1) {
				result=(result*base)%modulo;
				power--;
			}else {
				base=(base*base)%modulo;
				power/=2;
			}
		}
		return result==1?true:false;
	}
	
	public static boolean gcdIsOne(long firstNumber,long secondNumber) {
		if(secondNumber==0) {
			boolean isGcdOne=false;
			if(firstNumber==1) {
				isGcdOne=true;
			}
			return isGcdOne;
		}
		return gcdIsOne(secondNumber,firstNumber%secondNumber);
	}
}
