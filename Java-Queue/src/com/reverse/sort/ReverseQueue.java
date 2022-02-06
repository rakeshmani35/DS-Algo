package com.reverse.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.geeksforgeeks.org/reversing-a-queue/
// queue.peek() -> Retrieves, but does not remove
//queue.poll(); -> Retrieves and removes, returns null 
// queue.remove(); -> Retrieves and removes, throws an exception
public class ReverseQueue {

	public static void reverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();

		while (!queue.isEmpty()) {
			stack.add(queue.poll()); // Retrieves and removes, returns null
		}

		// add back to queue
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}

	static Queue<Integer> reverseQueue(Queue<Integer> q) {
		// Base case
		if (q.isEmpty())
			return q;

		// Dequeue current item (from front)
		int data = q.peek();
		q.remove();

		// Reverse remaining queue
		q = reverseQueue(q);

		// Enqueue current item (to rear)
		q.add(data);

		return q;
	}

	public static void main(String[] args) {

		Queue queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);

		System.out.println("Original Queue");
		queue.forEach(q -> System.out.print(q + " "));

		System.out.println();
		System.out.println("Reversed Queue iterative way");
		reverse(queue);
		queue.forEach(q -> System.out.print(q + " "));
		
		//System.out.println();
		//System.out.println("Reversed Queue recursive way");
		//Queue reverseQueue = reverseQueue(queue);
		//reverseQueue.forEach(q -> System.out.print(q + " "));
	}

}
