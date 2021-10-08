package com.pranab.challenges;

import java.util.Scanner;

public class PrimePrime {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Insert a number to find prime primes : ");
		int number=sc.nextInt();
		boolean[] primeIndicator=new boolean[number];
		primeIndicator[0]=true;primeIndicator[1]=true;
		int numberIterator=2;
		while(numberIterator*numberIterator<number) {
			if(!primeIndicator[numberIterator]) {
				for(int composite=numberIterator*numberIterator;composite<number;composite+=numberIterator) {
					primeIndicator[composite]=true;
				}
			}
			numberIterator++;
		}
		int counter=0,index=0;
		StringBuilder primePrimeBuilder=new StringBuilder();
		for(boolean primeStatus:primeIndicator) {
			if(!primeStatus) {
				counter++;
				if(!primeIndicator[counter]) {
					primePrimeBuilder.append(index+" ");
				}
			}
			index++;
		}
		System.out.println(primePrimeBuilder.toString());
	}
}
