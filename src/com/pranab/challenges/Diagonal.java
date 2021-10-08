package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    long[] arr=new long[n];
        for(List<Integer> listval:queries) {
            /*long adder=listval.get(2);
            for(int start=listval.get(0)-1;start<=(listval.get(1)-1);start++) {
                arr[start]+=adder;
            }*/
        	long adder=listval.get(2);
        	arr[listval.get(0)-1]+=adder;
        	//if (listval.get(1) != n) {
        		arr[listval.get(1)]-=adder;
        	//}
        }
        long max=0;
        for(long a:arr) {
            if(a>max) {
                max=a;
            }
        }
        System.out.println("max :"+max);
        return max;
    }

}

public class Diagonal {
    public static void main(String[] args) throws IOException {
    	LocalTime startime=LocalTime.now();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Input.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Output.txt")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        LocalTime endTime=LocalTime.now();
        System.out.println("Duration : "+Duration.between(startime, endTime).getSeconds());
    }
}
