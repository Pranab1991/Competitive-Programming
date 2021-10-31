package com.pranab.challenges;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result94 {

	public static List<Integer> STORAGE;

	public static int getParentIndex(int childInedx) {
		return (childInedx - 1) >> 1;
	}

	public static int getLeftChild(int index) {
		return (index << 1) + 1;
	}

	public static int getRightChild(int index) {
		return (index << 1) + 2;
	}

	public static void minifyHeap(int index) {
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRightChild(index);
		int smallest = index;
		int lastIndex = STORAGE.size();
		if (leftChildIndex < lastIndex && STORAGE.get(leftChildIndex) < STORAGE.get(index)) {
			smallest = leftChildIndex;
		}
		if (rightChildIndex < lastIndex && STORAGE.get(rightChildIndex) < STORAGE.get(smallest)) {
			smallest = rightChildIndex;
		}
		if (smallest != index) {
			exchange(index, smallest);
			minifyHeap(smallest);
		}
	}

	private static void exchange(int index, int otherIndex) {
		int temp = STORAGE.get(index);
		STORAGE.set(index, STORAGE.get(otherIndex));
		STORAGE.set(otherIndex, temp);
	}

	private static void add(int value) {
		STORAGE.add(value);
		int index = STORAGE.size() - 1;
		int parentIndex = getParentIndex(index);
		while (index > 0 && STORAGE.get(index) < STORAGE.get(parentIndex)) {
			exchange(index, parentIndex);
			index = parentIndex;
			parentIndex = getParentIndex(index);
		}
	}

	private static int extractMin() {
		int minElement = STORAGE.get(0);
		exchange(0, STORAGE.size() - 1);
		STORAGE.remove(STORAGE.size() - 1);
		minifyHeap(0);
		return minElement;
	}

	private static void buildHeap(List<Integer> A) {
		STORAGE = A;
		for (int mid = A.size() / 2; mid >= 0; mid--) {
			minifyHeap(mid);
		}
	}

	public static int cookies(int k, List<Integer> A) {
		// Write your code here
		buildHeap(A);
		int minOne = extractMin();
		int minTwo = 0;
		int iter = 0;
		while (minOne < k) {
			if (A.isEmpty()) {
				return -1;
			}
			iter++;
			minTwo = extractMin();
			int newNum = minOne + (2 * minTwo);
			add(newNum);
			minOne = extractMin();
		}
		return iter;

	}

}

public class JesseAndCookies {
	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("testFile.txt")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = Result94.cookies(k, A);
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).getSeconds());
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
