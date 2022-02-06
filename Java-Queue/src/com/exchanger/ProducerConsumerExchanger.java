package com.exchanger;

import java.util.concurrent.Exchanger;

// https://www.netjstech.com/2016/02/exchanger-in-java-concurrency.html
// https://knpcode.com/java/concurrency/exchanger-in-java/

class ProducerThread implements Runnable {

	String str;
	Exchanger<String> ex;

	public ProducerThread(Exchanger<String> ex) {
		this.ex = ex;
		str = new String();
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			str = "Producer-" + i;

			try {
				// insert string for consumer
				str = ex.exchange(str);
				
				// get string from consumer
				str = ex.exchange(new String());
				System.out.println("Producer Got from Consumer " + str);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class ConsumerThread implements Runnable {

	String str;
	Exchanger<String> ex;

	public ConsumerThread(Exchanger<String> ex) {
		this.ex = ex;
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {

			try {
				// Getting string from producer thread giving empty string in return
				str = ex.exchange(new String());
				System.out.println("Consumer Got from Producer " + str);
				
				// insert string for producer
				ex.exchange("consumer-"+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

public class ProducerConsumerExchanger {

	public static void main(String[] args) {

		Exchanger<String> ex = new Exchanger<String>();
		// Starting two threads
		new Thread(new ProducerThread(ex)).start();
		new Thread(new ConsumerThread(ex)).start();
	}

}
