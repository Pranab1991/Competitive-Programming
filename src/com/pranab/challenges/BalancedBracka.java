package com.pranab.challenges;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBracka {

    
    static String isBalanced(String s) {
    	boolean loopBreak=false;
    	Stack<Character> stack=new Stack<>();
    	if(s.length()%2==0&&s.length()>0) {
    		
    		Map<Character,Character> mapValues=new HashMap<>();
    		mapValues.put(')', '(');
    		mapValues.put(']', '[');
    		mapValues.put('}', '{');
    		for(int index=0;index<s.length();index++) {
    			if(mapValues.containsKey(s.charAt(index))) {
    				try {
    					char rightVal=stack.pop();
    					if(rightVal!=mapValues.get(s.charAt(index))) {
        					loopBreak=true;
        					break;
        				}
    				}catch(EmptyStackException e){
    					loopBreak=true;
    					break;
    				}
    				
    			}else {
    				stack.push(s.charAt(index));
    			}
    		}    
    	}else {
    		loopBreak=true;
    	}
    	if(loopBreak||stack.size()>0) {
    		return "NO";
    	}else {
    		return "YES";
    	}
    }

    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputall.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
