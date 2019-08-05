package com.Tech.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.bean.Table;
import com.Tech.dao.Tabledao;

@WebServlet("/tablelist")
public class TableList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		Tabledao tabledao = new Tabledao();
		List<Table> result=tabledao.tablelist();
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("tablelist.jsp").forward(req, resp);
	}

}

