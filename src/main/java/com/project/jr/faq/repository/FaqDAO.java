package com.project.jr.faq.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.project.jr.faq.model.FaqDTO;
import com.project.jr.main.DBUtil;

public class FaqDAO {
	
	
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public FaqDAO() {
		this.conn = DBUtil.open();
	}
	

	

	public ArrayList<FaqDTO> getList() {
		
		
try {
			
			String seq="select * from tblfaq";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(seq);
			
			ArrayList<FaqDTO> result=new ArrayList<FaqDTO>();
			
			while(rs.next()) {
				
				
				FaqDTO dto= new FaqDTO();
				
				dto.setFaqSeq(rs.getString("faqSeq"));
				dto.setFaqTitle(rs.getString("faqTitle"));
				dto.setFaqContent(rs.getString("faqContent"));
				dto.setFaqWriteDate(rs.getString("faqWriteDate"));
			
				
				result.add(dto);
			}
			
			return result;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
