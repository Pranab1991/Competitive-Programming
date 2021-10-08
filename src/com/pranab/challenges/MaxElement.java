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

class Result4 {

	/*
	 * Complete the 'getMax' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * STRING_ARRAY operations as parameter.
	 */

	public static List<Integer> getMax(List<String> operations) {
		// Write your code here
		List<Integer> maxList = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (String operation : operations) {
			String[] operand = operation.split(" ");
			if ("1".equals(operand[0])) {
				int num=Integer.parseInt(operand[1]);
				stack.push(num);
				if(num>max) {
					max=num;
				}
			} else if ("2".equals(operand[0])) {
				if (stack.isEmpty() == false) {
					int num=stack.pop();
					if(num==max) {
						max=0;
						for(int nums:stack) {
							if (nums > max) {
								max = nums;
							}
						}
					}
				}
			} else if ("3".equals(operand[0])) {
				maxList.add(max);
			}
		}
		return maxList;
	}

}

public class MaxElement {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> ops = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<Integer> res = Result4.getMax(ops);

		System.out.println(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
	}
}
