<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty wish}">
	<input type="button" value="♥" onclick="location.href='OttServlet?command=insert_wish&contentNum=${content.contentNum}&userId=${member.userId}'">
	</c:if>
	<c:if test="${!empty wish}">
	<input type="button" value="♥x" onclick="location.href='OttServlet?command=delete_wish&contentNum=${content.contentNum}&userId=${member.userId}'">
	</c:if>
	
</body>
</html>