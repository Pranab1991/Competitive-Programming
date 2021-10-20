package com.pranab.challenges;

import java.util.Scanner;
import java.util.stream.IntStream;
/*
 * given an array of divisors D and reminders R find the smallest number that when divided by D leaves reminder R
 */
public class ChineseReminderBrutForce {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int divisorsAndRemindersSize=sc.nextInt();
		int[] divisors=new int[divisorsAndRemindersSize];
		for(int index=0;index<divisorsAndRemindersSize;index++) {
			divisors[index]=sc.nextInt();
		}
		int[] reminders=new int[divisorsAndRemindersSize];
		for(int index=0;index<divisorsAndRemindersSize;index++) {
			reminders[index]=sc.nextInt();
		}
		int leastDivident=chineseReminderBruteForceOptimised(divisors,reminders);
		System.out.println(leastDivident);
		sc.close();
	}

	private static int chineseReminderBruteForce(int[] divisors, int[] reminders) {
		int leastDividentUpperBound=1;
		for(int divisor:divisors) {
			leastDividentUpperBound*=divisor;
		}
		
		return IntStream.range(1, leastDividentUpperBound+1).filter(divident->{
			boolean isTheDivident=true;
			for(int index=0;index<divisors.length;index++) {
				if(divident%divisors[index]!=reminders[index]) {
					isTheDivident=false;
				}
			}
			return isTheDivident;
			}).findFirst().getAsInt();
	}
	
	private static int chineseReminderBruteForceOptimised(int[] divisors, int[] reminders) {
		int maxDivisor=0,divisorIndex=0,maxDivisorIndex=0;
		int leastDividentUpperBound=1;
		for(int divisor:divisors) {
			leastDividentUpperBound*=divisor;
			if(divisor>maxDivisor) {
				maxDivisor=divisor;
				maxDivisorIndex=divisorIndex;
			}
			divisorIndex++;
		}
		int divident=0;
		for(divident=reminders[maxDivisorIndex];divident<leastDividentUpperBound;divident+=divisors[maxDivisorIndex]) {
			boolean isTheDivident=true;
			for(int index=0;index<divisors.length;index++) {
				if(divident%divisors[index]!=reminders[index]) {
					isTheDivident=false;
					break;
				}
			}
			if(isTheDivident) {
				break; 
			}			
		}
		return divident;
	}
}
