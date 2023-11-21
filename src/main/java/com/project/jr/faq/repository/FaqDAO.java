package com.project.jr.faq.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.project.jr.faq.model.FAQDTO;
import com.project.jr.main.DBUtil;

/**
 * 
 * @author oseunghyeon
 *
 * FAQ 데이터베이스 액세스 객체(DAO) 클래스입니다.
 */

public class FaqDAO {
	
	
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	 /**
     * FaqDAO의 생성자입니다. 데이터베이스 연결을 수행
     */
	public FaqDAO() {
		this.conn = DBUtil.open();
	}
	

	
	  /**
     * FAQ 목록을 조회하는 메서드
     * 
     * @return FAQ 목록
     */
	public ArrayList<FAQDTO> getList() {
		
		
try {
			
			String seq="select * from tblfaq";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(seq);
			
			ArrayList<FAQDTO> result=new ArrayList<FAQDTO>();
			
			while(rs.next()) {
				
				
				FAQDTO dto= new FAQDTO();
				
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
