package com.project.jr.crt.model;

import lombok.Data;

/**
 * 자격증 일정를 담는 데이터 전송 객체(DTO) 클래스입니다.
 * @author 이도훈
 */
@Data
public class CrtSchAdminDTO {

	private int crtSchSeq;
	private int crtTestSeq;
	private String crtSchName;
	private String round;
	private String testRcStartDate;
	private String testRcEndDate;
	private String testStartDate;
	private String testEndDate;
	private String passDay;
	private String crtTestName;
	private String agency;
	private String crtTestType;
	private String crtName;

}
