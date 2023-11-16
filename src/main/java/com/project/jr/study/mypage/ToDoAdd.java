package com.project.jr.study.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.study.model.ToDoDTO;
import com.project.jr.study.repository.StudyDAO;

@WebServlet("/study/mypage/todoadd.do")
public class ToDoAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		int studySeq=Integer.parseInt(req.getParameter("studySeq"));
		String toDo=req.getParameter("toDoList");
		String completeDate=req.getParameter("date");
		String id=req.getParameter("name");
		String ToDoComment=req.getParameter("memo");
		
		
		StudyDAO dao=new StudyDAO();
		
		
		int result=dao.setToDo(studySeq, toDo, completeDate, id, ToDoComment);
		
	}

}
