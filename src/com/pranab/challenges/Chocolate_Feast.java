package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result15 {

   

    public static int chocolateFeast(int n, int c, int m) {
    // Write your code here
    	int total_Chocolate=0;
    	total_Chocolate=n/c;
    	int wraffers=total_Chocolate;
    	while(wraffers>=m) {
    		int extraChoco=wraffers/m;
    		int leftwraffes=wraffers%m;
    		total_Chocolate+=extraChoco;
    		wraffers=extraChoco+leftwraffes;
    	}
    	return total_Chocolate;
    }

}

public class Chocolate_Feast {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int c = Integer.parseInt(firstMultipleInput[1]);

            int m = Integer.parseInt(firstMultipleInput[2]);

            int result = Result15.chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
