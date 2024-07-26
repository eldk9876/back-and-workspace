<%@page import="model.vo.ex.MemberEx"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>로그아웃!</h1>
		<% 
		// 로그아웃! 즉 세션 정보 죽여버리기!
		response.sendRedirect("index.jsp");%>
</body>
</html>