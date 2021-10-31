package com.pranab.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MergingCommunities {
	 	private static int[] arr;
	    private static Map<Integer, Integer> map = new HashMap<>();

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int arrSize = sc.nextInt();
	        arr = new int[arrSize];
	        for (int i = 0; i < arrSize; i++) {
	            arr[i] = i;
	            map.put(i, 1);
	        }
	        int queries = sc.nextInt();
	        while (queries > 0) {
	            String input = sc.next(Pattern.compile("Q|M"));
	            if ("Q".equals(input)) {
	                int Qinput = sc.nextInt();
	                System.out.println(query(Qinput));
	            } else {
	                int Minput = sc.nextInt();
	                int Minput2 = sc.nextInt();
	                merge(Minput, Minput2);
	            }
	            queries--;
	        }
	    }

	    private static int query(int index) {
	        int findVal = find(index);
	        return map.get(findVal);
	    }

	    private static int find(int index) {
	        index--;
	        while (index != arr[index]) {
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
	        arr[parent] = parent2;
	        map.put(parent2,(map.get(parent2)+map.get(parent)));
	        map.remove(parent);
	    }
	
}
