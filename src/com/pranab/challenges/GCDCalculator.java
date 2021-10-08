package com.pranab.challenges;

import java.util.Scanner;

public class GCDCalculator {

	private static final int PRIME = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases != 0) {
			int numberA = sc.nextInt();
			int numberB = sc.nextInt();
			int power = sc.nextInt();
			int gcd = GCDcalculator(numberA, numberB, power);
			System.out.println(gcd);
			testCases--;
		}
		sc.close();
	}

	static int powerCalculator(int number, int power, int modularDivisor) {
		int result = 1;
		while (power > 0) {
			if (power % 2 == 1) {
				result = ((result % modularDivisor) * (number % modularDivisor)) % modularDivisor;
				power--;
			} else {
				number = ((number % modularDivisor) * (number % modularDivisor)) % modularDivisor;
				power /= 2;
			}
		}
		return result;
	}

	static int GCDcalculator(int firstNumber, int secondNumber, int power) {
		if (firstNumber == secondNumber) {
			return (powerCalculator(firstNumber, power, PRIME) + powerCalculator(secondNumber, power, PRIME))
					% PRIME;
		}
		int gcd=1;
		int secondNumberForGCD=(firstNumber-secondNumber);
		if(secondNumberForGCD<0) {
			secondNumberForGCD*=-1;
		}
		for(int divisor=2;divisor*divisor<=secondNumberForGCD;divisor++) {
			if(secondNumberForGCD%divisor==0) {
				if(((powerCalculator(firstNumber, power, divisor) + powerCalculator(secondNumber, power, divisor))
						% divisor)==0) {
					gcd=divisor;
				}
				int inverseDivisor=(secondNumberForGCD/divisor);
				if(((powerCalculator(firstNumber, power, inverseDivisor) + powerCalculator(secondNumber, power, divisor))
						% inverseDivisor)==0) {
					if(inverseDivisor>gcd) {
						gcd=inverseDivisor;
					}
				}
			}
		}
		return gcd% PRIME;
	}
}
