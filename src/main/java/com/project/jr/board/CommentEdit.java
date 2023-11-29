package com.project.jr.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.project.jr.board.repository.BoardDAO;
import com.project.jr.forbidden.repository.ForbiddenDAO;

@WebServlet("/board/commentedit.do")
public class CommentEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CommentEdit.java
		
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JSONObject obj = new JSONObject();
		PrintWriter writer = resp.getWriter();
		
		
		// 금지어 검사
		ForbiddenDAO fdao = new ForbiddenDAO();
		ArrayList<String> flist = fdao.list();
		for (String word : flist) {
			if (content.contains(word)) {
				obj.put("result", 0);
				obj.put("word", word);

				writer.write(obj.toString());
				writer.close();
				return;
			}
		}
		
		
		BoardDAO dao = new BoardDAO();
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("seq", seq);
		map.put("content", content);
		int result = dao.editComment(map);

		
		obj.put("result", result);
		
		writer.write(obj.toString());
		writer.close();

	}
}