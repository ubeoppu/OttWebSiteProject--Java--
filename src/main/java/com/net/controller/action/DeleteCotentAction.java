package com.net.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.ContentDAO;
import com.ott.controller.action.Action;

public class DeleteCotentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		
		ContentDAO.getInstance().deleteContent(contentNum);
		
		response.sendRedirect("OttServlet?command=content_info");
	}

}
