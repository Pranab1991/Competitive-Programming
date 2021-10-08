package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result17 {

	/*
	 * Complete the 'minimumDistances' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY a as parameter.
	 */

	public static int minimumDistances(List<Integer> a) {
		int minDistance = Integer.MAX_VALUE;
		Map<Integer, Integer> pairDistanceMap = new HashMap<>();
		Map<Integer, Integer> integerIndex = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			int key = a.get(i);
			if (integerIndex.containsKey(key)) {
				pairDistanceMap.put(key, i - integerIndex.get(key));
			} else {
				integerIndex.put(key, i);
			}
		}
		if (!pairDistanceMap.isEmpty()) {
			for (int distance : pairDistanceMap.values()) {
				if (distance < minDistance) {
					minDistance = distance;
				}
			}
		} else {
			minDistance = -1;
		}
		return minDistance;
	}

}

public class Minimum_Distance {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> a = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aTemp[i]);
			a.add(aItem);
		}

		int result = Result17.minimumDistances(a);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
