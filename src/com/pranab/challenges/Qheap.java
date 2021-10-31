package com.pranab.challenges;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Qheap {

	private static final List<Integer> STORAGE=new ArrayList<>();
	
	private static int getParent(int child) {		
		return	(child-1)/2;
	}
	
	private static int getLeftChild(int parent) {
		return (parent*2+1);
	}
	
	private static int getRightChild(int parent) {
		return (parent*2+2);
	}
	
	private static void minheapyfy(int index) {
		int leftIndex=getLeftChild(index);
		int rightIndex=getRightChild(index);
		int smallest=index;
		if(leftIndex<STORAGE.size()&&STORAGE.get(leftIndex)<STORAGE.get(smallest)) {
			smallest=leftIndex;
		}
		if(rightIndex<STORAGE.size()&&STORAGE.get(rightIndex)<STORAGE.get(smallest)) {
			smallest=rightIndex;
		}
		if(index!=smallest) {
			int temp=STORAGE.get(index);
			STORAGE.set(index, STORAGE.get(smallest));
			STORAGE.set(smallest, temp);
			minheapyfy(smallest);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter writer=new PrintWriter(new File("IamThangos.txt"));
		int testcases=sc.nextInt();
		while(testcases>0) {
			int choice=sc.nextInt();
			heapDriver(choice,sc,writer);
			testcases--;
		}
		writer.close();
	}

	private static void heapDriver(int choice,Scanner sc,PrintWriter writer) {
		if(choice==1) {
			int addNum=sc.nextInt();
			addNumToHeap(addNum);
		}else if(choice==2) {
			int deleteNum=sc.nextInt();
			deleteNumFromHeap(deleteNum);
		}else {
			printMinHeap(writer);
		}
		
	}

	private static void printMinHeap(PrintWriter stream) {
		//System.out.println(STORAGE.get(0));
			stream.print(STORAGE.get(0));
			stream.println();
		
	}

	private static void deleteNumFromHeap(int deleteNum) {
		int index = STORAGE.indexOf(deleteNum);
		int lastIndex = STORAGE.size() - 1;
		STORAGE.set(index, STORAGE.get(lastIndex));
		STORAGE.remove(lastIndex);
		if (index != lastIndex) {
			int leftChildIndex = getLeftChild(index);
			int rigthChildIndex = getRightChild(index);
			int parent = getParent(index);
			if (leftChildIndex < lastIndex && STORAGE.get(leftChildIndex) < STORAGE.get(index)) {
				minheapyfy(index);
			} else if (rigthChildIndex < lastIndex && STORAGE.get(rigthChildIndex) < STORAGE.get(index)) {
				minheapyfy(index);
			} else if (index > 0 && STORAGE.get(index) < STORAGE.get(parent)) {
				while (index > 0 && STORAGE.get(index) < STORAGE.get(parent)) {
					int temp = STORAGE.get(index);
					STORAGE.set(index, STORAGE.get(parent));
					STORAGE.set(parent, temp);
					index = parent;
					parent = getParent(index);
				}
			}
		}
	}

	private static void addNumToHeap(int newNum) {
		STORAGE.add(newNum);
		int index=STORAGE.size()-1;
		int parentIndex=getParent(index);
		while(index>0&&STORAGE.get(index)<STORAGE.get(parentIndex)) {
			int temp=STORAGE.get(index);
			STORAGE.set(index, STORAGE.get(parentIndex));
			STORAGE.set(parentIndex, temp);
			index=parentIndex;
			parentIndex=getParent(index);
		}
	}
}
