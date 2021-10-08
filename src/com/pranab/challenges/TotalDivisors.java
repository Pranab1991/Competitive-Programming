package com.pranab.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TotalDivisors {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Map<Integer,Integer> map=new HashMap<>();
		int noOfPrimes=sc.nextInt();
		while(noOfPrimes>0) {
			map.put(sc.nextInt(), sc.nextInt());
			noOfPrimes--;
		}		
		System.out.println(map.values().stream().reduce(1,(partialMul,nextnum)->partialMul*(nextnum+1)));
		sc.close();
	}
}
