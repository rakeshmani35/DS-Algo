package com.ancestor;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=qjD-CmuC0MQ
public class AllAncesterOfGivenOneNode {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int allAncester(Node root, Node target,List<Integer> list) {

		if (root==null) {
			return 0;
		}
		
		if (root == target) {
			return 1;
		}

		int left = allAncester(root.left, target,list);
		int right = allAncester(root.right, target,list);
		
		if (left!=0 || right!=0) {
			
			//System.out.println(root.data);
			list.add(root.data);
			
			return 1;
		}

		return 0;

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
		
		Node target = root.left.left;
		
		List<Integer> list = new ArrayList();
		allAncester(root, target,list);
		
		System.out.println("All Ancester of Node "+target.data+" is : "+list);

	}

}
