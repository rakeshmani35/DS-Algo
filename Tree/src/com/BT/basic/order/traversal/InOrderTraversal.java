package com.BT.basic.order.traversal;

import java.util.Stack;

public class InOrderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void inorder_recursive(Node root) {

		if (root == null) {
			return;
		}

		inorder_recursive(root.left);
		
		System.out.print(root.data + " ");
		
		inorder_recursive(root.right);
		
		return;
	}
	
	// this method just for learning of recursion
	public static void inorder_test(Node root) {

		if (root == null) {
			return;
		}

		inorder_recursive(root.left);
		
		System.out.print(root.data + " ");
		if (root.data==2 || root.data==3) {
			return;
		}
		
		inorder_recursive(root.right);
		
		return;
	}

	public static void inorderIterative_OneStack_Approach1(Node root) {

		Stack<Node> stack = new Stack<Node>();

		while (true) {

			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			if (stack.isEmpty()) {
				return;
			}

			root = stack.pop();
			System.out.print(root.data + " ");
			root = root.right;
		}

	}

	public static void inorderIterative_OneStack_Approach2(Node root) {

		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();

		while (root != null || stack.size() > 0) {

			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			System.out.print(root.data + " ");
			root = root.right;

		}

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		inorder_recursive(root);
		
		System.out.println();
		inorderIterative_OneStack_Approach1(root);

		System.out.println();
		inorderIterative_OneStack_Approach2(root);

	}

}


/* Constructed binary tree is 
        1         = level 0
      /   \ 
     2     3      = level 1
    /  \   / \ 
   4    5 6   7   = level 2
*/

/**
 * Inorder traversal
 * 4 2 5 1 6 3 7 
 */ 
