package com.project.jr.crt.model;

import lombok.Data;

@Data
public class CrtDTO {
	private int crtSeq;
	private String crtName;
	private int crtTypeSeq;
	private String expiration;
	private int agencySeq;
	private int isRoutine;
	private int difficulty;
	private int likeCnt;
	private String qualificationCate;
	private String qualification;
	private String crtInfo;
	private int totalCnt;
	private String jobDesc;
	
	private String crtctg;
	private String agency;
	private String agencyurl;
	private int result;
	
	
	private String isRoutineS;
	private String difficultyS;
	private String likeCntS;
	private String totalCntS;
	
	private int crtlike;

}