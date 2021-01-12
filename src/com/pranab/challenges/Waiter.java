package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

public class Waiter {

	/*
	 * Complete the waiter function below.
	 */
	static int[] waiter(int[] number, int q) {
		Stack<Integer> plateStack = new Stack<>();
		for (int index = 0; index < number.length; index++) {
			plateStack.push(number[index]);
		}
		int[] q_primes = prime_generator(q);
		Map<Integer, Stack<Integer>> primes_stack = new TreeMap<>();
		Stack<Integer> result = new Stack<Integer>();
		for (int index = 0; index < q; index++) {
			if (plateStack.size() > 0) {
				while (plateStack.size() > 0) {
					int plate = plateStack.pop();
					if (plate % q_primes[index] == 0) {
						if (primes_stack.containsKey(q_primes[index])) {
							primes_stack.get(q_primes[index]).push(plate);
						} else {
							Stack<Integer> stack_for_prime = new Stack<Integer>();
							stack_for_prime.push(plate);
							primes_stack.put(q_primes[index], stack_for_prime);
						}
					} else {
						result.push(plate);
					}
				}
			} else if (result.size() > 0) {
				while (result.size() > 0) {
					int plate = result.pop();
					if (plate % q_primes[index] == 0) {
						if (primes_stack.containsKey(q_primes[index])) {
							primes_stack.get(q_primes[index]).push(plate);
						} else {
							Stack<Integer> stack_for_prime = new Stack<Integer>();
							stack_for_prime.push(plate);
							primes_stack.put(q_primes[index], stack_for_prime);
						}
					} else {
						plateStack.push(plate);
					}
				}
			}
			if (result.size() == 0 && plateStack.size() == 0) {
				break;
			}
		}
		int[] final_result = new int[number.length];
		for (int index = 0; index < number.length; index++) {
			for (Map.Entry<Integer, Stack<Integer>> entry : primes_stack.entrySet()) {
				Stack<Integer> stack = entry.getValue();
				while (stack.size() > 0) {
					final_result[index] = stack.pop();
					index++;
				}
			}
			if (result.size() > 0) {
				while (result.size() > 0) {
					final_result[index] = result.pop();
					index++;
				}
			} else if (plateStack.size() > 0) {
				while (plateStack.size() > 0) {
					final_result[index] = plateStack.pop();
					index++;
				}
			}
		}
		return final_result;
	}

	static int[] prime_generator(int numofPrime) {
		int[] primes = new int[1200];
		boolean isPrime = true;
		int counter = 0;
		primes[counter] = 2;
		counter++;
		for (int i = 3; i < 1000000; i++) {
			for (int j = 2; j < i - 1; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				if (counter < numofPrime) {
					primes[counter] = i;
				} else {
					break;
				}
				counter++;
			}
			isPrime = true;
		}
		return primes;
	}

	

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("waiterin.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("waiterout.txt"));

		String[] nq = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nq[0].trim());

		int q = Integer.parseInt(nq[1].trim());

		int[] number = new int[n];

		String[] numberItems = scanner.nextLine().split(" ");

		for (int numberItr = 0; numberItr < n; numberItr++) {
			int numberItem = Integer.parseInt(numberItems[numberItr].trim());
			number[numberItr] = numberItem;
		}

		int[] result = waiter(number, q);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}

	/*
	 * public static void main(String[] args) { int[] data = prime_generator(1200);
	 * System.out.println(data); }
	 */
}
