package com.k.leaves.bt;

// https://www.geeksforgeeks.org/print-nodes-binary-tree-k-leaves/
// https://www.youtube.com/watch?v=u2O11mengx8&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=23
// Post Order Traversal + Leaf counter
public class PrintNodesHasKLeaves {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static int findKLeavesNode(Node root, int k) {

		// Base Conditions : No leaves
		if (root == null) {
			return 0;
		}

		// if node is leaf
		if (root.left == null && root.right == null) {
			return 1;
		}

		int lc = findKLeavesNode(root.left, k);

		int rc = findKLeavesNode(root.right, k);

		// total leaves in subtree rooted with this node
		int tlc = lc + rc;

		if (tlc == k) {
			System.out.print(root.data + " ");

		}

		return tlc;
	}

	public static void main(String[] args) {

/* Constructed binary tree is 
        1         = level 0
      /    \ 
     2      3     = level 1
    /  \    / 
   4    5  8      = level 2
          /
         9
*/
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);
		root.right.left.left = new Node(9);

		int k = 1;
		findKLeavesNode(root, k);
	}

}
