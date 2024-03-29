package com.vertical.traversal;

import java.util.ArrayList;
import java.util.TreeMap;

//https://www.techiedelight.com/vertical-traversal-binary-tree/
//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
// https://www.youtube.com/watch?v=PQKkr036wRc
public class VerticalOrderTraversal_PreOrderTraversal_Map {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static TreeMap<Integer, ArrayList<Integer>> ht = new TreeMap();
	static ArrayList<Integer> al;

	public static void verticalTraversal(Node root, int level) {

		if (root == null) {
			return;
		}

		if (ht.containsKey(level)) {
			ArrayList<Integer> list = ht.get(level);
			list.add(root.data);
			ht.put(level, list);
		} else {
			al = new ArrayList<Integer>();
			al.add(root.data);
			ht.put(level, al);
		}

		verticalTraversal(root.left, level - 1);

		verticalTraversal(root.right, level + 1);
	}

	public static void print(TreeMap map) {

		map.forEach((key, value) -> System.out.println(value));
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		verticalTraversal(root, 0);

		print(ht);
	}

}
