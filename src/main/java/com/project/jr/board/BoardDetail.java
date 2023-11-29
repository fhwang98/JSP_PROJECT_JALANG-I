package com.project.jr.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;

	
/**
 * @author oseunghyeon
 * 게시글 상세 정보를 조회하는 서블릿 클래
 */
	@WebServlet("/board/boarddetail.do")
	
	public class BoardDetail extends HttpServlet {

		
		  /**
	     * HTTP GET 요청을 처리하여 게시글의 상세 정보를 조회합니다.
	     */
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession session = req.getSession();
			
			String id = "";
			if (session.getAttribute("id") != null) {
				id = session.getAttribute("id").toString();
			}
			
			String boardSeq = req.getParameter("boardSeq");
			//검색 데이터 받기
			String search = req.getParameter("search");
			String column = req.getParameter("column");
			String word = req.getParameter("word");
			
			BoardDAO dao=new BoardDAO();
			
			
			//조회수 증가
			if ((session.getAttribute("read") != null
					&& session.getAttribute("read").toString().equals("n")) // 
					
					&& session.getAttribute(boardSeq) == null) {
				
				dao.updateReadcount(boardSeq);
				
				session.setAttribute("read", "y");
				session.setAttribute(boardSeq, "y");
			}
			
			System.out.println(session.getAttribute(boardSeq));
			
			BoardDTO dto =dao.getDetail(boardSeq);
			
			
			String title = dto.getBoardTitle().replace("<", "&lt;").replace(">", "&gt;");
			String content = dto.getBoardContent().replace("<", "&lt;").replace(">", "&gt;").replace("\r\n", "<br>");
			dto.setBoardTitle(title);
			dto.setBoardContent(content);
			
			//내용으로 검색 > 검색어 강조
			if (search != null && search.equals("y") && column.equals("boardContent")) {
				//<span style="background-color:gold;color.tomato;"></span>
				dto.setBoardContent(dto.getBoardContent().replace(word, "<span style=\"background-color:gold;\">" + word + "</span>"));
			}
			
			
			req.setAttribute("dto", dto);
			req.setAttribute("id", id);
			//System.out.println(boardSeq);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boarddetail.jsp");
			dispatcher.forward(req, resp);


	}
}

	
	
	
	