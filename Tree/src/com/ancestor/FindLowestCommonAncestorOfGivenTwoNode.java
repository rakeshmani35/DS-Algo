package com.ancestor;


// https://www.youtube.com/watch?v=F-_1sbnPbWQ&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=24
public class FindLowestCommonAncestorOfGivenTwoNode {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	
	// https://www.youtube.com/watch?v=F-_1sbnPbWQ&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=24
	public static Node findCommonAncestor(Node root, int n1, int n2) {
		
		if (root==null) {
			return null;
		}
		if (root.data==n1 || root.data==n2) {
			return root;
		}
		Node left = findCommonAncestor(root.left, n1, n2);
		
		Node right = findCommonAncestor(root.right, n1, n2);
		
		
		if (left==null && right==null) {
			return null;
		}
		if (left!=null && right!=null) {
			return root;
		}
		return left!=null ? left : right;
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
        
        
        Node commonAncestor1 = findCommonAncestor(root, 4, 5);
        System.out.println("lowest common ancestor of 4 & 5 : "+commonAncestor1.data);
        
        Node commonAncestor2 = findCommonAncestor(root, 4, 8);
        System.out.println("lowest common ancestor of 4 & 8 : "+commonAncestor2.data);
		
	}
}
