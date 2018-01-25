package com.cshr.test;

import org.junit.Test;

import com.cshr.util.ReflectionUtils;

public class MyTest1{

	
	  @Test
	  public void testMain() throws Exception{
		  ReflectionUtils util = new ReflectionUtils();
		  util.getField("Student", "sex");
		  
		  ReflectionUtils util2 = new ReflectionUtils();
		  util2.getField2("Student", "name");
		  
		  ReflectionUtils util3 = new ReflectionUtils();
		  util3.getMethod("Student","test2",new Class[]{int.class,String.class},new Object[]{1,"jack"});
	  
		  ReflectionUtils util4 = new ReflectionUtils();
		  util4.getMethod2("Student","sum",new Class[]{int.class,int.class},new Object[]{2,3});
		  
	  
	  }
}
