package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.CommentDAO;

public class commentInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("테스트화면");
	  HttpSession session = request.getSession();
	  
	  String commentContent =request.getParameter("commentContent");
	  int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
	  String userId = (String)session.getAttribute("userId");
	  System.out.println(commentContent);
	  System.out.println(bulletinNum);
	  System.out.println(userId);
	  
	  CommentDAO.getInstance().insertComment(bulletinNum, commentContent, userId);
	  
	  response.sendRedirect("OttServlet?command=bulletin_view&bulletinNum="+ bulletinNum+"");
	}

}
