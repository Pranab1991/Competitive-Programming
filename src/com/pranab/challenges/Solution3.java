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

class Result3 {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    	Collections.sort(h);
    	int maxRect=0;
    	int buildingLength=h.size();
    	for(int height:h) {
    		int rectArea=height*buildingLength;
    		if(rectArea>maxRect) {
    			maxRect=rectArea;
    		}
    		buildingLength--;
    	}
    	
    	return maxRect;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result3.largestRectangle(h);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
