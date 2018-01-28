package com.cshr.test;

import java.util.List;

import org.junit.Test;

import com.cshr.dao.BaseDao;
import com.cshr.entity.Student;

public class MyTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testMian(){
		//Ìí¼Ó
	/*	Student stu = new Student();
		stu.setName("ksana");
		stu.setMomey(4186.89);
		stu.setBrithday(new java.util.Date());
		BaseDao.save(stu);*/
		//²éÑ¯
	    List<Student> list = BaseDao.queryList(Student.class);
		for (Student student : list) {
			System.out.println(student.getName());
		}
		
		//ĞŞ¸Ä
		/*Student stu = new Student();
		stu.setId(7);
		stu.setName("ks");
		stu.setMomey(4186.12);
		stu.setBrithday(new java.util.Date());
		BaseDao.medify(stu);*/
		
		//É¾³ı
/*		Student stu3 = new Student();
		stu3.setId(8);
		BaseDao.delete(stu3);*/
	}
}
