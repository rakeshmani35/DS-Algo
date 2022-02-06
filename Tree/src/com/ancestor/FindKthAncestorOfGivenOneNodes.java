package com.ancestor;

import java.util.ArrayList;
import java.util.List;

// https://www.techiedelight.com/find-all-nodes-at-given-distance-from-leaf-nodes-in-a-binary-tree/
public class FindKthAncestorOfGivenOneNodes {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int k;

	public static Node findKthAncestor_Approach1(Node root, int n, int k, List<Integer> list) {

		Node findNthAncestor = findNthAncestor(root, n, list);

		System.out.print(k + "th ancestor of node = " + n + " is: " + list);

		return findNthAncestor;

	}

	public static Node findNthAncestor(Node root, int n, List<Integer> list) {

		if (root == null) {
			return null;
		}

		Node left = findNthAncestor(root.left, n, list);
		Node right = findNthAncestor(root.right, n, list);

		if (root.data == n || left != null || right != null) {
			if (k > 0) {
				k--;
			} else if (k == 0) {
				// System.out.print("Kth ancestor of node = " + n + " is: " + root.data);
				list.add(root.data);
				// return null to stop further backtracking
				return null;
			}
			// return current node to previous call
			return root;
		}

		return null;
	}

	public static void findKthAncestor_Approach2(Node root, int n,int k, List<Integer> list) {

		allAncester(root, n, list);
		
		System.out.print(k + "th ancestor of node = " + n + " is: " + list.indexOf(k-1));

	}

	private static int allAncester(Node root, int n, List<Integer> list) {
		if (root == null) {
			return 0;
		}

		if (root.data == n) {
			return 1;
		}

		int left = allAncester(root.left, n, list);

		int right = allAncester(root.right, n, list);

		if (left != 0 || right != 0) {
			list.add(root.data);
			return 1;
		}

		return 0;
	}

	public static Node findKthAncestor_Approach3(Node root, int n, int k, List<Integer> list) {

		Node findNthAncestor = findNthAncestor_Approach3(root, n, list);

		System.out.print(k + "th ancestor of node = " + n + " is: " + list);

		return findNthAncestor;

	}

	private static Node findNthAncestor_Approach3(Node root, int n, List<Integer> list) {

		if (root == null) {
			return null;
		}

		if (root.data == n) {
			return root;
		}

		Node left = findNthAncestor_Approach3(root.left, n, list);
		Node right = findNthAncestor_Approach3(root.right, n, list);

		if (left != null || right != null) {

			k--;
			
			if (k == 0) {
				list.add(root.data);
				//return null;
			}
			return root;
		}

		return null;
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

		k = 2;

		System.out.println("Approach-1");
		
		List<Integer> list1 = new ArrayList<Integer>();

		Node parent = findKthAncestor_Approach1(root, 5, k, list1);
		if (parent != null) {
			System.out.print("Kth ancestor is: " + "-1 : means this kth ancestor not found");
		}
		
		System.out.println("\n\nApproach-2");
		List<Integer> list2 = new ArrayList<Integer>();
		findKthAncestor_Approach2(root, 5, 2, list2);
		
		k=2;
		System.out.println("\n\nApproach-3");
		List<Integer> list3 = new ArrayList<Integer>();
		findKthAncestor_Approach3(root, 4, k, list3);
	}

}
