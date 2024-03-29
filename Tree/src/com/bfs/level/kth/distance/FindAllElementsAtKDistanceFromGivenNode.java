package com.bfs.level.kth.distance;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
// https://www.youtube.com/watch?v=xiXWEUvoon4
// source code: https://thecodingsimplified.com/print-all-nodes-at-k-distance-from-given-node-in-binary-tree/
/*
 * find node at kth distance from given node in downward and upward left and right direction 
 */
public class FindAllElementsAtKDistanceFromGivenNode {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	
	
	public static int kthNodeFromGivenNode_Recursive(Node root, Node targetNode, int k) {

		if (root == null || targetNode == null || k < 0) {
			return -1;
		}
		int kthNodeFromGivenNode = kthNodeFromGivenNode(root, targetNode, k);
		
		return kthNodeFromGivenNode;
	}
	
	public static int kthNodeFromGivenNode(Node root, Node targetNode, int k) {
		
		if (root==null) {
			return -1;
		}
		
		// downward direction search, consider targetNode as root node
		if (root==targetNode) { // node found, consider find node at kth distance from root
			nodeAtKthDistanceFromParent(root, k);
			return 0;
		}
		
		int leftDist = kthNodeFromGivenNode(root.left, targetNode, k);
		
		// this is left upward direction search
		if (leftDist != -1) { // node found (means -1 = not found) 
			if (leftDist + 1 == k) {
				System.out.print(root.data + " ");
			} else {
				// why k-2, 1st 1 for left and 2nd for right move
				nodeAtKthDistanceFromParent(root.right, k - 2 - leftDist);
			}
			
			return leftDist + 1;
		}
		
		
		
		int rightDist = kthNodeFromGivenNode(root.right, targetNode, k);

		// this is right upward direction search
		if (rightDist != -1) { // node found 
			if (rightDist + 1 == k) {
				System.out.print(root.data + " ");
			} else {
				// why k-2, one 1 for left and 2 for right move
				nodeAtKthDistanceFromParent(root.left, k - 2 - rightDist);
			}
			
			return rightDist + 1;
		}
		
		return -1;
	}
	
	// same as find node at kth distance from root
	private static void nodeAtKthDistanceFromParent(Node root, int k) {
		if (root==null) {
			return ;
		}
		if (k==0) {
			System.out.print(root.data+" ");
		}
		nodeAtKthDistanceFromParent(root.left, k-1);
		nodeAtKthDistanceFromParent(root.right, k-1);
		return ;
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

       // Node targetNode = new Node(2);
        
        int k = 2;
        Node targetNode = root.left.left;
        System.out.println(" Nodes at distance "+k+" from node " + targetNode.data + " are :");
        int elements = kthNodeFromGivenNode_Recursive(root, targetNode, k);
        if (elements==-1) {
			System.out.println("element not found");
		}
        
		System.out.println();
		  System.out.println(" Nodes at distance "+k+" from leaf nodes(4,5,8) are :");
		// same as find node at kth distance from root
		nodeAtKthDistanceFromParent(root, k);
		
		List list = new ArrayList();
	}

}
