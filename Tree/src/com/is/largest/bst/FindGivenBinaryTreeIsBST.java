package com.is.largest.bst;

// https://www.youtube.com/watch?v=MILxfAbIhrE
// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
// https://www.techiedelight.com/determine-given-binary-tree-is-a-bst-or-not/
// Pre-Order Traversal
public class FindGivenBinaryTreeIsBST {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static boolean findBst(Node root) {

		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBst(Node root, int minKey, int maxKey) {

		// base case
		if (root == null) {
			return true;
		}

		// if nodes false outside valid range
		if (root.data < minKey || root.data > maxKey) {
			return false;
		}

		boolean left = isBst(root.left, minKey, root.data - 1);

		boolean right = isBst(root.right, root.data + 1, maxKey);

		return left && right;
	}

	public static void main(String[] args) {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		
	}

}
