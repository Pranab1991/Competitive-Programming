package com.pranab.challenges;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (num != -100) {
			num = sc.nextInt();
			boolean primeflag = true;
			if (num == 1) {
				System.out.println("NOT PRIME");
				primeflag = false;
			}
			for (int i = 2; i * i < num; i++) {
				if (num % i == 0) {
					System.out.println("NOT PRIME");
					primeflag = false;
					break;
				}
			}
			if (primeflag) {
				System.out.println("PRIME");
			}
		}
	}
}
