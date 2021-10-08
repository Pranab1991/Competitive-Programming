package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BellManFord {
	
	public static void main(String... args) throws FileNotFoundException {
		ProblemData problem=readGraph();
		int[][] dyanamicSolution=executeBellmanFord(problem);
		for(int i=dyanamicSolution.length-1;i>=0;i--) {
			for(int j=0;j<dyanamicSolution[0].length;j++) {
				System.out.print(dyanamicSolution[i][j]+", ");
			}
			System.out.println();
		}
	}

	public static ProblemData readGraph() throws FileNotFoundException {
		ProblemData problem=new ProblemData();
		problem.graph = new HashMap<>();
		Scanner scan = new Scanner(new File("test.txt"));
		//System.out.println(scan.next());
		problem.vertexCount = scan.nextInt();
		problem.edgeCount = scan.nextInt();
		while (scan.hasNext()) {
			int startNode = scan.nextInt();
			int endNode = scan.nextInt();
			if (!problem.graph.containsKey(startNode)) {
				problem.graph.put(startNode, new InOutEdge());
			}
			if (!problem.graph.containsKey(endNode)) {
				problem.graph.put(endNode,  new InOutEdge());
			}
			int length = scan.nextInt();
			EdgeOutGoing newEdge=new EdgeOutGoing(length,endNode);
			problem.graph.get(startNode).outgoing.add(newEdge);
			EdgeInComing newInEdge=new EdgeInComing(length,startNode);
			problem.graph.get(endNode).incoming.add(newInEdge);
		}
		return problem;
	}
	 
	public static int[][] executeBellmanFord(ProblemData problem) {
		int[][] dyanamicSolution=new int[problem.edgeCount][problem.vertexCount];
		dyanamicSolution[0][0]=0;
		for(int j=1;j<dyanamicSolution[0].length;j++) {
			dyanamicSolution[0][j]=Integer.MAX_VALUE;
		}
		Queue<EdgeOutGoing> queue= new LinkedList<EdgeOutGoing>();
		for(EdgeOutGoing edge:problem.graph.get(1).outgoing) {
			queue.add(edge);
		}
		queue.add(null);
		for(int k=1;k<dyanamicSolution.length;k++) {
			for(int i=0;i<problem.vertexCount;i++) {
				dyanamicSolution[k][i]=dyanamicSolution[k-1][i];
			}
			while(queue.peek()!=null) {
				int minValue=Integer.MAX_VALUE;
				EdgeOutGoing edge=queue.poll();
				ArrayList<EdgeInComing> incoming=problem.graph.get(edge.endNode).incoming;
				for(EdgeInComing inedge:incoming) {
					int prevNodeSol=dyanamicSolution[k-1][inedge.startNode-1];
					if(prevNodeSol==Integer.MAX_VALUE) {
						continue;
					}
					int newValue=prevNodeSol+inedge.length;
					if(newValue<minValue) {
						minValue=newValue;
					}
				}
				if(minValue<dyanamicSolution[k][edge.endNode-1]) {
					dyanamicSolution[k][edge.endNode-1]=minValue;
				}
				for(EdgeOutGoing newEdge:problem.graph.get(edge.endNode).outgoing) {
					queue.add(newEdge);
				}
			}
			queue.poll();
			queue.offer(null);
		}
		return dyanamicSolution;
	}
}

class EdgeOutGoing {
	public int length;
	public int endNode;
	public EdgeOutGoing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EdgeOutGoing(int length, int endNode) {
		super();
		this.length = length;
		this.endNode = endNode;
	}
	@Override
	public String toString() {
		return "EdgeOutGoing [length=" + length + ", endNode=" + endNode + "]";
	}		
}

class EdgeInComing {
	public int length;
	public int startNode;
	public EdgeInComing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EdgeInComing(int length, int startNode) {
		super();
		this.length = length;
		this.startNode = startNode;
	}
	@Override
	public String toString() {
		return "EdgeOutGoing [length=" + length + ", startNode=" + startNode + "]";
	}		
}

class InOutEdge {
	public ArrayList<EdgeOutGoing> outgoing=new ArrayList<>();
	public ArrayList<EdgeInComing> incoming=new ArrayList<>();
}

class ProblemData {
	public Map<Integer, InOutEdge> graph;
	int vertexCount;
	int edgeCount;
}

