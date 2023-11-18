package com.project.jr.crt.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.MyCrtDTO;
import com.project.jr.crt.repository.CrtDAO;

/**
 * 나의자격증 리스트 출력 클래스
 *
 */
@WebServlet("/crt/mypage/list.do")
public class List extends HttpServlet {

	/**
	 * 나의자격증 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String id=req.getSession().getAttribute("id").toString();
		String name=req.getSession().getAttribute("name").toString();
		
		req.setAttribute("name", name);
		
		CrtDAO dao=new CrtDAO();
		
		int count=dao.getCount(id);
		ArrayList<MyCrtDTO> list=dao.getMyCrt(id);
		
		//System.out.println(list.toString());
		
		
		for(MyCrtDTO dto : list) {
			dto.setGetDate(dto.getGetDate().substring(0,11));
		}
		
		
		req.setAttribute("list", list);
		req.setAttribute("count", count);
		
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/mypage/list.jsp");
		dispatcher.forward(req, resp);

	}

}
