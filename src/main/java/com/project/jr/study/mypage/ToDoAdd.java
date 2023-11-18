package com.project.jr.study.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.study.model.ToDoDTO;
import com.project.jr.study.repository.StudyDAO;

/**
 * 스터디 할일 클래스
 * @author sujin
 *
 */
@WebServlet("/study/mypage/todoadd.do")
public class ToDoAdd extends HttpServlet {

	/**
	 * 스터디 할일 목록 출력 doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		int studySeq=Integer.parseInt(req.getParameter("studySeq"));
		String toDo=req.getParameter("toDoList");
		String completeDate=req.getParameter("date");
		String id=req.getSession().getAttribute("id").toString();
		String ToDoComment=req.getParameter("memo");
		
		
		StudyDAO dao=new StudyDAO();
		
		
		int result=dao.setToDo(studySeq, toDo, completeDate, id, ToDoComment);
		
		System.out.println(result);
		if (result == 1) {
			
			resp.sendRedirect("/jr/study/mypage/study/detail.do");
			
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
	}

}
