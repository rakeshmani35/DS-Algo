package com.is.largest.bst;

public class FindLargestBSTinBT {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static int findLargestBST(Node root) {

		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return size(root);
		}

		int left = findLargestBST(root.left);
		int right = findLargestBST(root.right);

		return Math.max(left, right);
	}

	// pre-order
	private static boolean isBST(Node root, int min, int max) {

		if (root == null) {
			return true;
		}

		if (root.data < min || root.data > max) {
			return false;
		}

		boolean left = isBST(root.left, min, root.data);
		boolean right = isBST(root.right, root.data, max);

		return left && right;
	}

	// size
	private static int size(Node root) {

		if (root == null) {
			return 0;
		}

		int leftSize = size(root.left);
		int rightSize = size(root.right);

		return 1 + leftSize + rightSize;

	}

	public static void main(String[] args) {

		Node root = new Node(10);

		root.left = new Node(15);
		root.right = new Node(8);

		root.left.left = new Node(12);
		root.left.right = new Node(20);

		root.right.left = new Node(5);
		root.right.right = new Node(2);
		
		
		int largestSizeOfBST = findLargestBST(root);
		
		System.out.println("Largest Size of BST = "+largestSizeOfBST);
	}

}
