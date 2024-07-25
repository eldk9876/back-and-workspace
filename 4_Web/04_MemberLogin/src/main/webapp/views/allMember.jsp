<%@page import="model.vo.ex.MemberEx"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>전체회원보기!</h1>
		<a href="/"> 메인 페이지로 이동 </a>
		<% List<MemberEx> list = (List<MemberEx>) request.getAttribute("list"); %>
		<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		
		</tr>
		<%for(MemberEx m : list){ %>
		<tr>
			<th><%=m.getId() %></th>
			<th><%=m.getPassword() %></th>
			<th><%=m.getName() %></th>
		
		</tr>
		
		<% } %>
		
</body>
</html>