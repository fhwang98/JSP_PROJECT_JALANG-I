package com.project.jr.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.main.DBUtil;
import com.project.jr.user.model.UserDTO;

public class UserAdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public UserAdminDAO() {
		this.conn = DBUtil.open();
	}

	public UserDTO login(UserDTO dto) {

		try {
			
			String sql = "select * from tblUserInfo where id = ? and pw = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs=pstat.executeQuery();
			
			
			if(rs.next()) {
				
				UserDTO result=new UserDTO();
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setBirthDate(rs.getString("birthDate"));
				result.setSex(rs.getString("sex"));
				result.setEMail(rs.getString("eMail"));
				result.setPhoneNum(rs.getString("phoneNum"));
				result.setJoinDate(rs.getString("joinDate"));
				result.setUserStatus(rs.getInt("userStatus"));
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public ArrayList<UserDTO> list() {
	    try {
	        String sql = "select * from tblUserInfo";
	        
	        stat = conn.createStatement();
	        rs = stat.executeQuery(sql);
	        
	        ArrayList<UserDTO> list = new ArrayList<UserDTO>();
	        
	        while (rs.next()) {
	        	
	            UserDTO dto = new UserDTO();
	            
	            dto.setId(rs.getString("id"));
	            dto.setName(rs.getString("name"));
	            dto.setJoinDate(rs.getString("joindate"));
	            
	            list.add(dto);
	        }
	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public UserDTO detail(String id) {
		
		try {
	         
	         String sql = "select * from tblUserInfo where id = ?";
	         
	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, id);
	         
	         rs = pstat.executeQuery();
	         
	         UserDTO dto = new UserDTO();
	         
	         //회원명, 아이디, 생년월일, 성별, 주소, 전화번호, 보유자격증, 보유포인트, 누적신고수, 가입일을 출력하고 우측 상단에는 ‘활동 정지’ 버튼이 있다.
	         
	         if(rs.next()) {
	        	 
	        	 dto.setName(rs.getString("name"));
	        	 dto.setId(rs.getString("id"));
	        	 dto.setBirthDate(rs.getString("birthdate"));
	        	 dto.setSex(rs.getString("sex"));
	        	 dto.setPhoneNum(rs.getString("phonenum"));
	        	 dto.setJoinDate(rs.getString("joindate"));
	        	 
	            return dto;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

		return null;
	}

	
	
}
