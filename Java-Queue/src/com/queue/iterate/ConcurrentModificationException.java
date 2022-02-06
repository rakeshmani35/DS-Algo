package com.queue.iterate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ConcurrentModificationException {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);

		Iterator<Integer> it = q.iterator();
		//q.add(4); // java.util.ConcurrentModificationException
		while (it.hasNext()) {
			Integer x = (Integer) it.next();
			it.remove();
			System.out.print(x + " ");
		}
	}

}
