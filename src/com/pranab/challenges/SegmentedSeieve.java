package com.pranab.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSeieve {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("The lower number of the range : ");
		int lowerNumberOfTheRange=sc.nextInt();
		System.out.println("The higher number of the range : ");
		int higherrNumberOfTheRange=sc.nextInt();
		List<Integer> primeDivisors=calculateThePrimDivisorTillSqrtOfHigherNum(higherrNumberOfTheRange);
		segmentedSieve(primeDivisors,lowerNumberOfTheRange,higherrNumberOfTheRange);
	}

	private static List<Integer> segmentedSieve(List<Integer> primeDivisors, int lowerNumberOfTheRange,
			int higherrNumberOfTheRange) {
		List<Integer> primesInTheSegment=new ArrayList<>();
		boolean[] segmentedSieveArray=new boolean[higherrNumberOfTheRange-lowerNumberOfTheRange+1];
		for(int primeDivisor:primeDivisors) {
			int startquotent=lowerNumberOfTheRange/primeDivisor;
			int startNumber=startquotent*primeDivisor;
			if(startNumber<lowerNumberOfTheRange) {
				startNumber+=primeDivisor;
			}
			for(;startNumber<=higherrNumberOfTheRange;startNumber+=primeDivisor) {
				int index=startNumber-lowerNumberOfTheRange;
				segmentedSieveArray[index]=true;
			}
		}
		int index=0;
		for(boolean numberIndicator:segmentedSieveArray) {
			if(!numberIndicator) {
				primesInTheSegment.add(index+lowerNumberOfTheRange);
			}
			index++;
		}
		return primesInTheSegment;
	}

	private static List<Integer> calculateThePrimDivisorTillSqrtOfHigherNum(int higherrNumberOfTheRange) {
		List<Integer> primeDivisors=new ArrayList<>();
		int sqrt=2;
		for(;sqrt*sqrt<=higherrNumberOfTheRange;sqrt++);
		boolean[] sieveToFinThePrimes=new boolean[sqrt+1];
		sieveToFinThePrimes[0]=sieveToFinThePrimes[1]=true;
		for(int index=2;index<=sqrt;index++) {
			if(!sieveToFinThePrimes[index]) {
				primeDivisors.add(index);
				for(int startIndex=index*2;startIndex<=sqrt;startIndex+=index){
					sieveToFinThePrimes[startIndex]=true;
				}
			}
		}
		return primeDivisors;
	}
}
