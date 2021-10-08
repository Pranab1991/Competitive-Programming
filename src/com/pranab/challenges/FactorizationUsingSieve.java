package com.pranab.challenges;

import java.util.Scanner;

public class FactorizationUsingSieve {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = sc.nextInt();
		int[] sieveArray = new int[number + 1];
		int smallestDivisor = 2;
		while (smallestDivisor * smallestDivisor <= number) {
			if (sieveArray[smallestDivisor] == 0) {
				for (int divisor = smallestDivisor * smallestDivisor; divisor <= number; divisor += smallestDivisor) {
					if (sieveArray[divisor] == 0) {
						sieveArray[divisor] = smallestDivisor;
					}
				}
			}
			smallestDivisor++;
		}
		
		while(number!=1) {
			int leastDivisior=sieveArray[number];
			if(leastDivisior==0){
				leastDivisior=number;
			}
			System.out.print(leastDivisior+"*");
			number/=leastDivisior;
		}
	}
}
