package com.sort;

import java.util.Stack;

public class ImplementQueueUsingStack {

	static class Queue {

		// Two inbuilt stack
		static Stack<Integer> s1 = new Stack<Integer>();
		static Stack<Integer> s2 = new Stack<Integer>();

		// finally Push item into s1
		void enQueue(int x) {

			// Move all elements from s1 to s2
			while (!s1.isEmpty()) {
				s2.add(s1.pop());
			}

			// Push item into s1
			s1.push(x);

			// Push everything back s2 to s1
			while (!s2.isEmpty()) {
				s1.add(s2.pop());
			}
		}

		// Dequeue an item from the queue
		static int deQueue() {
			// if first stack is empty
			if (s1.isEmpty()) {
				System.out.println("Q is Empty");
				System.exit(0);
			}

			// Return top of s1
			int x = s1.peek();
			s1.pop();
			return x;
		}
	}

	public static void main(String[] args) {

		Queue q = new Queue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());

	}

}
