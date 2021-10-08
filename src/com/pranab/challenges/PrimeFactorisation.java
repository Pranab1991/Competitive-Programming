package com.pranab.challenges;

import java.util.Scanner;

public class PrimeFactorisation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Insert the number");
		int number=sc.nextInt();
		for(int num=2;(num*num)<=number;num++) {
			if(number%num==0) {
				int count=0;
				while(number%num==0) {
					number/=num;
					count++;
				}
				System.out.print("("+num+"^"+count+")");
			}
		}
		if(number>1) {
			System.out.print("("+number+"^"+1+")");
		}
		sc.close();
	}
}
