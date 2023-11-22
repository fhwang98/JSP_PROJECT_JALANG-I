package com.project.jr.forbidden.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

/**
 * @author 이도훈
 * 관리자 모듈에서 금지어를 삭제하는 서블릿 구현입니다.
 */
@WebServlet("/forbidden/admin/forbiddenadmindel.do")
public class ForbiddenAdminDel extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP GET 요청을 처리합니다. 요청을 금지어 삭제 폼 페이지로 전달합니다.
     *
     * @param req  {@code HttpServletRequest} 객체입니다.
     * @param resp {@code HttpServletResponse} 객체입니다.
     * @throws ServletException 서블릿에서 오류가 발생한 경우입니다.
     * @throws IOException      I/O 작업이 실패한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forbiddenSeq = req.getParameter("forbiddenSeq");
        req.setAttribute("forbiddenSeq", forbiddenSeq);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadmindel.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * HTTP POST 요청을 처리합니다. 금지어를 삭제합니다.
     *
     * @param req  {@code HttpServletRequest} 객체입니다.
     * @param resp {@code HttpServletResponse} 객체입니다.
     * @throws ServletException 서블릿에서 오류가 발생한 경우입니다.
     * @throws IOException      I/O 작업이 실패한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String forbiddenSeq = req.getParameter("forbiddenSeq");

        ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
        int result = dao.del(forbiddenSeq);

        if (result == 1) {
            resp.sendRedirect("/jr/forbidden/admin/forbiddenadminlist.do");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('실패');history.back();</script>");
            writer.close();
        }
    }
}
