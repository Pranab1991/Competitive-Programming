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

public class PickNumber {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
    	int max_diff_subarray=0,max_count=0;
    	SortedMap<Integer,Integer> map=new TreeMap<>();
    	for(int key:a) {
    		if(!map.containsKey(key)) {
    			map.put(key, 1);
    		}else {
    			map.put(key,(map.get(key)+1));
    		}
    	}
    	SortedMap.Entry<Integer,Integer> previous=null;
    	for(SortedMap.Entry<Integer,Integer> data:map.entrySet()) {
    		if(data.getValue()>max_count) {
    			max_count=data.getValue();
    		}
    		if(previous==null) {
    			previous=data;
    			continue;
    		}else if(data.getKey()-previous.getKey()==1) {
    			int sub_array=data.getValue()+previous.getValue();
    			if(sub_array>max_diff_subarray) {
    				max_diff_subarray=sub_array;
    			}
    		}    		
    		previous=data;
    	}
    	return max_count>max_diff_subarray? max_count: max_diff_subarray;
    }
    


    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    	
    	List<Integer> list=Arrays.asList(66, 66, 66, 66, 66, 66, 66, 66, 66, 66);
    	System.out.println(pickingNumbers(list));
    }
}
