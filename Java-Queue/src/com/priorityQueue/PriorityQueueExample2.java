package com.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Customer {

	private int id;
	private String name;

	public Customer(int i, String n) {
		this.id = i;
		this.name = n;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}

public class PriorityQueueExample2 {

	public static void main(String[] args) {

		// natural ordering example of priority queue
		Queue<Integer> pq = new PriorityQueue<Integer>(7);
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			pq.add(new Integer(random.nextInt(100)));
		}
		for (int i = 0; i < 7; i++) {
			Integer in = pq.poll();
			System.out.println("Processing Integer:" + in);
		}

		// PriorityQueue example with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
		addDataToQueue(customerPriorityQueue);
		pollDataFromQueue(customerPriorityQueue);
	}

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Pankaj " + id));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while (true) {
			Customer cust = customerPriorityQueue.poll();
			if (cust == null)
				break;
			System.out.println("Processing Customer with ID=" + cust.getId());
		}
	}

	// Comparator anonymous class implementation
	public static Comparator<Customer> idComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer c1, Customer c2) {
			return (int) (c1.getId() - c2.getId());
		}
	};
}
