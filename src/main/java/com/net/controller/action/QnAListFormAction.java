package com.net.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.net.dao.QnaDAO;
import com.net.dto.QnAReplyVO;
import com.net.dto.QnAVO;
import com.net.dto.pagingVO;
import com.ott.controller.action.Action;

public class QnAListFormAction implements Action {

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
		
		List<QnAVO> list = QnaDAO.getInstance().getAllList(page, limit);
		
		int count = QnaDAO.getInstance().getQnaList();
		pagingVO vo = new pagingVO(page, limit, count);
		
		QnAReplyVO rVo = new QnAReplyVO();
		
		request.setAttribute("qnaReply", rVo);
		request.setAttribute("page", vo);
		request.setAttribute("qnaList", list);
		request.getRequestDispatcher("qna/QnAList.jsp").forward(request, response);
		
	}

}
