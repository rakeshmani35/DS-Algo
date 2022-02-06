package com.level.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print level by level
 * 
 * 1) in one line
 * 
 * 2) level by level
 * 
 * 3) spiral way print
 * 
 * @author rakes
 *
 */
public class LevelOrderTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	// print level by level in one line
	// 1 2 3 4 5 6 7
	public static void printInOneLine_oneQueue(Node root) {

		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {

			root = q.poll(); // Retrieves and removes 
			System.out.print(root.data + " ");
			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
		}

	}

	// print level by level in next next line by using delimiter 'null'
	/* print level by level in next line
	 * 1 
	 * 2 3 
	 * 4 5 6 7 */
	public static void printLevelByLevel_oneQueue_delimeter(Node root) {
		if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root != null) {
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.add(null);
                }
            }
        }
	}

	// print level by level in next next line by using 2 queue
	/* print level by level in next line
	 * 1 
	 * 2 3 
	 * 4 5 6 7 */
	public static void printLevelByLevel_twoQueuer(Node root) {
		if (root == null) {
            return;
        }
		 Queue<Node> q1 = new LinkedList<Node>();
		 Queue<Node> q2 = new LinkedList<Node>();
		 
		 q1.add(root);
		 while (!q1.isEmpty() || !q2.isEmpty()) {
			
			while (!q1.isEmpty()) {
				root = q1.poll();
				System.out.print(root.data+" ");
				if (root.left!=null) {
					q2.add(root.left);
				}
				if (root.right!=null) {
					q2.add(root.right);
				}
			}
			 System.out.println();
			while (!q2.isEmpty()) {
				root = q2.poll();
				System.out.print(root.data+" ");
				if (root.left!=null) {
					q1.add(root.left);
				}
				if (root.right!=null) {
					q1.add(root.right);
				}
			}
			System.out.println();
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

		System.out.println("Level traversal in one line");
		printInOneLine_oneQueue(root);

		System.out.println();
		System.out.println("Lavel by lavel traversal using 1 queue and delimeter ");
		printLevelByLevel_oneQueue_delimeter(root);
		
		System.out.println();
		System.out.println("Level by level traversal by 2 queue ");
		printLevelByLevel_twoQueuer(root);
	}

}
