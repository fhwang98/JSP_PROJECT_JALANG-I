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
		
		