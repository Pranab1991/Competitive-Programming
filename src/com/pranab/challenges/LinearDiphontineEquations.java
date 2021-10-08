package com.pranab.challenges;

import java.util.Scanner;

/*
 * In mathematics, a Diophantine equation is a polynomial equation, usually involving two 
 * or more unknowns, such that the only solutions of interest are the integer 
 * ones (an integer solution is such that all the unknowns take integer values)
 * example ax + by = c where a,b,c are integral values
 */
public class LinearDiphontineEquations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int gcdOfAandB = Integer.parseInt(gcdSoln(A, B, false));
		if (C % gcdOfAandB == 0) {
			String[] xAndySoln = gcdSoln(A, B, true).split(",");
			int x1 = Integer.parseInt(xAndySoln[0]);
			int y1 = Integer.parseInt(xAndySoln[1]);
			int cByG = C / gcdOfAandB;
			System.out.println("Solution X : " + x1 * cByG + " & Y : " + y1 * cByG);
		} else {
			System.out.println("No Integral solution");
		}
		sc.close();
	}

	public static String gcdSoln(int firstNumber, int secondNumber, boolean indicator) {
		if (secondNumber == 0) {
			if (indicator) {
				return "1,0";
			} else {
				return firstNumber + "";
			}
		}
		String[] xAndySoln = gcdSoln(secondNumber, firstNumber % secondNumber, indicator).split(",");
		if (indicator) {
			int x1 = Integer.parseInt(xAndySoln[0]);
			int y1 = Integer.parseInt(xAndySoln[1]);
			int x = y1;
			int y = x1 - y1 * (firstNumber / secondNumber);
			return x + "," + y;
		} else {
			return xAndySoln[0];
		}
	}
}
