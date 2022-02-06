package com.priorityBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class Document implements Comparable<Document> {
	private int docId;
	private String docName;

	public Document(int bookId, String bookName) {
		this.docId = bookId;
		this.docName = bookName;
	}

	public int getDocId() {
		return docId;
	}

	public String getDocName() {
		return docName;
	}

	@Override
	public int compareTo(Document ob) {
		return docName.compareTo(ob.getDocName());
	}
}

class AddDocumentThread implements Runnable {
	BlockingQueue<Document> pqueue;

	public AddDocumentThread(BlockingQueue<Document> pqueue) {
		this.pqueue = pqueue;
	}

	@Override
	public void run() {
		System.out.println("Adding documnet started");
		pqueue.offer(new Document(1, "AFSD"));
		pqueue.offer(new Document(2, "HGTF"));
		pqueue.offer(new Document(3, "FRDE"));
		pqueue.offer(new Document(4, "BGTF"));
		pqueue.offer(new Document(5, "GTGT"));
		
		System.out.println("Adding documnet ended");
	}
}

class PrintDocumentThread implements Runnable {

	BlockingQueue<Document> pqueue;

	public PrintDocumentThread(BlockingQueue<Document> pqueue) {
		this.pqueue = pqueue;
	}

	@Override
	public void run() {
		System.out.println("Print documnet started.........");
		try {
			for (int i = 0; i < 5; i++) {
				Document doc = pqueue.take();
				System.out.println(doc.getDocName() + " with id:" + doc.getDocId() + " printed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Print documnet Ended......");
	}

}

public class PriorityBlockingQueueAddPrintDocThread {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		BlockingQueue<Document> bq = new PriorityBlockingQueue<Document>();
		
		Runnable addDocumentThread = new AddDocumentThread(bq);
		Runnable printDocumentThread = new PrintDocumentThread(bq);
		
		threadPool.execute(addDocumentThread);
		threadPool.execute(printDocumentThread);
		
		threadPool.shutdown();
	}

}
