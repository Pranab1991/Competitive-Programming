package com.pranab.challenges;

import java.util.Scanner;

public class CountBits2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int setBitsCount=0;
		while(n!=0) {
			setBitsCount++;
			n=n&(n-1);
		}
		System.out.println(setBitsCount);
	}
}
