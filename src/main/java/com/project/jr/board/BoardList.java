package com.project.jr.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;

@WebServlet("/board/boardlist.do")
public class BoardList extends HttpServlet {

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
		
		
		
		
		
		
//		HttpSession session = req.getSession();
//		
//	  
//	    session.setAttribute("read", "0");


HashMap<String,String> map = new HashMap<String,String>();
		
		int nowPage =0;
		   int totalCount = dao.getTotalCount(); // 총 게시물의 개수
		   int pageSize =10;
		   int totalPage = (int)Math.ceil((double)totalCount / pageSize); // 총 페이지 개수
		   int begin =0;
		   int end =0;
		   int n = 0;
		   int loop = 0;
		   int blockSize = 10;
		   
		   
		   
		   String page = req.getParameter("page");
		   
		   if(page==null || page.equals("")) {
		      nowPage =1;
		   }else {
		      nowPage = Integer.parseInt(page);
		   }
		   
		   begin =((nowPage -1)* pageSize)+1;
		   end = begin + pageSize -1;
		      
		   
		   
		   
		   map.put("begin", begin+ "");
		   map.put("end", end+"");
		   
		   list=dao.getList(map);
			
		   
		   for (BoardDTO b : list) {
			   b.setBoardWriteDate(b.getBoardWriteDate().substring(0, 10));
			   
			   if (b.getBoardTitle().length() > 20) {
				   b.setBoardTitle(b.getBoardTitle().substring(0, 20) + "...");
			   }
		   }
		   
			req.setAttribute("list", list);
			
//			
		   
		   HttpSession session = req.getSession();
		   
		   session.setAttribute("read", "n");
		
		
			StringBuilder sb = new StringBuilder();
			
			
			loop = 1;	//루프 변수(10바
			//n = 1;		//출력할 페이지 번호
			n = ((nowPage - 1) / blockSize) * blockSize + 1;
			
			
			//이전 10페이지
			if (n == 1) {
				sb.append(" <a href='#!'>[이전]</a>");
			} else {
				sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d'>[이전]</a>", n - 1));			
			}
			
			
			while (!(loop > blockSize || n > totalPage)) {
				
				if (n == nowPage) {
					sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
				} else {
					sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d'>%d</a>", n, n));
				}
				loop++;
				n++;
				
			}
			
			//다음 10페이지
			if (n > totalPage) {
				sb.append(" <a href='#!'>[다음]</a>");
			} else {
				sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d'>[다음]</a>", n));			
			}
			
			
			req.setAttribute("totalCount", totalCount);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("nowPage", nowPage);
			
			
			req.setAttribute("pageBar", sb.toString());
			
			
			req.setAttribute("map", map);
	    
		

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boardlist.jsp");
		dispatcher.forward(req, resp);
		
		
		
		

	}

}



