package com.Tech.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Tech.bean.Order;
import com.Tech.bean.OrderMenu;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class OrderMenudao {
	
	public void insertOrderMenus(int orderId,String[] menusIds) {
		
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
		
		String sql = "insert into tab_order_menu(order_id,menu_id) values(";
		for(String menuId:menusIds) {
			sql += orderId+","+Integer.valueOf(menuId)+"),(";
		}
		sql = sql.substring(0, sql.length()-2);
		try {
			queryRunner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderMenu> selectOrderMenuByOrderId(List<Order> orderList) {
		
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
		String sql = "select o.order_id as orderId,o.menu_id as menuId,m.dish,m.price  from  tab_order_menu as o ,tab_menu as m where o.menu_id = m.id and o.order_id in (";
		for(Order order: orderList) {
			sql += order.getId()+",";
		}
		sql = sql.substring(0,sql.length()-1);
		sql += ")";
		try {
			return queryRunner.query(sql, new BeanListHandler<OrderMenu>(OrderMenu.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
