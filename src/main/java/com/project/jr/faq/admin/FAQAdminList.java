package com.project.jr.faq.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.faq.repository.FAQAdminDAO;

/**
 * @author 이도훈
 * FAQ 목록을 조회하는 서블릿 클래스입니다.
 */
@WebServlet("/faq/admin/faqadminlist.do")
public class FAQAdminList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // FAQ 목록을 가져오기 위해 FAQ 관리 DAO 객체를 생성합니다.
        FAQAdminDAO dao = new FAQAdminDAO();

        // FAQ 목록을 조회합니다.
        ArrayList<FAQDTO> list = dao.list();

        // 조회된 FAQ 목록의 작성일자를 가공하여 다시 설정합니다.
        for (FAQDTO dto : list) {
            String regdate = dto.getFaqWriteDate();
            dto.setFaqWriteDate(regdate.substring(0, 10));
        }

        // 조회된 FAQ 목록을 request 속성에 설정합니다.
        req.setAttribute("list", list);

        // FAQ 목록 페이지로 이동합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadminlist.jsp");
        dispatcher.forward(req, resp);
    }
}
