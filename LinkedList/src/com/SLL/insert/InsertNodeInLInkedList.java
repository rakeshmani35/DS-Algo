package com.SLL.insert;

public class InsertNodeInLInkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// insert at beginning
	public static void insertAtFront(int data) {

		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	// Insert Node after a given node
	public static void insertAfterGivenNode(int data, Node node) {

		if (node == null) {
			System.out.println("given node can not be null");
		} else {
			
			Node current = head;
			Node next = null;
			while (current.data!=node.data) {
				current = current.next;
				next = current.next;
			}
			
			Node newNode = new Node(data);

			current.next = newNode;
			newNode.next = next;
		}
		return ;
	}

	// insert at end
	public static void insetAtEnd(int data) {

		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Insert at kth position(this is not an index) from end. This is similar of
	// Insert Node after a given node.
	public static void insertAtKthPoisitionFromEnd(int data, int k) {

		// find length of list
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.next;
		}

		// find current where neewNode insert after current and next node that will after newNode
		int kthPoisition = length - k;
		int i = 0;
		current = head;
		Node next = null;
		while (current != null && i < kthPoisition-1) {
             current = current.next;
             next = current.next;
             i++;
		}
		
		// insertion start
		Node newNode = new Node(data);
		current.next = newNode;
		newNode.next = next;
	}

	public static void printFromFirst() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		insertAtFront(1);
		insertAtFront(7);
		insertAtFront(8);
		insertAtFront(6);
		insertAtFront(4);

		printFromFirst();

		insertAfterGivenNode(5, new Node(8));
		printFromFirst();
		
		insetAtEnd(2);
		printFromFirst();
		
		insertAtKthPoisitionFromEnd(43, 3);
		printFromFirst();
	}

}
