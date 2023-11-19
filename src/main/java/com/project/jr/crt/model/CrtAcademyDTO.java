package com.project.jr.crt.model;

import lombok.Data;
/**
 * 자격증 관련 학원 DTO
 */
@Data
public class CrtAcademyDTO {
	private int crtseq;
	private int academyseq;
	private String academyName;
	private String academylocation;
	private int academyStar;
	private String eduName;
	private String eduRcStartDate;
	private String eduRcEndDate;
	private String eduStartDate;
	private String eduEndDate;
	private String eduLink;
	
	private String academyStarS;
}
