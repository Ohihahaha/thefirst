package com.Tech.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Tech.bean.Menu;
import com.Tech.dao.Menudao;
@WebServlet("/menulist")
public class MenuList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Menudao menudao=new Menudao();
		List<Menu> result=menudao.MenuList();
		req.setAttribute("result", result);
		req.getRequestDispatcher("menulist.jsp").forward(req, resp);
	}
}
