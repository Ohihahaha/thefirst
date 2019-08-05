package com.Tech.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.Tech.bean.Order;

public class Orderdao {
	
	public void insertOrder(int peopleNum,int tableNum,double totalPrice) {
		
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
		
		try {
			queryRunner.update("insert into tab_order(real_people,table_num,total_price) values("+peopleNum+","+tableNum+","+totalPrice+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int selectMaxId() {
		
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
		
		try {
			return Integer.parseInt(queryRunner.query("SELECT max(id) from tab_order", new ScalarHandler()).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void updatePrice(double ss,double cj,int orderId) {
		
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
		
		try {
			queryRunner.update("update tab_order set ss_price="+ss+",cj_price = "+cj+" where id = "+orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Order> selectAllOrder() {
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
		try {
			return queryRunner.query("select id,table_num as tableNum,total_price as totalPrice,real_people as realPeople,ss_price as ssPrice,cj_price as cjPrice from tab_order", new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
}
