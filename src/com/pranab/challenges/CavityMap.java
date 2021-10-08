package com.pranab.challenges;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CavityMap {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
    	String[][] twoDGrid = new String[grid.length][grid[0].length()];
		for (int i = 0; i < twoDGrid.length; i++) {
			twoDGrid[i] = grid[i].split("");
		}
		int rowIndex=twoDGrid.length;
		int columnIndex=twoDGrid[0].length;
		int rowStart=0,rowEnd=0,columnStart=0,columnEnd=0;
		if(rowIndex>2&&columnIndex>2) {
			rowStart=1;
			rowEnd=rowIndex-2;
			columnStart=1;
			columnEnd=columnIndex-2;
			for(int i=rowStart;i<=rowEnd;i++) {
				for(int j=columnStart;j<=columnEnd;j++) {
					int adjcentUp=i - 1;
					int adjcentDown=i + 1;
					int adjcentleft=j - 1;
					int adjcentRight=j + 1;
					String num=twoDGrid[i][j];
					if((num.compareTo(twoDGrid[adjcentUp][j])>=1)&&(num.compareTo(twoDGrid[adjcentDown][j])>=1)
							&&(num.compareTo(twoDGrid[i][adjcentleft])>=1)&&(num.compareTo(twoDGrid[i][adjcentRight])>=1)) {
						twoDGrid[i][j]="X";
					}
				}
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


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("outputLarry.txt")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

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
