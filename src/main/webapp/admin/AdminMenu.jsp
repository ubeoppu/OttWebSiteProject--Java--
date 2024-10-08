<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/adminMenu.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../header.jsp"></jsp:include>
</header>
	<section>
		<div id="link">
			<input type="button" value="회원관리" onclick="location.href='OttServlet?command=member_info'"> 
			<input type="button" value="컨텐츠 관리" onclick="location.href='OttServlet?command=content_info'"> 
			<input type="button" value="게시글 삭제" onclick="location.href='OttServlet?command=delete_bulletin_form'">
			<input type="button" name="qna" value="Q&A" onclick="location.href='OttServlet?command=qna_list_form'">
		</div>
	</section>
	<footer>
		<jsp:include page="../footer.jsp"></jsp:include>
	</footer>
</body>
</html>