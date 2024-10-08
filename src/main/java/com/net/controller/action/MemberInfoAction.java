package com.net.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.MemberDAO;
import com.net.dto.memberVO;
import com.net.dto.pagingVO;
import com.ott.controller.action.Action;

public class MemberInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<memberVO> list = MemberDAO.getInstance().getAllMemberList(page, limit);
		
		int count = MemberDAO.getInstance().getMemberList();		
		pagingVO vo = new pagingVO(page, limit, count);
		
		request.setAttribute("page", vo);
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("admin/MemberInfo.jsp").forward(request, response);
	}

}
