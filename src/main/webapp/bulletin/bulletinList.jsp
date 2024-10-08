<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/ott.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right">
            <a href="OttServlet?command=bulletin_write_form">게시글 등록</a></td>
         </tr>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>아이디</th>
            <th>작성일</th>
            <th>조회</th>
         </tr>
         <c:forEach var="bulletin" items="${bulletinList}">
            <tr class="record">
               <td>${bulletin.bulletinNum }</td>
               <td><a href="OttServlet?command=bulletin_view&bulletinNum=${bulletin.bulletinNum}">
                     ${bulletin.bulletinTitle } </a></td>
               <td>${bulletin.name}</td>
               <td>${bulletin.userId }</td>
               <td><fmt:formatDate value="${bulletin.bulletinDate }" pattern="yyyy-MM-dd"/></td>
               <td>${bulletin.readCount}</td>
            </tr>
         </c:forEach>
      </table>
   </div>
</body>
</html>