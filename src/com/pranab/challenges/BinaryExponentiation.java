package com.pranab.challenges;

import java.util.Scanner;

public class BinaryExponentiation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("THE BASE PLEASE : ");
		long base=sc.nextLong();
		System.out.println("THE POWER PLEASE : ");
		long power=sc.nextLong();
		
		long result=1;
		while(power!=0) {
			if(power%2==1) {
				result*=base;
				power--;
			}else {
				base*=base;
				power/=2;
			}
		}
		System.out.println(result);
	}
}
