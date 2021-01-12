package com.pranab.challenges;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SocksPair {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pair_count=0;
    	Map<Integer,Integer> socks=new HashMap<>();
        for(int color:ar) {
        	if(!socks.containsKey(color)) {
        		socks.put(color,1);
        	}else {
        		socks.put(color, (socks.get(color)+1));
        	}
        }
        for(Map.Entry<Integer,Integer> sock:socks.entrySet()) {
        	int pairs=sock.getValue()/2;
        	if(pairs>=1) {
        		pair_count+=pairs;
        	}
        }
        return pair_count;
    }

    private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
	   /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
	   System.out.println(sockMerchant(9,new int[]{10,20,20,10,10,30,50,10,20}));
    }
}
