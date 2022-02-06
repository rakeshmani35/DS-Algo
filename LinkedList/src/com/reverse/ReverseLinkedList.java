package com.reverse;

public class ReverseLinkedList {

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

	public static void printFromFirst() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void reverse() {

		Node previous = null;
		Node current = head;
		Node next = null;
		
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	public static void main(String[] args) {
		insertAtFront(1);
		insertAtFront(7);
		insertAtFront(8);
		insertAtFront(6);
		insertAtFront(4);
		
		printFromFirst();
		
		reverse();
		
		printFromFirst();
	}

}
