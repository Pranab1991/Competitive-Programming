package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Hackerrank {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
    	Queue<String> queue=new LinkedList<>();
    	queue.add("h");
    	queue.add("a");
    	queue.add("c");
    	queue.add("k");
    	queue.add("e");
    	queue.add("r");
    	queue.add("r");
    	queue.add("a");
    	queue.add("n");
    	queue.add("k");
    	
    	String[] strings=s.split("");
    	String search=queue.poll();
    	for(String string:strings) {
    		if(search.equals(string)) {
    			if(!queue.isEmpty()) {
    				search=queue.poll();
    			}else {
    				return "YES";
    			}
    		}
    	}
    	
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
