package com.project.jr.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.model.FaqDTO;
import com.project.jr.faq.repository.FaqDAO;



@WebServlet("/faq.do")
public class Faq extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	ArrayList<FaqDTO> list=new ArrayList<FaqDTO>(); 
	
		
		FaqDAO dao=new FaqDAO();
		
		list=dao.getList();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/faq.jsp");
		dispatcher.forward(req, resp);
		
		

		
	}

	}