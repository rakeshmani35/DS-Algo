package com.SynchronousQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

// https://www.codejava.net/java-core/concurrency/java-synchronousqueue-examples
// https://www.netjstech.com/2016/03/synchronousqueue-in-java.html
// https://www.youtube.com/watch?v=QCMt324j64U
public class SynchroQDemo {

	// Nulls are not allowed in SynchronousQueue
	public static void nullCheck() {

		BlockingQueue<String> sq = new SynchronousQueue<String>();
		sq.add(null); // NullPointerException
	}

	/**
	 * Use the put() method to add an element to the queue. The current thread may
	 * wait for another thread to receive the element:This method causes the current
	 * thread block until another thread has received the element.
	 */
	public static void insert() {
		BlockingQueue<String> syncQueue = new SynchronousQueue<>(true);
		try {
			syncQueue.put("Element"); // main thread is blocked
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("syncQueue.size() : " + syncQueue.size());
	}

	public static void main(String[] args) {

		// Nulls are not allowed in SynchronousQueue
		// nullCheck();

		insert();
	}

}
