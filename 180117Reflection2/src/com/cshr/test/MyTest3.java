package com.cshr.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest3 </p>
 *Description: 
 *������ȡ����
 *@author LH
 *@date 2018-1-18����03:34:34
 *@version V1.0
 */
public class MyTest3 {

	@Test
	public void testMian() throws Exception{
		Class c1 = Class.forName("com.cshr.entity.Student");
        Student stu = (Student) c1.newInstance();
		//��ȡָ�����ƵĹ��з���
        Method m1 = c1.getMethod("setName",String.class);
        //����stu.setName("tom");
        m1.invoke(stu, "tom");
        System.out.println(stu.getName());
        
        Method m2 = c1.getMethod("getName");
        System.out.println(m2.invoke(stu));
        
       //���еľ�̬����
        Method m3 = c1.getMethod("test");
        m3.invoke(null);
        
      //��ȡָ�����������������з���(�������η�)
        Method m4 = c1.getDeclaredMethod("sum",int.class,int.class);
        m4.setAccessible(true);//����
        m4.invoke(stu,1,2);
        
      //��ȡ���еĹ����ķ��� ��ע�����ﲢ�ҿ��Ի�ȡ�������еĹ�������
        Method [] mm1 = c1.getMethods();
        for (Method mm : mm1) {
        	//��ȡ�����������η�
			System.out.print(Modifier.toString(mm.getModifiers()));
			//��ȡ�����ķ�������
			System.out.print("  "+mm.getReturnType().getSimpleName());
			//��ȡ����������
			System.out.print("  "+mm.getName());
			//��ȡ�����Ĳ���
			System.out.print("  "+convert(mm.getParameterTypes()));
			
			System.out.println();

		}
        
        System.out.println("===================");
        
      //��ȡ���е�(�Լ���);
        Method [] mm2 = c1.getDeclaredMethods();
      //������һ��ȫ������
        Method.setAccessible(mm2, true);
        for (Method mm: mm2) {
        /*	String name = mm.getName();
        	if("sum".equals(name)){
        		mm.invoke(stu, 1,2);
        		System.out.println();
        	}*/
		System.out.println(mm);
		}
	}
	
	//ת������
	public static String convert(Class [] parameterTypes){
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for(int i=0;i<parameterTypes.length;i++){
			sb.append(parameterTypes[i].getSimpleName());
			if(i<parameterTypes.length-1){
				sb.append(",");
			}
		}
		sb.append(")");
		
		return sb.toString();
	}
}
