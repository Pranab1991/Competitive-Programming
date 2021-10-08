package com.pranab.challenges;

import java.util.Scanner;

public class Seives {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Range : ");
		int range=sc.nextInt();
		System.out.println("Queries : ");
		int queries=sc.nextInt();
		int[] queryList=new int[queries];
		System.out.println("Queries entry : ");
		for(int i=0;i<queries;i++) {
			queryList[i]=sc.nextInt();
		}
		sieves(range,queryList);
	}
	
	public static void sieves(int range,int[] queries) {
		int[] seivesArray=new int[range];
		seivesArray[0]=1;seivesArray[1]=1;
		int index=2;
		while((index*index)<range) {
			if(seivesArray[index]==0) {
				for(int looperIndex=index*index;looperIndex<range;looperIndex+=index) {
					seivesArray[looperIndex]=1;
				}
			}
			index++;
		}
		for(int i=0;i<queries.length;i++) {
			if(seivesArray[queries[i]]==0) {
				System.out.println(queries[i]+" is PRIME");
			}else {
				System.out.println(queries[i]+" is NOT PRIME");
			}
		}
	}
}
