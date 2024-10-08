<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="bulletin">
		<input type="hidden" name="command" value="bulletin">
		<h1>본문</h1>
	</form>
	<table>
		<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${comment.userId}</td>
				<td>${comment.commentContent}</td>
				<td colspan="2"><a
					href="OttServlet?command=update_comment&commentNum=${comment.commentNum}&bulletinNum=${bulletin.bulletinNum}">수정하기</a>
					<a
					href="OttServlet?command=delete_comment&commentNum=${comment.commentNum}&bulletinNum=${bulletin.bulletinNum}">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>


	<form action="OttServlet" method="post">
		<input type="hidden" name="command" value="insert_comment">
		<table>
			<tr>
				<td>${member.userId}</td>
				<td><input type="text" name="comment" value="댓글을 작성하세요"></td>
				<td><input type="submit" value="등록"></td>
			</tr>

		</table>
	</form>
	<footer>
		<jsp:include page="../footer.jsp"></jsp:include>
	</footer>

</body>
</html>