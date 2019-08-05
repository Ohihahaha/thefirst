package com.Tech.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.bean.Order;
import com.Tech.bean.OrderMenu;
import com.Tech.dao.Orderdao;
import com.Tech.dao.OrderMenudao;

@WebServlet("/selectorder")
public class SelectOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Orderdao orderDao = new Orderdao();
		List<Order> orderList = orderDao.selectAllOrder();
		OrderMenudao orderMenuDao = new OrderMenudao();
		List<OrderMenu> orderMenuList = orderMenuDao.selectOrderMenuByOrderId(orderList);
		for(Order order:orderList) {
			String menus = "";
			for(OrderMenu orderMenu:orderMenuList) {
				if(order.getId() == orderMenu.getOrderId()) {
					menus += orderMenu.getDish()+"("+orderMenu.getPrice()+")"+",";
				}
			}
			order.setMenus(menus != null && !menus.equals("") ? menus.substring(0,menus.length()-1) : "");
		}
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("order.jsp").forward(req, resp);
	}
}
