package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtAdminDetail
 *@author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 Certificate (CRT)의 세부 정보를 표시하는 요청을 처리합니다.
 * CrtAdminDAO를 사용하여 CRT 세부 정보를 검색하고 요청을 적절한 JSP 페이지로 전달합니다.
 * CRT 세부 정보는 JSP 페이지에서 액세스할 수 있도록 요청 속성으로 설정됩니다.
 */
@WebServlet("/crt/admin/crtadmindetail.do")
public class CrtAdminDetail extends HttpServlet {

    /**
     * GET 요청을 처리하여 관리자 인터페이스에서 Certificate (CRT)의 세부 정보를 표시합니다.
     * 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청에서 CRT 시퀀스 매개변수를 검색합니다.
        String crtSeq = req.getParameter("crtSeq");

        // 데이터베이스와 상호 작용하기 위해 CrtAdminDAO의 인스턴스를 생성합니다.
        CrtAdminDAO dao = new CrtAdminDAO();

        // CRT 시퀀스를 사용하여 CRT 세부 정보를 검색합니다.
        CrtDTO dto = dao.detail(crtSeq);

        // JSP 페이지에서 CRT 세부 정보에 액세스할 수 있도록 요청 속성으로 CRT 세부 정보를 설정합니다.
        req.setAttribute("dto", dto);

        // 요청을 CRT 관리자 세부 정보 JSP 페이지로 전달합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadmindetail.jsp");
        dispatcher.forward(req, resp);
    }
}
