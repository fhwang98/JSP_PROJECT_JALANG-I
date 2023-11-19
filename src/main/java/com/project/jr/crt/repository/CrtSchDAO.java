package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.crt.model.CrtSchDTO;
import com.project.jr.main.DBUtil;

public class CrtSchDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CrtSchDAO() {
		this.conn = DBUtil.open();
	}
	
	/**
	 * 자격증 일정 조회 JDBC
	 * @param map
	 * @return
	 */
	public ArrayList<CrtSchDTO> list(HashMap<String, String> map) {
		
		try {
			String where = "";
			
			if (map.get("search").equals("y")) {
				
				if ((map.get("word") != null) || !(map.get("word").equals(""))) {
					where = String.format("where crtName like '%%%s%%'", map.get("word"));
				}
			}
				

			String rcstart = map.get("hiddenRcStartDate");
			String rcend = map.get("hiddenRcEndDate");
			String start = map.get("hiddenStartDate");
			String end = map.get("hiddenEndDate");
			
			
			if ((map.get("hiddenRcStartDate") != null) && !(map.get("hiddenRcStartDate").equals(""))) {
				if (where.equals("")) {
					String.format("where testrcstartdate between '%s' and '%s' and testrcenddate between '%s' and '%s'", rcstart, rcend, rcstart, rcend);
				}else {
					where += String.format(" and testrcstartdate between '%s' and '%s' and testrcenddate between '%s' and '%s'", rcstart, rcend, rcstart, rcend);
				}
			}
			
			if ((map.get("hiddenStartDate") != null) && !(map.get("hiddenStartDate").equals(""))) {
				if (where.equals("")) {
					String.format("where teststartdate between '%s' and '%s' and testenddate between '%s' and '%s'", start, end, start, end);
				}else {
					where += String.format(" and testrcstartdate between '%s' and '%s' and testrcenddate between '%s' and '%s'", start, end, start, end);
				}
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from vwCrtSch a %s) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			System.out.println("sql: " + sql);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CrtSchDTO> list = new ArrayList<CrtSchDTO>();
			
			while (rs.next()) {
				
				CrtSchDTO dto = new CrtSchDTO();
				
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtSchSeq(rs.getInt("crtschseq"));
				dto.setCrtName(rs.getString("crtName"));
				dto.setCrtctg(rs.getString("crtctg"));
				dto.setAgency(rs.getString("agency"));
				dto.setAgencyURL(rs.getString("agencyURL"));
				dto.setCrtTestSeq(rs.getInt("crtTestSeq"));
				dto.setExamPay(rs.getInt("examPay"));
				dto.setExpiryDate(rs.getString("expiryDate"));
				dto.setPassLine(rs.getString("passLine"));;
				dto.setTestSubject(rs.getString("testSubject"));
				dto.setQuestionType(rs.getString("questionType"));
				dto.setQustionNum(rs.getInt("qustionNum"));
				dto.setTestTime(rs.getString("testTime"));
				dto.setCrtSchName(rs.getString("crtSchName"));
				dto.setRound(rs.getString("round"));
				dto.setTestRcStartDate(rs.getString("TestRcStartDate"));
				dto.setTestRcEndDate(rs.getString("TestRcEndDate"));
				dto.setTestStartDate(rs.getString("TestStartDate"));
				dto.setTestEndDate(rs.getString("TestEndDate"));
				dto.setPassDay(rs.getString("PassDay"));
				dto.setRcDday(rs.getInt("rcdday"));
				dto.setDday(rs.getInt("dday"));
				dto.setCrtInfo(rs.getString("crtInfo"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 자격증 시험 일정 조회 게시물 수 JDBC
	 * @param map
	 * @return
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {

			String sql = "";
			String where = "";
			
			String rcstart = map.get("hiddenRcStartDate");
			String rcend = map.get("hiddenRcEndDate");
			String start = map.get("hiddenStartDate");
			String end = map.get("hiddenEndDate");
			if (map.get("search").equals("y")) {
				
				if ((map.get("word") != null) || !(map.get("word").equals(""))) {
					where = String.format("where crtName like '%%%s%%'", map.get("word"));
				}

				
			
				if ((map.get("hiddenRcStartDate") != null) && !(map.get("hiddenRcStartDate").equals(""))) {
					if (where.equals("")) {
						String.format("where testrcstartdate between '%s' and '%s' and testrcenddate between '%s' and '%s'", rcstart, rcend, rcstart, rcend);
					}else {
						where += String.format(" and testrcstartdate between '%s' and '%s' and testrcenddate between '%s' and '%s'", rcstart, rcend, rcstart, rcend);
					}
				}
				
				if ((map.get("hiddenStartDate") != null) && !(map.get("hiddenStartDate").equals(""))) {
					if (where.equals("")) {
						String.format("where teststartdate between '%s' and '%s' and testenddate between '%s' and '%s'", start, end, start, end);
					}else {
						where += String.format(" and testrcstartdate between '%s' and '%s' and testrcenddate between '%s' and '%s'", start, end, start, end);
					}
				}
			
				sql = "select count(*) as cnt from vwCrtSch " + where;
			}	else {
				sql = "select count(*) as cnt from vwCrtSch";
			}
			
			System.out.println("CrtSchDAO getTotalCount: " + sql);

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 자격증 시험 일정 상세페이지 JDBC
	 * @param crtseq
	 * @return
	 */
	public ArrayList<CrtSchDTO> list(String crtseq) {
		
		try {
			
			String sql = "select * from vwcrtsch where crtseq = ? order by crttesttypeseq";
			System.out.println(sql);
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<CrtSchDTO> list = new ArrayList<CrtSchDTO>();
			
			if (rs.next()) {
				
				CrtSchDTO dto = new CrtSchDTO();
				
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtSchSeq(rs.getInt("crtschseq"));
				dto.setCrtName(rs.getString("crtName"));
				dto.setCrtctg(rs.getString("crtctg"));
				dto.setAgency(rs.getString("agency"));
				dto.setAgencyURL(rs.getString("agencyURL"));
				dto.setCrtTestSeq(rs.getInt("crtTestSeq"));
				dto.setExamPay(rs.getInt("examPay"));
				dto.setExpiryDate(rs.getString("expiryDate"));
				dto.setPassLine(rs.getString("passLine"));;
				dto.setTestSubject(rs.getString("testSubject"));
				dto.setQuestionType(rs.getString("questionType"));
				dto.setQustionNum(rs.getInt("qustionNum"));
				dto.setTestTime(rs.getString("testTime"));
				dto.setCrtSchName(rs.getString("crtSchName"));
				dto.setRound(rs.getString("round"));
				dto.setTestRcStartDate(rs.getString("TestRcStartDate"));
				dto.setTestRcEndDate(rs.getString("TestRcEndDate"));
				dto.setTestStartDate(rs.getString("TestStartDate"));
				dto.setTestEndDate(rs.getString("TestEndDate"));
				dto.setPassDay(rs.getString("PassDay"));
				dto.setRcDday(rs.getInt("rcdday"));
				dto.setDday(rs.getInt("dday"));
				dto.setCrtInfo(rs.getString("crtInfo"));
				dto.setCrtTestTypeSeq(rs.getInt("crtTestTypeSeq"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}
