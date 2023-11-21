package com.project.jr.board;

import java.io.IOException;
import java.io.PrintWriter;

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
	 * 
	 * @author oseunghyeon
	 *
	 */
	@WebServlet("/board/edit.do")
	public class Edit extends HttpServlet {

		/**
	     * HTTP GET 요청을 처리하여 수정 폼을 보여준다.
	     */
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//Edit.java
			//- view.do > 수정하기 버튼 클릭 > edit.do?seq=5
			//1. 데이터 가져오기(seq)
			//2. DB 작업 > select
			//3. 결과 + JSP 호출하기
			
		    //f ().check(req, resp)) {
//				return;
//			}
			
			
			//1.
			
			String id = req.getParameter("id");
			
			
			
			BoardDAO dao = new BoardDAO();			
			BoardDTO dto = dao.getEdit(id);
			
		
			req.setAttribute("dto", dto);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
			dispatcher.forward(req, resp);
		}
		
		   /**
	     * HTTP POST 요청을 처리하여 게시글을 수정
	     */
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//EditOk.java 역할
			
			//1. 데이터 가져오기
			//2. DB 작업 > update
			//3. 피드백
			
			HttpSession session = req.getSession();		
			
			//1.
			
//			String subject = req.getParameter("subject");
//			String content = req.getParameter("content");
//			String seq = req.getParameter("seq"); //수정할 글번호
			
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String id = req.getParameter("id");
		
			
			
			//2.
			BoardDAO dao = new BoardDAO();
			
			BoardDTO dto = new BoardDTO();
			
			dto.setBoardTitle(title);
			dto.setBoardContent(content); 
			dto.setId(session.getAttribute("id").toString());
			
			
			
			int result = dao.editResult(dto);
			
			//3.
			if (result == 1) {
					
				resp.sendRedirect("/jr/board/boarddetail.do?id=" + id);
				
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
			}
			
		}

	}
	
