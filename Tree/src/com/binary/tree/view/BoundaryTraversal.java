package com.binary.tree.view;

import java.util.HashSet;
import java.util.Set;

// https://www.youtube.com/watch?v=uemjIijtu2I
public class BoundaryTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void printBoundary(Node root) {

		Set<Integer> set = null;
		if (root != null) {

			 set = new HashSet<Integer>();
			 set.add(root.data);

			leftBoundaryTraversal(root, set);
			rightBoundaryTraversal(root, set);
			leafBoundaryTraversal(root, set);
		}
		
		return ;

	}

	public static void leftBoundaryTraversal(Node root, Set<Integer> set) {
		if (root != null) {

			if (root.left != null) { // not consider root
				set.add(root.left.data);
				System.out.println(root.left.data);
				leftBoundaryTraversal(root.left, set);

			} else if (root.right != null) {
				set.add(root.right.data);
				System.out.println(root.right.data);
				leftBoundaryTraversal(root.right, set);

			}
		}
	}

	public static void rightBoundaryTraversal(Node root, Set<Integer> set) {
		if (root != null) {

			if (root.right != null) { // not consider root
				set.add(root.right.data);
				System.out.println(root.right.data);
				leftBoundaryTraversal(root.right, set);

			} else if (root.left != null) {
				set.add(root.left.data);
				System.out.println(root.left.data);
				leftBoundaryTraversal(root.left, set);

			}
		}
	}

	public static void leafBoundaryTraversal(Node root, Set<Integer> set) {

		if (root == null) {
			return;
		}

		leafBoundaryTraversal(root.left, set);

		if (root.left == null && root.right == null) {
			set.add(root.data);
			System.out.println(root.data);
		}

		leafBoundaryTraversal(root.right, set);
	}

	public static void main(String[] args) {

/* Constructed binary tree is 
        1        = level 0
      /   \ 
     2     3     = level 1
    /  \   / 
   4    5 8      = level 2
*/
		
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);

		printBoundary(root);
	}

}
