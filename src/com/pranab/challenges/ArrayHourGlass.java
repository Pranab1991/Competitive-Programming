package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayHourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int max_hour_glass=0;
    	boolean first=true;
    	for(int i=0;i<4;i++) {
    		for(int j=0;j<4;j++) {
    			int sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+
    					arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
    			if(first) {
    				max_hour_glass=sum;
    				first=false;
    			}else if(sum>max_hour_glass) {
    				max_hour_glass=sum;
    			}
    		}
    	}
    	return max_hour_glass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    	int[][] arr= {{-1, -1, 0, -9, -2, -2},
    				  {-2, -1, -6, -8, -2, -5},
    				  {-1, -1, -1, -2, -3, -4},
    				  {-1, -9, -2, -4, -4, -5},
    				  {-7, -3, -3, -2, -9, -9},
    				  {-1, -3, -1, -2, -4, -5}};
    	System.out.println(hourglassSum(arr));
    }
}
