package com.pranab.challenges;

import java.util.Scanner;

public class CheckBitSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int checkTheBit=sc.nextInt();
		int oneShift=1<<checkTheBit;
		int result=oneShift&num;
		if(result==oneShift) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
}
