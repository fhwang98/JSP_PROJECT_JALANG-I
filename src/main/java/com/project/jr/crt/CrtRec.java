package com.project.jr.crt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtRecDTO;
import com.project.jr.crt.repository.CrtRecDAO;
/**
 * 직업군별 추천 자격증 조회 클래스
 */
@WebServlet("/crt/crtrec.do")
public class CrtRec extends HttpServlet {
	/**
	 * 직업군별 추천 자격증 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtRec.java
		
		CrtRecDAO dao = new CrtRecDAO();
		
		ArrayList<CrtRecDTO> jobGroupList = dao.jobgruoplist();
		
		
		
		for (CrtRecDTO dto : jobGroupList) {
			ArrayList<CrtRecDTO> list = dao.jobgruopSublist(dto.getJobgroupseq());
			for (CrtRecDTO crdto : list) {
				String crtName = crdto.getCrtname();
				if (crtName.indexOf("(")> 0) {
					crdto.setCrtname(crtName.substring(0, crtName.indexOf("(")));
					//System.out.println(crtName);
				}
			}
			dto.setList(list);
		}
		
		
		req.setAttribute("jobGroupList", jobGroupList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtrec.jsp");
		dispatcher.forward(req, resp);

	}

}