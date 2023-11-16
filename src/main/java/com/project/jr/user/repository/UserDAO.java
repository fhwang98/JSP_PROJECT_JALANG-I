package com.project.jr.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.project.jr.main.DBUtil;
import com.project.jr.user.model.UserDTO;

public class UserDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public UserDAO() {
		this.conn = DBUtil.open();
	}



	public HashMap<String, Integer> count() {
		
		try {
			
			String sql = "SELECT\n"
					+ "    (SELECT COUNT(*) from tblUserinfo) AS cntAll,\n"
					+ "    (SELECT COUNT(*)\n"
					+ "     FROM tbluserinfo\n"
					+ "     WHERE TO_CHAR(joindate, 'YYYY-MM') = TO_CHAR(sysdate, 'YYYY-MM')) AS cntNew,\n"
					+ "    (SELECT COUNT(*)\n"
					+ "     FROM tblUserInfo\n"
					+ "     WHERE userstatus = 1) AS cntDel\n"
					+ "FROM dual";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			if (rs.next()) {
				
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				
				map.put("cntAll", rs.getInt("cntAll"));
				map.put("cntNew", rs.getInt("cntNew"));
				map.put("cntDel", rs.getInt("cntDel"));
				
				return map;
			}
			
		} catch (Exception e) {
			System.out.println("UserDAO.count()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//회원가입
	public int signup(UserDTO uDto) {
		//queryParamNoReturn
		//매개변수(O),반환값(X)
		
		try {
			String sql = "Insert into tblUserInfo(id,pw,name,birthDate,sex,eMail,phoneNum,joinDate,userStatus) values (?,?,?,?,?,?,?,to_date(sysdate, 'RR/MM/DD'),2)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, uDto.getId());
			pstat.setString(2, uDto.getPw());
			pstat.setString(3, uDto.getName());
			pstat.setString(4, uDto.getBirthDate());
			pstat.setString(5, uDto.getSex());
			pstat.setString(6, uDto.getEMail());
			pstat.setString(7, uDto.getPhoneNum());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	//로그인 
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
	
	
	//회원탈퇴
	public int unregister(String id) {
		try {

			String sql = "update tblUserInfo set userstatus = '1' where id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	//아이디찾기 
	public int finduserid(UserDTO uDto) {
		//queryParamNoReturn
		//매개변수(O),반환값(X)
		
		try {
			String sql = "select id from tblUserInfo where name = ? and phoneNum = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, uDto.getName());
			pstat.setString(2, uDto.getPhoneNum());
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	//아이디 중복체크
	public int check(String id) {
		
	    try {

	        String sql = "select count(*) as cnt from tblUserInfo where id = ?";

	        pstat = conn.prepareStatement(sql);
	        pstat.setString(1, id);

	        rs = pstat.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("cnt");
	        }

	    } catch (Exception e) {
	        System.out.println("UserDAO.check()");
	        e.printStackTrace();
	    }

	    return 0;
	}

	
	//아이디 찾기
	public UserDTO findId(UserDTO uDto) {
		try {

            String sql = "select * from tblUserInfo where name = ? and phoneNum = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, uDto.getName());
            pstat.setString(2, uDto.getPhoneNum());

            rs = pstat.executeQuery();


            if (rs.next()) {
                UserDTO result = new UserDTO();

                result.setId(rs.getString("id"));
                result.setName(rs.getString("name"));
                result.setPhoneNum(rs.getString("phoneNum"));

                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

	}
	
	
	//비밀번호 찾기
	public UserDTO findPassword(UserDTO uDto) {
		System.out.println(uDto.getName());
		System.out.println(uDto.getId());
		System.out.println(uDto.getPhoneNum());
		System.out.println(uDto.getEMail());
		
		
		try {

            String sql = "select * from tblUserInfo where name = ? and id = ? and phoneNum = ? and eMail = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, uDto.getName());
            pstat.setString(2, uDto.getId());
            pstat.setString(3, uDto.getPhoneNum());
            pstat.setString(4, uDto.getEMail());

            rs = pstat.executeQuery();

            if (rs.next()) {
                UserDTO result = new UserDTO();

                result.setName(rs.getString("name"));
                result.setId(rs.getString("id"));
                result.setPhoneNum(rs.getString("phoneNum"));
                result.setEMail(rs.getString("eMail"));
                result.setPw(rs.getString("pw"));

                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

	}

	
	//비밀번호 변경
	public UserDTO changePw(UserDTO uDto) {
        try {

            String sql = "update tblUserInfo set pw = ? where id = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, uDto.getPw());
            pstat.setString(2, uDto.getId());

            int result = pstat.executeUpdate();

            if (result == 1) {
                return uDto;
            }
            //실패할 경우 처리 추가

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


	public int changePw(String id, String pw) {

		//queryParamNoReturn
		//매개변수(O),반환값(X)
		
		try {
			String sql = "update tblUserInfo set pw = ? where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pw);
			pstat.setString(2, id);
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	

	
}
