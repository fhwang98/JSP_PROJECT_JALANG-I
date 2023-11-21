package com.project.jr.qna.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;


/**
 * 
 * @author oseunghyeon
  * MyQnaDetail 클래스는 마이페이지에서 내가 작성한 Q&A 글의 상세 내용을 조회하는 기능을 담당하는 서블릿
 * 내가 작성한 Q&A 글 목록을 보여주고, 선택한 글의 상세 내용을 확인할 수 있
 * 
 * doGet 메서드:
 * - 사용자의 Q&A 글 목록을 조회하고 화면에 출력
 * - BoardDAO를 사용하여 데이터베이스에서 Q&A 글 목록을 가져온
 */
@WebServlet("")
public class MyQnaDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		boardDTO dto=new boardDTO;
//		
//		dto.get
//		dao.getSeq(); //1
//		dao.getSub(); //제
//		dao.getCon();dxsssssß
//		
//		boardDTO result=dao.getmo(dto);
		

		
//		BoardDAO dao=new BoardDAO();
//		
//		BoardDTO dto=dao.getBoard();
//		
//		req.setAttribute("dto", dto);
//		
//		System.out.println(dto);
		
		
		
		ArrayList<BoardDTO> list=new ArrayList<BoardDTO>(); 
		
		BoardDAO dao=new BoardDAO();
	}
}
		
		