<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/userInfo.css" />
<script src="https://kit.fontawesome.com/ef885bd654.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>

		<div class="box">
			<div class="container">
				<div class="section">
					<c:choose>
						<c:when test="${mem.member.memberImg != null}">
							<img class="user-img"
								src="http://192.168.10.51:8081/member/${mem.member.id}/${mem.member.memberImg}">
						</c:when>
						<c:otherwise>
							<img class="user-img" src="http://192.168.10.51:8081/기본프사.jpg">
						</c:otherwise>
					</c:choose>
					<div class="info">
						<div class="count_info">
							<span>모임 참여 횟수 ${mem.memberMeetCount}회</span>
						</div>
						<div class="tem_info">

							<c:if test="${mem.member.memberManner < 30}">
								<i class="fa-solid fa-temperature-quarter"></i>
								<span>${mem.member.memberManner}℃</span>
								<span style="color: red"><i
									class="fa-solid fa-face-angry fa-2x"></i></span>
							</c:if>
							<c:if
								test="${mem.member.memberManner >= 30 && mem.member.memberManner <= 40}">
								<i class="fa-solid fa-temperature-half"></i>
								<span>${mem.member.memberManner}℃</span>
								<span style="color: rgb(252, 177, 3)"><i
									class="fa-solid fa-face-smile fa-2x"></i></span>
							</c:if>
							<c:if test="${mem.member.memberManner > 40}">
								<i class="fa-solid fa-temperature-three-quarters"></i>
								<span>${mem.member.memberManner}℃</span>
								<span style="color: green"><i
									class="fa-solid fa-face-grin fa-2x"></i></span>
							</c:if>
						</div>

					</div>
					<div class="memberInfo_div">
						<h1>
							<i class="fa-solid fa-user"></i> ${mem.member.nickname}
						</h1>
					</div>
					<div class="memberInfo_div">
						<h2>한줄소개 : ${mem.member.memberInfo}</h2>
					</div>

					<sec:authorize access="isAuthenticated()" var="principal">
						<sec:authentication property="principal" var="loginMember" />
						<c:set var="ck" value="${false}" />
						<div id="align">
							<c:forEach items="${mem.membershipUserList}" var="list">
								<c:if test="${list.listGrade != 'guest'}">
									<c:forEach items="${loginMember.memberListDTO}" var="loginList">
										<c:if test="${loginList.listGrade != 'guest'}">
											<c:if
												test="${list.membership.membershipCode == loginList.membershipCode}">
												<c:set var="ck" value="${true}" />
											</c:if>
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
							<c:if test="${ck}">
								<p>나와 같은 클럽에 속한 회원입니다!</p>
							</c:if>
						</div>
						<div id="rating">
							<button id="plus-btn" data-target-member-id="${mem.member.id}"
								data-login-member-id="${loginMember.id}" class="left-btn">
								<i class="fa-regular fa-thumbs-up"></i>
							</button>
							<button id="minus-btn" data-target-member-id="${mem.member.id}"
								data-login-member-id="${loginMember.id}" class="right-btn">
								<i class="fa-regular fa-thumbs-down"></i>
							</button>

						</div>
					</sec:authorize>
					<div id="section2">
						<div class="section2_memberInfo">
							<h1>가입한 클럽</h1>
							<i class="fa-solid fa-users"></i>
						</div>
						<div class="club_info">
							<c:forEach items="${mem.membershipUserList}" var="list">
								<c:if test="${list.listGrade != 'guest'}">
									<div class="club_box">
										<a href="/${list.membership.membershipCode}"><img
											class="club_img"
											src="http://192.168.10.51:8081/membership/${list.membership.membershipCode}/${list.membership.membershipImg}">
											<p>${list.membership.membershipName}</p> </a>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<div class="section2_memberInfo">
							<h1>가입신청한 클럽</h1>
							<i class=" fa-solid fa-user-plus"></i>
						</div>
						<div class="club_info">
							<c:forEach items="${mem.membershipUserList}" var="list">
								<c:if test="${list.listGrade == 'guest'}">
									<div class="club_box">
										<a href="/${list.membership.membershipCode}"> <img
											class="club_img"
											src="http://192.168.10.51:8081/membership/${list.membership.membershipCode}/${list.membership.membershipImg}">
											<p>${list.membership.membershipName}</p>
										</a>
									</div>
								</c:if>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		</div>

	<jsp:include page="../footer/footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/userInfo.js"></script>
</body>
</html>
