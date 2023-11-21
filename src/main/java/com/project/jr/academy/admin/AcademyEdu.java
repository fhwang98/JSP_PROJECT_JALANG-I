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
 * 관리자 학원 상세 페이지 - 학원 교육 목록 조회 요청을 받는 서블릿
 * @author eugene
 *
 */
@WebServlet("/academy/admin/academyedu.do")
public class AcademyEdu extends HttpServlet {

    /**
     * HTTP GET 요청에 대한 처리를 담당하는 메서드입니다.
     * @param req HttpServletRequest 객체
     * @param resp HttpServletResponse 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException IO 예외
     * @author 이슬아
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // AcademyEdu.java
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