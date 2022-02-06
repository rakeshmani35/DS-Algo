package com.is.largest.bst;

//https://www.youtube.com/watch?v=MILxfAbIhrE
//https://www.techiedelight.com/determine-given-binary-tree-is-a-bst-or-not/
//In-Order Traversal
public class FindGivenBinaryTreeIsBST2 {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static boolean isBst(Node root, Node prev) {

		// base condition
		if (root == null) {
			return true;
		}

		boolean left = isBst(root.left, prev);

		if (root.data <= prev.data) {
			return false;
		}
		prev = root;

		boolean right = isBst(root.right, prev);

		return left && right;
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(8);

		Node prev = new Node(Integer.MIN_VALUE);
		boolean isBst = isBst(root, prev);
		
		System.out.println("Is Bst : "+isBst);
	}

}
