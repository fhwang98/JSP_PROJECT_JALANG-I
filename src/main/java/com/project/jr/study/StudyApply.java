package com.project.jr.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtSchDdayDTO;
import com.project.jr.crt.repository.CrtDAO;
import com.project.jr.study.model.StudyJoinDTO;
import com.project.jr.study.repository.StudyDAO;

@WebServlet("/study/studyapply.do")
public class StudyApply extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//StudyApply.java
		
		String crtseq = req.getParameter("crtseq");
		String crtName = req.getParameter("crtName");
		String agency = req.getParameter("agency");
		String crtctg = req.getParameter("crtctg");
		
		
		CrtDAO dao = new CrtDAO();
		
		ArrayList<CrtSchDdayDTO> schlist = dao.schddaylist(crtseq);
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		
		//시험접수일이 100전~30일전인지 확인
		for (CrtSchDdayDTO scdto : schlist) {
			if (scdto.getTestDday() <= 100 && scdto.getTestDday()>=30) {
				 HashMap<String, String> map = new HashMap<>();
	             map.put("schName", scdto.getCrtSchName());
	             map.put("year", scdto.getTestStartDate().substring(0, 4));
	             map.put("day", scdto.getTestStartDate().substring(0, 10));
	             map.put("crtsch", scdto.getCrtSchSeq()+"");
	             list.add(map);
			}
		}
		
		
		
		req.setAttribute("crtseq", crtseq);
		req.setAttribute("crtName", crtName);
		req.setAttribute("agency", agency);
		req.setAttribute("crtctg", crtctg);
		req.setAttribute("list", list);
		
		String fromlike = "study";
		req.setAttribute("fromlike", fromlike);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/study/studyapply.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String crtsch = req.getParameter("select-crtsch");
		String time = req.getParameter("select-time");
		String day = req.getParameter("select-day");
		String major = req.getParameter("select-major");
		String crtseq = req.getParameter("crtseq");
	
		StudyDAO dao = new StudyDAO();
		
		StudyJoinDTO dto = new StudyJoinDTO();
		dto.setCrtSchSeq(Integer.parseInt(crtsch));
		dto.setTimeOption(Integer.parseInt(time));
		dto.setDayOption(Integer.parseInt(day));
		dto.setMajorOption(Integer.parseInt(major));
		dto.setId(req.getSession().getAttribute("id").toString());
		
		int result = dao.add(dto);
		
		//3.
		if (result == 1) {
			/*
			// 성공 시 메시지를 세션에 저장
			String successMessage = "Add successful!";
			req.getSession().setAttribute("successMessage", successMessage);
			*/
//			PrintWriter writer = resp.getWriter();
//			writer.print("<script>alert('Add');</script>");
//			writer.close();
			

			// 페이지 이동
			resp.sendRedirect("/jr/crt/crtdetail.do?seq=" + crtseq);
			
		}else {
			//0 또는 에러
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('Add failed');history.back();</script>");
			writer.close();
		}
	
	}

}
