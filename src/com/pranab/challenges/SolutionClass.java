package com.pranab.challenges;

import java.util.Scanner;

public class SolutionClass {	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int cr=sc.nextInt();
		int term=sc.nextInt();
		int result=num;
		for(int i=1;i<term;i++) {
			result*=cr;
		}
		System.out.println(result);
	}

}
