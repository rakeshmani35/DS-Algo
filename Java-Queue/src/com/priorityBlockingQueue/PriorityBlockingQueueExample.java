package com.priorityBlockingQueue;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

class Employee implements Comparable<Employee> {

	private Long id;
	private String name;
	private LocalDate dob;

	public Employee(Long id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	@Override
	public int compareTo(Employee emp) {
		return this.getId().compareTo(emp.getId());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}

public class PriorityBlockingQueueExample {

	public static void main(String[] args) {
		
		PriorityBlockingQueue<Employee> priorityBlockingQueue = new PriorityBlockingQueue<>();
        
		//Natural Ordering as ID
		priorityBlockingQueue.add(new Employee(1l, "AAA", LocalDate.now()));
		priorityBlockingQueue.add(new Employee(4l, "CCC", LocalDate.now()));
		priorityBlockingQueue.add(new Employee(5l, "BBB", LocalDate.now()));
		priorityBlockingQueue.add(new Employee(2l, "FFF", LocalDate.now()));
		priorityBlockingQueue.add(new Employee(3l, "DDD", LocalDate.now()));
		priorityBlockingQueue.add(new Employee(6l, "EEE", LocalDate.now()));
		
		System.out.println("Natural Ordering as ID : - ");
		while(true) 
		{
		    Employee e = priorityBlockingQueue.poll();
		    System.out.println(e);
		     
		    if(e == null) break;
		}
		
		//Comparator for name field
		Comparator<Employee> nameSorter = Comparator.comparing(Employee::getName);
		
		PriorityBlockingQueue<Employee> priorityBlockingQueue1 = new PriorityBlockingQueue<>( 11, nameSorter );
		
		priorityBlockingQueue1.add(new Employee(1l, "AAA", LocalDate.now()));
		priorityBlockingQueue1.add(new Employee(4l, "CCC", LocalDate.now()));
		priorityBlockingQueue1.add(new Employee(5l, "BBB", LocalDate.now()));
		priorityBlockingQueue1.add(new Employee(2l, "FFF", LocalDate.now()));
		priorityBlockingQueue1.add(new Employee(3l, "DDD", LocalDate.now()));
		priorityBlockingQueue1.add(new Employee(6l, "EEE", LocalDate.now()));
		
		System.out.println("Comparator for name field : - ");
		while(true) 
		{
		    Employee e = priorityBlockingQueue1.poll();
		    System.out.println(e);
		     
		    if(e == null) break;
		}
	}
}
