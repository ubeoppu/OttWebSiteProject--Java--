package com.net.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.ContentDAO;
import com.net.dto.pagingVO;
import com.ott.controller.action.Action;
import com.ott.dto.ContentVO;

public class ContentInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit")!= null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<ContentVO> list = ContentDAO.getInstance().getAllContentList(page,limit);		
		
		int listCount = ContentDAO.getInstance().getContentList();
		pagingVO vo = new pagingVO(page, limit,listCount);
		
		request.setAttribute("page", vo);
		request.setAttribute("contentList", list);
		request.getRequestDispatcher("admin/ContentInfo.jsp").forward(request, response);
		
	}

}
