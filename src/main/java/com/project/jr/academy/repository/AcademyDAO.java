package com.project.jr.academy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.model.AcademyEduDTO;
import com.project.jr.main.DBUtil;

public class AcademyDAO {

   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;

   public AcademyDAO() {
      this.conn = DBUtil.open();
   }

   public ArrayList<AcademyDTO> list(HashMap<String, String> map) {
       try {
           String where = "";
           
           if(map.get("search").equals("y")) {
               where = String.format("where academyName like '%%%s%%'", map.get("word"));
           }
           
           String sql = String.format("select * from(select a.*, rownum as rnum from vwAcademyList a %s )where rnum between %s and %s "
                                       , where
                                       , map.get("begin")
                                       , map.get("end"));
           
           stat = conn.createStatement();
           rs = stat.executeQuery(sql);
           
           ArrayList<AcademyDTO> list = new ArrayList<AcademyDTO>();
              
           while (rs.next()) {
               AcademyDTO dto = new AcademyDTO();
               
               dto.setAcademySeq(rs.getInt("academySeq"));
               dto.setAcademyName(rs.getString("academyName"));
               dto.setAcademyLocation(rs.getString("academyLocation"));
               dto.setAcademyTel(rs.getString("academyTel"));
               dto.setAcademyStar(rs.getInt("academyStar"));
               dto.setAcademyEduSeq(rs.getInt("academyEduSeq"));
               dto.setEduName(rs.getString("eduName"));
               dto.setEduRcStartDate(rs.getString("eduRcStartDate"));
               dto.setEduRcEndDate(rs.getString("eduRcEndDate"));
               dto.setEduStartDate(rs.getString("eduStartDate"));
               dto.setEduEndDate(rs.getString("eduEndDate"));
               dto.setEduLink(rs.getString("eduLink"));
               dto.setCrtSeq(rs.getInt("crtSeq"));
               dto.setCrtName(rs.getString("crtName"));
               
               list.add(dto); // 이 부분이 누락되어 추가함
           }    
           
           return list;
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return null;
   }

   public int getTotalCount() {
      
      try {

         String sql = "select count(*) as cnt from vwAcademyList";

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

   
   
   //-----------------------------------------------
   
   public AcademyDTO get(String seq) {
		try {
			
			String sql = "SELECT * FROM tblAcademy WHERE academySeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();	
			
			if (rs.next()) {
				
				AcademyDTO dto = new AcademyDTO();
				
				dto.setAcademySeq(rs.getInt("academySeq"));
				dto.setAcademyName(rs.getString("academyName"));
				dto.setAcademyLocation(rs.getString("academyLocation"));
				dto.setAcademyTel(rs.getString("academyTel"));
				dto.setAcademyStar(rs.getInt("academyStar"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("AcademyDAO.get()");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AcademyEduDTO> getEduList(String seq) {
		
		try {
			
			String sql = "SELECT edu.*, (SELECT crtName FROM tblCrt WHERE crtSeq = edu.crtSeq ) AS crtName FROM tblAcademyEdu edu WHERE academySeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<AcademyEduDTO> list = new ArrayList<AcademyEduDTO>();
			
			while (rs.next()) {
				
				AcademyEduDTO dto = new AcademyEduDTO();
				
				dto.setAcademyEduSeq(rs.getInt("academyEduSeq"));
				dto.setAcademySeq(rs.getInt("academySeq"));
				dto.setCrtSeq(rs.getInt("crtSeq"));
				dto.setCrtName(rs.getString("crtName"));
				dto.setEduName(rs.getString("eduName"));
				dto.setEduLink(rs.getString("eduLink"));
				dto.setEduRcStartDate(rs.getString("eduRcStartDate"));
				dto.setEduRcEndDate(rs.getString("eduRcEndDate"));
				dto.setEduStartDate(rs.getString("eduStartDate"));
				dto.setEduEndDate(rs.getString("eduEndDate"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AcademyDAO.getEduList()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	
	public int getTotalCount(HashMap<String,String> map) {
		try {
			String sql ="";
			if (map.get("search").equals("n")) {
				
				sql = "SELECT count(*) AS cnt FROM tblAcademy";
				
			} else {
				sql = String.format("SELECT count(*) AS cnt FROM tblAcademy WHERE %s LIKE '%%%s%%'"
						,map.get("column"), map.get("word"));
			}
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			if (rs.next()) {
				
				return rs.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			System.out.println("AcademyDAO.getTotalCount()");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public ArrayList<AcademyDTO> getAdminList(HashMap<String, String> map) {

		try {

			String where = "";
			
			if (map.get("search").equals("y")) {
				where = String.format("WHERE %s LIKE '%%%s%%'", map.get("column"), map.get("word"));
			}
			
			
			String sql = String.format(
					"SELECT * FROM (SELECT a.*, rownum AS rnum FROM tblAcademy a %s) WHERE rnum BETWEEN %s AND %s",
					where, map.get("begin"), map.get("end"));

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			ArrayList<AcademyDTO> list = new ArrayList<AcademyDTO>();

			while (rs.next()) {

				AcademyDTO dto = new AcademyDTO();

				dto.setAcademySeq(rs.getInt("academySeq"));
				dto.setAcademyName(rs.getString("academyName"));
				dto.setAcademyLocation(rs.getString("academyLocation"));
				dto.setAcademyTel(rs.getString("academyTel"));
				dto.setAcademyStar(rs.getInt("academyStar"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("AcademyDAO.list()");
			e.printStackTrace();
		}

		return null;
	}
	

   



}