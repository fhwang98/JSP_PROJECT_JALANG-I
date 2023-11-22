package com.project.jr.forbidden.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

/**
 * @author 이도훈
 * 관리자 모듈에서 금지어를 추가하는 서블릿 구현입니다.
 */
@WebServlet("/forbidden/admin/forbiddenadminadd.do")
public class ForbiddenAdminAdd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP GET 요청을 처리합니다. 요청을 금지어 추가 폼 페이지로 전달합니다.
     *
     * @param req  {@code HttpServletRequest} 객체입니다.
     * @param resp {@code HttpServletResponse} 객체입니다.
     * @throws ServletException 서블릿에서 오류가 발생한 경우입니다.
     * @throws IOException      I/O 작업이 실패한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadminadd.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * HTTP POST 요청을 처리합니다. 양식 데이터를 처리하여 금지어를 추가합니다.
     *
     * @param req  {@code HttpServletRequest} 객체입니다.
     * @param resp {@code HttpServletResponse} 객체입니다.
     * @throws ServletException 서블릿에서 오류가 발생한 경우입니다.
     * @throws IOException      I/O 작업이 실패한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String forbidden = req.getParameter("forbidden");

        ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
        ForbiddenAdminDTO dto = new ForbiddenAdminDTO();
        dto.setForbidden(forbidden);

        int result = dao.add(dto);

        if (result == 1) {
            resp.sendRedirect("/jr/forbidden/admin/forbiddenadminlist.do");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
    }
}
