//package com.project.jr.academy;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.project.jr.academy.model.AcademyDTO;
//import com.project.jr.academy.repository.AcademyDAO;
//
//@WebServlet("/academy/academydetail.do")
//public class Academydetail extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String seq = req.getParameter("seq");
//
//        AcademyDAO dao = new AcademyDAO();
//
//        AcademyDTO academyDTO = dao.academyinfo(seq);
//
//        req.setAttribute("academyDTO", academyDTO);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/academy/academydetail.jsp");
//        dispatcher.forward(req, resp);
//    }
//}
