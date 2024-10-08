package com.net.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.MemberDAO;
import com.ott.controller.action.Action;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("넘어옴");
		String userId = request.getParameter("userId");
		
		
		System.out.println(userId);
		MemberDAO.getInstance().deleteMember(userId);
		
		response.sendRedirect("OttServlet?command=member_info");
		
	}

}
