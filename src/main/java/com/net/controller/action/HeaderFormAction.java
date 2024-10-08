package com.net.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.MemberDAO;
import com.net.dto.memberVO;
import com.ott.controller.action.Action;

public class HeaderFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		memberVO vo = MemberDAO.getInstance().getOneMember(userId);
		
		request.setAttribute("member", vo);
		request.getRequestDispatcher("header.jsp").forward(request, response);
	}

}
