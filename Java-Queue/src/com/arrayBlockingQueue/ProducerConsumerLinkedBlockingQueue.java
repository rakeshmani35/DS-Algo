package com.arrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// https://www.javacodestuffs.com/2020/07/linkedblockingqueue-vs.html

class Producer implements Runnable {

	private BlockingQueue<String> queue1;

	private BlockingQueue<String> queue2;

	public Producer(BlockingQueue<String> queue1, BlockingQueue<String> queue2) {
		this.queue1 = queue1;
		this.queue2 = queue2;
	}

	@Override
	public void run() {

		try {

			for (int i = 1; i <= 5; i++) {
				Thread.sleep(2000);

				String str = "Apple-" + i;
				queue1.put(str);
				System.out.println("Producer1: created " + str + " by - " + Thread.currentThread().getName());
			}
			queue1.put("-1"); // indicates end of producing

			System.out.println("Producer1 : STOPPED.");

			while (true) {
				String str = queue2.take();

				System.out.println("Producer2: consumed " + str + " by - " + Thread.currentThread().getName());

				if (str.equals("-2")) {
					System.out.println("Producer2: STOPPED.");
					break;
				}

				// fake consuming time
				Thread.sleep(2000);
			}

		} catch (InterruptedException ie) {

			ie.printStackTrace();

		}

	}

}

class Consumer implements Runnable {

	private BlockingQueue<String> queue1;

	private BlockingQueue<String> queue2;

	public Consumer(BlockingQueue<String> queue1, BlockingQueue<String> queue2) {
		this.queue1 = queue1;
		this.queue2 = queue2;
	}

	@Override
	public void run() {

		try {

			while (true) {
				String str = queue1.take();

				System.out.println("Consumer1: consumed " + str + " by - " + Thread.currentThread().getName());

				if (str.equals("-1")) {
					System.out.println("Consumer1: STOPPED.");
					break;
				}

				// fake consuming time
				Thread.sleep(2000);
			}

			for (int i = 1; i <= 5; i++) {
				Thread.sleep(2000);

				String str = "Banana-" + i;
				queue2.put(str);
				System.out.println("Consumer2: created " + str + " by - " + Thread.currentThread().getName());
			}
			queue2.put("-2"); // indicates end of producing
			System.out.println("consumer2 : STOPPED.");

		} catch (InterruptedException ie) {

			ie.printStackTrace();
		}

	}

}

public class ProducerConsumerLinkedBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue queue1 = new LinkedBlockingQueue<>(5);
		BlockingQueue queue2 = new LinkedBlockingQueue<>(5);
		// BlockingQueue queue = new ArrayBlockingQueue<>(10);

		Thread producer = new Thread(new Producer(queue1, queue2), "Producer-Thread");

		Thread consumer = new Thread(new Consumer(queue1, queue2), "Consumer-Thread");

		producer.start();

		consumer.start();
	}

}
