package com.SynchronousQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

class Producer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		Random randomer = new Random();
		Integer number = randomer.nextInt(1000);
		while (true) {
			try {
				System.out.println("Producer: created number: " + number);
				queue.put(number);

				Thread.sleep(randomer.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				
				Integer number = queue.take();
				
				String message = "Consumer [" + Thread.currentThread().getName() + "]: ";
				message += " processed number: " + number;
				System.out.println(message);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}

public class ProducerConsumer {

	static final int NUMBER_OF_CONSUMERS = 10;

	public static void main(String[] args) {

		BlockingQueue<Integer> syncQueue = new SynchronousQueue<>();

		Producer prod = new Producer(syncQueue);
//		Thread producer = new Thread(prod);
//		producer.start();
//
//		Consumer[] consumers = new Consumer[NUMBER_OF_CONSUMERS];
//
//		for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
//			consumers[i] = new Consumer(syncQueue);
//
//			Thread consumer = new Thread(consumers[i]);
//
//			consumer.start();
//		}
		
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(11);
		newFixedThreadPool.submit(prod);
		newFixedThreadPool.submit(new Consumer(syncQueue));
		
//		for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
//			newFixedThreadPool.submit(new Consumer(syncQueue));
//		}
		
		newFixedThreadPool.shutdown();
	}

}
