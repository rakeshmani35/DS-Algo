package com.sort;

import java.util.Stack;

// https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
public class SortStack {

	// input: [34, 3, 31, 98, 92, 23]
	public static Stack<Integer> sortstack(Stack<Integer> input) {

		Stack<Integer> tempStack = new Stack<Integer>();

		while (!input.isEmpty()) {

			int x = input.pop(); // remove

			while (!tempStack.isEmpty() && tempStack.peek() > x) {

				input.push(tempStack.pop());
			}

			tempStack.push(x);
		}

		return tempStack;
	}

	public static void main(String[] args) {

		Stack<Integer> input = new Stack<Integer>();
		input.add(34);
		input.add(3);
		input.add(31);
		input.add(98);
		input.add(92);
		input.add(23);
		
		Stack<Integer> tmpStack=sortstack(input); 
        System.out.println("Sorted numbers are:"); 
      
        while (!tmpStack.empty()) 
        { 
            System.out.print(tmpStack.pop()+" ");  // 98 92 34 31 23 3
        }  
	}

}
