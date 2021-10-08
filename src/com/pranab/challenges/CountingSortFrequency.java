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

class Result24 {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    	List<Integer> counterArr=new ArrayList<Integer>();
    	List<Integer> resultArr=new ArrayList<Integer>(arr.size());
    	for(int i=0;i<arr.size();i++) {
    		resultArr.add(0);
    	}
    	for(int i=0;i<100;i++) {
    		counterArr.add(0);
    	}
    	for(int num:arr) {
    		int val=counterArr.get(num);
    		counterArr.set(num, ++val);
    	}
    	for(int i=1;i<counterArr.size();i++) {
    		int val=counterArr.get(i-1);
    		int val2=counterArr.get(i);
    		counterArr.set(i,(val+val2));
    	}
    	for(int num:arr) {
    		int resultIndexPosition=counterArr.get(num);
    		resultArr.set(resultIndexPosition-1, num);
    		counterArr.set(num, --resultIndexPosition);
    	}
    	return resultArr;
    }

}

public class CountingSortFrequency {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result24.countingSort(arr);

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
