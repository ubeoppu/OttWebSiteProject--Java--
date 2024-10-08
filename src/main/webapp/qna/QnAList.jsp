<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/contentInfo.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../header.jsp"></jsp:include>
</header>
<section>
	<h1>QnA 목록</h1>
		<table style="text-align:center;" align="center">
			<tr>
				<th>답변 여부</th>
				<th>QnA 번호</th>
				<th>QnA 제목</th>
				<th>아이디</th>
				<th>등록 일자</th>
				<th>QnA 종류</th>
			</tr>
			<c:forEach items="${qnaList}" var="qna">
				<tr>
					<td>
						<c:if test="${empty qnaReply.replyNum}">
							답변완료
						</c:if>
						<c:if test="${!empty qnaReply.replyNum}">
							미답변문의
						</c:if>
					</td>
					<td>${qna.qnaNum}</td>
					<td><a href="OttServlet?command=qna_detail&qnaNum=${qna.qnaNum}&page=${page.page}">${qna.qnaTitle}</a></td>
					<td>${qna.userId}</td>
					<td>${qna.qnaRegiDate}</td>
					<td>${qna.qnaCategory}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
				<div id="page" >
					<c:if test="${page.prev}">
						<a href="OttServlet?command=content_info&page=${page.startPage-1}&limit=${page.limit}">이전</a>
					</c:if>
					 <c:forEach begin="${page.startPage}" end="${page.endPage}" var="nowPage">
					 	<c:if test="${page.page == nowPage}">
					 		<a href="OttServlet?command=content_info&page=${nowPage}&limit=${page.limit}" style="color:yellowgreen;">${nowPage}</a>					 		
					 	</c:if>
					 	<c:if test="${page.page != nowPage}">
					 		<a href="OttServlet?command=content_info&page=${nowPage}&limit=${page.limit}">${nowPage}</a>
					 	</c:if>
					 </c:forEach>
					 	<c:if test="${page.next}">
					 		<a href="OttServlet?command=content_info&page=${page.endPage +1}&limit=${page.limit}">다음</a>
					 	</c:if>
      				</div>
      </td>
			</tr>
		</table>
		<div class="home" style="text-align:center">
			<input type="button" value="홈으로" name="home" onclick="location.href='OttServlet?command=admin_menu'">
		</div>
	</section>
<footer>
	<jsp:include page="../footer.jsp"></jsp:include>
</footer>


</body>
</html>