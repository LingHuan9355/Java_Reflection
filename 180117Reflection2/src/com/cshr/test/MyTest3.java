package com.cshr.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.cshr.entity.Student;

/**
 * 
 *<p>Title:MyTest3 </p>
 *Description: 
 *三、获取方法
 *@author LH
 *@date 2018-1-18下午03:34:34
 *@version V1.0
 */
public class MyTest3 {

	@Test
	public void testMian() throws Exception{
		Class c1 = Class.forName("com.cshr.entity.Student");
        Student stu = (Student) c1.newInstance();
		//获取指定名称的公有方法
        Method m1 = c1.getMethod("setName",String.class);
        //调用stu.setName("tom");
        m1.invoke(stu, "tom");
        System.out.println(stu.getName());
        
        Method m2 = c1.getMethod("getName");
        System.out.println(m2.invoke(stu));
        
       //公有的静态方法
        Method m3 = c1.getMethod("test");
        m3.invoke(null);
        
      //获取指定名称所声明的所有方法(所有修饰符)
        Method m4 = c1.getDeclaredMethod("sum",int.class,int.class);
        m4.setAccessible(true);//解锁
        m4.invoke(stu,1,2);
        
      //获取所有的公共的方法 ，注意这里并且可以获取到父类中的公共方法
        Method [] mm1 = c1.getMethods();
        for (Method mm : mm1) {
        	//获取方法访问修饰符
			System.out.print(Modifier.toString(mm.getModifiers()));
			//获取方法的返回类型
			System.out.print("  "+mm.getReturnType().getSimpleName());
			//获取方法的名称
			System.out.print("  "+mm.getName());
			//获取方法的参数
			System.out.print("  "+convert(mm.getParameterTypes()));
			
			System.out.println();

		}
        
        System.out.println("===================");
        
      //获取所有的(自己的);
        Method [] mm2 = c1.getDeclaredMethods();
      //给数组一次全部解锁
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
	
	//转换方法
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
