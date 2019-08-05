package com.Tech.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.Tech.dao.Tabledao;


@WebServlet("/addtable")
public class Tableadd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		double tableNum = Double.valueOf(req.getParameter("table"));
		double peopleNum = Double.valueOf(req.getParameter("people"));
		
		Tabledao tabledao=new Tabledao();
		boolean flag=tabledao.add(tableNum,peopleNum);
		
		if(flag) {
			resp.sendRedirect("success.jsp");
		}else {
			resp.sendRedirect("fail.jsp");
		}
	}
}
