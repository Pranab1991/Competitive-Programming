package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodes {

	/*
	 * Complete the swapNodes function below.
	 */
	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int last = 1;
		int start = 0;
		int[][] result = new int[queries.length][indexes.length];
		Queue<SwapNode> parents = new LinkedList<>();
		SwapNode root = new SwapNode(1);
		parents.add(root);
		while (last < indexes.length) {
			int last_incrementor = 0;
			while (start < last) {
				SwapNode parent = parents.poll();
				if (indexes[start][0] != -1) {
					SwapNode node = new SwapNode(indexes[start][0]);
					parent.left = node;
					node.parent = parent;
					parents.add(node);
					++last_incrementor;
				}
				if (indexes[start][1] != -1) {
					SwapNode node = new SwapNode(indexes[start][1]);
					parent.right = node;
					node.parent = parent;
					parents.add(node);
					++last_incrementor;
				}
				start++;
			}
			last += last_incrementor;
		}
		for (int index = 0; index < queries.length; index++) {
			printInorder(root, queries[index], 1, true,0,result[index]);
			printInorder(root, 2, 1, false,0,result[index]);
		}
		return result;
	}

	public static int printInorder(SwapNode root, int key, int depth, boolean swap,int counter,int[] result) {

		if (root.left != null) {
			counter=printInorder(root.left, key, depth + 1, swap,counter, result);
		}		
		if (!swap) {
			// System.out.print("depth:"+depth+"value:"+root.data+" , ");
			result[counter] = root.data;
			counter++;
		}
		if (root.right != null) {
			counter=printInorder(root.right, key, depth + 1, swap,counter,result);
		}
		if (depth % key == 0 && swap) {
			SwapNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return counter;
	}

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		Scanner scanner = new Scanner(new File("input04.txt"));
		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

		/*
		 * for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
		 * for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length;
		 * resultColumnItr++) {
		 * bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
		 * 
		 * if (resultColumnItr != result[resultRowItr].length - 1) {
		 * bufferedWriter.write(" "); } }
		 * 
		 * if (resultRowItr != result.length - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
		scanner.close();
	}
}

class SwapNode {
	SwapNode left;
	SwapNode right;
	SwapNode parent;
	int data;

	SwapNode(int data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
}
