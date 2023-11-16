package com.project.jr.study.model;

import lombok.Data;

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
