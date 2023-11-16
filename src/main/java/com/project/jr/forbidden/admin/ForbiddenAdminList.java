package com.project.jr.forbidden.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

@WebServlet("/forbidden/admin/forbiddenadminlist.do")
public class ForbiddenAdminList extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
		
		ArrayList<ForbiddenAdminDTO> list = dao.list();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadminlist.jsp");

		dispatcher.forward(req, resp);
	}
}
