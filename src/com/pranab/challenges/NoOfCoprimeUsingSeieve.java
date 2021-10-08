package com.pranab.challenges;

import java.util.Scanner;

public class NoOfCoprimeUsingSeieve {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("The number please");
		int number=sc.nextInt();
		int[] seieve=noOfCoPrimeSeieve(number);
	}

	private static int[] noOfCoPrimeSeieve(int number) {
		int[] seieveArray=new int[number];
		for(int index=0;index<number;index++) {
			seieveArray[index]=index;
		}
		for(int num=2;num<=number/2;num++) {
			if(num==seieveArray[num]) {
				for(int increment=num;increment<number;increment+=num) {
					seieveArray[increment]/=num;
					seieveArray[increment]*=(num-1);
				}
			}
		}
		return null;
	}
}
