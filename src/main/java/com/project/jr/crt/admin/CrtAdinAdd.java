package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtAdminDAO;

/**
 * Servlet implementation class CrtAdinAdd
 * @author 이도훈
 * 이 서블릿은 관리자가 새 자격증(CRT)을 추가하는 기능을 처리합니다.
 */
@WebServlet("/crt/admin/crtadminadd.do")
public class CrtAdinAdd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *
     * 
     * GET 요청을 처리합니다. 요청을 "crtadminadd.jsp" 뷰로 전달합니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadminadd.jsp");

        dispatcher.forward(req, resp);
    }

    /**
     *
     * 
     * POST 요청을 처리합니다. 관리자가 새 자격증(CRT)을 추가하는 양식 제출을 처리합니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        // 양식 매개변수를 가져옵니다.
        String crtName = req.getParameter("crtName");
        String crtTypeSeq = req.getParameter("crtTypeSeq");
        String expiration = req.getParameter("expiration");
        String agencySeq = req.getParameter("agencySeq");
        String isRoutine = req.getParameter("isRoutine");
        String difficulty = req.getParameter("difficulty");
        String likeCnt = req.getParameter("likeCnt");
        String qualificationCate = req.getParameter("qualificationCate");
        String qualification = req.getParameter("qualification");
        String crtInfo = req.getParameter("crtInfo");
        String totalCnt = req.getParameter("totalCnt");
        String jobDesc = req.getParameter("jobDesc");

        // 자격증 관리용 데이터 액세스 객체 (DAO)를 생성합니다.
        CrtAdminDAO dao = new CrtAdminDAO();

        // 자격증 정보를 저장할 데이터 전송 객체 (DTO)를 생성합니다.
        CrtDTO dto = new CrtDTO();

        // DTO에 값을 설정합니다.
        dto.setCrtName(crtName);
        dto.setCrtTypeSeq(Integer.parseInt(crtTypeSeq));
        dto.setExpiration(expiration);
        dto.setAgencySeq(Integer.parseInt(agencySeq));
        dto.setIsRoutine(Integer.parseInt(isRoutine));
        dto.setDifficulty(Integer.parseInt(difficulty));
        dto.setLikeCnt(Integer.parseInt(likeCnt));
        dto.setQualificationCate(qualificationCate);
        dto.setQualification(qualification);
        dto.setCrtInfo(crtInfo);
        dto.setTotalCnt(Integer.parseInt(totalCnt));
        dto.setJobDesc(jobDesc);

        // DAO를 사용하여 새 자격증을 추가합니다.
        int result = dao.add(dto);

        // 추가 결과에 따라 리다이렉트합니다.
        if (result == 1) {
            resp.sendRedirect("/jr/crt/admin/crtadminlist.do");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
    }

}
