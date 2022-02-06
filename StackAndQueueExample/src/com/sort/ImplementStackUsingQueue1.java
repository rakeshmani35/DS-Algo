package com.sort;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue1 {

	static class Stack {
		// Two inbuilt queues
		static Queue<Integer> q1 = new LinkedList<Integer>();
		static Queue<Integer> q2 = new LinkedList<Integer>();

		// To maintain current number of elements
		static int curr_size;

		Stack() {
			curr_size = 0;
		}

		// final result store in q1
		static void push(int x) {
			curr_size++;

			// Push x first in empty q2
			q2.add(x);

			// Push all the remaining elements in q1 to q2.
			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}

			// swap the names of two queues
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}

		// read the top element and remove
		static void pop() {
			while (q1.isEmpty()) {
				return;
			}
			q1.remove(); // retrive but remove throws an exception
			curr_size--;

		}

		// read the top element, not remove
		static int top() {
			while (q1.isEmpty()) {
				return -1;
			}
			
			return q1.peek(); // retrive but not remove
		}

		// read the top element, not remove
		static int size() {
			return curr_size;
		}
	}

	public static void main(String[] args) {

		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println(s);
	}

}
