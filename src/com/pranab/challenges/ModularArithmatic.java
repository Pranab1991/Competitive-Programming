package com.pranab.challenges;

import java.util.Scanner;

public class ModularArithmatic {

	public static void main(String[] args) {
		System.out.println("The power to find");
		Scanner sc=new Scanner(System.in);
		int power=sc.nextInt();
		int result=8;
		for(int index=1;index<power;index++) {
			result=(result*8)%10;
		}
		System.out.println(result);
	}
}
