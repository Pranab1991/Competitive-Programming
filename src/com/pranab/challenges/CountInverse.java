package com.pranab.challenges;

import java.util.Scanner;

public class CountInverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("The number of inputs");
		int input=sc.nextInt();
		int[] inArray=new int[input];
		for(int index=0;index<input;index++) {
			inArray[index]=sc.nextInt();
		}
		System.out.println(countInversions(inArray, 0, inArray.length-1));
	}
	
	public static int countInversions(int[] inArray,int start,int end) {
		if(start==end) {
			return 0;
		}
		int partition=(start+end)/2;
		int leftInversions=countInversions(inArray, start, partition);
		int rightInversions=countInversions(inArray, partition+1, end);
		int splitInversions=mergeSortCountInversion(inArray,start,partition,end);
		return leftInversions+rightInversions+splitInversions;
	}

	private static int mergeSortCountInversion(int[] inArray, int start, int partition, int end) {
		int inversion=0;
		int[] leftArr=new int[partition-start+1];
		int[] rightArr=new int[end-partition];
		for(int index=0,temp=start;index<leftArr.length;index++,temp++) {
			leftArr[index]=inArray[temp];
		}
		partition++;
		for(int index=0,temp=partition;index<rightArr.length;index++,temp++) {
			rightArr[index]=inArray[temp];
		}
		int index=start,i=0,j=0;
		for(;index<=end;index++) {
			if(i==leftArr.length||j==rightArr.length) {
				break;
			}
			if(leftArr[i]<rightArr[j]) {
				inArray[index]=leftArr[i];
				i++;
			}else {
				inArray[index]=rightArr[j];
				j++;
				inversion+=leftArr.length-i;
			}
		}
		if(i==leftArr.length) {
			for(;index<=end;index++) {
				inArray[index]=rightArr[j];
				j++;
			}
		}
		if(j==rightArr.length) {
			for(;index<=end;index++) {
				inArray[index]=leftArr[i];
				i++;
			}
		}
		return inversion;
	}
}
