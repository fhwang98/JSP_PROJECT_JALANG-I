package com.project.jr.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.project.jr.main.DBUtil;
import com.project.jr.user.model.UserDTO;

/**
 * 회원 DAO
 * @author eugene
 * @author hyunbin
 * 
 */
public class UserDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	/**
	 * 회원 DAO 생성자
	 */
	public UserDAO() {
		this.conn = DBUtil.open();
	}


	/**
	 * 관리자 메인 페이지 - 회원수 조회 메소드
	 * @return
	 */
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
	
	/**
	 * 회원가입 메소드
	 * Method to sign up a new user.
	 * 
	 * @param uDto UserDTO object containing user information.
	 * @return Result of the database operation (1 if successful, 0 if not).
	 */
	public int signup(UserDTO uDto) {
		try {
			String sql = "Insert into tblUserInfo(id,pw,name,birthDate,sex,eMail,phoneNum,joinDate,userStatus) values (?,?,?,?,?,?,?,to_date(sysdate, 'RR/MM/DD'),1)";
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

	/**
	 * 로그인 메소드
	 * Method to handle user login.
	 * 
	 * @param dto UserDTO object containing login credentials.
	 * @return UserDTO object with user information if login is successful, null otherwise.
	 */
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
	
	/**
	 * 회원탈퇴 메소드
	 * Method to unregister a user.
	 * 
	 * @param id User ID to be unregistered.
	 * @return Result of the database operation (1 if successful, 0 if not).
	 */
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

	/**
	 * 아이디찾기 메소드
	 * Method to find user ID.
	 * 
	 * @param uDto UserDTO object containing information for finding the ID.
	 * @return Result of the database operation (1 if successful, 0 if not).
	 */
	public int finduserid(UserDTO uDto) {
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
	
	/**
	 * 아이디 중복체크 메소드
	 * Method to check if a user ID is already in use.
	 * 
	 * @param id User ID to be checked.
	 * @return Result of the database operation (1 if ID is already in use, 0 if not).
	 */
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

	/**
	 * 아이디 찾기 메소드
	 * Method to find user ID.
	 * 
	 * @param uDto UserDTO object containing information for finding the ID.
	 * @return UserDTO object with user information if found, null otherwise.
	 */
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

	/**
	 * 비밀번호 찾기 메소드
	 * Method to find user password.
	 * 
	 * @param uDto UserDTO object containing information for finding the password.
	 * @return UserDTO object with user information if found, null otherwise.
	 */
	public UserDTO findPassword(UserDTO uDto) {
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

	/**
	 * 비밀번호 변경 메소드
	 * Method to change user password.
	 * 
	 * @param uDto UserDTO object containing information for changing the password.
	 * @return UserDTO object with updated user information if successful, null otherwise.
	 */
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
            // 실패할 경우 처리 추가

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

	/**
	 * 비밀번호 변경 메소드
	 * Method to change user password.
	 * 
	 * @param id User ID for whom the password needs to be changed.
	 * @param pw New password.
	 * @return Result of the database operation (1 if successful, 0 if not).
	 */
	public int changePw(String id, String pw) {

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