package com.ott.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class CommentVO {

	private int commentNum;
	private String commentContent;
	private Timestamp commentDate;
	private int bulletinNum;
	private String userId;
	
}
