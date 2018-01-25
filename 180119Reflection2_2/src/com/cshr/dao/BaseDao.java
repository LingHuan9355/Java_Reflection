package com.cshr.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 
 *<p>Title:BaseDao </p>
 *Description: 
 *2.�����Լ�дһ��BaseDao����������дһ��getConnection()��������driver,url,uname
	password �����������ַ����ŵ���BaseDaoͬ����config.properties�У�ʵ�ֶ�ȡ���е���
	�õ�driver,url,uname,password�����Զ�Ӧ��ֵ
	config.properties�е���������:

	#oracle
	#driver = oracle.jdbc.driver.OracleDriver
	#url = jdbc:oracle:thin:@127.0.0.1:1521:orcl
	#uname = scott
	#upwd = tiger

	��ʾ:BaseDao�ж���config.properties ��ʽΪ:
	InputStream is = BaseDao.class.getResourceAsStream("config.properties");
 *@author LH
 *@date 2018-1-25����05:48:23
 *@version V1.0
 */
public class BaseDao {

	private static Properties ps = new Properties();
	
	//��ʼ������properties�е���Դ��Ϣ
	static {
		InputStream is = BaseDao.class.getResourceAsStream("config.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "admin");
			Class.forName(ps.getProperty("driver"));
			conn = DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("uname"), ps.getProperty("upwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  conn;
	}
	
	//����
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
