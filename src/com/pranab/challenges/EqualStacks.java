package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class EqualStacks {

	/*
	 * Complete the equalStacks function below.
	 */
	static int equalStacks(int[] h1, int[] h2, int[] h3) {
		Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>(), stack3 = new Stack<>();
		int stack_height_1 = 0, stack_height_2 = 0, stack_height_3 = 0;
		for (int index = h1.length - 1; index >= 0; index--) {
			stack1.push(h1[index]);
			stack_height_1 += h1[index];
		}
		for (int index = h2.length - 1; index >= 0; index--) {
			stack2.push(h2[index]);
			stack_height_2 += h2[index];
		}
		for (int index = h3.length - 1; index >= 0; index--) {
			stack3.push(h3[index]);
			stack_height_3 += h3[index];
		}

		return stacksHeightCalculator(stack1, stack_height_1, stack2, stack_height_2, stack3, stack_height_3);
	}

	static int stacksHeightCalculator(Stack<Integer> stack1, int stack_height_1, Stack<Integer> stack2,
			int stack_height_2, Stack<Integer> stack3, int stack_height_3) {

		if (stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3) {
			return stack_height_1;
		}

		if (stack_height_1 == 0 || stack_height_2 == 0 || stack_height_3 == 0) {
			return 0;
		}
		/*int cylinder_1 = stack1.pop(), cylinder_2 = stack2.pop(), cylinder_3 = stack3.pop();
		stack_height_1 -= cylinder_1;
		stack_height_2 -= cylinder_2;
		stack_height_3 -= cylinder_3;*/
		int cylinder_1=0,cylinder_2=0,cylinder_3=0;
		if(stack_height_1<=stack_height_2&&stack_height_1<=stack_height_3) {
			while(stack_height_1<stack_height_2) {
				cylinder_2=stack2.pop();
				stack_height_2-=cylinder_2;
			}			
			while(stack_height_1<stack_height_3) {
				cylinder_3=stack3.pop();
				stack_height_3-=cylinder_3;
			}
			if(!(stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3)) {
				cylinder_1=stack1.pop();
				stack_height_1-=cylinder_1;
			}
		}else if(stack_height_2<=stack_height_1&&stack_height_2<=stack_height_3) {
			while(stack_height_2<stack_height_1) {
				cylinder_1=stack1.pop();
				stack_height_1-=cylinder_1;
			}			
			while(stack_height_2<stack_height_3) {
				cylinder_3=stack3.pop();
				stack_height_3-=cylinder_3;
			}
			if(!(stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3)) {
				cylinder_2=stack2.pop();
				stack_height_2-=cylinder_2;
			}
		}else {
			while(stack_height_3<stack_height_1) {
				cylinder_1=stack1.pop();
				stack_height_1-=cylinder_1;
			}			
			while(stack_height_3<stack_height_2) {
				cylinder_2=stack2.pop();
				stack_height_2-=cylinder_2;
			}
			if(!(stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3)) {
				cylinder_3=stack3.pop();
				stack_height_3-=cylinder_3;
			}
		}
		if (stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3) {
			return stack_height_1;
		}
		if (cylinder_1 >= cylinder_2 && cylinder_1 >= cylinder_3) {
			int poped_cylinder_2 = 0;
			while (stack_height_2 > stack_height_1) {
				poped_cylinder_2 = stack2.pop();
				stack_height_2 -= poped_cylinder_2;
			}
			int poped_cylinder_3 = 0;
			while (stack_height_3 > stack_height_1) {
				poped_cylinder_3 = stack3.pop();
				stack_height_3 -= poped_cylinder_3;
			}
			if (stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3) {
				return stack_height_1;
			} else {
				if (poped_cylinder_2 > 0) {
					stack2.push(poped_cylinder_2);
					stack_height_2 += poped_cylinder_2;
				}
				if (poped_cylinder_3 > 0) {
					stack3.push(poped_cylinder_3);
					stack_height_3 += poped_cylinder_3;
				}
				return stacksHeightCalculator(stack1, stack_height_1, stack2, stack_height_2, stack3, stack_height_3);
			}
		} else if (cylinder_2 >= cylinder_3 && cylinder_2 >= cylinder_1) {
			int poped_cylinder_1 = 0;
			while (stack_height_1 > stack_height_2) {
				poped_cylinder_1 = stack1.pop();
				stack_height_1 -= poped_cylinder_1;
			}
			int poped_cylinder_3 = 0;
			while (stack_height_3 > stack_height_2) {
				poped_cylinder_3 = stack3.pop();
				stack_height_3 -= poped_cylinder_3;
			}
			if (stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3) {
				return stack_height_2;
			} else {
				if (poped_cylinder_1 > 0) {
					stack1.push(poped_cylinder_1);
					stack_height_1 += poped_cylinder_1;
				}
				if (poped_cylinder_3 > 0) {
					stack3.push(poped_cylinder_3);
					stack_height_3 += poped_cylinder_3;
				}
				return stacksHeightCalculator(stack1, stack_height_1, stack2, stack_height_2, stack3, stack_height_3);
			}
		} else {
			int poped_cylinder_1 = 0;
			while (stack_height_1 > stack_height_3) {
				poped_cylinder_1 = stack1.pop();
				stack_height_1 -= poped_cylinder_1;
			}
			int poped_cylinder_2 = 0;
			while (stack_height_2 > stack_height_3) {
				poped_cylinder_2 = stack3.pop();
				stack_height_2 -= poped_cylinder_2;
			}
			if (stack_height_1 == stack_height_2 && stack_height_2 == stack_height_3) {
				return stack_height_3;
			} else {
				if (poped_cylinder_1 > 0) {
					stack1.push(poped_cylinder_1);
					stack_height_1 += poped_cylinder_1;
				}
				if (poped_cylinder_2 > 0) {
					stack2.push(poped_cylinder_2);
					stack_height_2 += poped_cylinder_2;
				}
				return stacksHeightCalculator(stack1, stack_height_1, stack2, stack_height_2, stack3, stack_height_3);
			}

		}

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input04.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

		String[] n1N2N3 = scanner.nextLine().split(" ");

		int n1 = Integer.parseInt(n1N2N3[0].trim());

		int n2 = Integer.parseInt(n1N2N3[1].trim());

		int n3 = Integer.parseInt(n1N2N3[2].trim());

		int[] h1 = new int[n1];

		String[] h1Items = scanner.nextLine().split(" ");
		for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
			int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
			h1[h1Itr] = h1Item;
		}

		int[] h2 = new int[n2];

		String[] h2Items = scanner.nextLine().split(" ");

		for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
			int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
			h2[h2Itr] = h2Item;
		}

		int[] h3 = new int[n3];

		String[] h3Items = scanner.nextLine().split(" ");

		for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
			int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
			h3[h3Itr] = h3Item;
		}

		int result = equalStacks(h1, h2, h3);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
