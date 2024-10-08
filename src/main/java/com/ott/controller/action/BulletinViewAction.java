package com.ott.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.BulletinDAO;
import com.ott.dao.CommentDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.CommentVO;

public class BulletinViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int num = Integer.parseInt(request.getParameter("bulletinNum"));
		
		BulletinVO bVo = BulletinDAO.getInstance().selectOneBulletinByNum(num);
		
		BulletinDAO.getInstance().updateReadCount(num);
		
		request.setAttribute("bulletin", bVo);
		
		String url = "bulletin/bulletinView.jsp";
		int bulletinNum = bVo.getBulletinNum();
		
		request.setAttribute("bulletinNum", bulletinNum);
		
		CommentDAO cDao = CommentDAO.getInstance();
   	  	List<CommentVO> list = new ArrayList<CommentVO>();
   	  	//int bulletinNum = (int) request.getAttribute("bulletinNum");
   	  	list = cDao.getComments(num);
   	  	
   	  	request.setAttribute("comment", list);
		
   	  	request.getRequestDispatcher(url).forward(request, response);
	}

}
