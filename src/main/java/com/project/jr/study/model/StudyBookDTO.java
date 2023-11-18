package com.project.jr.study.model;

import lombok.Data;
import lombok.ToString;

/**
 * 스터디 교재 DTO
 * @author sujin
 *
 */
@Data
@ToString
public class StudyBookDTO {

	private String bookName;
	private int bookSeq;
	private String list;
	private String bookImg;
	private int count;
	private int titleStep;
	private int learnCheck;
	
	private int status; //1진행중, 2종료
	
}
