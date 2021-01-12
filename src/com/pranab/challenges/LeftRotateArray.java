package com.pranab.challenges;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class LeftRotateArray {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	int[] indexholder=new int[a.length],result=new int[a.length];
    	int final_rotate_count=d%(a.length);
    	if(final_rotate_count>0) {
    		for(int index=0;index<a.length;index++) {
    			int new_index=(a.length-final_rotate_count+index)%a.length;
    			indexholder[index]=new_index;
    		}
    		for(int index=0;index<a.length;index++) {
    			result[indexholder[index]]=a[index];
    		}
    		return result;
    	}
    	return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    	int[] results = rotLeft(new int[] {1,2,3,4,5}, 54);
    	
    	for(int result:results) {
    		System.out.print(result+",");
    	}
    }
}
