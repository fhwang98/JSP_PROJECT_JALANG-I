package com.project.jr.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.user.model.UserDTO;
import com.project.jr.user.repository.UserDAO;

@WebServlet("/user/finduserpasswordresult.do")
public class FindUserPasswordResult extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String id = req.getParameter("id");		
		String name = req.getParameter("name");
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/user/changepassword.jsp");
		dispacher.forward(req, resp);

	}
	

}
