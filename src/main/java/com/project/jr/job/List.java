package com.project.jr.job;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.job.model.GroupDTO;
import com.project.jr.job.model.JobDTO;
import com.project.jr.job.repository.JobDAO;

/**
 * 직업 리스트 출력 클래스
 * @author sujin
 *
 */
@WebServlet("/job/list.do")
public class List extends HttpServlet {

	/**
	 * 직업 리스트 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String jobgroupSeq=req.getParameter("seq");
		int seq=0;
		
		String jobName=req.getParameter("jobName");
		String searchN="n";
		String searchG="n";
		
		
		System.out.println(jobName + " " + jobgroupSeq);
		
		if (jobName == null || jobName.equals("")) {
			jobName = "";
		}else { 
			searchN="y";
		}
		if (jobgroupSeq == null || jobgroupSeq.equals("default")) {
			seq=0;
		} else {
			seq=Integer.parseInt(jobgroupSeq);
			searchG="y";
		}
		
		//System.out.println(jobName + " " + seq);
		
		
//		if(jobName.isEmpty()) {
//			jobName="";
//		}
		
		//System.out.println(jobName);
		
		JobDAO dao=new JobDAO();
		
		//직업군 목록 호출
		
		ArrayList<GroupDTO> gList=dao.getGroup();
		
		req.setAttribute("gList", gList);
		
		
		//직업 호출
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물수
		int pageSize = 10; // 한페이지에서 출력할 게시물 수
		int totalPage = 0; // 총 페이지수
		int begin = 0; // 페이징 시작 위치
		int end = 0; // 페이지 끝 위치
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
		
		ArrayList<JobDTO> jList=dao.getJobList(begin, end, seq, jobName, searchN, searchG);
		
		totalCount=dao.getTotalCount(seq, jobName, searchN, searchG);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		
		StringBuilder sb = new StringBuilder();
		
		loop = 1; // 루프 변수(10바퀴)
		// n=1; //출력 페이지 번호
		n = ((nowPage - 1) / blockSize) * blockSize + 1;

		// 이전 10페이지
		if (n == 1) {
			sb.append(String.format("<a href='#!'>[이전]</a>"));
		} else {
			sb.append(String.format("<a href='/jr/job/list.do?page=%d'>[이전]</a>", n - 1));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a> ", n));
			} else {
				String add="";
				if(searchN.equals("y") && searchG.equals("y")) {
					add=String.format("&jobName=%s&seq=%s"
										, jobName, jobgroupSeq);
				}else if(searchN.equals("n") && searchG.equals("y")) {
					add=String.format("&seq=%s"
										, jobgroupSeq);
				}else if(searchN.equals("y") && searchG.equals("n")) {
					add=String.format("&jobName=%s&seq=%s"
										, jobName, "default");
				}
				
				sb.append(String.format(" <a href='/jr/job/list.do?page=%d%s'>%d</a> ", n, add, n));
				//System.out.println(sb);
			}

			loop++;
			n++;
		}

		// 다음 10페이지
		if (n > totalPage) {
			sb.append(String.format("<a href='#!'>[다음]</a>"));
		} else {
			sb.append(String.format("<a href='/jr/job/list.do?page=%d'>[다음]</a>", n));
		}

		// 2.
		req.setAttribute("list", jList);

		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);

		req.setAttribute("pagebar", sb.toString());
		
		req.setAttribute("searchG", searchG);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/job/list.jsp");
		dispatcher.forward(req, resp);

	}

}
