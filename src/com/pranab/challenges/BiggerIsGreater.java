package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
    	String[] numSplit=w.split("");
    	Map<Integer,Integer> map=new HashMap<>();
    	for(int i=numSplit.length-1;i>=0;i--) {
    		checkSwap(numSplit,i,map);
    	}
    	Map.Entry<Integer, Integer> maxEntry=null;
    	for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
    		if(maxEntry==null) {
    			maxEntry=entry;
    		}else {
    			if((entry.getValue().compareTo(maxEntry.getValue()))>0) {
    				maxEntry=entry;
    			}
    			if((entry.getValue().compareTo(maxEntry.getValue()))==0) {
    				if(numSplit[entry.getKey()].compareTo(numSplit[maxEntry.getKey()])<0) {
    					maxEntry=entry;
    					//System.out.println(numSplit[entry.getKey()]);
    				}
    			}
    		}
    	}
    	if(maxEntry!=null) {
    		swapAndSort(numSplit, maxEntry.getKey(), maxEntry.getValue());
    		StringBuilder sb = new StringBuilder();
    		for(String s:numSplit) {
    			sb.append(s); 
    		}
    		//System.out.println(sb.toString()); 
    		return sb.toString();
    	}
    	//System.out.println("no answer");
    	return "no answer";
    } 

    public static void checkSwap( String[] numSplit, int index,Map<Integer,Integer> map) {
    	for(int i=index-1;i>=0;i--) {
    		//System.out.println(index+"&"+i+":"+numSplit[index]+"   "+numSplit[i]+"  "+(numSplit[index].compareTo(numSplit[i])));
    		if((numSplit[index].compareTo(numSplit[i]))>=1) {    			
    			map.put(index, i);
    			break;
    		}
    	}
    }

	private static void swapAndSort(String[] numSplit, int index, int i) {
		String temp=numSplit[index];
		numSplit[index]=numSplit[i];
		numSplit[i]=temp;
		sort(numSplit,i+1);
	}
    
    public static void sort(String[] numSplit, int sortIndex) {
    	//System.out.println(sortIndex);
    	Arrays.sort(numSplit, sortIndex, numSplit.length);
    }
    
   

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(new File("BiggerInput.txt"));
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("outputLarry.txt")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
