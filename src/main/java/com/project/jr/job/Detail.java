package com.project.jr.job;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.job.model.JobDTO;
import com.project.jr.job.repository.JobDAO;

/**
 * 직업상세 클래스
 *
 */
@WebServlet("/job/detail.do")
public class Detail extends HttpServlet {

	/**
	 * 직업상세 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int seq=Integer.parseInt(req.getParameter("seq"));
		
		System.out.println(seq);
		
		JobDAO dao=new JobDAO();
		
		JobDTO dto=dao.job(seq);
		
		req.setAttribute("dto", dto);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/job/detail.jsp");
		dispatcher.forward(req, resp);

	}

}
