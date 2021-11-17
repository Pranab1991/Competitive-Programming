package com.pranab.challenges;

import java.util.HashMap;
import java.util.Map;

class BinaryNode<T extends Comparable<T>> {
	T key;
	BinaryNode<T> parent;
	BinaryNode<T> leftChild;
	BinaryNode<T> rightChild;
}

public class BinarySearchTree<T extends Comparable<T>> {

	private Map<T, BinaryNode<T>> storage = new HashMap<>();
	private BinaryNode<T> root = null;

	public void insert(T key) {
		BinaryNode<T> node = new BinaryNode<>();
		node.key = key;
		storage.put(key, node);

		BinaryNode<T> temp = root;
		BinaryNode<T> parent = null;
		while (temp != null) {
			parent = temp;
			if (node.key.compareTo(temp.key) < 0) {
				temp = temp.leftChild;
			} else {
				temp = temp.rightChild;
			}
		}
		node.parent = parent;
		if (parent == null) {
			root = node;
		} else if (node.key.compareTo(parent.key) < 0) {
			parent.leftChild = node;
		} else {
			parent.rightChild = node;
		}
	}

	public boolean searchExist(T key) {
		boolean result = false;
		BinaryNode<T> temp = root;
		while (temp != null) {
			if (key == temp.key) {
				result = true;
				break;
			} else {
				if (key.compareTo(temp.key) < 0) {
					temp = temp.leftChild;
				} else {
					temp = temp.rightChild;
				}
			}
		}
		return result;
	}

	public BinaryNode<T> searchNode(T key) {
		BinaryNode<T> result = null;
		BinaryNode<T> temp = root;
		while (temp != null) {
			if (key == temp.key) {
				result = temp;
				break;
			} else {
				if (key.compareTo(temp.key) < 0) {
					temp = temp.leftChild;
				} else {
					temp = temp.rightChild;
				}
			}
		}
		return result;
	}

	public boolean searchConstTimeExit(T key) {
		boolean result = false;
		if (storage.containsKey(key)) {
			result = true;
		}
		return result;
	}

	public BinaryNode<T> searchConstTimeNode(T key) {
		BinaryNode<T> result = null;
		if (storage.containsKey(key)) {
			result = storage.get(key);
		}
		return result;
	}

	public T min() {
		BinaryNode<T> temp = root;
		if (temp == null) {
			return null;
		}
		while (temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp.key;
	}

	public T min(T key) {
		BinaryNode<T> temp = searchConstTimeNode(key);
		if (temp == null) {
			return null;
		}
		while (temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp.key;
	}
	
	public BinaryNode<T> minNode(T key) {
		BinaryNode<T> temp = searchConstTimeNode(key);
		if (temp == null) {
			return null;
		}
		while (temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp;
	}

	public T max() {
		BinaryNode<T> temp = root;
		if (temp == null) {
			return null;
		}
		while (temp.rightChild != null) {
			temp = temp.rightChild;
		}
		return temp.key;
	}

	public T max(T key) {
		BinaryNode<T> temp = searchConstTimeNode(key);
		if (temp == null) {
			return null;
		}
		while (temp.rightChild != null) {
			temp = temp.rightChild;
		}
		return temp.key;
	}

	public T predecessor(T key) {
		T result = null;
		BinaryNode<T> temp = searchConstTimeNode(key);
		if (temp != null && temp.leftChild != null) {
			result = max(temp.leftChild.key);
		} else {
			while (temp.parent != null && temp == temp.parent.leftChild) {
				temp = temp.parent;
			}
			result = temp.parent.key;
		}
		return result;
	}

	public T successor(T key) {
		T result = null;
		BinaryNode<T> temp = searchConstTimeNode(key);
		if (temp != null && temp.rightChild != null) {
			result = min(temp.rightChild.key);
		} else {
			while (temp.parent != null && temp == temp.parent.rightChild) {
				temp = temp.parent;
			}
			result = temp.parent.key;
		}
		return result;
	}

	private void transplant(BinaryNode<T> outGoing, BinaryNode<T> inComing) {
		if (outGoing.parent == null) {
			root = inComing;
			return;
		}
		if (outGoing == outGoing.parent.leftChild) {
			outGoing.parent.leftChild = inComing;
		} else {
			outGoing.parent.rightChild = inComing;
		}
		if (inComing != null) {
			inComing.parent = outGoing.parent;
		}
	}
	
	public void delete(T key) {
		BinaryNode<T> deletenode=searchNode(key);
		if(deletenode.leftChild==null) {
			transplant(deletenode, deletenode.rightChild);
		}else if(deletenode.rightChild==null) {
			transplant(deletenode, deletenode.leftChild);
		}else {
			BinaryNode<T> inNode=minNode(deletenode.rightChild.key);
			if(inNode.parent!=deletenode) {
				transplant(inNode, inNode.rightChild);
				inNode.rightChild=deletenode.rightChild;
				deletenode.rightChild.parent=inNode;
			}
			transplant(deletenode, inNode);
			inNode.leftChild=deletenode.leftChild;
			deletenode.leftChild.parent=inNode;
		}
		storage.remove(deletenode.key);
	}
	
	public void walk(BinaryNode<T> node) {
		if(node==null) {
			return;
		}
		BinaryNode<T> temp=node;
		walk(temp.leftChild);
		System.out.print(temp.key+", ");
		walk(temp.rightChild);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(15);
		tree.insert(6);
		tree.insert(3);
		tree.insert(7);
		tree.insert(2);
		tree.insert(4);
		tree.insert(13);
		tree.insert(9);
		tree.insert(18);
		tree.insert(17);
		tree.insert(20);
		tree.insert(19);
		tree.walk(tree.root);
		System.out.println();
		tree.delete(15);
		tree.walk(tree.root);
		System.out.println();
		System.out.println("done");
	}
}
