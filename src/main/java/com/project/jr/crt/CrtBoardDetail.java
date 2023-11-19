package com.project.jr.crt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.model.CrtBoardDTO;
import com.project.jr.crt.repository.CrtBoardDAO;
/**
 * 자격증 후기게시판 상세보기 클래스
 *
 */
@WebServlet("/crt/crtboarddetail.do")
public class CrtBoardDetail extends HttpServlet {
	/**
	 * 자격증 후기게시판 상세보기 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		
		//1.
		String crtboardseq = req.getParameter("crtboardseq");
		String crtname = req.getParameter("crtname");
		String crtseq = req.getParameter("crtseq");
		System.out.println("CrtBoardDetail crtboardseq: " + crtboardseq + " crtname: "+ crtname + " crtseq"+ crtseq);
		
		//2.
		CrtBoardDAO dao = new CrtBoardDAO();
		
		// 조회 수 증가
		if (session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {
			dao.updateReadcount(crtboardseq);
			session.setAttribute("read", "y");
		}
		

		CrtBoardDTO dto = dao.get(crtboardseq);
		
		// 2.5 데이터 가공
		String crtBoardContent = dto.getCrtBoardContent();
		// 사용자가 태그를 입력했을 때 비활성화 처리
		// <> 태그를 &lt;div&gt; 로 바꿔주기
		crtBoardContent = crtBoardContent.replace("<", "&lt;").replace(">", "&gt");

		String crtboardtitle = dto.getCrtBoardTitle();
				crtboardtitle = crtboardtitle.replace("<", "&lt;").replace(">", "&gt");

		// 개행 문자 처리
		crtBoardContent = crtBoardContent.replace("\r\n", "<br>");

		dto.setCrtBoardContent(crtBoardContent);
		dto.setCrtBoardTitle(crtboardtitle);
		
		
		req.setAttribute("dto", dto);
		req.setAttribute("crtboardseq", crtboardseq);
		req.setAttribute("crtname", crtname);
		req.setAttribute("crtseq", crtseq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtboarddetail.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
		
	}
}