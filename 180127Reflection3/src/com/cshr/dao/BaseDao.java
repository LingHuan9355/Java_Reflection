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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseDao {

	
	public static Properties ps = new Properties();
	
	//��ʼ������properties�е���Դ��Ϣ
	static {
		InputStream is = BaseDao.class.getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ���ݿ����Ӷ���
	public static Connection getConn(){
		Connection conn = null;
		
		try {
			Class.forName(ps.getProperty("driver"));
            conn = DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("uname"),ps.getProperty("upwd"));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//�ر��ͷ���Դ
	public static void closeAll(ResultSet rs,Statement st,Connection conn){
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
	
	
	//ͨ�õı������ķ���
	public static int save(Object obj){
		int num = 0;
		//���ݶ��󣬻�ȡ����Ķ���
		Class c1 = obj.getClass();
		//��ȡ����(����)
		String tableName = c1.getSimpleName();
		//��ȡ���������˽��������
		Field [] fs = c1.getDeclaredFields();
		//����
	    Field.setAccessible(fs, true);
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append(" insert into ");
	    sb.append(tableName);
	    sb.append(" ( ");
	    for (int i = 1; i < fs.length; i++) {
		   sb.append(fs[i].getName());
		   if(i < fs.length -1){
			   sb.append(" , ");
		   }
		}
	    sb.append(" ) ");
		sb.append(" values ( ");
		for (int i = 1; i < fs.length; i++) {
			sb.append(" ? ");
			if(i < fs.length -1){
				sb.append(" , ");
			}
		}
		sb.append(" ) "); 
		
		//ִ��JDBC�Ĳ���
		Connection  conn = null;
		PreparedStatement pst = null;
		
		conn = BaseDao.getConn();
		try {
			pst = conn.prepareStatement(sb.toString());
			//������SQL�����ʺŽ��и�ֵ
			for (int i = 1; i < fs.length; i++) {
				//fs[i].get(obj)��ʾ��obj��������л�ȡ���������Զ����ֵ
				//stu.getId();
				
				//�ж����ʵ������һ�����Ե�����Ϊjava.util.Date��ʱ��
				if(fs[i].get(obj) instanceof java.util.Date){
					//������ֵobject����ȡ������ǿת
					java.util.Date date = (java.util.Date) fs[i].get(obj);
					Date sdate = new Date(date.getTime());
					pst.setObject(i,sdate);
				}else{
				    pst.setObject(i,fs[i].get(obj));
				}
			}
			
			//��ȡִ����β�������Ӱ�������
			num = pst.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(null, pst, conn);
		}
		
		
		System.out.println(sb);
		return num;
	}
	
	//��ѯ c��Ҫ����ѯ�������
	@SuppressWarnings("unchecked")
	public static List queryList(Class c){
		List list = new ArrayList();
		
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from  ");
		sb.append(c.getSimpleName());
		System.out.println(sb);
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = BaseDao.getConn();
			pst = conn.prepareStatement(sb.toString());
            rs = pst.executeQuery();
            while(rs.next()){
            	//Student stu = new Student();
            	Object obj = c.newInstance();
            	for (int i = 0; i < fs.length; i++) {
            		//�����Զ���ֵ
            		//oracle number-->BigDecimal
            		if(rs.getObject(fs[i].getName()) instanceof BigDecimal){
                        BigDecimal big = (BigDecimal) rs.getObject(fs[i].getName());
                        int value = big.intValue();
            			fs[i].set(obj, value);
            			//���ݿ���date���ͣ��÷����ȡ������һ��timestamp����
            		}else if(rs.getObject(fs[i].getName()) instanceof Timestamp){
            			Timestamp time = (Timestamp) rs.getObject(fs[i].getName());
            			Date date = new Date(time.getTime());
            			fs[i].set(obj, date);
            		}else{
            			//stu.setId(rs.getInt("id"));
						//stu.setName(rs.getString("name"));
            			fs[i].set(obj, rs.getObject(fs[i].getName()));
            		}
				}
				//�Ѷ���ŵ�������ȥ
                list.add(obj);
            }
			
		} catch (Exception e) {
             closeAll(rs, pst, conn);
		}
		
		return list;
	}
	
	//�޸ķ���
	@SuppressWarnings("unchecked")
	public static int medify(Object obj){
		int num = 0;
		Class c = obj.getClass();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
	    StringBuffer sb = new StringBuffer();
	    sb.append(" update ");
	    sb.append(c.getSimpleName());
	    sb.append(" set ");
	    for (int i = 1; i < fs.length; i++) {
			sb.append(fs[i].getName());
			sb.append(" = ? ");
			if(i < fs.length-1){
				sb.append(",");
			}
		}
	    sb.append(" where ");
	    sb.append(fs[0].getName());
	    sb.append(" = ?");
	    System.out.println(sb);
		
	  //ִ��JDBC�Ĳ���
	    Connection conn = null;
	    PreparedStatement pst = null;
	    conn = BaseDao.getConn();
	    try {
			pst = conn.prepareStatement(sb.toString());
			//���ʺŸ�ֵ
			for (int i = 1; i < fs.length; i++) {
				if(fs[i].get(obj) instanceof java.util.Date){
					java.util.Date date = (java.util.Date) fs[i].get(obj);
					Date sdate = new Date(date.getTime());
					pst.setObject(i, sdate);
				}else {
					pst.setObject(i, fs[i].get(obj));
				}
			}
			//������where����������ʺŸ�ֵ
			pst.setObject(fs.length, fs[0].get(obj));
			num = pst.executeUpdate();
		} catch (Exception e) {
           e.printStackTrace();
		}finally{
			closeAll(null, pst, conn);
			
		}
	    
		return num;
	}
	
	//ɾ��
	@SuppressWarnings("unchecked")
	public static int delete(Object obj){
		int num = 0;
		
		Class c = obj.getClass();
		Field [] fs = c.getDeclaredFields();
		Field.setAccessible(fs,true);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from ");
		sb.append(c.getSimpleName());
		sb.append(" where ");
		sb.append(" id  = ");
		sb.append(" ? ");
		System.out.println(sb);
		
		//ִ��JDBC�Ĳ���
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = BaseDao.getConn();
		try {
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
	//��������
	/*public static void main(String[] args) {
		System.out.println(getConn());
	}*/
	
	
	
	
}
