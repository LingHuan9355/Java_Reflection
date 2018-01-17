package com.cshr.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

public class MyTest5 {

	@SuppressWarnings("unchecked")
/*	@Test
	public void test() throws Exception{
		 URL []  urls ={new URL("http://127.0.0.1:8080/TestPro/tea.jar")};
		 URLClassLoader loader = new URLClassLoader(urls);
		 Class c = loader.loadClass("com.cshr.entity.Teacher");
          c.newInstance();
	
	}*/
	
	public static void main(String[] args) throws Exception {
		URL []  urls ={new URL("http://127.0.0.1:8080/TestPro/tea.jar")};
		 URLClassLoader loader = new URLClassLoader(urls);
		 Class c = loader.loadClass("com.cshr.entity.Teacher");
         c.newInstance();
	}
}
