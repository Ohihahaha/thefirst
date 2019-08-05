package com.Tech.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Tech.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Userdao {
	public List<User>login (String userName,String passWord){
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/17?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("318678");
		QueryRunner queryRunner = new QueryRunner(cpds);
		List<User> result  = new ArrayList<>();
		try {
			result = queryRunner.query("select * from tab_user where username = '"+userName+"' and password='"+passWord+"'", new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean register(String userName,String passWord) {
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/17?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("318678");
		QueryRunner queryRunner = new QueryRunner(cpds);
		
		boolean flag = false;
		try {
			queryRunner.update("insert into tab_user(username,password) values('"+userName+"','"+passWord+"')");
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
}
public List<User>userlist(){
	
	ComboPooledDataSource cpds = new ComboPooledDataSource();
	try {
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
	} catch (PropertyVetoException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	cpds.setJdbcUrl("jdbc:mysql://localhost:3306/17?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
	cpds.setUser("root");
	cpds.setPassword("318678");
	QueryRunner queryRunner = new QueryRunner(cpds);
	List<User> result  = new ArrayList<>();
	
	try {
		result = queryRunner.query("select * from tab_user ", new BeanListHandler<User>(User.class));
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return result;
	}
public boolean deleteUser(int id) {
	ComboPooledDataSource cpds = new ComboPooledDataSource();
	try {
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
	} catch (PropertyVetoException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	cpds.setJdbcUrl("jdbc:mysql://localhost:3306/17?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
	cpds.setUser("root");
	cpds.setPassword("318678");
	QueryRunner queryRunner = new QueryRunner(cpds);
	
	boolean flag = false;
	
	try {
		queryRunner.update("delete from tab_user where id = "+ id);
		flag= true;
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return flag;
}
}
