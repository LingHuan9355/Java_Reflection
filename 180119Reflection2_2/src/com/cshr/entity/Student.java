package com.cshr.entity;

import java.util.Date;

/**
 * 
 *<p>Title:Student </p>
 *Description: 
 *Ҫ��ʵ����һ��Ҫ�ͱ���һ��
 *�������ͱ������һ��
 *@author LH
 *@date 2018-1-28����05:02:29
 *@version V1.0
 */
public class Student {
	  /*id int(11) auto_increment primary key,
	  name varchar(30) not null,
	  momey double(16,2) not null,
	  brithday date not null*/
	
	private int id;
	private String name;
	private double momey;
	private Date brithday;
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
	public double getMomey() {
		return momey;
	}
	public void setMomey(double momey) {
		this.momey = momey;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	
	
}
