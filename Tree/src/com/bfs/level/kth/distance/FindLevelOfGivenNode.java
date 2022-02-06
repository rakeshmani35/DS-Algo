package com.bfs.level.kth.distance;

// https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
public class FindLevelOfGivenNode {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static int getLevelOfNode_recursive(Node root, int data, int level) {
		if (root == null) {
			return 0;
		}

		if (root.data == data) {
			return level;
		}
		int l = getLevelOfNode_recursive(root.left, data, level + 1);
		
		// optional
		//if (l != 0) { // If found in left subtree , return
		//	return l;
		//}
		
		l = getLevelOfNode_recursive(root.right, data, level + 1);
		
		if (l != 0) { // If found in left subtree , return
			return l;
		}
		return l;
	}

	public static void main(String[] args) {

		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		
		int data = 5;
		int level = getLevelOfNode_recursive(root, data, 1);
		System.out.println("level of node "+data+" is : "+level);
	}

}
