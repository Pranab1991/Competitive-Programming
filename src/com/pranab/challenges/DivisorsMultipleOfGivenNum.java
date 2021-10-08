package com.pranab.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DivisorsMultipleOfGivenNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> results = new ArrayList<>();
		int firstNumber = sc.nextInt();
		Map<Integer, Integer> primeFactorisationOfFirstNumber = factorisation(firstNumber);
		int testCases = sc.nextInt();
		while (testCases > 0) {
			int secondNumber = sc.nextInt();
			Map<Integer, Integer> primeFactorisationOfSecondNumber = factorisation(secondNumber);
			Map<Integer, Integer> commonPrimeOfBothNums = commonPrimesofBothNumbers(primeFactorisationOfFirstNumber,
					primeFactorisationOfSecondNumber);
			if (commonPrimeOfBothNums==null) {
				results.add(0);
			} else {
				int totalDivisors = 1;
				for (int count : commonPrimeOfBothNums.values()) {
					totalDivisors *= (count + 1);
				}
				results.add(totalDivisors);
			}
			testCases--;
		}
		System.out.println(results);
	}

	private static Map<Integer, Integer> commonPrimesofBothNumbers(
			Map<Integer, Integer> primeFactorisationOfFirstNumber,
			Map<Integer, Integer> primeFactorisationOfSecondNumber) {
		Map<Integer, Integer> commonPrimeOfBothNums = new HashMap<>();
		for (int prime : primeFactorisationOfSecondNumber.keySet()) {
			if (primeFactorisationOfFirstNumber.containsKey(prime)
					&& (primeFactorisationOfSecondNumber.get(prime)<primeFactorisationOfFirstNumber.get(prime))) {
				commonPrimeOfBothNums.put(prime,
						(primeFactorisationOfFirstNumber.get(prime) - primeFactorisationOfSecondNumber.get(prime)));
			} else {
				return null;
			}
		}
		for(Map.Entry<Integer, Integer> entity:primeFactorisationOfFirstNumber.entrySet()) {
			if(!commonPrimeOfBothNums.containsKey(entity.getKey())) {
				commonPrimeOfBothNums.put(entity.getKey(), entity.getValue());
			}
		}
		return commonPrimeOfBothNums;
	}

	private static Map<Integer, Integer> factorisation(int number) {
		Map<Integer, Integer> primeFactorisationOfNumber = new HashMap<>();
		for (int divisor = 2; divisor * divisor <= number; divisor++) {
			if (number % divisor == 0) {
				int count = 0;
				while (number % divisor == 0) {
					number /= divisor;
					count++;
				}
				primeFactorisationOfNumber.put(divisor, count);
			}
		}
		if(primeFactorisationOfNumber.isEmpty()) {
			primeFactorisationOfNumber.put(number, 1);
		}
		return primeFactorisationOfNumber;
	}
}
