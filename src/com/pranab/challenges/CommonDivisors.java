package com.pranab.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommonDivisors {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Integer> results=new ArrayList<>();
		int firstNumber=sc.nextInt();
		Map<Integer,Integer> primeFactorisationOfFirstNumber=factorisation(firstNumber);
		int testCases=sc.nextInt();
		while(testCases>0) {
			int secondNumber=sc.nextInt();
			Map<Integer,Integer> commonPrimeOfBothNums=commonPrimesofBothNums(primeFactorisationOfFirstNumber,secondNumber);
			int totalDivisors=1;
			for(int count:commonPrimeOfBothNums.values()) {
				totalDivisors*=(count+1);
			}
			results.add(totalDivisors);
			testCases--;
		}
		System.out.println(results);
	}

	private static Map<Integer, Integer> commonPrimesofBothNums(Map<Integer, Integer> primeFactorisationOfFirstNumber,
			int secondNumber) {
		Map<Integer,Integer> commonPrimeOfBothNums=new HashMap<>();
		for(int prime:primeFactorisationOfFirstNumber.keySet()) {
			int count=0;
			if(secondNumber%prime==0) {
				while(secondNumber%prime==0) {
					secondNumber/=prime;
					count++;
				}				
			}
			int firstCount=primeFactorisationOfFirstNumber.get(prime);
			if(firstCount>count) {
				commonPrimeOfBothNums.put(prime, count);
			}else {
				commonPrimeOfBothNums.put(prime, firstCount);
			}
		}
		
		return commonPrimeOfBothNums;
	}

	private static Map<Integer, Integer> factorisation(int number) {
		Map<Integer,Integer> primeFactorisationOfNumber=new HashMap<>();
		for(int divisor=2;divisor*divisor<=number;divisor++) {
			if(number%divisor==0) {
				int count=0;
				while(number%divisor==0) {
					number/=divisor;
					count++;
				}
				primeFactorisationOfNumber.put(divisor, count);
			}
		}
		return primeFactorisationOfNumber;
	}
}
