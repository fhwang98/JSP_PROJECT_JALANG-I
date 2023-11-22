package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.repository.CrtAdminDAO;

/**
 * Servlet implementation class CrtAdminDel
 * @author 이도훈
 * 이 서블릿은 관리자가 자격증(CRT)을 삭제하는 기능을 처리합니다.
 */
@WebServlet("/crt/admin/crtadmindel.do")
public class CrtAdminDel extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *
     * 
     * GET 요청을 처리합니다. 요청된 자격증(CRT)의 시퀀스를 받아와서 "crtadmindel.jsp" 뷰로 전달합니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String crtSeq = req.getParameter("crtSeq");
        
        req.setAttribute("crtSeq", crtSeq);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadmindel.jsp");

        dispatcher.forward(req, resp);
    }
    
    /**
     *
     * 
     * POST 요청을 처리합니다. 받아온 자격증(CRT)의 시퀀스를 사용하여 자격증을 삭제합니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        
        String crtSeq = req.getParameter("crtSeq");
        
        CrtAdminDAO dao = new CrtAdminDAO();
        
        int result = dao.del(crtSeq);
        
        // 삭제 결과에 따라 리다이렉트 또는 경고창 출력
        if (result == 1) {
            resp.sendRedirect("/jr/crt/admin/crtadminlist.do");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
    }
}
