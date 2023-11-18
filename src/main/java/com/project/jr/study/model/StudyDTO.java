package com.project.jr.study.model;

import lombok.Data;
import lombok.ToString;

/**
 * 스터디 DTO
 * @author sujin
 *
 */
@Data
@ToString
public class StudyDTO {

	private int studySeq;
	private String studyName;
	private String studyStartDate;
	private String studyEndDate;
	private int studyMemberSeq;
	private String id;
	private int studyJoinSeq;
}
