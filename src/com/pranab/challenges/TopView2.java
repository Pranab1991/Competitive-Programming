package com.pranab.challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Node104 {
    Node104 left;
    Node104 right;
    int data;
    
    Node104(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopView2 {
	public static Node104 insert(Node104 root, int data) {
        if(root == null) {
            return new Node104(data);
        } else {
            Node104 cur;
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
        Node104 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView2(root);
    }

	private static void topView2(Node104 root) {
		class QueueObj{
			int hd;
			Node104 node;
			public QueueObj(int hd, Node104 node) {
				super();
				this.hd = hd;
				this.node = node;
			}
			
		}
		
		Queue<QueueObj> queueObj=new LinkedList<>();
		Map<Integer,Node104> hdMap=new HashMap<>();
		queueObj.offer(new QueueObj(0, root));
		hdMap.put(0,root);
		while(!queueObj.isEmpty()) {
			QueueObj obj=queueObj.poll();
			if(obj.node.left!=null) {
				int lefthd=obj.hd-1;
				if(!hdMap.containsKey(lefthd)) {
					hdMap.put(lefthd,obj.node.left);
				}
				queueObj.offer(new QueueObj(lefthd, obj.node.left));
			}
			if(obj.node.right!=null) {
				int righthd=obj.hd+1;
				if(!hdMap.containsKey(righthd)) {
					hdMap.put(righthd,obj.node.right);
				}
				queueObj.offer(new QueueObj(righthd, obj.node.right));
			}
		}
		
		for(Node104 value:hdMap.values()) {
			System.out.print(value.data+" ");
		}
	}	
}
