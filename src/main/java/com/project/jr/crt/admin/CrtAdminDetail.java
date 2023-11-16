package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtAdminDAO;
import com.project.jr.crt.repository.CrtDAO;

@WebServlet("/crt/admin/crtadmindetail.do")
public class CrtAdminDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String crtSeq= req.getParameter("crtSeq");
		
		CrtAdminDAO dao = new CrtAdminDAO();
		
		CrtDTO dto  = dao.detail(crtSeq);
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadmindetail.jsp");

		dispatcher.forward(req, resp);
	}
}
