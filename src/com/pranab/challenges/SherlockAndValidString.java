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

class Result86 {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    	Map<String,Integer> map=new HashMap<>();
    	for(String str:s.split("")) {
    		if(map.containsKey(str)) {
    			map.put(str,map.get(str)+1);
    		}else {
    			map.put(str, 1);
    		}
    	}
    	List<Integer> dist=map.values().stream().distinct().collect(Collectors.toList());
    	if(dist.size()>2) {
    		return "NO";
    	}
    	if(dist.size()==1) {
    		return "YES";
    	}
    	int key1=dist.get(0);
    	int key2=dist.get(1);
    	long count1=map.values().stream().filter(a->a==key1).count();
    	long count2=map.values().stream().filter(a->a==key2).count();
    	if(key1>key2) {
    		if(count1==1&&(key1-key2==1)) {
    			return "YES";
    		}else if(count2==1) {
    			return "YES";
    		}
    	}else {
    		if(count2==1&&(key2-key1==1)) {
    			return "YES";
    		}else if(count1==1) {
    			return "YES";
    		}
    	}
    	return "NO";
    }

}

public class SherlockAndValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result86.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
