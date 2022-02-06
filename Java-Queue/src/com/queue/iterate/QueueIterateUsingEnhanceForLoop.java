package com.queue.iterate;

import java.util.LinkedList;
import java.util.Queue;

// https://www.techiedelight.com/iterate-through-queue-java/
public class QueueIterateUsingEnhanceForLoop {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		for (Integer x : q) {
			System.out.print(x+" ");
		}
	}

}
