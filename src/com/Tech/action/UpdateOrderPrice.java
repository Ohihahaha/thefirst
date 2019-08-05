package com.Tech.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.dao.Orderdao;

@WebServlet("/updateOrderPrice")
public class UpdateOrderPrice extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
		double ssPrice = Double.parseDouble(req.getParameter("ssPrice"));
		double cj = ssPrice - totalPrice;
		Orderdao orderDao = new Orderdao();
		orderDao.updatePrice(ssPrice, cj, orderId);
		resp.sendRedirect("home");
	}
}
