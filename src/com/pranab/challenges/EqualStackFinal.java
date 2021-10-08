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

class Result5 {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    	Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>(), stack3 = new Stack<>();
        int stack_height_1 = 0, stack_height_2 = 0, stack_height_3 = 0;
        for (int index = h1.size()-1; index >= 0; index--) {
            stack1.push(h1.get(index));
            stack_height_1 += h1.get(index);
        }
        for (int index = h2.size() - 1; index >= 0; index--) {
            stack2.push(h2.get(index));
            stack_height_2 += h2.get(index);
        }
        for (int index = h3.size() - 1; index >= 0; index--) {
            stack3.push(h3.get(index));
            stack_height_3 += h3.get(index);
        }
        return stacksHeightCalculator(stack1, stack_height_1, stack2, stack_height_2, stack3, stack_height_3);
    }

	private static int stacksHeightCalculator(Stack<Integer> stack1, int stack_height_1, Stack<Integer> stack2,
			int stack_height_2, Stack<Integer> stack3, int stack_height_3) {
		boolean isEqualStack=false;
		int min_stack_height=findMinimum(stack_height_1,stack_height_2,stack_height_3);		
		while(!isEqualStack) {
			if(!(stack_height_1==stack_height_2&&stack_height_2==stack_height_3)) {
				while(stack_height_1>min_stack_height) {
					int element=stack1.pop();
					stack_height_1-=element;
				}
				while(stack_height_2>min_stack_height) {
					int element=stack2.pop();
					stack_height_2-=element;
				}
				while(stack_height_3>min_stack_height) {
					int element=stack3.pop();
					stack_height_3-=element;
				}
			}else {
				isEqualStack=true;				
			}
			min_stack_height=findMinimum(stack_height_1,stack_height_2,stack_height_3);
		}
		
		return min_stack_height;
	}
	
	private static int findMinimum(int stack_height_1,int stack_height_2,int stack_height_3) {
		if((stack_height_1<=stack_height_2)&&(stack_height_1<=stack_height_3)) {
			return stack_height_1;
		}else if((stack_height_2<=stack_height_1)&&(stack_height_2<=stack_height_3)) {
			return stack_height_2;
		}else {
			return stack_height_3;
		}
	}

}

public class EqualStackFinal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Output.txt")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result5.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
