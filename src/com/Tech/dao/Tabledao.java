package com.Tech.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Tech.bean.Table;
import com.mchange.v2.c3p0.ComboPooledDataSource;

    public class Tabledao {
    	
    	public boolean add(double tableNum,double peopleNum) {
    		
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
    			queryRunner.update("insert into tab_table(tablenum,peoplenum) values('"+tableNum+"','"+peopleNum+"')");
    			flag = true;
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return flag;
    	}
    	
	public List<Table>tablelist(){
	
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
	List<Table> result  = new ArrayList<>();
	
	try {
		result = queryRunner.query("select * from tab_table ", new BeanListHandler<Table>(Table.class));
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return result;
	}
	
	
	public boolean deleteTable(int id) {
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
			queryRunner.update("delete from tab_table where id = "+ id);
			flag= true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return flag;
	}

}
