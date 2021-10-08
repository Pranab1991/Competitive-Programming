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

class Result25 {    
    public static List<Integer> quickSort(List<Integer> arr) {
    	swap(arr, 0, arr.size()-1);
    	int i=-1;
    	int key=arr.get(arr.size()-1);
    	for(int j=0;j<(arr.size()-1);j++) {
    		if(arr.get(j)<key) {
    			i++;
    			swap(arr,i,j);
    		}
    	}
    	swap(arr,++i,arr.size()-1);
        return arr;
    }
	private static void swap(List<Integer> arr, int i, int j) {
		int temp=arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
}

public class QuickPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result25.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
