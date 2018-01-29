package com.cshr.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cshr.dao.BaseDao;
import com.cshr.entity.Student;

public class MyTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testMian(){
		/*Student stu = new Student();
		stu.setName("–ªµ¿‘Ã");
		stu.setMomey(100000);
		stu.setBrithday(new Date());
        BaseDao.save(stu);*/
		
		List<Student> list = BaseDao.find(Student.class);
	     for (Student student : list) {
			System.out.println(student.getName());
		}
		
		/*Object obj = BaseDao.load(Student.class,10);
		System.out.println(obj.toString());*/
	
		/*Student stu2 = new Student();
		stu2.setId(12);
		stu2.setName("πÀ‚˝÷Æ");
		stu2.setMomey(1080.2);
		stu2.setBrithday(new Date());
		BaseDao.update(stu2);*/
		
		//BaseDao.delete(Student.class,5);
		
	}
}
