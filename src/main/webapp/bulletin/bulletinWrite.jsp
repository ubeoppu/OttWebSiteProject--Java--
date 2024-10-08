<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/ott.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
      <h1>게시글 등록</h1>
      <form name="frm" method="post" action="OttServlet">
         <input type="hidden" name="command" value="bulletin_write">
          
         <table>
            <tr>
               <th>작성자</th>
               <td><input type="text" name="name"> * 필수</td>
            </tr>
            <tr>
               <th>아이디</th>
               <td><input type="text" name="userId" value="hikari" readonly></td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="bulletinTitle"> * 필수</td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="bulletinContent"></textarea></td>
            </tr>
         </table>
         <br>
         <br> 
         	<input type="submit" value="등록" > 
            <input type="reset" value="다시 작성"> 
            <input type="button" value="목록" onclick="location.href='OttServlet?command=bulletin_list'">
      </form>
   </div>
</body>
</html>