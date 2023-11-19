package com.project.jr.crt.model;

import lombok.Data;
/**
 *	자격증 시험 일정 DTO
 */
@Data
public class CrtSchDTO {
	
	private int crtSeq;
	private int crtSchSeq;
	private String crtName;
	private String agency;
	private String agencyURL;
	private String crtctg;
	private String crtInfo;
	private int crtTestSeq;
	private int examPay;
	private String expiryDate;
	private String passLine;
	private String testSubject;
	private String questionType;
	private int qustionNum;
	private String testTime;
	private String crtSchName;
	private String round;
	private String testRcStartDate;
	private String testRcEndDate;
	private String testStartDate;
	private String testEndDate;
	private String passDay;
	private int crtTestTypeSeq;
	
	private int rcDday;
	private int Dday;
	
}
