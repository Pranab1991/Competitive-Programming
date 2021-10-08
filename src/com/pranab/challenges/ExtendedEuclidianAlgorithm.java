package com.pranab.challenges;

import java.util.Scanner;

/*
 * Extended Euclidian Algorithm that solves for X and Y in AX + BY =gcd(A,B);
 */
public class ExtendedEuclidianAlgorithm {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of firstNumber : ");
		int firstNumber=sc.nextInt();
		System.out.println("Enter the value of secondNumber : ");
		int secondNumber=sc.nextInt();
		System.out.println(gcd(firstNumber,secondNumber));
	}
	
	public static String gcd(int firstNumber,int secondNumber) {
		if(secondNumber==0) {
			int x=1;
			int y=0;
			return x+","+y;
		}
		String[] x1Andy1Values=gcd(secondNumber,firstNumber%secondNumber).split(",");
		int x1=Integer.parseInt(x1Andy1Values[0]);
		int y1=Integer.parseInt(x1Andy1Values[1]);
		int x=y1;
		int y=(x1-y1*(firstNumber/secondNumber));
		return x+","+y;
	}
}
