package com.pranab.challenges;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOnStreamUsingHeap {
	
	public static PriorityQueue<Integer> minQueue=new PriorityQueue<>();
	public static PriorityQueue<Integer> maxQueue=new PriorityQueue<>((o1,o2)-> {
			return -1*o1.compareTo(o2);
		});
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("medianInput.txt"));
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		if(num1>num2) {
			minQueue.add(num1);
			maxQueue.add(num2);
		}else {
			minQueue.add(num2);
			maxQueue.add(num1);
		}
		
		double medianSum=((double)num1)+((num1+num2)/2d);
		while(scanner.hasNextInt())
		{
			double result=calculateMedian(scanner.nextInt());
			medianSum+=result;
		}
		
		System.out.println(medianSum%10000);
		int sum=0;
		for(int i=1;i<1000000;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	public static double calculateMedian(int num) {
		if(num>minQueue.peek()) {
			minQueue.add(num);
		}else if(num<maxQueue.peek()) {
			maxQueue.add(num);
		}else {
			minQueue.add(num);
		}
		
		int sizeDiff=minQueue.size()-maxQueue.size();
		if(sizeDiff==2) {
			maxQueue.add(minQueue.poll());
		}else if(sizeDiff==-2) {
			minQueue.add(maxQueue.poll());
		}
		
		int medianNum=minQueue.size()-maxQueue.size();
		
		if(medianNum==1) {
			return minQueue.peek();
		}else if(medianNum==-1) {
			return maxQueue.peek();
		}else {
			return (minQueue.peek()+maxQueue.peek())/2d;
		}
	}
}
