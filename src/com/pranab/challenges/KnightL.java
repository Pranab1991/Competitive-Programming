package com.pranab.challenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KnightL {
//UNSOLVED TRY AGAIN
	// Complete the knightlOnAChessboard function below.
	static int[][] knightlOnAChessboard(int n) {
		for (int x = 1; x < n; x++) {
			for (int y = 1; y < n; y++) {
				System.out.print("(" + x + "," + y + ") ");
				System.out.print(findMinimalpath(x,y,0,0,0,n-1)+" ");
			}
			System.out.println();
		}
		return null;
	}

	static int findMinimalpath(int x_move, int y_move, int x, int y, int count, int last) {
		int[] countArray = new int[8];int min_count=0;
		if (x - x_move >= 0 && y - y_move >= 0) {
			int new_x = x - x_move;
			int new_y = y - y_move;
			if((new_x == last && new_y == last)) {
				countArray[0]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[0] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x + x_move <= last && y - y_move >= 0) {
			int new_x = x + x_move;
			int new_y = y - y_move;
			if((new_x == last && new_y == last)) {
				countArray[1]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[1] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x + y_move <= last && y - x_move >= 0) {
			int new_x = x + y_move;
			int new_y = y - x_move;
			if((new_x == last && new_y == last)) {
				countArray[2]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[2] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x + y_move <= last && y + x_move <= last) {
			int new_x = x + y_move;
			int new_y = y + x_move;
			if((new_x == last && new_y == last)) {
				countArray[3]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[3] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x + x_move <= last && y + y_move <= last) {
			int new_x = x + x_move;
			int new_y = y + y_move;
			if((new_x == last && new_y == last)) {
				countArray[4]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[4] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x - x_move >= 0 && y + y_move <= last) {
			int new_x = x - x_move;
			int new_y = y + y_move;
			if((new_x == last && new_y == last)) {
				countArray[5]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[5] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x - y_move >= 0 && y + x_move <= last) {
			int new_x = x - y_move;
			int new_y = y + x_move;
			if((new_x == last && new_y == last)) {
				countArray[6]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[6] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		if (x - y_move >= 0 && y - x_move >= 0) {
			int new_x = x - y_move;
			int new_y = y - x_move;
			if((new_x == last && new_y == last)) {
				countArray[7]=count+1;
			}else if (!((new_x == 0 && new_y == 0))) {
				countArray[7] = findMinimalpath(x_move, y_move, new_x, new_y, count + 1, last);
			}
		}
		Arrays.sort(countArray);
		for(int num:countArray) {
			if(min_count!=0) {
				min_count=num;
				break;
			}
		}
		return min_count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int n = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * int[][] result = knightlOnAChessboard(n);
		 * 
		 * for (int i = 0; i < result.length; i++) { for (int j = 0; j <
		 * result[i].length; j++) { bufferedWriter.write(String.valueOf(result[i][j]));
		 * 
		 * if (j != result[i].length - 1) { bufferedWriter.write(" "); } }
		 * 
		 * if (i != result.length - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
		knightlOnAChessboard(2);
	}
}
