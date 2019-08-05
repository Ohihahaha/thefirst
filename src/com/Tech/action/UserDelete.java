package com.Tech.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.dao.Userdao;

@WebServlet("/deleteuser")
public class UserDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		int id = Integer.parseInt(req.getParameter("id"));
		Userdao userdao = new Userdao();
		userdao.deleteUser(id);
		resp.sendRedirect("userlist");
	}

}
