package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinWeightIndependentSet {

	public static void main(String[] args) throws FileNotFoundException {
		List<Integer> storage=readInfo();
		int[] sol=mwisBottomUp(storage);
		int[] index= {1, 2, 3, 4, 17, 117, 517, 997};
		for(int i:index) {
			if(storage.get(i-1)==sol[i]) {
				System.out.println(true);
			}else {
				System.out.println(false);
			}
		}
	}
	
	public static List<Integer> readInfo() throws FileNotFoundException{
		Scanner scan=new Scanner(new File("mwis.txt"));
		int weightCount=scan.nextInt();
		List<Integer> storage=new ArrayList<>();
		while(scan.hasNext()) {
			storage.add(scan.nextInt());
		}
		return storage;
	}
	
	public static int[] mwisBottomUp(List<Integer> storage) {
		int[] subproblemSum=new int[storage.size()+1];
		int[] subproblemRecreation=new int[storage.size()+1];
		subproblemSum[0]=0;
		subproblemRecreation[0]=0;
		subproblemSum[1]=storage.get(0);
		subproblemRecreation[1]=storage.get(0);
		for(int i=1;i<storage.size();i++) {
			int alterSum=subproblemSum[i-1]+storage.get(i);
			boolean alterSumIndicator=false;
			int sum=0;
			if(alterSum>=subproblemSum[i]) {
				sum=alterSum;
				alterSumIndicator=true;
			}else {
				sum=subproblemSum[i];
			}
			if(alterSumIndicator) {
				subproblemRecreation[i+1]=storage.get(i);
			}else {
				subproblemRecreation[i+1]=storage.get(i-1);
			}
			subproblemSum[i+1]=sum;
		}
		for(int j=subproblemRecreation.length-1;j>=0;j-=2) {
			subproblemRecreation[j]=-1;
		}
		return subproblemRecreation;
	}
}
