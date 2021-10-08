package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Goti {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
    	Map<String,Integer> map=new HashMap<>();
    	String[] input=s.split("");
    	for(String str:input) {
    		if(map.containsKey(str)) {
    			map.put(str,(map.get(str)+1));
    		}else {
    			map.put(str, 1);
    		}
    	}
    	boolean found=false;
    	for(Map.Entry<String, Integer> entry:map.entrySet()) {
    		if(entry.getValue()%2==0) {
    			continue;
    		}else {
    			if(!found) {
    				found=true;
    			}else {
    				return "NO";
    			}
    		}
    	}
    	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
