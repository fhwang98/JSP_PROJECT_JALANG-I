package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.crt.repository.CrtTestDAO;

@WebServlet("/crt/admin/crttestadmindetail.do")
public class CrtTestAdminDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String crtSeq = req.getParameter("crtSeq");
		
		CrtTestDAO dao = new CrtTestDAO();
				
		CrtTestDTO dto = dao.detail(crtSeq);
		
		req.setAttribute("dto", dto);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadmindetail.jsp");
       
		dispatcher.forward(req, resp);
	}
}
                         