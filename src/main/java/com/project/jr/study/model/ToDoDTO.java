package com.project.jr.study.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ToDoDTO {

	private int toDoListSeq;
	private int studySeq;
	private String toDo;
	private String completeDate;
	private String id;
	private String ToDoComment;
}
