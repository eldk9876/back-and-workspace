<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="header.jsp"/>
		<form action="choose5_view.jsp">
		숫자 : <input type="text" name="number">
				<input type="submit" value="전송">
		</form>
</body>
</html>