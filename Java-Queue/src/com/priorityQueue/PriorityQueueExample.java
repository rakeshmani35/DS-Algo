package com.priorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(10);
		pq.add(20);
		pq.add(15);
		
		System.out.println(pq);
		
		for (Integer integer : pq) {
			System.out.println("queue element - "+integer);
		}
		System.out.println();	
		
		System.out.println("Top element - "+pq.peek());
	}

}
