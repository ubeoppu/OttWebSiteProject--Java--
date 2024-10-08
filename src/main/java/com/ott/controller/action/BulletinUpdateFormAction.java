package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class BulletinUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "bulletin/bulletinUpdate.jsp";
		
		String num = request.getParameter("bulletinNum");
		
		BulletinVO bVo = BulletinDAO.getInstance().
				selectOneBulletinByNum(Integer.parseInt(num));
		
		request.setAttribute("bulletin", bVo);
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
