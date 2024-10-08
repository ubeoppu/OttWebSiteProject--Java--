package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class BulletinUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		BulletinVO bVo = new BulletinVO();
		
		bVo.setBulletinNum(Integer.parseInt(request.getParameter("bulletinNum")));
		bVo.setName(request.getParameter("name"));
		bVo.setBulletinTitle(request.getParameter("bulletinTitle"));
		bVo.setBulletinContent(request.getParameter("bulletinContent"));
		
		System.out.println("bVo : " + bVo);
		
		BulletinDAO.getInstance().updateBulletin(bVo);
		
		response.sendRedirect("OttServlet?command=bulletin_list");
	}

}
