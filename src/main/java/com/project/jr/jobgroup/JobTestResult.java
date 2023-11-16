package com.project.jr.jobgroup;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/jobTestResult.do")
	public class JobTestResult extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println(req.getParameter("page1"));
			System.out.println(req.getParameter("page2"));
			System.out.println(req.getParameter("page3"));
			
			int totalScore = 0;
			for(int i=0; i<20; i++) {
				totalScore += Integer.parseInt(req.getParameter("page" + i));
				
			}
			
			req.setAttribute("totalScore",totalScore);   //Attribute 에 호출명 STR 로 저장 
			

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/jobTestResult.jsp");
			dispatcher.forward(req, resp);

		}

	}
