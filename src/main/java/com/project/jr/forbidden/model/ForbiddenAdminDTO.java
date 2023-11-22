package com.project.jr.forbidden.model;

import lombok.Data;

/**
 * 금지어 정보를 담는 데이터 전송 객체(DTO) 클래스입니다.
 * @author 이도훈
 */
@Data
public class ForbiddenAdminDTO {

	private int forbiddenSeq;
	private String forbidden;
	
}
