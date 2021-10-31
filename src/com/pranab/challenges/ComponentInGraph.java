package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result97 {

	private static int[] arr;
	private static int maxIndex=0;
	private static int maxconnection=Integer.MIN_VALUE; 
	private static int minconnection=Integer.MAX_VALUE; 
	public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
		arr = new int[30000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		for(List<Integer> value:gb) {
			merge(value.get(0), value.get(1));
		}
		for(int index=0;index<maxIndex;index++) {
			if(arr[index]<-1) {
				int value=arr[index]*-1;
				if(value>maxconnection) {
					maxconnection=value;
				}
				if(value<minconnection) {
					minconnection=value;
				}
			}
		}
		return Arrays.asList(minconnection,maxconnection);
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
		if (parent == parent2) {
			return;
		}		
		arr[parent2] = arr[parent] + arr[parent2];
		arr[parent] = parent2;
		if(maxIndex<indexTwo) {
			maxIndex=indexTwo;
		}
	}
}

public class ComponentInGraph {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> gb = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				gb.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = Result97.componentsInGraph(gb);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
