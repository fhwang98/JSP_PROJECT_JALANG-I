package com.project.jr.admin.model;

import lombok.Data;
import lombok.ToString;

/**
 * 관리자 정보 DTO
 * @author eugene
 *
 */
@Data
@ToString
public class AdminDTO {

	private String adminInfoId;
	private String adminInfoPw;
	private String adminInfoMail;
	private String adminInfoPN;
	
}
