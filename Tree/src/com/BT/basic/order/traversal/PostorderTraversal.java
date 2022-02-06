package com.BT.basic.order.traversal;

// https://www.youtube.com/watch?v=cviyUv2TFG8
//https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java#L98
import java.util.Stack;

public class PostorderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void postorder(Node root) {

		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	public static void postorder_iterative_oneStack(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				Node temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public static void postorder_iterative_twoStack(Node root) {

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);

		while (!s1.isEmpty()) {

			Node temp = s1.pop();
			s2.push(temp);
			
			if (temp.left != null) {
              s1.push(temp.left);
			}
			if (temp.right != null) {
               s1.push(temp.right);
			}
		}
		
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data+" ");
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

		postorder(root);

		System.out.println();
		postorder_iterative_oneStack(root);
		
		System.out.println();
		postorder_iterative_twoStack(root);
	}

}

/**
 * post-order traversal : 4 5 2 6 7 3 1
 */
