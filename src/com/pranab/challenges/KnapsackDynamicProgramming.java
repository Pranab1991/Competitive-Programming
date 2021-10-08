package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapsackDynamicProgramming {

	public static void main(String args[]) {
		try {
			int[][] soultion=solveKanpSack(read());
			/*for(int i=soultion.length-1;i>=0;i--) {
				for(int j=0;j<soultion[0].length;j++) {
					System.out.print(soultion[i][j]+", ");
				}
				System.out.println();
			}*/
			System.out.println("soultion : "+soultion[soultion.length-1][soultion[0].length-1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Problem read() throws FileNotFoundException {
		Scanner scan=new Scanner(new File("knapsack1.txt"));
		Problem problem=new Problem();
		problem.sackSize=scan.nextInt();
		problem.items=new Item[scan.nextInt()];
		int count=0;
		while(scan.hasNext()) {			
			Item item=new Item(scan.nextInt(),scan.nextInt());
			problem.items[count]=item;
			count++;
		}
		return problem;
	}
	
	public static int[][] solveKanpSack(Problem problem){
		int[][] twoDArray=new int[problem.sackSize+1][problem.items.length+1];
		for(int w=1;w<=problem.sackSize;w++) {
			for(int i=1;i<=problem.items.length;i++) {
				int valueWithCurrentItemNotIncluded=twoDArray[w][i-1];
				int valueWithCurrentItemIncluded=-1;
				Item currentItem=problem.items[i-1];
				if(!(currentItem.weight>w)) {
					valueWithCurrentItemIncluded=twoDArray[w-(currentItem.weight)][i-1]+currentItem.value;
				}
				twoDArray[w][i]=Math.max(valueWithCurrentItemNotIncluded, valueWithCurrentItemIncluded);
			}
		}
		return twoDArray;
	}
	
}

class Problem{
	public int sackSize;
	public Item[] items;
}

class Item{
	public int value;
	public int weight;
	public Item(int value, int weight) {
		super();
		this.value = value;
		this.weight = weight;
	}
	
}