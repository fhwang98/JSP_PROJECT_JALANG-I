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


/**
 * 
 * @author oseunghyeon
 * MyQnaList 클래스는 마이페이지에서 내가 작성한 Q&A 목록을 조회하는 기능을 담당하는 서블릿
 * 내가 작성한 Q&A 글 목록을 화면에 출력
 * 
 * doGet 메서드:
 * - 사용자의 ID를 통해 내가 작성한 Q&A 글 목록을 조회
 * - QnaDAO를 사용하여 데이터베이스에서 내가 작성한 Q&A 글 목록을 가져온다.
 * - 조회된 목록을 req에 저장하고, 화면으로 포워딩
 */
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
