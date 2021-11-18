package com.pranab.challenges;

import java.util.Scanner;

public class MaximumSumSubArray {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Number of inputs : ");
		int inputs=sc.nextInt();
		int[] inArr=new int[inputs];
		for(int index=0;index<inputs;index++) {
			inArr[index]=sc.nextInt();
		}
		MaxSum out=calculateContiSum(inArr, 0, inArr.length-1);
		System.out.println(out.leftIndex+"   "+out.rightIndex+"   "+out.maxSum);
	}
	
	public static MaxSum calculateContiSum(int[] inArr, int startIndex, int endIndex) {
		if(startIndex==endIndex){
			return new MaxSum(inArr[startIndex],startIndex,endIndex);
		}
		int partition=(startIndex+endIndex)/2;
		MaxSum leftsum=calculateContiSum(inArr, startIndex, partition);
		MaxSum rightSum=calculateContiSum(inArr, partition+1, endIndex);
		MaxSum partitionSum=calculateContiSumPartition(inArr,startIndex,partition,endIndex);
		if(leftsum.maxSum>rightSum.maxSum&&leftsum.maxSum>partitionSum.maxSum) {
			return leftsum;
		}else if(rightSum.maxSum>leftsum.maxSum&&rightSum.maxSum>partitionSum.maxSum) {
			return rightSum;
		}else {
			return partitionSum;
		}
	}

	private static MaxSum calculateContiSumPartition(int[] inArr, int startIndex, int partition, int endIndex) {
		int leftIndex=0;
		int leftSumMax=Integer.MIN_VALUE;
		int rightIndex=0;
		int rightSumMax=Integer.MIN_VALUE;
		int sum=0;
		for(int index=partition;index>=startIndex;index--) {
			sum+=inArr[index];
			if(sum>leftSumMax) {
				leftSumMax=sum;
				leftIndex=index;
			}
		}
		sum=0;
		for(int index=partition+1;index<=endIndex;index++) {
			sum+=inArr[index];
			if(sum>rightSumMax) {
				rightSumMax=sum;
				rightIndex=index;
			}
		}
		return new MaxSum(leftIndex, rightIndex, leftSumMax+rightSumMax);
	}

}

class MaxSum{
	public int leftIndex;
	public int rightIndex;
	public int maxSum;
	public MaxSum(int leftIndex, int rightIndex, int maxSum) {
		super();
		this.leftIndex = leftIndex;
		this.rightIndex = rightIndex;
		this.maxSum = maxSum;
	}	
}