package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FloydWarshall {

	public static void main(String... args) throws FileNotFoundException {
		ProblemDef problem=read("g1.txt");
		floydWarshall(problem);
		System.out.println("done");
	}
	
	public static ProblemDef read(String file) throws FileNotFoundException {
		Scanner scan=new Scanner(new File(file));
		ProblemDef problem=new ProblemDef();
		problem.vertexCount=scan.nextInt();
		problem.edgeCount=scan.nextInt();
		problem.graph=new HashMap();
		
		while(scan.hasNext()) {
			int source=scan.nextInt();
			int destination=scan.nextInt();
			int weight=scan.nextInt();
			if(problem.graph.containsKey(source)) {
				problem.graph.get(source).put(destination, weight);
			}else {
				Map<Integer,Integer> map=new HashMap<>();
				map.put(destination, weight);
				problem.graph.put(source, map);
			}
		}
		return problem;
	}
	
	public static void floydWarshall(ProblemDef problem) {
		int[][][] optimalSoln=new int[problem.vertexCount][problem.vertexCount][problem.vertexCount];
		for(int i=0;i<problem.vertexCount;i++) {
			for(int j=0;j<problem.vertexCount;j++) {
				if(i==j) {
					optimalSoln[0][i][j]=0;
				}else if(problem.graph.containsKey(i+1)&&problem.graph.get(i+1).containsKey(j+1)) {
					optimalSoln[0][i][j]=problem.graph.get(i+1).get(j+1);
				}else {
					optimalSoln[0][i][j]=Integer.MAX_VALUE;
				}
			}
		}
		/*for(int i=0;i<problem.vertexCount;i++) {
			for(int j=0;j<problem.vertexCount;j++) {
			  System.out.print(optimalSoln[0][i][j]+" ");
			}
			System.out.println();
		}*/
		for(int k=1;k<problem.vertexCount;k++) {
			for(int i=0;i<problem.vertexCount;i++) {
				for(int j=0;j<problem.vertexCount;j++) {
					int subprobOne=optimalSoln[k-1][i][k];
					int subprobTwo=optimalSoln[k-1][k][j];
					int result=0;
					if(subprobOne==Integer.MAX_VALUE||subprobTwo==Integer.MAX_VALUE) {
						result=Integer.MAX_VALUE;
					}else {
						result=optimalSoln[k-1][i][k]+optimalSoln[k-1][k][j];
					}
					optimalSoln[k][i][j]=Math.min(optimalSoln[k-1][i][j],
							(result));
				}
			}
		}
		for(int i=0;i<problem.vertexCount;i++) {
			for(int j=0;j<problem.vertexCount;j++) {
			  System.out.print(optimalSoln[4][i][j]+" ");
			}
			System.out.println();
		}
	}
}

class ProblemDef {
	public int vertexCount;
	public int edgeCount;
	public Map<Integer,Map<Integer,Integer>> graph; 
}
