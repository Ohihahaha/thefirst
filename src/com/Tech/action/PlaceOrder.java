package com.Tech.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.bean.Menu;
import com.Tech.dao.Menudao;
import com.Tech.dao.OrderMenudao;
import com.Tech.dao.Orderdao;

@WebServlet("/placeorder")
public class PlaceOrder extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//人数
		int peopleNum = Integer.valueOf(req.getParameter("peopleNum"));
		//座位号
		int tableNum = Integer.valueOf(req.getParameter("tableNum"));
		//菜品id
		
		String[] menuListIds = req.getParameterValues("menu");
		Menudao menuDao = new Menudao();
		List<Menu> menuList = menuDao.selectByIds(menuListIds);
		double totalPrice = 0d;
		for(Menu menu: menuList) {
			totalPrice = totalPrice + menu.getPrice();
		}
		
		Orderdao orderDao = new Orderdao();
		orderDao.insertOrder(peopleNum, tableNum,totalPrice);
		int orderId = orderDao.selectMaxId();
		OrderMenudao orderMenuDao = new OrderMenudao();
		orderMenuDao.insertOrderMenus(orderId, menuListIds);
		
		req.setAttribute("tableNum", tableNum);
		req.setAttribute("peopleNum", peopleNum);
		req.setAttribute("menuList", menuList);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("orderId", orderId);
		req.getRequestDispatcher("ordering.jsp").forward(req, resp);
	}
}
