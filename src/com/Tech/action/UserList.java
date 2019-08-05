package com.Tech.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.bean.User;
import com.Tech.dao.Userdao;

@WebServlet("/userlist")
public class UserList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		Userdao userdao = new Userdao();
		List<User> result=userdao.userlist();
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("userlist.jsp").forward(req, resp);
	}

}

