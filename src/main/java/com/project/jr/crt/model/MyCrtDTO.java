package com.project.jr.crt.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MyCrtDTO {
	private int myCrtSeq;
	private String id;
	private int crtSeq;
	private String getDate;
	private String regdate;
	
	private String crtName;
	private String expiration;
	
}
