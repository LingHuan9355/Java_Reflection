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
 *2.试着自己写一个BaseDao，在这其中写一个getConnection()方法，将driver,url,uname
	password 等数据连接字符串放到与BaseDao同包的config.properties中，实现读取其中的配
	置的driver,url,uname,password的属性对应的值
	config.properties中的配置如下:

	#oracle
	#driver = oracle.jdbc.driver.OracleDriver
	#url = jdbc:oracle:thin:@127.0.0.1:1521:orcl
	#uname = scott
	#upwd = tiger

	提示:BaseDao中读到config.properties 方式为:
	InputStream is = BaseDao.class.getResourceAsStream("config.properties");
 *@author LH
 *@date 2018-1-25下午05:48:23
 *@version V1.0
 */
public class BaseDao {

	private static Properties ps = new Properties();
	
	//初始化加载properties中的资源信息
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
	
	//测试
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
