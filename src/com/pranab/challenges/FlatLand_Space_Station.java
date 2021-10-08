package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FlatLand_Space_Station {

	// Complete the flatlandSpaceStations function below.
	static int flatlandSpaceStations(int n, int[] c) {
		Arrays.sort(c);
		int previousStation = 0;
		int maxDistance = 0;
		int distanceStrat = c[0] - 0;
		if (maxDistance < distanceStrat) {
			maxDistance = distanceStrat;
		}
		previousStation = c[0];
		for (int i = 1; i < c.length; i++) {
			int midpoint = (int) (Math.floor(((double) (c[i] - previousStation)) / 2));
			// int distance=(c[i]-midpoint);
			if (maxDistance < midpoint) {
				maxDistance = midpoint;
			}
			previousStation = c[i];
		}
		if (!(c.length == n)) {
			int distance = n - c[c.length - 1] - 1;
			if (maxDistance < distance) {
				maxDistance = distance;
			}
		}
		return maxDistance;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] c = new int[m];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = flatlandSpaceStations(n, c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
