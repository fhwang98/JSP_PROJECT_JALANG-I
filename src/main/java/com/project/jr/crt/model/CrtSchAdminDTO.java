package com.project.jr.crt.model;

import lombok.Data;

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
