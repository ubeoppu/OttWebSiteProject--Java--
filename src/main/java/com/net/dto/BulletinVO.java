package com.net.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BulletinVO {

	/*
	 * create table bulletin(
bulletinNum number(10) NOT NULL primary key,
usernum number(10) NOT NULL ,
bulletinTitle varchar2(30) NOT NULL,
bulletinDate TIMESTAMP DEFAULT SYSTIMESTAMP,
constraint FK_USERNUM foreign key (userNum) references member(usernum)
);

	 * */
	
	private int bulletinNum;
	private String userId;
	private String name;
	private String bulletinTitle;
	private Timestamp bulletinDate;
	private String bulletinContent;
	private int readCount;
}
