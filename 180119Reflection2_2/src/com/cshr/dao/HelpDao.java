package com.cshr.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

/**
 * 
 *<p>Title:BaseDao2 </p>
 *Description: 
 *3.试着自己写一个通用的BaseDao(利用反射写出通用的增、删、改、查的方法)
 *@author LH
 *@date 2018-1-25下午06:22:22
 *@version V1.0
 */
public class HelpDao {

	public static Properties ps = new  Properties();
	
	//初始化加载properties中的资源信息
	static {
		InputStream is = HelpDao.class.getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库连接对象
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(ps.getProperty("driver"));
			conn = DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("uname"),ps.getProperty("upwd"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//关闭释放资源
	public static void closeAll(ResultSet rs,Statement st, Connection conn){
			try {
				if(rs != null){
				   rs.close();
				}
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	//测试
	/*public static void main(String[] args) {
		System.out.println(getConn());
	}*/
	
	//添加
	public static int sava(Object obj){
		int num = 0;
		//根据对象，获取其类的对象
		Class c = obj.getClass();
		//获取表名(类名)
		String tableName = c.getSimpleName();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into  ");
		sb.append(tableName);
		sb.append(" ( ");
		for (int i = 1; i < fs.length; i++) {
			sb.append(fs[i].getName());
			if(i<fs.length-1){
				sb.append(",");
			}
		}
		sb.append(" ) ");
		sb.append(" values ( ");
		for (int i = 1; i < fs.length; i++) {
			sb.append(" ? ");
			if(i<fs.length-1){
				sb.append(",");
			}
		}
		sb.append(" ) ");
		
		System.out.println(sb);
		
		//执行JDBC的操作
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = HelpDao.getConn();
		try {
			pst = conn.prepareStatement(sb.toString());
			//给上面SQL语句的问号进行赋值
			for (int i = 1; i < fs.length; i++) {
				//fs[i].get(obj)表示从obj这个对象中获取其对象的属性对象的值
				//stu.getId();
				//判断如果实体类有一个属性的类型为java.util.Date的时候
				if(fs[i].get(obj) instanceof java.util.Date){
					java.util.Date date = (java.util.Date) fs[i].get(obj);
					Date sdate = new Date(date.getTime());
					pst.setObject(i, sdate);
				}else{
					pst.setObject(i,fs[i].get(obj));
				}
			}
			
			//获取执行这次操作的受影响的行数
			num = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
		}
		
		return num;
	}

	//查询
	@SuppressWarnings("unchecked")
	public static List queryList(Class c){
		List list = new ArrayList();
		
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from ");
		sb.append(c.getSimpleName());
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		conn = HelpDao.getConn();
		try {
			pst = conn.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while(rs.next()){
				//Student stu = new Student();
				Object obj = c.newInstance();
				for (int i = 0; i < fs.length; i++) {
				  //给属性对象赋值
					//oracle number-->BigDecimal
				   if(rs.getObject(fs[i].getName()) instanceof BigDecimal ){
					    BigDecimal big = (BigDecimal) rs.getObject(fs[i].getName());
						int value = big.intValue();
						fs[i].set(obj, value);					
						//数据库中date类型，用反射获取到的是一个timestamp类型
				   }else if(rs.getObject(fs[i].getName()) instanceof Timestamp){
					   Timestamp time = (Timestamp) rs.getObject(fs[i].getName());
					   Date sdate = new Date(time.getTime());
					   fs[i].set(obj, sdate);
				   }else {
			     		//stu.setId(rs.getInt("id"));
						//stu.setName(rs.getString("name"));
					   fs[i].set(obj, rs.getObject(fs[i].getName()));
				   }
				}
				//把对象放到集合中去
				list.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(rs, pst, conn);
		}
		
		return list;
	}
	
	//修改
	public static int modify(Object obj){
		int num = 0;
		Class c = obj.getClass();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs, true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" update ");
		sb.append(c.getSimpleName());
		sb.append(" set ");
		for (int i = 1; i < fs.length; i++) {
		    sb.append(fs[i].getName());
		    sb.append(" = ? ");
		    if(i < fs.length-1){
		    	sb.append(" , ");
		    }
		}
		sb.append(" where ");
		sb.append(fs[0].getName());
		sb.append(" = ? ");
		System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst = null;
		conn = HelpDao.getConn();
		try {
			pst = conn.prepareStatement(sb.toString());
			//给问号赋值
			for (int i = 1; i < fs.length; i++) {
              if(fs[i].get(obj) instanceof java.util.Date) {
            	  java.util.Date date = (java.util.Date) fs[i].get(obj);
            	  Date sdate = new Date(date.getTime());
            	  pst.setObject(i,sdate);
            	  
              }else {		
				  pst.setObject(i, fs[i].get(obj));
			
              }
			}
			//单独给where条件后面的问号赋值
			pst.setObject(fs.length,fs[0].get(obj));
			num = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
		}
		
		return num;
	}
	
	//删除
	public static int delete(Object obj){
		int num = 0;
		Class c = obj.getClass();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from ");
		sb.append(c.getSimpleName());
		sb.append(" where ");
		sb.append(fs[0].getName());
		sb.append(" = ? ");
		System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = HelpDao.getConn();
			pst = conn.prepareStatement(sb.toString());
			pst.setObject(1,fs[0].get(obj));
			num = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
		}
		
		return num;
	}
	
	
}
