package com.priorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<Integer>();
		
		Thread.sleep(TimeUnit.SECONDS.toMillis(2));
         pq.add(1);
         
         Thread.sleep(TimeUnit.SECONDS.toMillis(2));
         pq.add(2);
         
         Thread.sleep(TimeUnit.SECONDS.toMillis(2));
         pq.add(3);
         
         new Thread(() -> {
        	 System.out.println("Waiting to poll ...");
        	 
        	 while (true) {
				try {
					Integer take = pq.take();
					
					System.out.println("Polled element : - "+take);
					
					Thread.sleep(TimeUnit.SECONDS.toMillis(1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
         }).start();;
	}

}
