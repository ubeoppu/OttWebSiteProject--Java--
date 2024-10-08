<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/insertContent.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../header.jsp"></jsp:include>
</header>
<section>
	<div id="info" align="center">
      <h1>컨텐츠 등록</h1>
      <form enctype="multipart/form-data" method="post" name="frm" action="OttServlet">
         <input type="hidden" name="command" value="insert_content">
         <table>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="contentName"></td>
            </tr> <tr>
               <th>장르</th>
               <td><input type="text" size="70" name="genre"></td>
            </tr> 
            <tr>
            <th>감독</th>
               <td><input type="text" size="70" name="director"></td>
            </tr>
            <tr>
               <th>배우</th>
               <td><input type="text" size="70" name="actor"></td>
            </tr> <tr>
               <th>개봉연도</th>
               <td><input type="text" size="70" name="year"></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="story"></textarea></td>
            </tr>
            <tr>
               <th>파일</th>
               <td><input type="file" name="poster"></td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록"> 
         <input type="reset" value="다시 작성">
          <input type="button" value="목록"
            onclick="location.href='OttServlet?command=content_info'">
      </form>
   </div>
   </section>
   <footer>
	<jsp:include page="../footer.jsp"></jsp:include>
</footer>
</body>
</html>