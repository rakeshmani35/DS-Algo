package com.math;

// https://www.studytonight.com/java-programs/java-program-to-find-square-root-of-a-number
public class SquareRootOfNumber {

	public static double squareRoot(int num)   
    {  
        //temporary variable  
        double temp = 0;  
        double sqrtroot=num/2;
        
        
        while (temp!=sqrtroot) {
        	
        	 temp=sqrtroot;  
             sqrtroot=(temp+(num/temp))/2; 
		}
        
		/*
		 * do { temp=sqrtroot; sqrtroot=(temp+(num/temp))/2; } while((temp-sqrtroot)!=
		 * 0);
		 */
        
        
        
        return sqrtroot;  
   }  
	
	public static void main(String[] args) {
		
		int num = 7;
		System.out.println("square root of "+num+" is : "+squareRoot(num));

	}

}
