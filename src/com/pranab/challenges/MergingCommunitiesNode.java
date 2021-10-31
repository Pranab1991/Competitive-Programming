package com.pranab.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MergingCommunitiesNode {

	private static class Node{
		int count=1;
		Node parent=null;
	}
	private static Map<Integer, Node> map = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		for (int i = 0; i < arrSize; i++) {
			map.put(i, new Node());
		}
		int queries = sc.nextInt();
		while (queries > 0) {
			String input = sc.next(Pattern.compile("Q|M"));
			if ("Q".equals(input)) {
				int Qinput = sc.nextInt();
				System.out.println(query(Qinput));
			} else {
				int Minput = sc.nextInt();
				int Minput2 = sc.nextInt();
				merge(Minput, Minput2);
			}
			queries--;
		}
	}
	
	private static int query(int qinput) {
		// TODO Auto-generated method stub
		return find(qinput).count;
	}

	private static void merge(int minput, int minput2) {
		Node parentNode1=find(minput);
		Node parentNode2=find(minput2);
		if(parentNode1==parentNode2) {
			return;
		}
		parentNode1.count=parentNode1.count+parentNode2.count;
		parentNode2.parent=parentNode1;
	}

	private static Node find(int index) {
		index--;
		Node temp=map.get(index);
		while (temp.parent != null) {
			temp=temp.parent;
		}
		return temp;
	}
	
	
}
