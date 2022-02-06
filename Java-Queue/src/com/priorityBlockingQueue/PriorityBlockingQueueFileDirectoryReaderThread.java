package com.priorityBlockingQueue;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FileComparator implements Comparator<File> {

	@Override
	public int compare(File f1, File f2) {
		long length1 = f1.length();
		long length2 = f2.length();

		if (length1 > length2) {
			return -1;
		} else {
			return 1;
		}
	}

}

class FileParser extends Thread {

	private BlockingQueue<File> queue;
	private String keyboard;

	public FileParser(BlockingQueue<File> queue, String keyboard) {
		super();
		this.queue = queue;
		this.keyboard = keyboard;
	}

	@Override
	public void run() {
		while (true) {
			try {
				File file = queue.peek();
				if (file != null && !file.getName().equals("END")) {
					file = queue.take();
					parseFile(file);
				} else {
					break;
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void parseFile(File file) throws IOException {
		List<String> lines = Files.readAllLines(file.toPath());
		int linecount = 0;

		for (String aline : lines) {
			linecount++;
			if (aline.contains(keyboard)) {
				String result = "Found in %s at line %d\n";
				System.out.printf(result, file.getAbsolutePath(), linecount, file.length());
				break;
			}
		}
	}
}

class DirectoryLister extends Thread {

	private BlockingQueue<File> queue;
	private File directory;
	private String extension;

	public DirectoryLister(BlockingQueue<File> queue, File directory, String extension) {
		this.queue = queue;
		this.directory = directory;
		this.extension = extension;
	}

	@Override
	public void run() {

		try {
			listOfDirectory(directory);
			queue.put(new File("END"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void listOfDirectory(File dir) throws InterruptedException {
		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(extension);
			}
		});

		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					listOfDirectory(file);
				} else {
					queue.put(file);
				}
			}
		}
	}
}

public class PriorityBlockingQueueFileDirectoryReaderThread {

	public static void main(String[] args) {
		String dirPath = args[0];
		String extension = args[1];
		String keyword = args[2];

		BlockingQueue<File> queue = new PriorityBlockingQueue<>(100, new FileComparator());

		DirectoryLister lister = new DirectoryLister(queue, new File(dirPath), extension);
		lister.start();

		for (int i = 0; i < 10; i++) {
			FileParser parser = new FileParser(queue, keyword);
			parser.start();
		}
	}
}
