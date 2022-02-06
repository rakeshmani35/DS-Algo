package com.custome.queue;

public class QueueUsingLinkedList {

	static class Node {
		int data;
		Node next;

		// constructor to create a new linked list node
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static Node front;
	static Node rear;

	public QueueUsingLinkedList() {
		front = null;
		rear = null;
	}

	public static void enqueue(int data) {

		// If queue is empty, then new node is front and rear both
		Node newNode = new Node(data);
		if (rear==null) {
			rear = newNode;
			front = newNode;
			return ;
		}
		rear.next = newNode;
		rear = newNode;
		return ;
	}

	public static void dequeue() {
		
		Node current = front;
		front = front.next;
		current.next = null; // make null a dequeued node
	}
	
	public void printQueue() {
		Node current = front;
		while (current!=null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList q = new QueueUsingLinkedList(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50);
        
        q.printQueue();
        
        System.out.println();
        q.dequeue();
        q.dequeue();
        q.printQueue();

	}

}
