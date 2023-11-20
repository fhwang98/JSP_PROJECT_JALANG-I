package com.project.jr.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.model.NoticeBoardDTO;
import com.project.jr.board.repository.BoardDAO;
import com.project.jr.book.repository.BookDAO;
import com.project.jr.crt.repository.CrtDAO;
import com.project.jr.qna.model.QnaDTO;
import com.project.jr.qna.repository.QnaDAO;
import com.project.jr.user.repository.UserDAO;

/**
 * 관리자 메인 페이지 서블릿
 * @author eugene
 *
 */
@WebServlet("/admin/home.do")
public class Home extends HttpServlet {

	/**
	 * 관리자 메인 페이지를 출력하는 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Home.java

		
		// 넘길 데이터 Hash Map
		// 꺼낼때 ${map.submap.key}
		//HashMap<String, HashMap> map = new HashMap<String, HashMap>();
		
		//접근할 데이터
		//CrtDAO
		//CrtDTO (자격증명, 좋아요수, 등록수)
		// 좋아요순 top3
		CrtDAO cdao = new CrtDAO();
		ArrayList<HashMap<String, String>> crtlist = cdao.getLikeTop();
		req.setAttribute("crtlist", crtlist);
		
		//BookDAO
		//BookDTO
		BookDAO bookdao = new BookDAO(); 
		//제목, like수
		ArrayList<HashMap<String, String>> booklist = bookdao.getLikeTop();
		req.setAttribute("booklist", booklist);
		
		
		// UserDAO
		// (전체 회원수, 신규 가입회원수, 탈퇴 회원수)
		UserDAO udao = new UserDAO();
		HashMap<String, Integer> userCnt = udao.count();
		req.setAttribute("userCnt", userCnt);
		
		//QnaDAO
		QnaDAO qdao = new QnaDAO();
		ArrayList<QnaDTO> qlist = qdao.getRecentQna();
		for (QnaDTO q : qlist) {
			q.setQnaWriteDate(q.getQnaWriteDate().substring(0, 10));
		}
		req.setAttribute("qlist", qlist);
		
		// BoardDAO
		// BoardDTO 게시판 (seq(링크로 넘길것), id, 제목, 좋아요, 등록일, 조회수, 신고수, 공개여부)
		BoardDAO bdao = new BoardDAO();
		ArrayList<BoardDTO> reportList = bdao.getRecentReportList();
		for (BoardDTO b : reportList) {
			b.setBoardWriteDate(b.getBoardWriteDate().substring(0, 10));
		}
		req.setAttribute("reportList", reportList);
		
		// NoticeBoardDTO 공지사항 (seq, 제목, 내용)
		ArrayList<NoticeBoardDTO> noticeList = bdao.getRecentNoticeList();
		for (NoticeBoardDTO n : noticeList) {
			if (n.getNoticeBoardContent().length() > 50) {
				n.setNoticeBoardContent(n.getNoticeBoardContent().substring(0, 50) + "...");
			}
		}
		
		
		req.setAttribute("noticeList", noticeList);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/home.jsp");
		dispatcher.forward(req, resp);
	}
}