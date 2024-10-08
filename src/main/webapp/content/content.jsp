<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/contentInfo.css?after">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
   <h1>컨텐츠 목록</h1>
   <form name="frm">
   <div id="insert">
      <a href="OttServlet?command=insert_content_form">컨텐츠 추가</a>
      </div>
      <table style="text-align:center;" align="center">
         <tr>
            <th>컨텐츠 번호</th>
            <th>컨텐츠 제목</th>
            <th>감독</th>
            <th>배우</th>
            <th>개봉연도</th>
            <th>삭제</th>
         </tr>
         <c:forEach items="${contentList}" var="content">
            <tr>
               <td>${content.contentNum}</td>
               <td><a
                  href="OttServlet?command=content_detail&contentNum=${content.contentNum}&page=${page}">${content.contentName}</a></td>
               <td>${content.director}</td>
               <td>${content.actor}</td>
               <td>${content.year}</td>
               <td><a
                  href="OttServlet?command=delete_content&contentNum=${content.contentNum}"
                  onclick="return deleteCheck()">컨텐츠 삭제</a></td>
            </tr>
         </c:forEach>
         <tr>
            <td colspan="6">
            <div id="page" >
               <c:if test="${page.prev}">
                  <a href="OttServlet?command=content_info&page=${endPage-(endPage-10)}">prev</a>         
               </c:if>
                <c:forEach begin="${page.startPage}" end="${page.endPage}" var="pageGo">
                   <c:if test="${page.page == pageGo}">
                      <a href="OttServlet?command=content_info&page=${pageGo}" style="color:yellowgreen;">${pageGo}</a>                      
                   </c:if>
                   <c:if test="${page.page != pageGo}">
                      <a href="OttServlet?command=content_info&page=${pageGo}">${pageGo}</a>
                   </c:if>
                </c:forEach>
                  <c:if test="${page.next}">
                  <a href="OttServlet?command=content_info&page=${startPage+(startPage+10)-1}">next</a>
                  </c:if>
                  </div>
      </td>
         </tr>
      </table>
      <div class="home" style="text-align:center">
         <input type="button" value="홈으로" name="home" onclick="location.href='OttServlet?command=admin_menu'">
      </div>
   </form>
   </section>
<footer>
   <jsp:include page="../footer.jsp"></jsp:include>
</footer>


</body>
</html>