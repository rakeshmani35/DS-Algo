package com.depth;

public class FindDepthOfNodeInBinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;
	};

	// Utility function to create a new Binary Tree Node
	static Node newNode(int item) {
		Node temp = new Node();
		temp.data = item;
		temp.left = temp.right = null;
		return temp;
	}

	static int depth(Node root, int x) {

		// Base case
		if (root == null)
			return -1;

		// Initialize distance as -1
		// int dept = -1;

		// Check if x is current node=
		if ((root.data == x)) {

		}

		int l = depth(root.left, x);

		int r = depth(root.left, x);

		/*
		 * if (l > r) { dept = l + 1; } else { dept = r + 1; }
		 */

		int dept = Math.max(l, r) + 1;

		if (root.data == x) {
			return dept;
		}
		return dept;
	}

	static int findDepth(Node root, int x) {
		// Base case
		if (root == null)
			return -1;

		// Initialize distance as -1
		int dist = -1;

		// Check if x is current node=
		if ((root.data == x))
		{
			return dist + 1;
		}
		int l = findDepth(root.left, x);
		int r = findDepth(root.right, x);

		if (l >= 0) {
			dist = l + 1;
		} else if (r >= 0) {
			dist = r + 1;
		}

		return dist;
	}

	public static void main(String[] args) {

		// Binary Tree Formation
		Node root = newNode(5);
		root.left = newNode(10);
		root.right = newNode(15);
		root.left.left = newNode(20);
		root.left.right = newNode(25);
		root.left.right.right = newNode(45);
		root.right.left = newNode(30);
		root.right.right = newNode(35);

		int k = 25;

		// int depth = depth(root, k);

		// System.out.println("find depth : " + depth);

		int depth1 = findDepth(root, k);

		System.out.println("find depth : " + depth1);
	}

}
