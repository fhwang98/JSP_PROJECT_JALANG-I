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

	public ArrayList<CrtSchDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			String rcstart = map.get("testrcstartdate");
			String rcend = map.get("testrcenddate");
			String start = map.get("teststartdate");
			String end = map.get("testenddate");
			/*
			if (map.get("search").equals("y")) {
				
				if ((map.get("word") != null) || !(map.get("word").equals(""))) {
					where = String.format("where crtName like '%%%s%%'", map.get("word"));
				}
				
				if ((rcstart != null) || !(rcstart.equals(""))) {
					if (where.equals("")) {
						where = String.format("where testrcstartdate >= '%%%s%%'", rcstart);
					}else {
						where += String.format(" and testrcstartdate >= '%%%s%%'", rcstart);
					}
				}
				
				if ((rcend != null) || !(rcend.equals(""))) {
					if (where.equals("")) {
						where = String.format("where testrcenddate <= '%%%s%%'", rcend);
					}else {
						where += String.format(" and testrcenddate <= '%%%s%%'", rcend);
					}
				}
				
				if ((start != null) || !(start.equals(""))) {
					if (where.equals("")) {
						where = String.format("where teststartdate >= '%%%s%%'", start);
					}else {
						where += String.format(" and teststartdate >= '%%%s%%'", start);
					}
				}
				
				if ((end != null) || !(end.equals(""))) {
					if (where.equals("")) {
						where = String.format("where testenddate <= '%%%s%%'", end);
					}else {
						where += String.format(" and testenddate <= '%%%s%%'", end);
					}
				}
				
			}
			*/
			String sql = String.format("select * from (select a.*, rownum as rnum from vwCrtSch a %s) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			System.out.println(sql);
			
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

	public int getTotalCount(HashMap<String, String> map) {
		
		try {

			String sql = "select count(*) as cnt from vwCrtSch";

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
