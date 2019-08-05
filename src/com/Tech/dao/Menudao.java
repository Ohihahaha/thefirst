package com.Tech.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Tech.bean.Menu;
import com.mchange.v2.c3p0.ComboPooledDataSource;

    public class Menudao {
    	
public boolean add(String dish,double price) {
    		
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
    				queryRunner.update("insert into tab_menu(dish,price) values('"+dish+"','"+price+"')");
    				flag = true;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			return flag;
    		}

public List<Menu> MenuList() {
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
	List<Menu> result = new ArrayList<>();
	try {
		result  = queryRunner.query("select * from tab_menu ", new BeanListHandler<Menu>(Menu.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}
public boolean deletemenu(int id) {
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
	boolean flag=false;
	try {
		queryRunner.update("delete from tab_menu where id = " + id);
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}
public List<Menu> selectByIds(String[] menuIds){
	
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
	
	String sql = "SELECT * FROM `tab_menu` where id in (";
	for(String menuId: menuIds) {
		sql += menuId+",";
	}
	sql = sql.substring(0,sql.length()-1);
	sql += ")";
	
	try {
		return queryRunner.query(sql, new BeanListHandler<Menu>(Menu.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new ArrayList<>();
}
}
    	
    	
    	