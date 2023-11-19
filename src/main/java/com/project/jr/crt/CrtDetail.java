package com.project.jr.crt;

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

import com.project.jr.crt.model.CrtAcademyDTO;
import com.project.jr.crt.model.CrtBookLikeDescDTO;
import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.model.CrtFaqDTO;
import com.project.jr.crt.model.CrtPassRateDTO;
import com.project.jr.crt.model.CrtPayDTO;
import com.project.jr.crt.model.CrtSchDTO;
import com.project.jr.crt.model.CrtSchDdayDTO;
import com.project.jr.crt.repository.CrtDAO;
import com.project.jr.crt.repository.CrtSchDAO;
/**
 * 자격증조회 상세페이지 클래스
 */
@WebServlet("/crt/crtdetail.do")
public class CrtDetail extends HttpServlet {
	/**
	 * 자격증조회 상세페이지 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtDetail.java
		HttpSession session = req.getSession();
		
		
		String crtseq = req.getParameter("seq");
		
		CrtDAO dao = new CrtDAO();
		
		String id = (String)req.getSession().getAttribute("id");
		/*
		if (req.getSession().getAttribute("id") == null || req.getSession().getAttribute("id").equals("")) {
			id = 
		}
		*/
		System.out.println("CrtDetail id : " + id);
		
		ArrayList<CrtSchDdayDTO> daylist = dao.schddaylist(crtseq);
		CrtDTO dto = dao.list(crtseq, id);
		ArrayList<CrtFaqDTO> faqlist = dao.faqlist(crtseq);
		ArrayList<CrtBookLikeDescDTO> booklist = dao.booklist(crtseq);
		ArrayList<CrtPayDTO> paylist = dao.paylist(crtseq);
		CrtPassRateDTO cprdto = dao.passrate(crtseq);
		ArrayList<CrtAcademyDTO> academylist = dao.acamedylist(crtseq);
		
		CrtSchDAO schdao = new CrtSchDAO();
		ArrayList<CrtSchDTO> schlist = schdao.list(crtseq);
		System.out.println(crtseq);
		
		//데이터 가공
		//정기유무
		String isRoutineS;
		int isRoutine = dto.getIsRoutine();
		if (isRoutine == 1) {
			isRoutineS = "정기시험";
		} else {
			isRoutineS = "상시시험";
		}
		dto.setIsRoutineS(isRoutineS);
		
		//난이도
		String difficultyS ="";
		int difficulty = dto.getDifficulty();
		for (int i=1; i<=difficulty; i++) {
			difficultyS += "★";
		}
		dto.setDifficultyS(difficultyS);
		
		//누적 좋아요
		String likeCntS = dto.getLikeCnt()+"";
		likeCntS = likeCntS.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		dto.setLikeCntS(likeCntS);
		
		ArrayList<HashMap<String, String>> testdaylist = new ArrayList<>();
		//시험일 날짜 , 시험접수일이 100전~30일전인지 확인
		for (CrtSchDdayDTO schdto: daylist) {
			String testRcStartDate = schdto.getTestRcStartDate();
			schdto.setTestRcStartDate(testRcStartDate.substring(0, 10));
			
			if (schdto.getTestDday() <= 100 && schdto.getTestDday()>=30) {
				 HashMap<String, String> map = new HashMap<>();
	             map.put("schName", schdto.getCrtSchName());
	             map.put("year", schdto.getTestStartDate().substring(0, 4));
	             map.put("day", schdto.getTestStartDate().substring(0, 10));
	             map.put("crtsch", schdto.getCrtSchSeq()+"");
	             testdaylist.add(map);
			}
		}
		
		//faq 개행 처리
		for (CrtFaqDTO faqdto : faqlist) {
			String crtfaqcontent = faqdto.getCrtfaqcontent();
			crtfaqcontent = crtfaqcontent.replace("\r\n", "<br>");
			faqdto.setCrtfaqcontent(crtfaqcontent);
		}
		
		
		//응시료
		for (CrtPayDTO paydto : paylist) {
			String exampayS = paydto.getExampay()+"";
			exampayS = exampayS.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
			paydto.setExampayS(exampayS);
		}
		
		//학원 평점 및 날짜
		for (CrtAcademyDTO adto : academylist) {
			String academyStarS ="";
			int academyStar = adto.getAcademyStar();
			for (int i=1; i<=academyStar; i++) {
				academyStarS += "★";
			}
			adto.setAcademyStarS(academyStarS);
			
			String eduRcStartDate = adto.getEduRcStartDate();
			String eduRcEndDate = adto.getEduRcEndDate();
			String eduStartDate = adto.getEduStartDate();
			String eduEndDate = adto.getEduEndDate();
			
			adto.setEduRcStartDate(eduRcEndDate.substring(0, 10));
			adto.setEduRcEndDate(eduRcEndDate.substring(0, 10));
			adto.setEduStartDate(eduStartDate.substring(0, 10));
			adto.setEduEndDate(eduEndDate.substring(0, 10));
		}
		
		//합격률 계산
		HashMap<String, Integer> passmap = new HashMap<String, Integer>();
		int starteSum = cprdto.getStarein18()+cprdto.getStarein19()+cprdto.getStarein20()+cprdto.getStarein21()+cprdto.getStarein22();
		int passSum = cprdto.getPassin18()+cprdto.getPassin19()+cprdto.getPassin20()+cprdto.getPassin21()+cprdto.getPassin22();
		passmap.put("starteSum", starteSum);
		passmap.put("passSum", passSum);
		int passRate = 0; 
		passRate = (int)Math.round(((double)cprdto.getPassin18()/(double)cprdto.getStarein18())*100);
		passmap.put("passRate", passRate);
		//System.out.println((((double)passSum/(double)starteSum)*100));
		
		System.out.println(passRate);
		
		
		//3.
		session.setAttribute("crtname", dto.getCrtName());
		
		req.setAttribute("crtseq", crtseq);
		req.setAttribute("dto", dto);
		req.setAttribute("daylist", daylist);
		req.setAttribute("faqlist", faqlist);
		req.setAttribute("booklist", booklist);
		req.setAttribute("paylist", paylist);
		req.setAttribute("cprdto", cprdto);
		req.setAttribute("academylist", academylist);
		req.setAttribute("testdaylist", testdaylist);
		
		String fromlike = "detail";
		req.setAttribute("fromlike", fromlike);
		
		req.setAttribute("schlist", schlist);
		req.setAttribute("passmap", passmap);
		
		String studyok = "y";
		req.setAttribute("studyok", studyok);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtdetail.jsp");
		dispatcher.forward(req, resp);

	}

}