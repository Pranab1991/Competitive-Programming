package com.pranab.challenges;
import java.util.*;
import java.io.*;

class NodeAll {
    NodeAll left;
    NodeAll right;
    int data;
    
    NodeAll(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Salvation {

	/* 
    
    class NodeAll 
    	int data;
    	NodeAll left;
    	NodeAll right;
	*/
	public static void levelOrder(NodeAll root) {
      Queue<NodeAll> queue=new LinkedList<>();
      queue.add(root);
      while(queue.size()>0) {
    	NodeAll inspected=queue.poll();
    	if(inspected.left!=null) {queue.add(inspected.left);}
    	if(inspected.right!=null) {queue.add(inspected.right);}
    	System.out.print(inspected.data);
      }      
    }

	public static NodeAll insert(NodeAll root, int data) {
        if(root == null) {
            return new NodeAll(data);
        } else {
            NodeAll cur;
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
        NodeAll root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}