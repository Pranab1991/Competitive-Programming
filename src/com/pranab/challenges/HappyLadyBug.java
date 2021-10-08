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

class Result8 {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    	String result="NO";
    	String bug_pattern = "^[A-Z_]+$";
    	if(!b.matches(bug_pattern)) {
    		return result;
    	}
    	Map<String,Integer> ladyBugCollector=new HashMap<>();
    	String[] ladybugs=b.split("");
    	String prevLadyBug="";
    	int counter=0;
    	for(String ladyBug:ladybugs) {
    		if(ladyBugCollector.containsKey(ladyBug)) {
    			ladyBugCollector.put(ladyBug,ladyBugCollector.get(ladyBug)+1);
    		}else {
    			ladyBugCollector.put(ladyBug, 1);
    		}    		
    	}
    	
    
    	if(ladyBugCollector.containsKey("_")) {
    		result="YES";
    		ladyBugCollector.remove("_");
    	}else {
    		result="YES";
    		for(String ladyBug:ladybugs) {
        		if(counter==0) {
        			prevLadyBug=ladyBug;
        			counter++;
        		}else {
        			if(ladyBug.equals(prevLadyBug)) {
        				counter++;
        			}else {
        				if(counter==1) {
        					result="NO";
        					return result;
        				}
        				prevLadyBug=ladyBug;
        				counter=1;
        			}
        		}
        	}
    	}
    	for(Integer value:ladyBugCollector.values()) {
    		if(value==1) {
    			result="NO";
    		}
    	}
    	return result;
    }

}

public class HappyLadyBug {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result8.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
