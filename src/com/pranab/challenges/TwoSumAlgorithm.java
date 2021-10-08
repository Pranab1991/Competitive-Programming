package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSumAlgorithm {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(new File("prob2sum.txt"));
		Set<Long> dataStore=new HashSet<>();
		while(scan.hasNext()) {
			dataStore.add(scan.nextLong());
		}
		int targetsmeet=0;
		for(int i=-10000;i<=10000;i++) {
			for(long num:dataStore) {
				long lookup=i+num;
				if(dataStore.contains(lookup)) {
					targetsmeet++;
					break;
				}
			}
		}
		System.out.println(targetsmeet);
	}
}
