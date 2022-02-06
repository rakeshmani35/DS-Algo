package com.reverse;

// https://www.geeksforgeeks.org/reverse-even-elements-in-a-linked-list/?ref=rp
public class ReverseEvenElement {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node head;

	// insert at beginning
	public void insertAtFront(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
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
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void reverse() {

		Node prev = null;
		Node next;
		Node current = head;
		Node parent;
		Node first;
		Node last;

		while (current != null) {
			parent = current;
			next = current.next;
			
			first = current.next; // find first node of even element
			last = current.next; // find last node of even element
			
			current = current.next;
			
			while (current != null && current.data % 2 == 0) {

				if (parent.next != null) {
					parent.next = null;
					prev = null;
				}
				next = current.next;
				current.next = prev;
				prev = current;
				last = current; // assign last node of even
				current = next;

			}

			// check last node is even or not
			if (last != null && last.data % 2 == 0) {
				parent.next = last; // parent assign to last node of even element
				parent = first; // now parent become first node of even element
				last = current; // break point of if condition
			}
			parent.next = current;
		}

	}

	public static void main(String[] args) {

		ReverseEvenElement list = new ReverseEvenElement();
		list.insetAtEnd(1);
		list.insetAtEnd(2);
		list.insetAtEnd(3);
		list.insetAtEnd(3);
		list.insetAtEnd(4);
		list.insetAtEnd(6);
		list.insetAtEnd(8);
		list.insetAtEnd(5);
		list.insetAtEnd(2);
		list.insetAtEnd(8);
		list.insetAtEnd(8);
		list.insetAtEnd(14);
		list.insetAtEnd(9);

		// print
		System.out.println("original list");
		list.printFromFirst();

		list.reverse();

		// print
		System.out.println("reverse even number list");
		list.printFromFirst();
	}

}
