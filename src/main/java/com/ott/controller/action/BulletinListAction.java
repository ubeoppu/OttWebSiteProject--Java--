package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.PagingVO;

public class BulletinListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("userId", "test1234");
		// 화면 전환 시에 조회하는 페이지번호 and 화면에 그려질 데이터개수 2개를 전달 받음
		int page = 1;
		int limit = 10;
		
		// 페이지 번호를 클릭 하는 경우
		if(request.getParameter("page") != null && 
				request.getParameter("limit") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		String url = "/bulletin/bulletinList.jsp";

		// 1. DAO 생성
		BulletinDAO bDao = BulletinDAO.getInstance();
		// 2. pageVO생성
		List<BulletinVO> list = bDao.getAllBulletin(page, limit);
		int listCount = bDao.getListCount(); // 전체 게시글 수
		PagingVO pagingVO = new PagingVO(page, limit, listCount);
		
		request.setAttribute("pagingVO", pagingVO);
		
		request.setAttribute("bulletinList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
