package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumBribe {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		boolean isDeviated = false, first = true;
		int previous = 0;
		int bribes = 0;
		for (int index = 0; index < q.length; index++) {
			int deviation = q[index] - (index + 1);
			if (deviation > 2) {
				isDeviated = true;
				break;
			}
			if (deviation > 0) {
				bribes += deviation;
				q[index] = 0;
			}
		}

		for (int index = 0; index < q.length; index++) {
			if (q[index] != 0 && first) {
				previous = q[index];
				first = false;
				continue;
			}
			if (q[index] != 0) {
				if (previous < q[index]) {
					previous = q[index];
				} else {
					bribes++;
					previous = q[index];
				}
			}
		}
		if (isDeviated) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(bribes);
		}

	}

	static void minimumBribes2(int[] q) 
	{
	    int n = q.length;
	    int cnt = 0;
	    for(int i = n - 1; i >= 0; i--)
	    {
	        if(q[i] != (i + 1))
	        {
	            if(((i - 1) >= 0) && q[i - 1] == (i + 1))
	            {
	                cnt++;
	                int temp=q[i];
	                q[i]=q[i-1];
	                q[i-1]=temp;
	            }
	            else if(((i - 2) >= 0) && q[i - 2] == (i + 1))
	            {
	                cnt += 2;
	                q[i - 2] = q[i - 1];
	                q[i - 1] = q[i];
	                q[i] = i + 1;
	            }
	            else
	            {
	                System.out.println("Too chaotic\n");
	                return;
	            }
	        }      
	    }
	    System.out.println(cnt);
	    return;
	}
	

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes2(q);
		}

		scanner.close();

	}
}
