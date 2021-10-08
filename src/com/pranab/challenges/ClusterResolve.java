package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ClusterResolve {

	public static void main(String[] args) throws FileNotFoundException {
		/*UnionFindDataStructure storage=new UnionFindDataStructure();
		storage.create(1);
		storage.create(2);
		storage.create(3);
		storage.create(4);
		storage.create(5);
		storage.create(6);
		
		System.out.println(storage.find(1).nodeValue);
		System.out.println(storage.find(6).nodeValue);
		System.out.println(storage.findleaders());
		System.out.println("LEADERS : "+storage.leaders);
		storage.union(1, 6);
		
		System.out.println(storage.find(1).nodeValue);
		System.out.println(storage.find(6).nodeValue);
		System.out.println(storage.findleaders());
		storage.union(2, 3);
		System.out.println("LEADERS : "+storage.leaders);
		System.out.println(storage.findleaders());
		storage.union(3, 4);
		System.out.println("LEADERS : "+storage.leaders);
		System.out.println(storage.findleaders());
		storage.union(6, 2);
		System.out.println("LEADERS : "+storage.leaders);
		System.out.println(storage.findleaders());
		System.out.println(storage.find(3).nodeValue);
		System.out.println(storage.find(4).nodeValue);
		storage.union(1, 2);
		System.out.println("LEADERS : "+storage.leaders);
		System.out.println(storage.find(5).nodeValue);
		System.out.println(storage.findleaders());*/
		List<GraphNode> data=new ArrayList<>();
		Scanner scan=new Scanner(new File("clustering.txt"));
		UnionFindDataStructure storage=new UnionFindDataStructure();
		int abc=scan.nextInt();
		while(scan.hasNext()) {
			int nodeStart=scan.nextInt();
			int nodeEnd=scan.nextInt();
			int distance=scan.nextInt();
			GraphNode node=new GraphNode(nodeStart,distance,nodeEnd);
			data.add(node);
			storage.create(nodeStart);
			storage.create(nodeEnd);
		}		
		Collections.sort(data);
		for(GraphNode datanode:data) {
			storage.union(datanode.startNode, datanode.endNode);
			if(storage.leaders==4) {
				break;
			}
		}
		
		System.out.println(storage.findleaders());
	}
	
	
}

class UnionFindDataStructure{
	 public Map<Integer,UnionFindNode> storage=new HashMap<>();
	 public int leaders;
	 public void create(int nodeValue) {
		 UnionFindNode node=new UnionFindNode();
		 node.nodeValue=nodeValue;
		 node.parent=node;
		 if(!storage.containsKey(nodeValue)) {
			 storage.put(nodeValue, node);
			 leaders=storage.size();
		 }
	 }
	 
	 public UnionFindNode find(int nodeValue) {
		 UnionFindNode node=storage.get(nodeValue);
		 while(node.parent!=node) {
			 node=node.parent;
		 }
		 return node;
	 }
	 
	 public void union(int oneNodeVal,int secondNodeVal) {
		 UnionFindNode leaderOne=find(oneNodeVal);
		 UnionFindNode leaderTwo=find(secondNodeVal);
		 if(leaderOne==leaderTwo) {
			 return;
		 }else {
			 leaderTwo.parent=leaderOne;
			 leaders--;
		 }
	 }
	 
	 public List<Integer> findleaders(){
		 List<Integer> list=new ArrayList<>();
		 for(UnionFindNode node:storage.values()) {
			 while(node.parent!=node) {
				 node=node.parent;
			 }
			 if(!list.contains(node.nodeValue)) {
				 list.add(node.nodeValue); 
			 }
		 }
		 return list;
	 }
}

class UnionFindNode {
	
	public int nodeValue;
	public UnionFindNode parent;
	public UnionFindNode() {
		super();
	}
	public UnionFindNode(int nodeValue, UnionFindNode parent) {
		super();
		this.nodeValue = nodeValue;
		this.parent = parent;
	}		
}

class GraphNode implements Comparable<GraphNode>{
	public int startNode;
	public Integer distance;
	public int endNode;
	public GraphNode(int startNode, int distance, int endNode) {
		super();
		this.startNode = startNode;
		this.distance = distance;
		this.endNode = endNode;
	}
	public GraphNode() {
		super();
	}
	@Override
	public int compareTo(GraphNode o) {
		return this.distance.compareTo(o.distance);
	}	
}