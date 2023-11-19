package com.project.jr.crt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.project.jr.crt.model.CrtLikeDTO;
import com.project.jr.crt.repository.CrtDAO;
/**
 * 자격증 좋아요 추가/삭제 처리 클래스
 */
@WebServlet("/crt/crtlikesubmit.do")
public class CrtLikeSubmit extends HttpServlet {
	/**
	 * 자격증 좋아요 추가/삭제 처리 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtLikeSubmit.java
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("id") == null) {
	         
	         resp.setContentType("text/html; charset=UTF-8");
	         
	         PrintWriter writer = resp.getWriter();
	         writer.print("<script>alert('로그인이 필요한 서비스입니다. 로그인 화면으로 이동합니다.');location.href='/jr/user/login.do';</script>");
	         return;
	    }
		
		//1.
		String crtseq = req.getParameter("crtseq");
		String agency = req.getParameter("agency");
		String crtctg = req.getParameter("crtctg");
		String crtname = req.getParameter("crtName");
		String fromlike = req.getParameter("fromlike");
		
		//2.
		CrtDAO dao = new CrtDAO();
		
		CrtLikeDTO dto = new CrtLikeDTO();
		dto.setCrtSeq(Integer.parseInt(crtseq));
		
		String id = (String)session.getAttribute("id");
		if (id != null) {
			dto.setId(id);
		}
		
		int result = dao.isliked(dto);
		int a = 0;
		
		if (result == 0) {
			result = dao.addliked(dto);
			a= dao.plusliked(dto);
		} else {
			result = dao.delliked(dto);
			a= dao.minusliked(dto);
		}
		
		
		//3.
		/*
		resp.setContentType("application/json");
		//결과에 한글이 포함되지않아 인코딩은 생략
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.write(obj.toString());
		writer.close();
		*/
		
		if (result == 1) {
			
			if (fromlike.equals("list")) {
				resp.sendRedirect("/jr/crt/crtlist.do");
			} else if (fromlike.equals("detail")) {
				resp.sendRedirect("/jr/crt/crtdetail.do?seq=" + crtseq);
			} else if (fromlike.equals("board")) {
				resp.sendRedirect("/jr/crt/crtboardlist.do?crtseq=" + crtseq + "&crtName=" + crtname + "&agency=" + agency + "&crtctg=" + crtctg);
			} else if (fromlike.equals("study")) {
				resp.sendRedirect("/jr/crt/crtlist.do?seq=" + crtseq);
			}
		} else {
			// 0 또는 에러
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('Like failed');history.back();</script>");
			writer.close();
		}

	}

}