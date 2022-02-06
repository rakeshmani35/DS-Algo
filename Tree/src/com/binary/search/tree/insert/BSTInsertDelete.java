package com.binary.search.tree.insert;

public class BSTInsertDelete {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static Node root;

	public BSTInsertDelete() {
		this.root = null;
	}

	public void insert(int value) {

		Node newNode = new Node(value);

		Node current = root;
		Node parent = null;

		if(root==null){
			root = newNode;
			return;
		}
		
		while (true) {
			parent = current;

			if (value < current.data) {

				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}

			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}

			}
		}
	}

	public boolean search(int value) {

		Node current = root;

		while (current != null) {

			if (current.data == value) {
				return true;
			} else if (value < current.data) {
				current = current.left;
			} else if (value > current.data) {
				current = current.right;
			}
		}
		return false;
	}

	public boolean delete(int value) {

		Node parent = root;
		Node current = root;

		// deleting node left of parent(true) or right of parent(false)
		boolean isLeftChild = false;

		// reaching at deleting node and parent node
		while (current.data != value) {

			parent = current; // parent of deleting node

			
			if (value < current.data) {

				isLeftChild = true;
				current = current.left;

			} else if (value > current.data) {

				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
			
		} // end of while

		// Case 1: if node to be deleted has no children
		if (current.left == null && current.right == null) {

			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		if (current.right == null) { // means left child available of deleting node

			if (current == root) {
				root = current.left;
			} else if (isLeftChild) { // deleting node if left of parent
				parent.left = current.left;
			} else { // deleting node if right of parent
				parent.right = current.left;
			}

		} else if (current.left == null) { // means right child available of deleting node
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) { // deleting node if left of parent
				parent.left = current.right;
			} else { // deleting node if right of parent
				parent.right = current.right;
			}
		}
		// Case 3 : if node to be deleted has two child
		if (current.left != null && current.right != null) {

			// now we have found the successor(minimum element) in the right sub tree
			Node successor = getSuccessor(current);

			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
		}
		return true;
	}

	private Node getSuccessor(Node deleteNode) {

		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.right;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		// if successor has right child, then successorparent should be point to right
		// child of successor
		if (successor.right != null) {
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		return successor;
	}

	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	public static void main(String[] args) {

		BSTInsertDelete b = new BSTInsertDelete();
		b.insert(3);
		b.insert(8);
		b.insert(1);
		b.insert(4);
		b.insert(6);
		b.insert(2);
		b.insert(10);
		b.insert(9);
		b.insert(20);
		b.insert(25);
		b.insert(15);
		b.insert(16);
		
		System.out.println("Original Tree : ");
		b.display(b.root);
		//System.out.println();
		
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}

}
