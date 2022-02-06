package com.reverse;

public class ReverseFirstKElements {

	static Node head;

	// Link list node
	static class Node {
		int data;
		Node next;
	};

	// Function to push a node
	void insert(int data) {
		Node new_node = new Node();
		new_node.data = data;
		new_node.next = (head);
		(head) = new_node;
	}

	// Function to print linked list
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.printf("%d ", temp.data);
			temp = temp.next;
		}
	}

	// original : 1->2->3->4->5 , k=3
	// reversed: 3->2->1->4->5
	public void reverseKNodes(int k) {

		Node temp = head;
		int count = 1;

		while (count < k) {
			count++;
			temp = temp.next;
		}
		// next after kth element
		Node joint_point = temp.next;

		// break point
		temp.next = null;

		// start reverse
		Node current = head;
		Node prev = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = joint_point;

		return;
	}

	public static void main(String[] args) {

		ReverseFirstKElements list = new ReverseFirstKElements();
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);

		list.printList(head);

		int k = 3;
		list.reverseKNodes( k);

		System.out.println();
		list.printList(head);
	}

}
