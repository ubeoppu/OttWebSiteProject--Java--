package com.net.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.ContentDAO;
import com.net.dto.pagingVO;
import com.ott.controller.action.Action;
import com.ott.dto.ContentVO;

public class UpdateContentFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));			
		}
		if(request.getParameter("limit")!=null) {
			limit = Integer.parseInt(request.getParameter("limit"));			
		}
		
		
		ContentVO vo =  ContentDAO.getInstance().getOneContent(contentNum);
		
		int count = ContentDAO.getInstance().getContentList();
		pagingVO pVo = new pagingVO(page, limit, count);
		
		request.setAttribute("page", pVo);
		request.setAttribute("content", vo);
		request.getRequestDispatcher("admin/UpdateContent.jsp").forward(request, response);
		
		
	}

}
