package com.pranab.challenges;

import java.util.Scanner;

public class ModuloInverseBrutForce {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number");
		int number = sc.nextInt();
		System.out.println("Please enter the divisor");
		int divisor = sc.nextInt();
		System.out.println("Please enter the modulo");
		int modulo = sc.nextInt();
		int result = -1;
		if (gcdOneOrNot(divisor, modulo)) {
			for (int moduloInverse = 2; moduloInverse < modulo; moduloInverse++) {
				if (((divisor*moduloInverse) % modulo) == 1) {
					result = moduloInverse;
					break;
				}
			}
		}
		System.out.println(result);
		sc.close();
	}

	public static boolean gcdOneOrNot(int firstNum, int secondNum) {
		if (secondNum == 0) {
			if (firstNum == 1) {
				return true;
			}
			return false;
		}
		return gcdOneOrNot(secondNum, firstNum % secondNum);
	}
}
