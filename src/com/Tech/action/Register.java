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
import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;

import jdk.nashorn.internal.ir.Flags;


@WebServlet("/Register")
public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String userName1 = req.getParameter("user1");
		String passWord1 = req.getParameter("pass1");
		
		Userdao userdao=new Userdao();
		boolean flag=userdao.register(userName1, passWord1);
		
		if(userName1!=null && passWord1!=null) {
			if(flag) {
				resp.sendRedirect("login.jsp");
			}else {
				resp.sendRedirect("fail.jsp");
			}
		}
		else {
			resp.sendRedirect("fail.jsp");
		}
	}
}
