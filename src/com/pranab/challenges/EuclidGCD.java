package com.pranab.challenges;

import java.util.Scanner;

public class EuclidGCD {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first number");
		int firstNumber=sc.nextInt();
		System.out.println("Enter the second number");
		int secondNumber=sc.nextInt();
		
		int result=gcd(firstNumber,secondNumber);
		System.out.println(result);
		sc.close();
	}

	private static int gcd(int firstNumber, int secondNumber) {
		if(secondNumber==0) {
			return firstNumber;
		}
		return gcd(secondNumber,firstNumber%secondNumber);
	}
}
