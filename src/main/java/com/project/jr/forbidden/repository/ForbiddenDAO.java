package com.project.jr.forbidden.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.main.DBUtil;

public class ForbiddenDAO {

	private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public ForbiddenDAO() {
        this.conn = DBUtil.open();
    }

	public ArrayList<String> list() {
		
		try {
			
			String sql = "SELECT * FROM tblForbidden";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<String> list = new ArrayList<String>();
			
			while (rs.next()) {
				
				String word= rs.getString("forbidden");
				
				
				list.add(word);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("ForbiddenDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}
	
}
