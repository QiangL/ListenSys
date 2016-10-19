package com.ListenSys.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class BaseDBHelper {
	/*
	 * ����·����ʹ����database.properties��ͬ����������������
	 * 
	 */
	private static String userName;
	private static String passWord;
	private static String connectionURL;
	private static String driver;
	private static ThreadLocal<Connection> connection=new ThreadLocal<Connection>();
	
	public BaseDBHelper(){
		Properties pro=new Properties();
		try {
			pro=PropertiesLoaderUtils.loadAllProperties("DataBase.properties");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("BaseDBHelper init fail");
		}
		userName=pro.getProperty("jdbc.username");
		passWord=pro.getProperty("jdbc.password");
		connectionURL=pro.getProperty("jdbc.url");
		driver=pro.getProperty("jdbc.driverClassName");
	}
	public  Connection getConnection(){
		Connection conn=connection.get();
		if(conn==null){
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(connectionURL, userName, passWord);
				connection.set(conn);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public void CloseConnection(){
		Connection conn=connection.get();
		if(conn!=null){
			try {
				conn.close();
				connection.remove();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public  void CloseStatement(PreparedStatement pstmt){
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void CloseResultSet(ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void CloseAll(ResultSet rs,PreparedStatement pstmt){
		CloseResultSet(rs);
		CloseStatement(pstmt);
		CloseConnection();
	}
}
