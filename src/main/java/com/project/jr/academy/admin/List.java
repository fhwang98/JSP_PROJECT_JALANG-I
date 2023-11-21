package com.project.jr.academy.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.repository.AcademyDAO;

/**
 * List 서블릿은 학원 목록을 조회하고 페이징 처리를 담당하는 클래스입니다.
 * @author 이슬아
 */
@WebServlet("/academy/admin/list.do")
public class List extends HttpServlet {

	/**
	 * 관리자 학원 목록 페이지 doGet
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // List.java
        AcademyDAO dao = new AcademyDAO();

        HashMap<String, String> map = new HashMap<String, String>();

        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n"; // 검색중("y") 목록보기("n")

        if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
            search = "n";
        } else {
            search = "y";
        }
        map.put("column", column);
        map.put("word", word);
        map.put("search", search);

        // 페이징
        int nowPage = 0; // 현재 페이지 번호
        int totalCount = dao.getTotalCount(map); // 총 게시물 수
        // 검색어가 있는데 totalcount가 0일 때 검색 결과가 없다고 표시
        int pageSize = 10; // 한 페이지에서 출력할 게시물 수
        int totalPage = (int) Math.ceil((double) totalCount / pageSize); // 총 페이지 수
        int begin = 0; // 페이징 시작 위치
        int end = 0; // 페이징 끝 위치
        int n = 0;
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

        ArrayList<AcademyDTO> list = dao.getAdminList(map);

        // 페이지 바
        StringBuilder sb = new StringBuilder();

        // list.do?page=1 ~ 10
        // [이전] 1 2 3 4 5 6 7 8 9 10 [다음]
        // list.do?page=11 ~ 20
        // [이전] 11 12 13 14 15 16 17 18 19 20 [다음]

        loop = 1; // 루프 변수(10바
        // n = 1; //출력할 페이지 번호
        n = ((nowPage - 1) / blockSize) * blockSize + 1;

        // 이전 10페이지
        if (n == 1) {
            sb.append(" <a href='#!'>[이전]</a>");
        } else {
            sb.append(String.format(" <a href='/jr/academy/admin/list.do?page=%d'>[이전]</a>", n - 1));
        }

        while (!(loop > blockSize || n > totalPage)) {

            if (n == nowPage) {
                sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
            } else {
                sb.append(String.format(" <a href='/jr/academy/admin/list.do?page=%d'>%d</a>", n, n));
            }
            loop++;
            n++;

        }

        // 다음 10페이지
        if (n > totalPage) {
            sb.append(" <a href='#!'>[다음]</a>");
        } else {
            sb.append(String.format(" <a href='/jr/academy/admin/list.do?page=%d'>[다음]</a>", n));
        }

        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);

        req.setAttribute("pageBar", sb.toString());

        req.setAttribute("list", list);
        req.setAttribute("map", map);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/academy/admin/list.jsp");
        dispatcher.forward(req, resp);
    }
}