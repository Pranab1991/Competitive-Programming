package com.pranab.challenges;

import java.util.Scanner;

public class CountBits {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int setBitsCount=0;
		while(number!=0) {
			int result=number&1;
			if(result!=0) {
				setBitsCount++;
			}
			number=number>>1;
		}
		System.out.println(setBitsCount);
	}
}
