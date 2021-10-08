package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AbsolutePermutation {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {

    	int[] output=null;
    	if(k==0) {
    		output=new int[n];
    		for(int i=0;i<n;i++) {
    			output[i]=i+1;
    		}
    		return output;
    	}
    	int kDivider=2*k;
    	int multiplier=1;
    	if(n%kDivider==0) {
    		output=new int[n];
    		for(int i=0;i<n;i+=k) {    			
    			for(int j=i;j<i+k;j++) {
    				output[j]=j+1+(k*multiplier);
    			}
    			multiplier=multiplier*-1;
    		}
    	}else {
    		output=new int[] {-1};
    	}
    	return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("outputLarry.txt")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

