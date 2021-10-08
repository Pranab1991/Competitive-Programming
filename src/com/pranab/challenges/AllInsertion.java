package com.pranab.challenges;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 class Result23 {

    public static int runningTime(List<Integer> arr){
    	Integer[] A=new Integer[arr.size()];
    	arr.toArray(A);
        int shifts=0;
    	for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
                shifts++;
            }
            A[j + 1] = value;
        }
        return shifts;
    }
    
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    
}


public class AllInsertion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result23.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}