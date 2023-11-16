package com.project.jr.faq.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.main.DBUtil;

public class FAQAdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public FAQAdminDAO() {
		this.conn = DBUtil.open();
	}

	public ArrayList<FAQDTO> list() {
		
		try {
			
			String sql = "select * from tblFaq";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<FAQDTO> list = new ArrayList<FAQDTO>();
			
			while (rs.next()) {
				
				FAQDTO dto = new FAQDTO();
				
				dto.setFaqSeq(rs.getString("faqSeq"));
				dto.setFaqTitle(rs.getString("faqtitle"));
				dto.setFaqContent(rs.getString("faqContent"));
				dto.setFaqWriteDate(rs.getString("faqWriteDate"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public FAQDTO detail(String faqSeq) {
		
		try {
			
			String sql = "select * from tblfaq where faqSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, faqSeq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				FAQDTO dto = new FAQDTO();
				
				dto.setFaqSeq(rs.getString("faqSeq"));
				dto.setFaqTitle(rs.getString("faqtitle"));
				dto.setFaqContent(rs.getString("faqContent"));
				dto.setFaqWriteDate(rs.getString("faqWriteDate"));
				
				return dto;
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int edit(FAQDTO dto) {
		
		try {

			String sql = "update tblfaq set faqtitle = ?, faqContent = ? where faqSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getFaqTitle());
			pstat.setString(2, dto.getFaqContent());
			pstat.setString(3, dto.getFaqSeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String faqSeq) {
		
		try {

			String sql = "delete from tblfaq where faqSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, faqSeq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	
	
}
