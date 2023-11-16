package com.project.jr.crt.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.crt.repository.CrtTestDAO;

@WebServlet("/crt/admin/crttestadminlist.do")
public class CrtTestAdminList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HashMap<String,String> map = new HashMap<String,String>();
		
		//페이징
		int nowPage = 0;
		int totalCount = 0; //총 게시물 수
		int pageSize = 30;
		int totalPage = 0;
		int begin = 0;
		int end = 0;
		int n = 0;
		int loop = 0;
		int blockSize = 10;
				
		String page = req.getParameter("page");		
				
		if (page == null || page.equals("")) {		
			nowPage = 1;	
		} else {		
			nowPage = Integer.parseInt(page);	
		}																										

																																		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;


		map.put("begin", begin + "");
		map.put("end", end + "");

		CrtTestDAO dao =  new CrtTestDAO();
		
		ArrayList<CrtTestDTO> list = dao.list(map);
		
		//총 게시물 수		
		totalCount = dao.getTotalCount();		
						
		totalPage = (int)Math.ceil((double)totalCount / pageSize);		
						
						
		StringBuilder sb = new StringBuilder();		
						
		loop = 1; //루프 변수(10바퀴)		
		n = ((nowPage - 1) / blockSize) * blockSize + 1;		
						
		//이전 10페이지		
		if (n == 1) {		
			sb.append(String.format("<a href='#!'>[이전] </a>", blockSize));	
		} else {		
			sb.append(String.format("<a href='/jr/crt/admin/crttestadminlist.do?page=%d'>[이전] </a>", n - 1, blockSize));	
		}		
				
				
		while (!(loop > blockSize || n > totalPage)) {		
					
			if (n == nowPage) {	
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
			} else {	
				sb.append(String.format(" <a href='/jr/crt/admin/crttestadminlist.do?page=%d'>%d</a>", n, n));
			}	
						
			loop++;	
			n++;	
		}		
				
		//다음 10페이지		
		if (n > totalPage) {		
			sb.append(String.format("<a href='#!'> [다음]</a>", blockSize));	
		} else {		
			sb.append(String.format("<a href='/jr/crt/admin/crttestadminlist.do?page=%d'> [다음]</a>", n, blockSize));	
		}
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);		
		
		req.setAttribute("totalCount", totalCount);		
		req.setAttribute("totalPage", totalPage);		
		req.setAttribute("nowPage", nowPage);		
				
		req.setAttribute("pagebar", sb.toString());		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadminlist.jsp");

		dispatcher.forward(req, resp);
	}
}
