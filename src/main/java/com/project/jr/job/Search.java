package com.project.jr.job;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.project.jr.job.repository.JobDAO;

/**
 * 직업 검색 autocomlet 클래스
 *
 */
@WebServlet("/job/search.do")
public class Search extends HttpServlet {
	
	/**
	 * 직업 검색 autocomlete JSON 출력 doGet 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String searchWord = req.getParameter("jobName");
		//String searchWord = "관리";
		String jobgroupName = req.getParameter("jobgroupName");
		
		int jobGroupSeq=0;
		
		
		
		if(!jobgroupName.equals("default")) {
			jobGroupSeq=Integer.parseInt(jobgroupName);
		}
		
		System.out.println(searchWord+" "+jobgroupName+ " "+ jobGroupSeq);
		
		JobDAO dao=new JobDAO();
		
		ArrayList<String> list=dao.search(searchWord, jobGroupSeq);
		
		JSONArray arr=new JSONArray();
		
		for(String s : list) {
			
			arr.add(s);
		}
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer=resp.getWriter();
		
		writer.print(arr.toString());
		
		writer.close();
		
		
		
	}

}
