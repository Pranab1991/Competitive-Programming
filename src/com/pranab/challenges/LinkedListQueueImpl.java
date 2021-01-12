package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.Stack;

public class LinkedListQueueImpl {

	public static void main(String[] args) throws FileNotFoundException {
		Instant start = Instant.now();
		Scanner scanner = new Scanner(new File("input04.txt"));
		int inputCounts = Integer.parseInt(scanner.nextLine());
		Stack<String> inputStack = new Stack<>();
		Stack<String> deleteStack = new Stack<>();
		for (int iter = 0; iter < inputCounts; iter++) {
			String[] actions = scanner.nextLine().split(" ");
			int action = Integer.parseInt(actions[0]);
			if (1 == action) {
				if (!deleteStack.isEmpty()) {
					while (deleteStack.size() > 0) {
						inputStack.push(deleteStack.pop());
					}
				}
				inputStack.push(actions[1]);
			}else if(2 == action) {
				if (!inputStack.isEmpty()) {
					while (inputStack.size() > 0) {
						deleteStack.push(inputStack.pop());
					}
				}
				deleteStack.pop();
			}else {
				if (!inputStack.isEmpty()) {
					while (inputStack.size() > 0) {
						deleteStack.push(inputStack.pop());
					}
				}
				System.out.println(deleteStack.peek());
			}
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
		scanner.close();
	}
}
