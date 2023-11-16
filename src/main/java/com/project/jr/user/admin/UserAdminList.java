package com.project.jr.user.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.user.model.UserDTO;
import com.project.jr.user.repository.UserAdminDAO;

@WebServlet("/user/admin/useradminlist.do")
public class UserAdminList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		UserAdminDAO dao =  new UserAdminDAO();
		
		ArrayList<UserDTO> list = dao.list();
		

		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/admin/useradminlist.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}
