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
		System.out.println("�޲ι���...");
	}

	public Student(int id) {
		super();
		this.id = id;
		System.out.println("һ�ι���...");
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("���ι���...");
	}
	
	private Student(int id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		System.out.println("���ι���...");
	}
	
	public Student(int id, String name, Date birthday, double money) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.money = money;
		System.out.println("�Ĳι���...");

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
		System.out.println("�޲ξ�̬���� ");
	}
	public static void test2(int id,String name){
		System.out.println("�вξ�̬���� ");
		System.out.println("��ţ�"+id+",������"+name);
	}
	
	public  void sum(int a,int b){
		System.out.println(a+b);
	}
	
}
