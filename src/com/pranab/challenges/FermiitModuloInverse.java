package com.pranab.challenges;

import java.util.Scanner;

public class FermiitModuloInverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number and the modulo");
		int number = sc.nextInt();
		int modulo = sc.nextInt();
		int moduloinverse = 0;
		if (gcdOneOrNot(number, modulo)) {
			moduloinverse = binaryExpnentiation(number, modulo - 2,modulo);
			System.out.println(moduloinverse);
		} else {
			System.out.println("The numbers are not co-prime");
		}
		sc.close();
	}

	private static int binaryExpnentiation(int number, int power, int modulo) {
		int result = 1;
		while (power != 0) {
			if (power % 2 == 1) {
				result = (result * number)%modulo;
				power--;
			} else {
				number = (number * number)%modulo;
				power /= 2;
			}
		}
		return result;
	}

	private static boolean gcdOneOrNot(int firstNumber, int secondNumber) {
		if (secondNumber == 0) {
			boolean result = false;
			if (firstNumber == 1) {
				result = true;
			}
			return result;
		}
		return gcdOneOrNot(secondNumber, firstNumber % secondNumber);
	}
}
