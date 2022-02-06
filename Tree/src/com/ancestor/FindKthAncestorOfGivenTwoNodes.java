package com.ancestor;

/**
 * This is combination of common Ancestor of 2 node + common Ancestor of 1
 * node.
 * 
 * @author rakes
 *
 */
public class FindKthAncestorOfGivenTwoNodes {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int k;

	public static Node findKthAncestorOfOneNode(Node root, int n) {

		if (root == null) {
			return null;
		}

		Node left = findKthAncestorOfOneNode(root.left, n);
		Node right = findKthAncestorOfOneNode(root.right, n);

		if ((root.data == n || left != null || right != null)) {
			if (k > 1)
				k--;

			else if (k == 1) {
				System.out.print("Kth ancestor is: " + root.data);

				// return null to stop further backtracking
				return null;
			}

			// return current node to previous call
			return root;
		}

		return null;
	}

	// https://www.youtube.com/watch?v=13m9ZCB8gjw tushar roy
	public static Node lowestCommonAncestorOfTwoNodes(Node root, int n1, int n2) {

		if (root == null) {
			return null;
		}

		if (root.data == n1 || root.data == n2) {
			return root;
		}

		Node left = lowestCommonAncestorOfTwoNodes(root.left, n1, n2);

		Node right = lowestCommonAncestorOfTwoNodes(root.right, n1, n2);

		if (left == null && right == null) {
			return null;
		}

		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}

	/**
	 * This is combination of common Ancestor of 2 node + common Ancestor of 1
	 * node.
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 */
	public static void kthAncestorOfTwoNode(Node root, int n1, int n2) {
		Node lca = lowestCommonAncestorOfTwoNodes(root, n1, n2);
		Node ancestor = findKthAncestorOfOneNode(root, lca.data);

		if (ancestor != null) {
			System.out.print("Kth ancestor is: " + "-1 : means this kth ancestor not found");
		}
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
		kthAncestorOfTwoNode(root, 4, 5);
	}

}
