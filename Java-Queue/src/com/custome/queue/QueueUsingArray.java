package com.custome.queue;

public class QueueUsingArray {

	int[] queueArr;
	private int size; // size of Queue
	private int rear; // elements will be added at rear.
	private int front; // elements will be removed from front
	private int number; // holds number of elements in Queue, initialized with 0 by default

	public QueueUsingArray(int size) {
		this.size = size;
		this.queueArr = new int[size];
		rear = 0;
		front = 0;
	}

	public void insert(int key) {
		// if we are at last position of queue, then reset rear and start storing key
		// from beginning
		if (rear == size) {
            rear = 0;
		}
		queueArr[rear++] = key;
		number++;
	}
	
	public void remove() {
		int deletedValue = queueArr[front++];
		if (front==size) {
			front =0;
		}
		number--;
	}
	
	public void dequeue() {
		if (front==rear) {
			System.out.println("Queue is empty");
			return ;
		}else {
			for (int i = 0; i < number-1; i++) {
				queueArr[i] =  queueArr[i+1];
			}
		}
	}

	public static void main(String[] args) {

	}

}
