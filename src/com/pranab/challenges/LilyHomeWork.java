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

class Result27 {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
    	int deviationsAcending=0;
    	int deviationsDecending=0;
    	List<Integer> resultArr=new ArrayList<>(arr);
    	int arrLength=resultArr.size()-1;
    	quickSort(resultArr,0,arrLength);
    	for(int i=0;i<resultArr.size();i++) {
    		if(arr.get(i)!=resultArr.get(i)) {
    			deviationsAcending++;
    		}
    		if(arr.get(i)!=resultArr.get(arrLength-i)) {
    			deviationsDecending++;
    		}
    	}
    	int swapNum=0;
    	if(deviationsAcending<deviationsDecending) {
    		swapNum=(int) Math.ceil(((double)deviationsAcending)/2);
    	}else {
    		swapNum=(int) Math.ceil(((double)deviationsDecending)/2);
    	}
    	return swapNum;
    }
    
    public static void quickSort(List<Integer> inputArray,int startIndex,int endIndex) {
		if(startIndex>=endIndex) {
			return;
		}
		int key=inputArray.get(startIndex);
		int endPointer=endIndex+1;
		for(int j=(endPointer-1);j>startIndex;j--) {
			if(inputArray.get(j)>key) {
				endPointer--;
				swap(inputArray,j,endPointer);
			}
		}
		int partionIndex=--endPointer;
		swap(inputArray,partionIndex,startIndex);
		quickSort(inputArray,startIndex,partionIndex-1);
		quickSort(inputArray,partionIndex+1,endIndex);
	}

	private static void swap(List<Integer> arr, int i, int j) {
		int temp=arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

}

public class LilyHomeWork {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result27.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    	/*List<Integer> data=Arrays.asList(new Integer[]{3,2,6,4,5,1,7,9,8});
    	Result27.quickSort(data,0,8);
    	System.out.println("done");*/
    }
}
