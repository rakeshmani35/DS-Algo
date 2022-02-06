package com.SLL.max.min;

public class FindLargestAndSecondLargest {

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

	public static void largestAndSecondLargest(Node head) {
		
		Node current = head;
		int val1 = current.data;
		int val2 = current.next.data;
		
		// initialise max and second max using first two nodes of linked list 
		int max = Math.max(val1, val2);
		int second_max = Math.min(val1, val2);
		
		
		// move the head pointer to 3rd node 
		current = current.next.next;
		while (current!=null) {
			
			if (current.data > max) {
				second_max = max;
				max = current.data;
			}else if(current.data > second_max) {
				second_max = current.data;
			}
			current.next = current.next;
		}
		System.out.println("largest = "+max);
		System.out.println("second-largest = "+second_max);
	}
	
	public static void main(String[] args) {

		insertAtFront(1);
		insertAtFront(7);
		insertAtFront(8);
		insertAtFront(6);
		insertAtFront(4);

		printFromFirst();

		largestAndSecondLargest(head);
	}

}
