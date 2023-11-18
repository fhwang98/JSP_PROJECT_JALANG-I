package com.project.jr.study.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.study.model.StudyBookDTO;
import com.project.jr.study.repository.StudyDAO;

/**
 * 스터디 교재 리스트 출력 클래스
 * @author sujin
 *
 */
@WebServlet("/study/mypage/book/list.do")
public class BookList extends HttpServlet {

	/**
	 * 스터디 교재 리스트 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String id=req.getSession().getAttribute("id").toString();
		
		StudyDAO dao=new StudyDAO();
		
		ArrayList<StudyBookDTO> sbs=new ArrayList<StudyBookDTO>();
		
		sbs=dao.getInfo(id);
		
		
		
		Set<Integer> setS=new LinkedHashSet<Integer>();
		Set<String> setN=new LinkedHashSet<String>();
		Set<String> setI=new LinkedHashSet<String>();
		
		
		
		for(StudyBookDTO sb : sbs) {
			setS.add(sb.getBookSeq());
			setN.add(sb.getBookName());
			setI.add(sb.getBookImg());
		}
		
		ArrayList<StudyBookDTO> sbs2=new ArrayList<StudyBookDTO>();
		
//		for(int i=0; i<setSeq.size(); i++) {
//			StudyBookDTO dto2=new StudyBookDTO();
//			Iterator iterS=setSeq.iterator();
//			System.out.println();
//		}
		
		Iterator iterS=setS.iterator();
		Iterator iterN=setN.iterator();
		Iterator iterI=setI.iterator();
		while(iterS.hasNext()) {
			StudyBookDTO dto2=new StudyBookDTO();
			int seq=(int) iterS.next();
			
			int total=dao.totalCh(seq);
			int prog=dao.progCh(id,seq);
			
			int count=prog*100/total;
			System.out.println(count);
			dto2.setCount(count); 
			dto2.setBookSeq(seq);
			dto2.setBookName((String) iterN.next());
			dto2.setBookImg((String) iterI.next());
			sbs2.add(dto2);
		}
		
		req.setAttribute("list", sbs2);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/study/mypage/book/list.jsp");
		dispatcher.forward(req, resp);

	}

	


}
