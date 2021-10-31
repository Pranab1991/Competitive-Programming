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

class Result91 {

	static class TriNode91{
	    boolean isLeaf=false;
	    TriNode91[] charArr=new TriNode91[26];
		int prefixcount=0;
	}
	
	public static final TriNode91 ROOT=new TriNode91();
    
	public static List<Integer> contacts(List<List<String>> queries) {
		List<Integer> preFixCounts=new ArrayList<>();
		for(List query:queries) {
			if("add".equals(query.get(0))) {
				add((String)query.get(1));
			}else {
				preFixCounts.add(find((String)query.get(1)));
			}
		}
    	return preFixCounts;
    }
    
    public static void add(String contact) {
    	TriNode91 temp=ROOT;
    	for(int index=0;index<contact.length();index++) {
    		int charIndex=contact.charAt(index)-97;
    		if(temp.charArr[charIndex]==null) {
    			TriNode91 newTri=new TriNode91();
    			newTri.prefixcount++;
    			temp.charArr[charIndex]=newTri;
    		}else {
    			temp.charArr[charIndex].prefixcount++;
    		}
    		temp=temp.charArr[charIndex];
    	}
    	temp.isLeaf=true;
    }

    public static int find(String prefixString){
    	TriNode91 temp=ROOT;
    	int prefixCount=-1;
    	for(int index=0;index<prefixString.length();index++) {
    		int charIndex=prefixString.charAt(index)-97;
    		temp=temp.charArr[charIndex];
    		if(temp==null) {
    			prefixCount=0;
    			break;
    		}
    	}
    	if(prefixCount==-1) {
    		prefixCount=temp.prefixcount;
    	}
    	return prefixCount;
    }
}

public class Contacts {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result91.contacts(queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
