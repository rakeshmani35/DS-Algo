package com.BT.basic.order.traversal;

import java.util.LinkedList;
import java.util.Queue;

// Approach:1- https://algorithms.tutorialhorizon.com/binary-tree-preorder-traversal-non-recursive-approach/
// Approach:1- https://www.geeksforgeeks.org/iterative-preorder-traversal/

import java.util.Stack;

public class PreorderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void preorder(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void preorder_iterative_OneStack_Approach1(Node root) {

		Stack<Node> stack = new Stack<Node>();

		// while (root!=null || !stack.isEmpty()) { // condition:1
		while (true) { // condition:2

			while (root != null) {
				System.out.print(root.data + " ");
				stack.push(root);
				root = root.left;
			}

			// condition:2
			if (stack.isEmpty()) {
				return;
			}
			root = stack.pop();
			root = root.right;
		}

	}

	public static void preorder_iterative_OneStack_Approach2(Node root) {

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			
			Node current = stack.pop();
			System.out.print(current.data+" ");
			
			if (current.right!=null) {
				stack.push(current.right);
			}
			if (current.left!=null) {
				stack.push(current.left);
			}
		}
	}

	public static void preorder_iterative_oneStack_oneQueue(Node root) {
		
		Stack<Node> s1 = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		
		s1.push(root);
		
		while (!s1.isEmpty()) { 
			Node temp = s1.pop();
			
			queue.add(temp);
			
			if (temp.right!=null) {
				s1.push(temp.right);
			}
			if (temp.left!=null) {
				s1.push(temp.left);
			}
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.poll().data+" ");
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

		preorder(root);

		System.out.println();
		preorder_iterative_OneStack_Approach1(root);
		
		System.out.println();
		preorder_iterative_OneStack_Approach2(root);
		
		System.out.println();
		preorder_iterative_oneStack_oneQueue(root);
	}

}

/**
 * pre-order traversal : 1 2 4 5 3 6 7
 */