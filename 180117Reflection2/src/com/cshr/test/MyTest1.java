package com.cshr.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.sql.Date;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest1 </p>
 *Description: 
 *һ��������ȡ�乹�췽��
 *@author LH
 *@date 2018-1-18����12:18:49
 *@version V1.0
 */
public class MyTest1  {

	
	@Test
	public void testMain() throws Exception{
		
		Class c1=Class.forName("com.cshr.entity.Student");
		//ͨ������󣬵������޲ι��췽�����Ӷ��ﵽʵ���������Ŀ��
		Student stu = (Student) c1.newInstance();
		
		//ͨ����������ȡ���췽��
	     Constructor ct1 = c1.getConstructor();	
	     Student stu1 = (Student) ct1.newInstance();
	     
	     //��ȡ��������Ĺ��췽��(public���εĹ��췽��)
	     Constructor ct2 = c1.getConstructor(int.class);
	     Student stu2 = (Student) ct2.newInstance(23);
	     System.out.println(stu2.getId());
	     
	     Constructor ct3 = c1.getConstructor(int.class,String.class);
	     Student stu3 = (Student) ct3.newInstance(22,"Tom");
	     System.out.println(stu3.getId()+ ":" + stu3.getName());
	     
	     Constructor ct4 = c1.getConstructor(new Class []{int.class,String.class});
	     Student stu4 = (Student) ct4.newInstance(new Object[]{21,"Cat"});
	     System.out.println(stu4.getId()+ ":" + stu4.getName());
	     
	   //��ȡ���������Ĺ��췽��
	     Constructor ct5 = c1.getDeclaredConstructor(int.class,String.class,Date.class);
	     //���ÿ��Է���-->����
	     ct5.setAccessible(true);
	     Student stu5 = (Student) ct5.newInstance(20,"Jack",new Date(System.currentTimeMillis()));
	     System.out.println(stu5.getId()+ ":" + stu5.getName()+ ":" +stu5.getBirthday());
	     
	     
	   //��ȡȫ���Ĺ����Ĺ��췽��
	     Constructor  [] cts1 = c1.getConstructors();
	     for (Constructor cc : cts1) {
			//System.out.println(cc);
	    	//��ȡ�������η�
	    	// System.out.println(Modifier.toString(cc.getModifiers()));
	    	//��ȡ����������
	    	// System.out.println(cc.getName());
	    	//��ȡ����
	    	 System.out.println(convert(cc.getParameterTypes()));	 
		}
	     
	     System.out.println("=================");
			
			
		//��ȡ���еĹ��췽��
	Constructor [] cts2 = c1.getDeclaredConstructors();
	for (Constructor cc : cts2) {
		System.out.println(cc);
	}
	
	
	}
	
	//ת������
	public static String convert(Class [] parameterTypes){
		StringBuffer sb = new StringBuffer();
		sb.append("��");
		for (int i = 0; i < parameterTypes.length; i++) {
			sb.append(parameterTypes[i].getName());
			if(i< parameterTypes.length-1){
				sb.append(",");
			}
		}
		sb.append("��");
		
		return sb.toString();
	}
}
