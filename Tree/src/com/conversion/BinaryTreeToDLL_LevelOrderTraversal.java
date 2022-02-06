package com.conversion;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDLL_LevelOrderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private static Node convertDLL_levelOrder(Node p) {

		Node head = null;
		Node prev = null;
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue
		q.add(p);
		while (!q.isEmpty()) {

			// Dequeue
			Node root = q.poll();

			// enqueue left and right
			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
			// logic to convert DLL - level order traverse
			Node current = root;
			if (prev == null) { // first node
				head = current;
			} else {
				current.left = prev;
				prev.right = current;
			}
			prev = current;

		}

		return head;
	}

	public static void printHead(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
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

		Node head = convertDLL_levelOrder(root);

		printHead(head);

	}

}
