package com.pranab.challenges;

import java.util.*;

public class BST_common_ansistor {
	
	public static Node lca(Node root, int v1, int v2) {
        Node result = null;
        List<Node> parents1 = new ArrayList<>();
        List<Node> parents2 = new ArrayList<>();
        findParents(root, v1, parents1);
        findParents(root, v2, parents2);
        Set<Node> setAll = new HashSet<>(parents1);
        for (int index = parents2.size()-1; index >= 0; index--) {
            Node element = parents2.get(index);
            if (!setAll.add(element)) {
                result = element;
                break;
            }
        }
        return result;
    }

    public static void findParents(Node root, int value, List<Node> parents) {
        if (root.data == value) {
            parents.add(root);
            return;
        } else {
            if (value <= root.data) {
                parents.add(root);
                root = root.left;
                findParents(root, value, parents);
            } else {
                parents.add(root);
                root = root.right;
                findParents(root, value, parents);
            }
        }
    }

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
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
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		int v1 = scan.nextInt();
		int v2 = scan.nextInt();
		scan.close();
		Node ans = lca(root, v1, v2);
		System.out.println(ans.data);
	}
}

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}