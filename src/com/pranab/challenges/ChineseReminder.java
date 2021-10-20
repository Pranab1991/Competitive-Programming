package com.pranab.challenges;

import java.util.Scanner;

public class ChineseReminder {
	
     private static final long PRIME=1000000007; 
	
	 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
			int divisorsAndRemindersSize=sc.nextInt();
			long[] divisors=new long[divisorsAndRemindersSize];
			for(int index=0;index<divisorsAndRemindersSize;index++) {
				divisors[index]=sc.nextInt();
			}
			long[] reminders=new long[divisorsAndRemindersSize];
			for(int index=0;index<divisorsAndRemindersSize;index++) {
				reminders[index]=sc.nextInt();
			}
			long leastDivident=chineseReminder(divisors,reminders);
			System.out.println(leastDivident);
	 }
	 public static long chineseReminder(long[] divisors,long[] reminders) {
		 if(divisors.length!=reminders.length) {
			 throw new UnsupportedOperationException("Number of divident and Divisors must be same");
		 }
		 long upperBoundForTheDivident=1;
		 for(long divisor:divisors) {
			 upperBoundForTheDivident*=divisor;
		 }
		 long divident=0;
		 for(int index=0;index<divisors.length;index++) {
			 long productOfReminderAndAllNumbersExceptveryNum=upperBoundForTheDivident/divisors[index];
			 long moduloInverseOfDivident=moduloInverse(productOfReminderAndAllNumbersExceptveryNum,divisors[index]);
			 long dividentresult=(reminders[index]*productOfReminderAndAllNumbersExceptveryNum*moduloInverseOfDivident); 
			 divident+=dividentresult;
		 }
		 return divident%upperBoundForTheDivident;
	 }
	 
	 public static long moduloInverse(long number,long modulo) {
		 long moduloInverseOfTheNumber=-1;
		 if(gcdIsOne(number,modulo)) {
			 moduloInverseOfTheNumber= modularExponentiation(number, modulo-1, modulo);
		 }
		 return moduloInverseOfTheNumber;
	 }
	 
	 public static long modularExponentiation(long base,long power,long modulo) {
		 long baseRaisedToPowerUnderModulo=1;
		 while(power!=0) {
			 if(power%2==1) {
				 baseRaisedToPowerUnderModulo=(baseRaisedToPowerUnderModulo*base)%modulo;
				 power--;
			 }else {
				 base= (base*base)%modulo;
				 power/=2;
			 }
		 }
		 return baseRaisedToPowerUnderModulo;
	 }
	 
	 public static boolean gcdIsOne(long firstNumber,long secondNumber) {
		 if(secondNumber==0) {
			 boolean isGcdOne=false;
			 if(firstNumber==1) {
				 isGcdOne=true;
			 }
			 return isGcdOne;
		 }
		 return gcdIsOne(secondNumber,firstNumber%secondNumber);
	 }
}
