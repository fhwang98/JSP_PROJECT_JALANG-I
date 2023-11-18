package com.project.jr.study.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.study.model.StudyDTO;
import com.project.jr.study.model.ToDoDTO;
import com.project.jr.study.repository.StudyDAO;

/**
 * 스터디 상세 클래스
 * @author sujin
 *
 */
@WebServlet("/study/mypage/study/detail.do")
public class StudyDetail extends HttpServlet {

	/**
	 * 스터디 상세 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getSession().getAttribute("id").toString();
		//String id="RvXc3eY";
		
		StudyDAO dao=new StudyDAO();
		
		StudyDTO dto=dao.getStudy(id);
		
		int studySeq=dto.getStudySeq();
		
		String crtTestName=dao.getCrtName(id);
		
		ArrayList<String> nl=dao.getNameList(studySeq);
		
		ArrayList<ToDoDTO> list=dao.getList(studySeq);
		
		req.setAttribute("list", list);
		req.setAttribute("nameList", nl);
		req.setAttribute("crtTestName", crtTestName);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/study/mypage/study/detail.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
	
	
	
	}
}
