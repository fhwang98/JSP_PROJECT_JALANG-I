package com.project.jr.qna.admin;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.qna.model.QnaDTO;
import com.project.jr.qna.repository.QnaDAO;



@WebServlet("/qna.do")
public class Qna extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		
		ArrayList<QnaDTO> list=new ArrayList<QnaDTO>(); 
		
		QnaDAO dao=new QnaDAO();
		
		list=dao.getList();
		
		req.setAttribute("dto", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/qna/admin.jsp");
		dispatcher.forward(req, resp);
		

	}

}




