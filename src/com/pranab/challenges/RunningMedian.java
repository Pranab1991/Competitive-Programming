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

class Result95 {

	public static final List<Integer> SMALLSTORAGE = new ArrayList<>();
	public static final List<Integer> LARGESTORAGE = new ArrayList<>();

	public static int getParentIndex(int childInedx) {
		return (childInedx - 1) >> 1;
	}

	public static int getLeftChild(int index) {
		return (index << 1) + 1;
	}

	public static int getRightChild(int index) {
		return (index << 1) + 2;
	}

	private static void exchange(int index, int otherIndex, List<Integer> storage) {
		int temp = storage.get(index);
		storage.set(index, storage.get(otherIndex));
		storage.set(otherIndex, temp);
	}

	public static void minifyHeap(int index) {
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRightChild(index);
		int smallest = index;
		int lastIndex = SMALLSTORAGE.size();
		if (leftChildIndex < lastIndex && SMALLSTORAGE.get(leftChildIndex) < SMALLSTORAGE.get(index)) {
			smallest = leftChildIndex;
		}
		if (rightChildIndex < lastIndex && SMALLSTORAGE.get(rightChildIndex) < SMALLSTORAGE.get(smallest)) {
			smallest = rightChildIndex;
		}
		if (smallest != index) {
			exchange(index, smallest, SMALLSTORAGE);
			minifyHeap(smallest);
		}
	}

	public static void maxifyHeap(int index) {
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRightChild(index);
		int largest = index;
		int lastIndex = LARGESTORAGE.size();
		if (leftChildIndex < lastIndex && LARGESTORAGE.get(leftChildIndex) > LARGESTORAGE.get(index)) {
			largest = leftChildIndex;
		}
		if (rightChildIndex < lastIndex && LARGESTORAGE.get(rightChildIndex) > LARGESTORAGE.get(largest)) {
			largest = rightChildIndex;
		}
		if (largest != index) {
			exchange(index, largest, LARGESTORAGE);
			maxifyHeap(largest);
		}
	}

	private static void addToSmall(int value) {
		SMALLSTORAGE.add(value);
		int index = SMALLSTORAGE.size() - 1;
		int parentIndex = getParentIndex(index);
		while (index > 0 && SMALLSTORAGE.get(index) < SMALLSTORAGE.get(parentIndex)) {
			exchange(index, parentIndex, SMALLSTORAGE);
			index = parentIndex;
			parentIndex = getParentIndex(index);
		}
	}

	private static int extractMin() {
		int minElement = SMALLSTORAGE.get(0);
		exchange(0, SMALLSTORAGE.size() - 1, SMALLSTORAGE);
		SMALLSTORAGE.remove(SMALLSTORAGE.size() - 1);
		minifyHeap(0);
		return minElement;
	}

	private static void addToBig(int value) {
		LARGESTORAGE.add(value);
		int index = LARGESTORAGE.size() - 1;
		int parentIndex = getParentIndex(index);
		while (index > 0 && LARGESTORAGE.get(index) > LARGESTORAGE.get(parentIndex)) {
			exchange(index, parentIndex, LARGESTORAGE);
			index = parentIndex;
			parentIndex = getParentIndex(index);
		}
	}

	private static int extractMax() {
		int maxElement = LARGESTORAGE.get(0);
		exchange(0, LARGESTORAGE.size() - 1, LARGESTORAGE);
		LARGESTORAGE.remove(LARGESTORAGE.size() - 1);
		maxifyHeap(0);
		return maxElement;
	}

	public static List<Double> runningMedian(List<Integer> a) {
		// Write your code here
		List<Double> runningMedian = new ArrayList<>();
		runningMedian.add((double) a.get(0));
		double secondMedian = roundAvoid((((double) a.get(0) + a.get(1)) / 2), 1);
		runningMedian.add(secondMedian);
		if (a.get(0) > a.get(1)) {
			addToBig(a.get(1));
			addToSmall(a.get(0));
		} else {
			addToBig(a.get(0));
			addToSmall(a.get(1));
		}
		for (int index = 2; index < a.size(); index++) {
			int number = a.get(index);
			if(number < LARGESTORAGE.get(0)) {
				addToBig(number);
			}else {
				addToSmall(number);
			}
			int diff=LARGESTORAGE.size()-SMALLSTORAGE.size();
			if(diff==1) {
				runningMedian.add((double) LARGESTORAGE.get(0));
			}else if(diff==-1) {
				runningMedian.add((double) SMALLSTORAGE.get(0));
			}else {
				if(diff==2) {
					addToSmall(extractMax());
				}else  if(diff==-2) {
					addToBig(extractMin());
				}
				runningMedian.add(roundAvoid((((double) SMALLSTORAGE.get(0) + LARGESTORAGE.get(0)) / 2), 1));
			}
		}
		return runningMedian;
	}

	public static double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}
}

public class RunningMedian {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int aCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Double> result = Result95.runningMedian(a);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
