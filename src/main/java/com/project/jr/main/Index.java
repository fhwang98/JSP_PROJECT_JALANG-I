package com.project.jr.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtDAO;

/**
 * 메인 화면 클래스
 * @author eugene
 *
 */
@WebServlet("/index.do")
public class Index extends HttpServlet {

	/**
	 * 메인 페이지 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//자격증 top 100
		CrtDAO cdao = new CrtDAO();
		ArrayList<CrtDTO> clist = cdao.getTop100();
		
		for (CrtDTO dto : clist) {
			if (dto.getTestRcStartDate() != null && !dto.getTestRcStartDate().equals("")) {
//				System.out.println(dto.getTestRcStartDate());
				dto.setTestRcStartDate(dto.getTestRcStartDate().substring(0, 10));
			} else {
				dto.setTestRcStartDate("공시예정");
			}
			
			if (dto.getTestStartDate() != null && !dto.getTestStartDate().equals("")) {
				dto.setTestStartDate(dto.getTestStartDate().substring(0, 10));
			} else {
				dto.setTestStartDate("공시예정");
			}
			
			if (dto.getRound() == null || dto.getRound().equals("")) {
				dto.setRound("공시예정");
			}
			
		}
		
		req.setAttribute("clist", clist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(req, resp);

	}	
	
}
