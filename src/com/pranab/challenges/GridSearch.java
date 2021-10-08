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

class Result9 {

	/*
	 * Complete the 'gridSearch' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING_ARRAY G 2. STRING_ARRAY P
	 */

	public static String gridSearch(List<String> G, List<String> P) {
		String result = "NO";
		int i = 0;
		Outer:
		for (String gridLineLine : G) {			
			for (int j = 0; j < gridLineLine.length(); j++) {
				char charecterGrid = gridLineLine.charAt(j);
				if (charecterGrid == P.get(0).charAt(0)) {
					if(true==matchPattern(G, j, i, P)) {
						result="YES";
						break Outer;
					}
				}
			}
			i++;
		}
		return result;
	}

	private static boolean matchPattern(List<String> G, int j, int k, List<String> P) {
		boolean result = true;
		int l=0;
		Outer:
		for (String patternLine : P) {
			for (int i = 0; i < patternLine.length(); i++) {
				char charecterPattern = patternLine.charAt(i);
				try {
					if (G.get(k+l).charAt(j + i) != charecterPattern) {
						result=false;
						break Outer;
					}
				} catch (IndexOutOfBoundsException e) {
					result = false;
				}
			}
			l++;
		}
		return result;
	}

}

public class GridSearch {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int R = Integer.parseInt(firstMultipleInput[0]);

				int C = Integer.parseInt(firstMultipleInput[1]);

				List<String> G = IntStream.range(0, R).mapToObj(i -> {
					try {
						return bufferedReader.readLine();
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				}).collect(toList());

				String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int r = Integer.parseInt(secondMultipleInput[0]);

				int c = Integer.parseInt(secondMultipleInput[1]);

				List<String> P = IntStream.range(0, r).mapToObj(i -> {
					try {
						return bufferedReader.readLine();
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				}).collect(toList());

				String result = Result9.gridSearch(G, P);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
