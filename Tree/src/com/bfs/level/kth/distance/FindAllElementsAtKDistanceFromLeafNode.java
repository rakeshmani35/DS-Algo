package com.bfs.level.kth.distance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.youtube.com/watch?v=ZgT8NXIMF4g
// https://thecodingsimplified.com/print-elements-at-k-distance-from-leaf-node-in-binary-tree/
//https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
// https://www.techiedelight.com/find-all-nodes-at-given-distance-from-leaf-nodes-in-a-binary-tree/
public class FindAllElementsAtKDistanceFromLeafNode {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	
	
	// https://www.youtube.com/watch?v=ZgT8NXIMF4g
	public static void printAllElementsAtKDistanceFromLeafNode(Node root, int k) {
		 int[] arr = new int[20]; // display data
	        boolean[] visited = new boolean[20]; // remove duplicate
	        int count = 0;
	        printkthNodeFromLeaf_recursive(root, k, arr, visited, count);
	}
	
	public static void printkthNodeFromLeaf_recursive(Node root, int k, int[] arr, boolean[] visited, int count) {

		if (root == null) {
			return;
		}

		arr[count] = root.data;
		visited[count] = false;

		if (root.left == null && root.right == null && count - k >= 0  && visited[count - k] == false) {
			System.out.print(arr[count - k] + " ");
			visited[count - k] = true;
			return;
		}

		printkthNodeFromLeaf_recursive(root.left, k, arr, visited, count + 1);
		printkthNodeFromLeaf_recursive(root.right, k, arr, visited, count + 1);
		
		return ;
	}
	
	// https://www.techiedelight.com/find-all-nodes-at-given-distance-from-leaf-nodes-in-a-binary-tree/
	// Recursive function to find all nodes at a given distance from leaf nodes
	public static void leafNodeDistance(Node root, int k, List<Integer> list, Set<Integer> set) {
		// base case: empty tree
		if (root == null) {
			return;
		}

		// if a leaf node is found, insert the node at a distance `k` from the
		// leaf node into the set
		if (root.left == null && root.right == null && list.size() >= k) {
			if (k == 0) { // this is for when k=0 means find all leaf node only
				list.add(root.data);
				set.add(list.get(list.size() - (k + 1)));
			} else {

				set.add(list.get(list.size() - k)); // except leaf node
			}

			return;
		}

		// include the current node in the current path
		list.add(root.data);

		// recur for the left and right subtree
		leafNodeDistance(root.left, k, list, set);
		leafNodeDistance(root.right, k, list, set);

		// remove the current node from the current path
		// list.remove(list.indexOf(root.data));
		list.remove(Integer.valueOf(root.data));

		return;
	}
	
	
	public static void main(String[] args) {
		
/* Constructed binary tree is 
        1        = level 0    count=0
      /   \ 
     2     3     = level 1    count=1
    /  \   / 
   4    5 8      = level 2    count=2
*/
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(8); 
        
        /**
         * In this example consider leaf at start with level=0
         */
        int k = 1;
        System.out.print(" Nodes at distance "+k+" from leaf are : "); 
       // printAllElementsAtKDistanceFromLeafNode(root, k);
		
        
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        leafNodeDistance(root, k, list, set);
        
        System.out.println("\n\nSet = "+set);
        
	}
}
