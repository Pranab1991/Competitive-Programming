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

class Result12 {

	/*
	 * Complete the 'workbook' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER k 3. INTEGER_ARRAY arr
	 */

	public static int workbook(int n, int k, List<Integer> arr) {
		// Write your code here
		int pageNum = 0;
		int specialNum=0;
		for (int problems : arr) {
			String result=checkspecial(problems, pageNum, k);
			String[] results=result.split(",");
			specialNum+=Integer.parseInt(results[0]);
			pageNum=Integer.parseInt(results[1]);
		}
		return specialNum;
	}

	private static String checkspecial(int problems, int pageNum, int maxProbInPage) {
		int startproblem = 1, endproblem = (startproblem + maxProbInPage - 1),specialCounter=0;
		for (; endproblem <= problems; startproblem += maxProbInPage, endproblem = (startproblem + maxProbInPage - 1)) {
			pageNum++;
			if(isSpecial(startproblem,endproblem,pageNum)) {
				specialCounter++;
			}
		}

		if ((problems - startproblem+1) != 0) {
			endproblem=problems;
			pageNum++;
			if(isSpecial(startproblem,endproblem,pageNum)) {
				specialCounter++;
			}
		}
		return ""+specialCounter+","+pageNum;
	}

	private static boolean isSpecial(int startproblem, int endproblem, int pageNum) {
		if(pageNum>=startproblem&&pageNum<=endproblem) {
			return true;
		}else {
			return false;
		}
	}

}

public class Lisa_WorkBook {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = Result12.workbook(n, k, arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
