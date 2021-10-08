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

public class ArrayLayer {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
    	int[][] arrMatrix=new int[matrix.size()][matrix.get(0).size()];
    	for(int i=0;i<arrMatrix.length;i++) {
    		for(int j=0;j<arrMatrix[0].length;j++) {
    			arrMatrix[i][j]=matrix.get(i).get(j);
    		}
    	}
    	int[][] finalArrMatrix=extractLayer(arrMatrix,r);
    	for(int i=0;i<arrMatrix.length;i++) {
    		for(int j=0;j<arrMatrix[0].length;j++) {
    			System.out.print(finalArrMatrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    }

    public static int[][] extractLayer(int[][] arrMatrix,int r) {
    	int minRowIndex=0;
    	int maxRowIndex=arrMatrix.length-1;
    	int minColumnIndex=0;
    	int maxColumnIndex=arrMatrix[0].length-1;
    	int[][] finalArrMatrix= new int[arrMatrix.length][arrMatrix[0].length];
    	while((maxRowIndex-minRowIndex>=0)&&(maxColumnIndex-minColumnIndex>=0)) {
    		/*System.out.println("minRowIndex : "+minRowIndex+" maxRowIndex : "+maxRowIndex+" minColumnIndex : "+minColumnIndex
    				+" maxColumnIndex : "+maxColumnIndex);*/
    		finalArrMatrix=doRotate(arrMatrix,minRowIndex,maxRowIndex,minColumnIndex,maxColumnIndex,r,finalArrMatrix);
    		minRowIndex++;
    		maxRowIndex--;
    		minColumnIndex++;
    		maxColumnIndex--;
    	}
    	return finalArrMatrix;
    }
    
    public static int[][] doRotate(int[][] arrMatrix,int minRowIndex,int maxRowIndex,
    		int minColumnIndex,int maxColumnIndex,int r,int[][] finalArrMatrix) {
    	int repeatRoto=calculateMaxRoto(minRowIndex,maxRowIndex,minColumnIndex,maxColumnIndex);
    	if(r>repeatRoto) {
    		r%=repeatRoto;
    	}
    	int[][] indexHolder=new int[repeatRoto][2];
    	int index=0;
    	for(int i=minColumnIndex;i<=maxColumnIndex;i++) {
    		indexHolder[index][0]=minRowIndex;
    		indexHolder[index][1]=i;
    		index++;
    	}
    	for(int i=minRowIndex+1;i<=maxRowIndex;i++) {
    		indexHolder[index][0]=i;
    		indexHolder[index][1]=maxColumnIndex;
    		index++;
    	}
    	for(int i=maxColumnIndex-1;i>=minColumnIndex;i--) {
    		indexHolder[index][0]=maxRowIndex;
    		indexHolder[index][1]=i;
    		index++;
    	}
    	for(int i=maxRowIndex-1;i>minRowIndex;i--) {
    		indexHolder[index][0]=i;
    		indexHolder[index][1]=minColumnIndex;
    		index++;
    	}
    	
    	int newIndex=r;
    	for(int i=minColumnIndex;i<=maxColumnIndex;i++) {
    		finalArrMatrix[minRowIndex][i]=arrMatrix[indexHolder[newIndex][0]][indexHolder[newIndex][1]];
    		if(newIndex!=index-1) {
    			newIndex++;
    		}else {
    			newIndex=0;
    		}
    	}
    	for(int i=minRowIndex+1;i<=maxRowIndex;i++) {
    		finalArrMatrix[i][maxColumnIndex]=arrMatrix[indexHolder[newIndex][0]][indexHolder[newIndex][1]];
    		if(newIndex!=index-1) {
    			newIndex++;
    		}else {
    			newIndex=0;
    		}
    	}
    	for(int i=maxColumnIndex-1;i>=minColumnIndex;i--) {
    		finalArrMatrix[maxRowIndex][i]=arrMatrix[indexHolder[newIndex][0]][indexHolder[newIndex][1]];
    		if(newIndex!=index-1) {
    			newIndex++;
    		}else {
    			newIndex=0;
    		}
    	}
    	for(int i=maxRowIndex-1;i>minRowIndex;i--) {
    		finalArrMatrix[i][minColumnIndex]=arrMatrix[indexHolder[newIndex][0]][indexHolder[newIndex][1]];
    		if(newIndex!=index-1) {
    			newIndex++;
    		}else {
    			newIndex=0;
    		}
    	}
    	//System.out.println("done");
    	return finalArrMatrix;
    }
    
    public static int calculateMaxRoto(int minRowIndex,int maxRowIndex,int minColumnIndex,int maxColumnIndex) {
    	int length=maxRowIndex-minRowIndex;
    	int breadth=maxColumnIndex-minColumnIndex;
    	return 2*(length+breadth);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
