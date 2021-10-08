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

class Result6 {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

    public static long strangeCounter(long t) {
    	long counter=0,timer=3,adder=3;
    	for( ;timer<t;adder*=2,timer+=adder,counter++) {    		
    		//System.out.println("timer : "+timer);
    		//System.out.println("counter : "+counter);
    	}
    	timer-=adder;
    	long lefttime=t-timer;
    	//System.out.println(counter);
    	long result2Mul= (long)Math.pow(2, counter);
    	//System.out.println("result2Mul"+result2Mul);
    	long value=(result2Mul*3)-lefttime+1;
    	//System.out.println(value);
    	return value;
    }

}

public class StrangeCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result6.strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
