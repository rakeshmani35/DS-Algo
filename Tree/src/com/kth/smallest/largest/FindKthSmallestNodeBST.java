package com.kth.smallest.largest;

public class FindKthSmallestNodeBST {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int count = 0;

	// In-order: is sorted order
	public static Node kthSmallest_Inorder(Node root, int k) {

		// base case
		if (root == null) {
			return null;
		}
		Node left = kthSmallest_Inorder(root.left, k);

		// if k'th smallest is found in left subtree, return it
		if (left != null) {
			return left;
		}

		// if current element is k'th smallest, return it
		count++;
		if (count == k) {
			return root;
		}

		// else search in right subtree
		Node right = kthSmallest_Inorder(root.right, k);

		return right;
	}
	
	public static Node inorder(Node root) {
		
		// base case
		if (root == null) {
			return null;
		}
		Node left = inorder(root.left);

		System.out.print(root.data+" ");

		// else search in right subtree
		Node right = inorder(root.right);

		return right;
	}

	public static void main(String[] args) {

		Node root = new Node(15);

		root.left = new Node(10);
		root.right = new Node(20);

		root.left.left = new Node(8);
		root.left.right = new Node(12);

		root.right.left = new Node(16);
		root.right.right = new Node(25);

		int k = 2;

		//Node kthSmallest = kthSmallest_Inorder(root, k);
		//System.out.println(k + "th node in BST : " + kthSmallest.data);
		
		inorder(root);
	}

}
