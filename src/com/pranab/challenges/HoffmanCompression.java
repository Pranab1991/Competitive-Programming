package com.pranab.challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HoffmanCompression {

	public static void main(String[] args) throws FileNotFoundException {
		Queue<HoffmanNode> dataQueue = readAndStructure();
		while (dataQueue.size() > 2) {
			compress(dataQueue);
		}
		HoffmanNode newNode=new HoffmanNode();
		newNode.leftChild=dataQueue.poll();
		newNode.rightChild=dataQueue.poll();
		System.out.println(findMinCode(newNode,0));
		System.out.println(findMaxCode(newNode,0));
		System.out.println("done dona done");
	}

	public static Queue<HoffmanNode> readAndStructure() throws FileNotFoundException {
		Scanner reader = new Scanner(new File("hoffman.txt"));
		int count = reader.nextInt();
		PriorityQueue<HoffmanNode> queue = new PriorityQueue<>((o1, o2) -> {
			int result = o1.frequency.compareTo(o2.frequency);
			if (result != 0) {
				return result;
			} else {
				return 1;
			}
		});
		while (reader.hasNext()) {
			HoffmanNode node = new HoffmanNode();
			node.nodeData=count;
			node.frequency = reader.nextLong();
			queue.offer(node);
			count--;
		}
		return queue;
	}

	public static void compress(Queue<HoffmanNode> dataQueue) {
		HoffmanNode minfreq = dataQueue.poll();
		HoffmanNode minSecfreq = dataQueue.poll();
		HoffmanNode newNode=new HoffmanNode();
		newNode.frequency=minfreq.frequency+minSecfreq.frequency;
		newNode.leftChild=minfreq;
		newNode.rightChild=minSecfreq;
		dataQueue.offer(newNode);
	}
	
	public static int findMinCode(HoffmanNode node,int min) {
		if(node.leftChild==null&&node.rightChild==null) {
			return min;
		}
		int minRight=min;
		if(node.rightChild!=null) {
			minRight=findMinCode(node.rightChild,min+1);
		}
		int minLeft=min;
		if(node.leftChild!=null) {
			minLeft=findMinCode(node.leftChild,min+1);
		}
		return Math.min(minLeft, minRight);
	}
	
	public static int findMaxCode(HoffmanNode node,int max) {
		if(node.leftChild==null&&node.rightChild==null) {
			return max;
		}
		int maxRight=max;
		if(node.rightChild!=null) {
			maxRight=findMaxCode(node.rightChild,max+1);
		}
		int maxLeft=max;
		if(node.leftChild!=null) {
			maxLeft=findMaxCode(node.leftChild,max+1);
		}
		return Math.max(maxLeft, maxRight);
	}
}

class HoffmanNode {
	public int nodeData;
	public Long frequency;
	public HoffmanNode leftChild;
	public HoffmanNode rightChild;

	@Override
	public String toString() {
		return "HoffmanNode [nodeData=" + nodeData + ", frequency=" + frequency + "]";
	}
}