<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/contentDetail.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../header.jsp"></jsp:include>
</header>
<section>
	<div id="wrap" align="center">
	<input type="hidden" name="page" value="${page.page}">
	<input type="hidden" name="contentNum" value="${content.contentNum}">
		<h1>컨텐츠 상세페이지</h1>
		<div id="info">
		<table>
			<tr>
				<td><c:choose>
						<c:when test="${empty content.poster}">
							<img src="images/noimage.gif">
						</c:when>
						<c:otherwise>
							<img src="${content.poster}">
						</c:otherwise>
					</c:choose></td>
				<td>
					<table>
						<tr>
							<th>컨텐츠 제목</th>
							<td>${content.contentName}</td>
						</tr>
						<tr>
						<th>감독</th>
							<td>${content.director}</td>
						</tr>
						<tr>
							<th>장르</th>
							<td>${content.genre}</td>
						</tr>
						<tr>
							<th>배우</th>
							<td>${content.actor}</td>
						</tr>
						<tr>
							<th>개봉연도</th>
							<td colspan="3">${content.year}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">${content.story}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br> <a href="OttServlet?command=update_content_form&contentNum=${content.contentNum}&page=${page.page}">컨텐츠 수정</a> 
		<input type="button" value="컨텐츠 리스트" onclick="location.href='OttServlet?command=content_info&page=${page.page}'">
	</div>
	</div>
	</section>
	<footer>
	<jsp:include page="../footer.jsp"></jsp:include>
</footer>
</body>
</html>