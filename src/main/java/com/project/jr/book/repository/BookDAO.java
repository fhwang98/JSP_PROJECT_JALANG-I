package com.project.jr.book.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.book.model.BookDTO;
import com.project.jr.main.DBUtil;

public class BookDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BookDAO() {
		this.conn = DBUtil.open();
	}

	public ArrayList<BookDTO> list(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if(map.get("search").equals("y")) {
				where = String.format("where bookName %s like'%%%s%%'", map.get("word"));
			}
			
			String sql = String.format("select * from(select a.*, rownum as rnum from tblBook a %s)where rnum between %s and %s"
										, where
										, map.get("begin")
										, map.get("end"));
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setBookseq(rs.getInt("bookSeq"));
				dto.setBookname(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPbDate(rs.getString("pbDate"));
				dto.setAuthor(rs.getString("author"));
				dto.setBookLike(rs.getInt("bookLike"));
				dto.setLv(rs.getInt("lv"));
				dto.setBookImg(rs.getString("bookImg"));
				
				
			list.add(dto);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			
			
	}
		
	public ArrayList<HashMap<String, String>> getLikeTop() {
		
		try {
			
			String sql = "SELECT * FROM (SELECT a.*, rownum AS rnum FROM (SELECT bookname, booklike FROM tblbook ORDER BY booklike DESC) a) WHERE rnum BETWEEN 1 AND 3";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
			
			while (rs.next()) {
				
				HashMap<String,String> map = new HashMap<String,String>();
				
				map.put("bookName", rs.getString("bookName"));
				map.put("bookLike", rs.getString("bookLike"));
				
				list.add(map);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public int getTotalCount() {
		
		try {

			String sql = "select count(*) as cnt from tblBook";

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

	public BookDTO bookinfo(String seq) {
		
		try {
			
			String sql = "select * from vwbookInfo where bookseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				BookDTO dto = new BookDTO();
				
				dto.setBookseq(rs.getInt("bookSeq"));
				dto.setBookname(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPbDate(rs.getString("pbDate"));
				dto.setAuthor(rs.getString("author"));
				dto.setBookLike(rs.getInt("booklike"));
				dto.setLv(rs.getInt("lv"));
				
				return dto;
			}	
			
		} catch (Exception e) {
			System.out.println("BookDAO.getLikeTop()");
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<BookDTO> booklist(String seq) {

		try {
			
			String sql = "select * from vwbooklist where bookseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			while (rs.next()) {
				
				BookDTO dto = new BookDTO();
			   
				
				dto.setListNum(rs.getInt("listnum"));
				dto.setList(rs.getString("list"));
				dto.setTitleStep(rs.getInt("titlestep"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int updateLike(String seq) {
		try {

			String sql = "update tblbook set BOOKLIKE = (select BOOKLIKE from tblbook where bookseq = ?)+1 where bookseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
}
