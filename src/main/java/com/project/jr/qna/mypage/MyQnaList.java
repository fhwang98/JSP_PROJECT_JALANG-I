package com.project.jr.qna.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;
import com.project.jr.qna.model.QnaDTO;
import com.project.jr.qna.repository.QnaDAO;

@WebServlet("/qna/myqnalist.do")

public class MyQnaList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//	
		
		String id = "H5oZdAqV";
		
		QnaDAO dao=new QnaDAO();
		
		ArrayList<QnaDTO> list= dao.getMyQnaList(id);
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/qna/mypage/myQnaList.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
		
		
		
	}
}
