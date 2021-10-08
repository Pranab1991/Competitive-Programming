package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfGcdUsingEtf {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int result=0;
		int[] numberOfCoPrimesAtIndex=calculateCoPrimesAtIndexUsingSeieve(number);
		List<Integer> divisors=findAllDivisors(number);
		for(int divisor:divisors) {
			result+=(numberOfCoPrimesAtIndex[number/divisor]*divisor);
		}
		System.out.println(result);
	}

	private static int[] calculateCoPrimesAtIndexUsingSeieve(int number) {
		int[] numberOfCoPrimesAtIndex=new int[number+1];
		for(int index=0;index<numberOfCoPrimesAtIndex.length;index++) {
			numberOfCoPrimesAtIndex[index]=index;
		}
		for(int divisor=2;divisor<=number/2;divisor++) {
			if(divisor==numberOfCoPrimesAtIndex[divisor]) {
				for(int compositeNum=divisor;compositeNum<=number;compositeNum+=divisor) {
					numberOfCoPrimesAtIndex[compositeNum]/=divisor;
					numberOfCoPrimesAtIndex[compositeNum]*=(divisor-1);
				}
			}
		}
		return numberOfCoPrimesAtIndex;
	}

	private static List<Integer> findAllDivisors(int number) {
		List<Integer> numberOfDivisors=new ArrayList<>();
		for(int divisor=1;divisor*divisor<=number;divisor++) {
			if(number%divisor==0) {
				numberOfDivisors.add(divisor);
				int otherdivisor=number/divisor;
				if(divisor!=otherdivisor) {
					numberOfDivisors.add(otherdivisor);
				}
			}
		}
		return numberOfDivisors;
	}
}
