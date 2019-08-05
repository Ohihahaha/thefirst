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


@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String userName = req.getParameter("user");
		String passWord = req.getParameter("pass");
		
		Userdao userdao=new Userdao();
		List<User>result=userdao.login(userName, passWord);
		
		if(result.size()>0 && result.get(0).getUserName() != null && !result.get(0).getUserName().equals("")) {
			resp.sendRedirect("home");
		}else {
			resp.sendRedirect("fail.jsp");
		}
	}
}
