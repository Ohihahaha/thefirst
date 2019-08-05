package com.Tech.action;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tech.bean.Menu;
import com.Tech.bean.Table;
import com.Tech.dao.Menudao;
import com.Tech.dao.Tabledao;

@WebServlet("/home")
public class Home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tabledao tabledao = new Tabledao();
		List<Table> tableList = tabledao.tablelist();
		
		Menudao menuDao = new Menudao();
		List<Menu> menuList = menuDao.MenuList();
		
		req.setAttribute("tableList",tableList);
		req.setAttribute("menuList", menuList);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
