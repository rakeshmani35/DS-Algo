package com.reverse;

// https://www.youtube.com/watch?v=acJEBQiFPoY&list=PLeIMaH7i8JDio7glJoO1rQIAo4g1msRRG&index=20
public class ReverseNodeOfGroupOfSizeK {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// insert at end
	public void insetAtEnd(int data) {

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

	public void printFromFirst() {
		Node current = head;
		while (current.next != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println(current.data);
	}

	public void printReverseNode(Node root) {
		Node current = root;
		while (current.next != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println(current.data);
	}

	// reverse group of k nodes
	public Node reverseGroupOfK(Node head, int k) {

		int count = 0;

		Node current = head;
		Node next = null;
		Node prev = null;

		Node first = null; // point first node of every k node
		Node temp = null; // reverse and last node of every k node

		/* Reverse first k nodes of linked list */
		while (current != null) {

			// reverse
			while (count < k) {

				// break condition
				if (current == null) {
					break;
				}

				next = current.next;
				current.next = prev;
				prev = current;
				current = next;

				count++;
			}

			// link the previous reverse to current reverse
			if (temp == null) {
				temp = prev;
			} else {
				first = temp;
				while (first.next != null) {
					first = first.next;
				}
				first.next = prev;
			}

			// reset for reverse again
			prev = null;
			next = null;
			count = 0;

		}

		return temp;
	}

	public static void main(String[] args) {

		ReverseNodeOfGroupOfSizeK list = new ReverseNodeOfGroupOfSizeK();
		list.insetAtEnd(1);
		list.insetAtEnd(2);
		list.insetAtEnd(3);
		list.insetAtEnd(4);
		list.insetAtEnd(5);
		list.insetAtEnd(6);
		list.insetAtEnd(7);
		list.insetAtEnd(8);
		list.insetAtEnd(9);
		list.insetAtEnd(10);
		list.insetAtEnd(11);
		list.insetAtEnd(12);
		list.insetAtEnd(13);
		list.insetAtEnd(14);

		System.out.println("Before revers of group node");
		list.printFromFirst();

		System.out.println();
		System.out.println("After revers of group node");
		int k = 3;
		Node root = list.reverseGroupOfK(head, k);
		list.printReverseNode(root);
	}

}
