package com.pranab.challenges;

import java.util.*;
import java.io.*;

class Node105 {
    Node105 left;
    Node105 right;
    int data;
    
    Node105(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {

	 

	
	public static void topView(Node105 root) {
		Map<String,Integer> memo=new HashMap<>();
		Map<String,Integer> result=new HashMap<>();
		result.put("Base",root.data);
		viewTop(0,0,root,memo,result,0);
		for(int num:result.values()) {
			System.out.print(num+ " ");
		}
    }

	public static void viewTop(int rightIndex,int leftIndex,Node105 root,Map<String,Integer> memo,Map<String,Integer> result,int level){
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			leftIndex++;
			if(leftIndex>0&&!memo.containsKey("L"+leftIndex)) {
				result.put("L"+leftIndex,root.left.data);
				memo.put("L"+leftIndex,level);
			}else if(leftIndex>0&&memo.containsKey("L"+leftIndex)){
				int index=memo.get("L"+leftIndex);
				if(level<index) {
					result.put("L"+leftIndex,root.left.data);
					memo.put("L"+leftIndex,level);
				}
			}
		}
		if(root.right!=null) {
			rightIndex++;
			if(rightIndex>0&&!memo.containsKey("R"+rightIndex)) {
				result.put("R"+rightIndex,root.right.data);
				memo.put("R"+rightIndex,level);
			}else if(rightIndex>0&&memo.containsKey("R"+rightIndex)){
				int index=memo.get("R"+rightIndex);
				if(level<index) {
					result.put("R"+rightIndex,root.right.data);
					memo.put("R"+rightIndex,level);
				}
			}
		}
		viewTop(-1*leftIndex,leftIndex,root.left,memo,result,level+1);
		viewTop(rightIndex,-1*rightIndex,root.right,memo,result,level+1);
		
	}
	
	public static Node105 insert(Node105 root, int data) {
        if(root == null) {
            return new Node105(data);
        } else {
            Node105 cur;
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
        Node105 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
