package com.conversion;

public class BinaryTreeToDLL_InorderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
    static Node head = null;
    static Node prev = null;
	public static void convertDLL_Inorder(Node p) {
		if (p==null) {
			return ;
		}
		
		convertDLL_Inorder(p.left);
		
		// logic for convert DLL - Inorder based
		if (prev==null) {
			head = p;
		}else {
			p.left = prev;
			prev.right = p;
		}
		prev = p;
		
		convertDLL_Inorder(p.right);
	}
	
	
	public static void printHead() {
		Node current = head;
		while (current!=null) {
			System.out.print(current.data+" ");
			current = current.right;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		
		convertDLL_Inorder(root);
		
		printHead();

	}

}
