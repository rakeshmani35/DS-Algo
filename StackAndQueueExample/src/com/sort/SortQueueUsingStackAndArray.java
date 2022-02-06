package com.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SortQueueUsingStackAndArray {

	private static Queue<Integer> sortQueue(Queue<Integer> queue) {
		
		Stack<Integer> tempStack = new Stack<Integer>();

		while (!queue.isEmpty()) {
			Integer x = queue.poll(); // remove

			while (!tempStack.isEmpty() && tempStack.peek() > x) { // trick
				queue.add(tempStack.pop());
			}

			tempStack.push(x);
		}
		
		Integer[] arr = new Integer[tempStack.size()];
		tempStack.copyInto(arr);
		for (Integer x : arr) {
			queue.add(x);
		}
		
		// this will reverse order
		//while (!tempStack.isEmpty()) {
		//	queue.add(tempStack.pop());
		//}
		return queue;
	}

	public static void main(String[] args) {

		Queue<Integer> list = new LinkedList<Integer>();
		list.add(30);
		list.add(11);
		list.add(15);
		list.add(4);

		// Sort Queue
		Queue<Integer> sortQueue = sortQueue(list);

		while (!sortQueue.isEmpty()) {
			System.out.print(sortQueue.poll() + " ");
		}
	}

}
