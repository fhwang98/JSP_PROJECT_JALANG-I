package com.project.jr.forbidden.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

/**
 * @author 이도훈
 * 관리자 모듈에서 금지어 목록을 조회하는 서블릿 구현입니다.
 */
@WebServlet("/forbidden/admin/forbiddenadminlist.do")
public class ForbiddenAdminList extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP GET 요청을 처리합니다. 금지어 목록을 조회하고, 조회된 목록을 목록 페이지로 전달합니다.
     *
     * @param req  {@code HttpServletRequest} 객체입니다.
     * @param resp {@code HttpServletResponse} 객체입니다.
     * @throws ServletException 서블릿에서 오류가 발생한 경우입니다.
     * @throws IOException      I/O 작업이 실패한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
        ArrayList<ForbiddenAdminDTO> list = dao.list();

        req.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadminlist.jsp");
        dispatcher.forward(req, resp);
    }
}
