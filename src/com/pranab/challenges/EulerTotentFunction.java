package com.pranab.challenges;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EulerTotentFunction {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number=sc.nextInt();
		Set<Integer> primeDivisors=getPrimeDivisors(number);
		int numberOfCoPrimes=number;
		if(primeDivisors.isEmpty()) {
			numberOfCoPrimes--;
		}else {			
			for(int primeDivisor:primeDivisors) {
				numberOfCoPrimes=(numberOfCoPrimes/primeDivisor)*(primeDivisor-1);
			}			
		}
		System.out.println(numberOfCoPrimes);
		sc.close();
	}

	private static Set<Integer> getPrimeDivisors(int number) {
		int[] seieve=new int[number+1];
		Set<Integer> primeDivisors=new HashSet<>();
		for(int index=2;index*index<=number;index++) {
			for(int incrementor=1,composite=incrementor*index;composite<=number;incrementor++,composite=incrementor*index) {
				if(seieve[composite]==0||seieve[composite]>index) {
					seieve[composite]=index;
				}
			}
		}
		if(seieve[number]==0) {
			return primeDivisors;
		}
		while(number!=1) {
			int divisor=seieve[number];
			if(divisor==0) {
				divisor=number;
			}
			number=number/divisor;
			primeDivisors.add(divisor);
		}
		return primeDivisors;
	}
}
