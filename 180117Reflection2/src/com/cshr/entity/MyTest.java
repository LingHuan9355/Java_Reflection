package com.cshr.entity;

import org.junit.Test;


public class MyTest {

	@Test
	public void testMain(){
		
		sum(1,2,3,4,5);
	}
	
	public void sum(int ...args){
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			sum += args[i]; 
		}
		System.out.println(sum);
	}
	
}
