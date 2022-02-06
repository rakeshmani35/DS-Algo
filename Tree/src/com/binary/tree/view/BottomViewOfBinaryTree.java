package com.binary.tree.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import javax.naming.spi.DirStateFactory.Result;

import com.binary.tree.view.TopViewOfBinaryTree.Node;

// https://www.youtube.com/watch?v=V7alrvgS5AI&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=25
//level order traversal + vertical order traversal
public class BottomViewOfBinaryTree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private static List<Integer> levelOrderList = new ArrayList<Integer>();

	// level order elements store in list
	public static void levelOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {

			root = q.poll(); // Retrieves and removes
			System.out.print(root.data + " ");
			levelOrderList.add(root.data);
			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
		}
	}

	// find input elements in levelOrderList, which appears first
	private static int findFist(List<Integer> levelOrderList, List<Integer> input) {

		int x = input.get(0);
		// input.remove(0);

		int minIndex = Integer.MAX_VALUE;

		for (Integer integer : input) {

			int y = integer.intValue();

			int min = Math.min(levelOrderList.indexOf(x), levelOrderList.indexOf(y));

			if (min < minIndex) {
				minIndex = min;
			}
			x = y;
		}

		return levelOrderList.get(minIndex);
	}

	// hd = horizontal distance
	private static TreeMap<Integer, ArrayList<Integer>> ht = new TreeMap<Integer, ArrayList<Integer>>();
	private static ArrayList<Integer> al;

	private static void verticalTravers(Node root, int hd) {

		if (root == null) {
			return;
		}

		if (ht.containsKey(hd)) {
			ArrayList<Integer> list = ht.get(hd);
			list.add(root.data);
			ht.put(hd, list);
		} else {
			al = new ArrayList<Integer>();
			al.add(root.data);
			ht.put(hd, al);
		}

		verticalTravers(root.left, hd - 1);
		verticalTravers(root.right, hd + 1);
	}

	// Approach 1 : vertical distance + level order traversal + find first element in level order
	private static List<Integer> resultList1 = new ArrayList<Integer>();

	public static List<Integer> bottomView_Approach1(Node root) {

		// store elements at horizontal distance
		int hd = 0;
		verticalTravers(root, hd);

		// level order
		System.out.println("print level order traversal in same line");
		levelOrderTraversal(root);

		ht.entrySet().stream().forEach(entry -> {
			ArrayList<Integer> list = entry.getValue();
			if (list.size() > 1) {

				// find input elements in levelOrderList, which appears first
				int firstEle = findFist(levelOrderList, list);

				resultList1.add(firstEle);
			} else {
				resultList1.add(list.get(0));
			}
		});

		return resultList1;

	}

	// Approach 2 , only use vertical distance
	private static List<Integer> resultList2 = new ArrayList<Integer>();

	public static List<Integer> bottomView_Approach2(Node root) {

		// store elements at horizontal distance
		int hd = 0;
		verticalTravers(root, hd);

		ht.entrySet().stream().forEach(entry -> {
			ArrayList<Integer> list = entry.getValue();
			
			int size = list.size();
			
			if (size > 1) {
				resultList2.add(list.get(size-1));
			}else {
				resultList2.add(list.get(0));
			}
		});

		return resultList2;

	}

	public static void main(String[] args) {

//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
//		root.left.left.left = new Node(8);
//		root.left.left.right = new Node(9);
		
		
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
		

		List<Integer> bottomView = bottomView_Approach1(root);

		System.out.println();
		System.out.println("Bottom view approach - 1 ");
		bottomView.stream().forEach(v -> System.out.print(v + " "));
		
		
		List<Integer> bottomView2 = bottomView_Approach2(root);
		System.out.println();
		System.out.println("Bottom view approach - 2");
		bottomView2.stream().forEach(v -> System.out.print(v + " "));
		return;
	}

}
