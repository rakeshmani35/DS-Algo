package com.predecessor.successor;

// inorder :  4 2 5 1 8 3
// inorder predessor of 8 is 1, of 5 is 2
// https://www.youtube.com/watch?v=rukYFD8cYBY&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=3
public class InorderPredecessorInBT {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void inorder(Node root) {

		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	static Node store;
	public static void findInorderPredessor(Node root, int key) {

		Node temp = findNode(root, key);
		

		// case1: if given node has left subtree, then find maximum value in left subtree
		if (temp.left != null) {
			temp = temp.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			System.out.println("predecessor of " + key + " is = " + temp.data);
		}

		// case2: if given node does not has left subtree, find node from where taken last right
		else if (temp.left == null) {
            System.out.println("predecessor of " + key + " isss = " + store.data);
		}else {
			System.out.println("predecessor of " + key + " is not found");
		}
	}

	public static Node findNode(Node root, int key) {

		if (root == null) {
			return null;
		}

		
		if (root.data == key) {
			return root;
		}
		
		Node left = findNode(root.left, key);
		if (left != null) { // node found, no need to look further
			return left;
		}
		
		//store last right, which is inorder predecessor when given node does not has left subtree
		store = root;  
		
		// node is not found in left, so recur on right subtree /
		Node right = findNode(root.right, key);

		return right;
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

		inorder(root); // 4 2 5 1 8 3

		System.out.println();
		findInorderPredessor(root, 2);

	}

}
