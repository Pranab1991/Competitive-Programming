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

class Result20 {

	/*
	 * Complete the 'twoPluses' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING_ARRAY grid as parameter.
	 */

	public static int twoPluses(List<String> grid) {
		Map<String, Integer> trackPluses = new TreeMap<>();
		Set<Integer> diffsize = new TreeSet<>((o1, o2) -> -(o1.compareTo(o2)));
		Set<String> largeUsedIndexes = new HashSet<>();
		Set<String> secondUsedIndexes = new HashSet<>();
		List<Integer> sumList = new ArrayList<>();
		int largestPlusArea = 0, largestIindex = 0, largestJindex = 0, largestLengthAdder = 0;
		int secondLargestPlus = 0;
		int i = 0;
		for (String s : grid) {
			for (int j = 0; j < s.length(); j++) {
				if ('G' == s.charAt(j)) {
					int plusSize = calculatePlusSize(i, j, 1, grid);
					trackPluses.put(i + "," + j, plusSize);
				}
			}
			i++;
		}
		for (Integer value : trackPluses.values()) {
			diffsize.add(value);
		}
	
		for (int counter : diffsize) {	
			Outer: 	for (int size : diffsize) {
				if (size <=counter) {
					for (Map.Entry<String, Integer> entry : trackPluses.entrySet()) {
						int value = entry.getValue();
						if (value == size) {
							String[] key = entry.getKey().split(",");
							int iIndex = Integer.parseInt(key[0]);
							int jIndex = Integer.parseInt(key[1]);
							if (largeUsedIndexes.isEmpty()) {
								allIndexFinder(largeUsedIndexes, iIndex, jIndex, value);
								largestLengthAdder = value;
								largestIindex = iIndex;
								largestJindex = jIndex;
								continue;
							}
							if (!largeUsedIndexes.isEmpty()) {
								allIndexFinder(secondUsedIndexes, iIndex, jIndex, value);
								if (!secondUsedIndexes.removeAll(largeUsedIndexes)) {
									largestPlusArea = largestLengthAdder + (3 * (largestLengthAdder - 1));
									secondLargestPlus = value + (3 * (value - 1));
									//trackPluses.remove(largestIindex + "," + largestJindex);
									sumList.add(largestPlusArea * secondLargestPlus);
									largeUsedIndexes.clear();
									break Outer;
								}
							}
						}
					}
				}
			}
		}
		return Collections.max(sumList);
	}

	private static void allIndexFinder(Set<String> largeUsedIndexes, int largestIindex, int largestJindex,
			int largestLengthAdder) {
		largeUsedIndexes.clear();
		for (int unit = 0; unit < largestLengthAdder; unit++) {
			largeUsedIndexes.add(largestIindex - unit + "," + largestJindex);
			largeUsedIndexes.add(largestIindex + unit + "," + largestJindex);
			largeUsedIndexes.add(largestIindex + "," + (largestJindex - unit));
			largeUsedIndexes.add(largestIindex + "," + (largestJindex + unit));
		}
	}

	private static int calculatePlusSize(int i, int j, int size, List<String> grid) {
		int minIindex = 0, maxIindex = grid.size() - 1, minJindex = 0, maxJindex = grid.get(0).length() - 1;
		if (((i - size) >= minIindex && 'G' == grid.get(i - size).charAt(j))
				&& ((i + size) <= maxIindex && 'G' == grid.get(i + size).charAt(j))
				&& ((j - size) >= minJindex && 'G' == grid.get(i).charAt(j - size))
				&& ((j + size) <= maxJindex && 'G' == grid.get(i).charAt(j + size))) {
			return calculatePlusSize(i, j, ++size, grid);
		} else {
			return size;
		}
	}

}

public class Ema_SuperComp {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<String> grid = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int result = Result20.twoPluses(grid);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
