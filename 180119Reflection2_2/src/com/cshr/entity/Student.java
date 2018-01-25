package com.cshr.entity;

import java.sql.Date;

public class Student {

	
	public int id;
	public static String sex;
	protected String name;
	Date birthday;
	private double money;
	
	
	public Student() {
		super();
		System.out.println("无参构造...");
	}

	public Student(int id) {
		super();
		this.id = id;
		System.out.println("一参构造...");
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("两参构造...");
	}
	
	private Student(int id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		System.out.println("三参构造...");
	}
	
	public Student(int id, String name, Date birthday, double money) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.money = money;
		System.out.println("四参构造...");

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

	public static String getSex() {
		return sex;
	}

	public static void setSex(String sex) {
		Student.sex = sex;
	}
	
	public static void test(){
		System.out.println("无参静态方法 ");
	}
	public static void test2(int id,String name){
		System.out.println("有参静态方法 ");
		System.out.println("编号："+id+",姓名："+name);
	}
	
	public  void sum(int a,int b){
		System.out.println(a+b);
	}
	
}
