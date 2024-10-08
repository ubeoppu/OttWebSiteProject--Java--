package com.net.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {
	/*
	 * create table member(
userNum number(10) not null primary key,
admin number(1) not null,
name varchar2(10) not null,
userId varchar2(20) not null unique,
pwd varchar(30) not null,
email varchar(30) not null,
phone varchar(14) not null,
address varchar(100) not null);

	 * */
	
	int userNum;
	int admin;
	String name;
	String userId;
	String pwd;
	String email;
	String phone;
	String address;
}
