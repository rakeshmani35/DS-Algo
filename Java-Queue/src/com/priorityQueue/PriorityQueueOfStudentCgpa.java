package com.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

class Student {
	public String name;
	public double cgpa;

	public Student(String name, double cgpa) {
		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}
}

class CgpaComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		if (s1.cgpa < s2.cgpa) {
			return 1;
		} else if (s1.cgpa > s2.cgpa) {
			return -1;
		}

		return 0;
	}
}

public class PriorityQueueOfStudentCgpa {

	public static void main(String[] args) {

		PriorityQueue<Student> pq = new PriorityQueue<Student>(3, new CgpaComparator());
		
		 Student student1 = new Student("Nandini", 3.2); 
		 Student student2 = new Student("Anmol", 3.6);
		 Student student3 = new Student("Palak", 4.0); 
		 
		 pq.add(student1);
		 pq.add(student2);
		 pq.add(student3);
		 
		// Printing all elements 
	        System.out.println("Iterate The queue elements:"); 
	        java.util.Iterator<Student> itr = pq.iterator(); 
	        while (itr.hasNext()) {
				System.out.println(itr.next().getName());
			}
	        System.out.println();
	        
		 System.out.println("Students served in their priority order");
		 while (!pq.isEmpty()) {
			System.out.println(pq.poll().getName());
		}
	}

}
