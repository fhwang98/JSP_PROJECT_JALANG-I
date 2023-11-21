package com.project.jr.user.model;

import lombok.Data;
import lombok.ToString;

/**
 * 회원 정보 DTO
 * @author eugene
 * @author hyunbin
 * 
 */
@ToString
@Data
public class UserDTO {

	private String id;
	private String pw;
	private String name;
	private String birthDate;
	private String sex;
	private String eMail;
	private String phoneNum;
	private String joinDate;
	private int userStatus;
	
}
