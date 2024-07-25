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
		<h1>회원 검색 정보 출력!</h1>
		<%MemberEx member = (MemberEx)request.getAttribute("member"); %>>
		<ul>
		<li>아이디 :<%=member.getId() %> </li>
		<li>비밀번호 : <%=member.getPassword() %></li>
		<li>이름 : <%=member.getName() %> </li>
		
		
		</ul>
</body>
</html>