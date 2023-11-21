package com.project.jr.academy;

import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.repository.AcademyDAO;

/**
 * 학원 목록 조회 페이지 서블릿 
 * @author eugene
 *
 */
@WebServlet("/academy/academylist.do")
public class Academy extends HttpServlet {

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

        // 검색
        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n";  // 검색중("y") 목록보기("n")

        if ((word == null) || (word.equals(""))) {
            search = "n";
        } else {
            search = "y";
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("word", word);
        map.put("search", search);
        map.put("column", column);

        // 페이징
        int nowPage = 0;
        int totalCount = 0;
        int pageSize = 10;
        int totalPage = 0;
        int begin = 0;
        int end = 0;
        int loop = 0;
        int blockSize = 10;

        String page = req.getParameter("page");

        if (page == null || page.equals("")) {
            nowPage = 1;
        } else {
            nowPage = Integer.parseInt(page);
        }

        begin = ((nowPage - 1) * pageSize) + 1;
        end = begin + pageSize - 1;

        map.put("begin", begin + "");
        map.put("end", end + "");

        HttpSession session = req.getSession();

        session.setAttribute("read", "n");

        // 목록조회
        AcademyDAO dao = new AcademyDAO();

        ArrayList<AcademyDTO> list = dao.list(map);

        // 날짜 포맷 변경
        for (AcademyDTO a : list) {
            a.setEduRcStartDate(a.getEduRcStartDate().substring(0, 11));
            a.setEduRcEndDate(a.getEduRcEndDate().substring(0, 11));
            a.setEduStartDate(a.getEduStartDate().substring(0, 11));
            a.setEduEndDate(a.getEduEndDate().substring(0, 11));
        }

        // 별표
        for (AcademyDTO dto : list) {
            int academyStar = dto.getAcademyStar();
            StringBuilder academyStarS = new StringBuilder();
            for (int i = 1; i <= academyStar; i++) {
                academyStarS.append("★");
            }
            dto.setAcademyStarS(academyStarS.toString());
        }

        // 총게시물 수
        totalCount = dao.getTotalCount();
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 페이지 바 계산하기
        StringBuilder sb = new StringBuilder();

        // 이전,다음 버튼
        loop = 1;
        int n = ((nowPage - 1) / blockSize) * blockSize + 1;

        // 이전
        if (n == 1) {
            sb.append("<a href='#!'>[이전페이지]</a>");
        } else {
            sb.append(String.format("<a href='/jr/academy/academylist.do?page=%d'>[이전페이지]</a>", n - 1));
        }

        while (!(loop > blockSize || n > totalPage)) {
            if (n == nowPage) {
                sb.append(String.format("<a href='#!' style='color:tomato; font-weight:bold;'>%d</a> ", n));
            } else {
                sb.append(String.format("<a href='/jr/academy/academylist.do?page=%d'>%d</a>", n, n));
            }
            loop++;
            n++;
        }

        // 다음
        if (n > totalPage) {
            sb.append("<a href='#!'>[다음페이지]</a>");
        } else {
            sb.append(String.format("<a href='/jr/academy/academylist.do?page=%d'>[다음페이지]</a>", n));
        }

        req.setAttribute("list", list);
        req.setAttribute("map", map);

        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);

        req.setAttribute("pagebar", sb.toString());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/academy/academylist.jsp");
        dispatcher.forward(req, resp);
    }
}