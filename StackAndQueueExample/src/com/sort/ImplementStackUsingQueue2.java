package com.sort;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue2 {

	static class Stack {
		// Two inbuilt queues
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		int curr_size;

		public Stack() {
			curr_size = 0;
		}

		// final result store in q1
		void add(int x) {
			q1.add(x);
			curr_size++;
		}

		// read the top element and remove
		int top() {
			if (q1.isEmpty()) {
				return -1;
			}
			while (q1.size() != 1) {
				q2.add(q1.peek());
				q1.remove();
			}

			// last pushed element
			int temp = q1.peek();
			q1.remove();

			q2.add(temp);

			// final result store in q1, swap the two queues
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
			return temp;
		}

		void remove() {
			if (q1.isEmpty()) {
				return;
			}

			while (q1.size() != 1) {
				q2.add(q1.peek());
				q1.remove();
			}

			// last element in q1
			q1.remove();
			curr_size--;

			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
