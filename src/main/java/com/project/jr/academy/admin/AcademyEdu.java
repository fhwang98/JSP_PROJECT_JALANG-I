package com.project.jr.academy.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.jr.academy.model.AcademyEduDTO;
import com.project.jr.academy.repository.AcademyDAO;

/**
 * 학원 정보 내의 교육 정보 요청 서블릿 
 * @author eugene
 *
 */
@WebServlet("/academy/admin/academyedu.do")
public class AcademyEdu extends HttpServlet {

	/**
	 * 학원 내의 교육 정보를 ajax에 반환하는 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//AcademyEdu.java
		String seq = req.getParameter("seq");
		AcademyDAO dao = new AcademyDAO();
		ArrayList<AcademyEduDTO> edulist = dao.getEduList(seq);
		
		JSONArray arr = new JSONArray();
		
		for (AcademyEduDTO edu : edulist) {
			edu.setEduRcStartDate(edu.getEduRcStartDate().substring(0, 10));
			edu.setEduRcEndDate(edu.getEduRcEndDate().substring(0, 10));
			edu.setEduStartDate(edu.getEduStartDate().substring(0, 10));
			edu.setEduEndDate(edu.getEduEndDate().substring(0, 10));
			
			
			JSONObject obj = new JSONObject();
			
			obj.put("eduName", edu.getEduName());
			obj.put("crtName", edu.getCrtName());
			obj.put("eduLink", edu.getEduLink());
			obj.put("eduRcStartDate", edu.getEduRcStartDate());
			obj.put("eduRcEndDate", edu.getEduRcEndDate());
			obj.put("eduStartDate", edu.getEduStartDate());
			obj.put("eduEndDate", edu.getEduEndDate());
			
			arr.add(obj);
			
		}
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(arr.toString());
		writer.close();

	}
}