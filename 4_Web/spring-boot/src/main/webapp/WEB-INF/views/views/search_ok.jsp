<%@page import="com.kh.model.vo.Member"%>
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
		<ul>
		<li>아이디 :${member.Id} </li>
		<li>비밀번호 : ${member.Password}</li>
		<li>이름 : ${member.Name}  </li>
		
		
		</ul>
		<a href="/">메인 페이지로 이동</a>
</body>
</html>