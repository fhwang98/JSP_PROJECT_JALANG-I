package com.project.jr.study.model;

import lombok.Data;
import lombok.ToString;

/**
 * 스터디 할일 DTO
 * @author sujin
 *
 */
@Data
@ToString
public class ToDoDTO {

	private int toDoListSeq;
	private int studySeq;
	private String toDo;
	private String completeDate;
	private String id;
	private String toDoComment;
	
	private String name;
}
