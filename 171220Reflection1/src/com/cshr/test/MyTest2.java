package com.cshr.test;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest2 </p>
 *Description: 
 *
 *@author LH
 *@date 2017-12-20����05:53:36
 *@version V1.0
 */
public class MyTest2 {

	/**
	 * 2.Class���ͻ�ȡ�����ַ�ʽ
	 * @throws Exception
	 */
	@Test
	public void testMian() throws Exception{
		//һ��ͨ�������ҵ��࣬����Class����(��ʱ����)
		//��ʱ���أ������ϴ�ӡ��̬��Ĵ��룩
		//Class c1 = Class.forName("com.cshr.entity.Student");
		
		//����ͨ��class�ļ�����(��ʱ���ؾ��ǵ���������ʱ��Ż����)
		//��ʱ����(�����ӡ��̬��Ĵ���)
		//�����࣬����û�����ϼ���,ֻ�е�new�������Ķ���ʱ�Ż����
	    //Class c2 = Student.class;
	    //Student stu = (Student) c2.newInstance();
		
		//����ͨ����������û�ȡ��Class����
		//Student stu3 = new Student();
		//Class c3 = stu3.getClass();
		
		//4����������ķ�ʽ(��ʱ����)
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		Class c4 = loader.loadClass("com.cshr.entity.Student");
		c4.newInstance();
		
	}
}
