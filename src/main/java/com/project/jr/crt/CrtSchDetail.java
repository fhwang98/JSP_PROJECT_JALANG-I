package com.project.jr.crt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtSchDTO;
import com.project.jr.crt.repository.CrtSchDAO;

@WebServlet("/crt/crtschdetail.do")
public class CrtSchDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtSchDetail.java
		
		
		String crtschseq = req.getParameter("crtschseq");
		
		
		CrtSchDAO dao = new CrtSchDAO();
		CrtSchDTO dto = dao.list(crtschseq);
		
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtschdetail.jsp");
		dispatcher.forward(req, resp);

	}

}