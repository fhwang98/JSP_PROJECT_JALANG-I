package com.project.jr.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;

@WebServlet("/board/view.do")

/**
 * 
 * @author oseunghyeon
 *
 */
public class View extends HttpServlet{
	

    /**
     * HTTP GET 요청을 처리하여 게시글 상세 정보를 보여줍니다.
     */
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	HttpSession session = req.getSession();
	
	String boardSeq = req.getParameter("boardSeq");
	
	String search = req.getParameter("search");
	String column = req.getParameter("column");
	String word = req.getParameter("word");
	
	BoardDAO dao = new BoardDAO();
	
	if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("0")) {
		
		dao.updateReadcount(boardSeq);
		
		session.setAttribute("read","1" );
	}
	
	BoardDTO dto=dao.getDetail(boardSeq);
	
	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
	dispatcher.forward(req, resp);

	}	
}
