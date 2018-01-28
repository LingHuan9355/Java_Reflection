package com.cshr.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cshr.dao.HelpDao;
import com.cshr.entity.Student;

public class TestStudent {

	@SuppressWarnings("unchecked")
	@Test
	public void testMain(){
		/*Student stu = new Student();
		stu.setName("³Â×ÓÖØ");
		stu.setMomey(10345.23);
		stu.setBrithday(new Date());
		HelpDao.sava(stu);*/
		
		List<Student> list = HelpDao.queryList(Student.class);
		for (Student student : list) {
			System.out.println(student.getName()+":"+student.getBrithday());
		}
		
		/*Student stu2 = new Student();
		stu2.setId(9);
		stu2.setName("Â½ÝÚÞ¨");
		stu2.setMomey(10000);
		stu2.setBrithday(new Date());
		HelpDao.modify(stu2);*/
		
		/*Student stu3 = new Student();
		stu3.setId(6);
		HelpDao.delete(stu3);*/
	}
}
