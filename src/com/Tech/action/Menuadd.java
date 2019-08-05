package com.Tech.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.dao.Menudao;


@WebServlet("/addmenu")
public class Menuadd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String dish = req.getParameter("dish");
		double price = Double.valueOf(req.getParameter("price"));	
		
		Menudao menudao=new Menudao();
		boolean flag=menudao.add(dish,price);
		
		if(flag) {
			resp.sendRedirect("success.jsp");
		}else {
			resp.sendRedirect("fail.jsp");
		}
	}
}
