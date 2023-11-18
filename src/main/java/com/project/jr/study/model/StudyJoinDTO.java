package com.project.jr.study.model;

import lombok.Data;

/**
 * 스터디신청 DTO
 * @author sujin
 *
 */
@Data
public class StudyJoinDTO {
	private int studyJoinSeq;
	private String id;
	private int crtSchSeq;
	private int timeOption;
	private int dayOption;
	private int majorOption;
	private int status;

}
