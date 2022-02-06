package com.queue.iterate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueIterateUsingIterator {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		Iterator<Integer> it = q.iterator();
		while (it.hasNext()) {
			Integer x = (Integer) it.next();
			System.out.print(x+" ");
		}
	}

}
