package com.Tech.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.dao.Tabledao;

@WebServlet("/deletetable")
public class TableDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		int id = Integer.parseInt(req.getParameter("id"));
		Tabledao table = new Tabledao();
		table.deleteTable(id);
		resp.sendRedirect("tablelist");
	}

}
