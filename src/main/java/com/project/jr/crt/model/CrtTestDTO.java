package com.project.jr.crt.model;

import lombok.Data;
/**
 *	자격증 시험 정보 DTO
 */
@Data
public class CrtTestDTO {
	
	private String crtTestSeq;
	private String crtTestName;
	private String crtSeq;
	private String crtTestTypeSeq;
	private String examPay;
	private String expiryDate;
	private String passLine;
	private String testSubject;
	private String questionType;
	private String qustionNum;
	private String testTime;
	private String crtName;
	private String testType;
 
}
