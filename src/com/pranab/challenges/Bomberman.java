package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Bomberman {
	// Complete the bomberMan function below.
	static String[] bomberMan(int n, String[] grid) {
		String[][] twoDGrid = new String[grid.length][grid[0].length()];
		for (int i = 0; i < twoDGrid.length; i++) {
			twoDGrid[i] = grid[i].split("");
		}
		Map<String, String> primaryBomb = new HashMap<>();
		Map<String, String> secondaryBomb = new HashMap<>();
		if (n == 1) {
			printGrig(grid);
			return grid;
		} else {
			for (int i = 0; i < twoDGrid.length; i++) {
				for (int j = 0; j < twoDGrid[0].length; j++) {
					if ("O".equals(twoDGrid[i][j])) {
						primaryBomb.put(i + ":" + j, "Y");
					}
				}
			}
			n--;
		}
		boolean isprimary = false;
		while (n != 0) {
			if (primaryBomb.isEmpty()) {
				plantBomb(twoDGrid, primaryBomb);
				isprimary = true;
			} else {
				plantBomb(twoDGrid, secondaryBomb);
				isprimary = false;
			}
			n--;
			if (n > 0) {
				if (!isprimary) {
					processDetonation(primaryBomb, secondaryBomb, twoDGrid);
				} else {
					processDetonation(secondaryBomb, primaryBomb, twoDGrid);
				}
				n--;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < twoDGrid.length; i++) {
			for (int j = 0; j < twoDGrid[0].length; j++) {
				sb.append(twoDGrid[i][j]);
			}
			grid[i] = sb.toString();
			sb = new StringBuilder();
		}

		printGrig(grid);

		return grid;
	}

	private static void printGrig(String[] grid) {
		for (String string : grid) {
			System.out.println(string);
		}
	}

	public static void plantBomb(String[][] twoDGrid, Map<String, String> bombStatus) {
		for (int i = 0; i < twoDGrid.length; i++) {
			for (int j = 0; j < twoDGrid[0].length; j++) {
				if (!"O".equals(twoDGrid[i][j])) {
					twoDGrid[i][j] = "O";
					bombStatus.put(i + ":" + j, "Y");
				}
			}
		}
	}

	public static void processDetonation(Map<String, String> primaryBomb, Map<String, String> secondaryBomb,
			String[][] twoDGrid) {
		for (Map.Entry<String, String> iter : primaryBomb.entrySet()) {
			if ("Y".equals(iter.getValue())) {
				String[] indexes = iter.getKey().split(":");
				int indexRow = Integer.parseInt(indexes[0]);
				int indexColumn = Integer.parseInt(indexes[1]);
				twoDGrid[indexRow][indexColumn] = ".";
				if (indexRow - 1 >= 0) {
					checkAndDetonate(secondaryBomb, twoDGrid, ((indexRow - 1) + ":" + indexColumn), indexRow - 1,
							indexColumn);
				}
				if (indexRow + 1 <= (twoDGrid.length - 1)) {
					checkAndDetonate(secondaryBomb, twoDGrid, ((indexRow + 1) + ":" + indexColumn), indexRow + 1,
							indexColumn);
				}
				if (indexColumn - 1 >= 0) {
					checkAndDetonate(secondaryBomb, twoDGrid, (indexRow + ":" + (indexColumn - 1)), indexRow,
							indexColumn - 1);
				}
				if (indexColumn + 1 <= (twoDGrid[0].length - 1)) {
					checkAndDetonate(secondaryBomb, twoDGrid, (indexRow + ":" + (indexColumn + 1)), indexRow,
							indexColumn + 1);
				}
			}
		}
		primaryBomb.clear();
	}

	public static void checkAndDetonate(Map<String, String> secondaryBomb, String[][] twoDGrid, String key,
			int indexRow, int columnIndex) {
		if (secondaryBomb.containsKey(key)) {
			secondaryBomb.put(key, "N");
		}
		twoDGrid[indexRow][columnIndex] = ".";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("outputLarry.txt")));

		String[] rcn = scanner.nextLine().split(" ");

		int r = Integer.parseInt(rcn[0]);

		int c = Integer.parseInt(rcn[1]);

		int n = Integer.parseInt(rcn[2]);

		String[] grid = new String[r];

		for (int i = 0; i < r; i++) {
			String gridItem = scanner.nextLine();
			grid[i] = gridItem;
		}

		String[] result = bomberMan(n, grid);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(result[i]);

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
