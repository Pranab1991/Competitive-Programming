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

class Result50 {

   
    public static int alternate(String s) {
     List<String> uniqueStringSet=new ArrayList<>();
     int maxStrLen=0;
     for(String stringUnit:s.split("")){
         if(!uniqueStringSet.contains(stringUnit)) {
        	 uniqueStringSet.add(stringUnit);
         }
     }
     
     for(int index=0;index<uniqueStringSet.size();index++) {
    	 for(int secIndex=index+1;secIndex<uniqueStringSet.size();secIndex++) {
    		 int strLen=deleteRestAndFind(uniqueStringSet.get(index),uniqueStringSet.get(secIndex),s);
    		 if(strLen>maxStrLen) {
    			 maxStrLen=strLen;
    		 }
    	 }
     }
     return maxStrLen;
    }

	private static int deleteRestAndFind(String string, String string2,String s) {
		int count=0;
		boolean toggle=true;
		for(String eachString:s.split("")) {
			if(toggle) {
				if(eachString.equals(string)) {
					count++;
					toggle=!toggle;
				}
				else if(eachString.equals(string2)) {
					return -1;
				}
				else {
					continue;
				}
			}else {
				if(eachString.equals(string2)) {
					count++;
					toggle=!toggle;
				}
				else if(eachString.equals(string)) {
					return -1;
				}
				else {
					continue;
				}
			}
		}
		return count;
	}

}

public class TwoCharecter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result50.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
