<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/deleteBulletin.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../header.jsp"></jsp:include>
</header>
<section>
<h1>게시글 삭제</h1>
	<table>
		<tr>
			<th>게시글 번호</th>
			<th>게시글 제목</th>
			<th>이름</th>
			<th>아이디</th>
			<th>개시일자</th>
		</tr>
		<c:forEach items="${bulletinList}" var="bulletin">
			<tr>
				<td>${bulletin.bulletinNum}</td>
				<td><a
					href="OttServlet?command=bulletin_detail&bulletinNum=${bulletin.bulletinNum}">${bulletin.bulletinTitle}</a></td>
				<td>${bulletin.name}</td>
				<td>${bulletin.userId}</td>
				<td>${bulletin.bulletinDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<c:choose>
					<c:when test="${page.prev}">
						<a href="OttServlet?command=delete_bulletin_form&page${page.endPage-(endPage-10)}&limit=${page.limit}">이전</a>
					</c:when>
				</c:choose>
				<c:forEach begin="${page.startPage}" end="${page.endPage}" var="nowPage">
					<c:if test="${page.page == nowPage}">
						<a href="OttServlet?command=delete_bulletin_form&page=${nowPage}&limit=${page.limit}" style="color:yellowgreen">${nowPage}</a>
					</c:if>
					<c:if test="${page.page != nowPage}">
						<a href="OttServlet?command=delete_bulletin_form&page=${nowPage}&limit=${page.limit}" >${nowPage}</a>
					</c:if>
				</c:forEach>
				<c:choose>
					<c:when test="${page.next}">
						<a href="OttServlet?command=delete_bulletin_form&page${page.startPage+10}&limit=${page.limit}">이전</a>
					</c:when>
				</c:choose>
			</td>
		</tr>
	</table>
	<div class="home">
	<input type="button" value="홈으로" onclick="location.href='OttServlet?command=admin_menu'">
	</div>
	</section>
	<footer>
	<jsp:include page="../footer.jsp"></jsp:include>
</footer>
</body>
</html>