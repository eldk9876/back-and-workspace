<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원가입</h1>
		 <form action="/front" method="post">  <!--get 방식으로 하면 홈페이지 창에 다 보여서 보이지 않게 -->
		 <input type ="hidden" name="command" value="register"> <!--/front controller 방식 -->
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="password" name="password"><br>
			이름 : <input type="text" name="name"><br>
			<input type="submit" value="회원가입">			
			</form>
</body>
</html>