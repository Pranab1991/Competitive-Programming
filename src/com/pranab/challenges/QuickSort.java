package com.pranab.challenges;

import java.io.*;
import java.util.*;

public class QuickSort {
	
	public static final Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        sc.nextLine();
        String input=sc.nextLine();
        String[] inputArray=input.split(" ");
        Integer[] intArr=new Integer[inputArray.length];
        int counter=0;
        for(String num:inputArray) {
        	intArr[counter]=Integer.parseInt(num);
        	counter++;
        }
        quickSort(intArr,0,(intArr.length-1));
        bufferedWriter.close();
    }
	
	public static void quickSort(Integer[] inputArray,int startIndex,int endIndex) {
		if(startIndex==endIndex) {
			return;
		}
		int key=inputArray[startIndex];
		int endPointer=endIndex+1;
		for(int j=(endPointer-1);j>startIndex;j--) {
			if(inputArray[j]>key) {
				endPointer--;
				swap(inputArray,j,endPointer);
			}
		}
		int partionIndex=--endPointer;
		swap(inputArray,partionIndex,startIndex);
		
		int lowerpartition=partionIndex-1;
		if(lowerpartition<startIndex) {
			lowerpartition=startIndex;
		}
		quickSort(inputArray,startIndex,lowerpartition);
		int higherPartition=partionIndex+1;
		if(higherPartition>endIndex) {
			higherPartition=endIndex;
		}
		quickSort(inputArray,higherPartition,endIndex);
		printArray(inputArray,0,inputArray.length);
	}
	
	private static void printArray(Integer[] inputArray, int startIndex, int endIndex) {
		for(int i=startIndex;i<endIndex;i++) {
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
	}

	private static void swap(Integer[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}
}
