package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TruckTour {

	/*
	 * Complete the truckTour function below.
	 */
	static int truckTour(int[][] petrolpumps) {
		List<Integer> results = new ArrayList<>();
		for (int pump_index = 0; pump_index < petrolpumps.length; pump_index++) {
			if (petrolpumps[pump_index][1] > petrolpumps[pump_index][0]) {
				continue;
			}
			int extra = 0;
			boolean isStart = true;
			for (int start_point = pump_index; start_point < petrolpumps.length; start_point++) {
				int diff=petrolpumps[start_point][0] - petrolpumps[start_point][1];
				extra += diff;
				if (extra < 0) {
					isStart = false;
					break;
				}
			}
			if (isStart) {
				for (int start_point = 0; start_point < pump_index; start_point++) {
					extra += petrolpumps[start_point][0] - petrolpumps[start_point][1];
					if (extra < 0) {
						isStart = false;
						break;
					}
				}
			}
			if (isStart) {
				results.add(pump_index);
			}
		}
		return results.get(0);
	}

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		Scanner scanner = new Scanner(new File("input04.txt"));
		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] petrolpumps = new int[n][2];

		for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
			String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

			for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
				int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
				petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
			}
		}

		int result = truckTour(petrolpumps);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();
	}
}
