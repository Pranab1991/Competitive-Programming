package com.pranab.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeVerticalWork {

	public static Node106 insert(Node106 root, int data) {
        if(root == null) {
            return new Node106(data);
        } else {
            Node106 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node106 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        verticalWalk(root);
    }

	private static void verticalWalk(Node106 root) {
		Map<Integer,List<Integer>> storage=new HashMap<>();
		walkVertical(root,0,storage);
		storage.get(0).add(root.data);
		System.out.println("done");
	}
	
	private static void walkVertical(Node106 node,int shift,Map<Integer,List<Integer>> storage) {
		if(node==null) {
			return;
		}
		if(node.left!=null) {
			int leftshift=shift-1;
			if(storage.containsKey(leftshift)) {
				storage.get(leftshift).add(node.left.data);
			}else {
				List<Integer> data=new ArrayList<>();
				data.add(node.left.data);
				storage.put(leftshift, data);
			}
			walkVertical(node.left,leftshift,storage);
		}
		if(node.right!=null) {
			int rightShift=shift+1;
			if(storage.containsKey(rightShift)) {
				storage.get(rightShift).add(node.right.data);
			}else {
				List<Integer> data=new ArrayList<>();
				data.add(node.right.data);
				storage.put(rightShift, data);
			}
			walkVertical(node.right,rightShift,storage);
		}		
	}
}

class Node106 {
    Node106 left;
    Node106 right;
    int data;
    
    Node106(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}