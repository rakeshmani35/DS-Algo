package com.bfs.level.kth.distance;

import java.util.LinkedList;
import java.util.Queue;

// In this example consider level=0
// https://www.techiedelight.com/find-all-nodes-at-given-distance-from-leaf-nodes-in-a-binary-tree/
// https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
public class FindNodeAtKthDistanceFromRoot {
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	// In this example consider root at 'k' level
	public static void printKDistant_recursive1(Node root, int level) {
		
		if (root==null) {
			return ;
		}
		
		if (level==0) {
			System.out.print(root.data+" ");
			return ;
		}
		printKDistant_recursive1(root.left, level-1);
		printKDistant_recursive1(root.right, level-1);
	}
	
	// consider root at 0 level
	public static void printKDistant_recursive2(Node root, int level, int startlevel) {
		
		if (root==null) {
		return ;
		}
		
		if (level==startlevel) {
			System.out.print(root.data+" ");
			return ;
		}
		printKDistant_recursive2(root.left, level, startlevel+1);
		
		printKDistant_recursive2(root.right, level, startlevel+1);
	}
	
	public static void printKDistant_recursive(Node root, int level) {
		printKDistant_recursive2(root, level, 0);
	}
	
	// level order traversal
	public static void printKDistant_iterative_oneQueue(Node root, int level) {
		
		int startLevel = 0;
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		
		while (!q.isEmpty()) {
			
			root = q.poll();
			
			if (root==null) {
				startLevel++;
			}
			if (root != null) {
				if (level==startLevel) {
					System.out.print(root.data+" ");
				}
				if (root.left!=null) {
					q.add(root.left);
				}
				if (root.right!=null) {
					q.add(root.right);
				}
			}else {
				if (!q.isEmpty()) {
	                System.out.println();
	                q.add(null);
	            }
			}
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
        
        /**
         * In this example consider level=0
         */
        
        printKDistant_recursive1(root, 2);
        
        System.out.println();
        printKDistant_recursive(root, 2);
        
        System.out.println();
        printKDistant_iterative_oneQueue(root, 2);
	}

}
