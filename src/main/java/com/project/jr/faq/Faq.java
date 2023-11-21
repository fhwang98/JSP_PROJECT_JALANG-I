package com.project.jr.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.faq.repository.FaqDAO;

/**
 * 
 * @author oseunghyeon
 * 자주 묻는 질문(FAQ) 목록을 조회하는 서블릿 클래스
 * 이 서블릿은 "/faq.do" 경로로 매핑되어 있습니다.
 * FAQ 목록을 조회하여 request 속성에 저장한 후 "/WEB-INF/views/faq/faq.jsp" 페이지로 포워딩합니다.
 * 
 
 */

@WebServlet("/faq.do")
public class Faq extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	ArrayList<FAQDTO> list=new ArrayList<FAQDTO>(); 
	
		
		FaqDAO dao=new FaqDAO();
		
		list=dao.getList();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/faq.jsp");
		dispatcher.forward(req, resp);
		
		

		
	}

	}