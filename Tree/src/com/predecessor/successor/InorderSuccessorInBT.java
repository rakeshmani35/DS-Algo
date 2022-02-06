package com.predecessor.successor;

public class InorderSuccessorInBT {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node store;
	public static void inorderSuccessor(Node root, int key) {
		
		root = findNode(root, key);
		
		// case1 : if given node has right subtree, then find min value in right subtree
		
		// case2 : if given node does not has right subtree, find node from where taken last left
	}
	
	public static Node findNode(Node root, int key) {
		
		if (root==null) {
			return null;
		}
		
		if (root.data==key) {
			return root;
		}
		
		Node left = findNode(root.left, key);
		if (left!=null) { // node found, no need to look further
			return left;
		}
		
		Node right = findNode(root.right, key);
		
		return right;
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);

	}

}
