package com.pranab.challenges;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MergingCommunitiesArray {

	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder builder=new StringBuilder();
		int arrSize = sc.nextInt();
		arr = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = -1;
		}
		int queries = sc.nextInt();
		while (queries > 0) {
			String input = sc.next(Pattern.compile("Q|M"));
			if ("Q".equals(input)) {
				int Qinput = sc.nextInt();
				builder.append(query(Qinput)+"\n");
			} else {
				int Minput = sc.nextInt();
				int Minput2 = sc.nextInt();
				merge(Minput, Minput2);
			}
			queries--;
		}
		System.out.println(builder.toString());
	}

	private static int query(int index) {
		int findVal = find(index);
		return -1 * arr[findVal];
	}

	private static int find(int index) {
		index--;
		while (arr[index] >= 0) {
			index = arr[index];
		}
		return index;
	}
	
	   private static void merge(int indexOne, int indexTwo) {
	        int parent = find(indexOne);
	        int parent2 = find(indexTwo);
	        if(parent==parent2) {
	            return;
	        }
	        arr[parent2] = arr[parent]+arr[parent2];
	        arr[parent] = parent2;
	    }
}
