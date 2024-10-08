package com.net.dao;

public class QnAReplyDAO {

	private static QnAReplyDAO instance = new QnAReplyDAO();
	
	private QnAReplyDAO() {
		
	}
	
	public static QnAReplyDAO getInstance() {
		return instance;
	}
	
	
	
}
