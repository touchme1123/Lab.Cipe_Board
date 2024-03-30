<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>헤더</title>
</head>
<body>
	<nav class="navbar fixed-top navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbarBrand" href="${contextPath}/main.do">Lab.Cipe</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/board/koreanFood.do">한식</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/board/westernFood.do">양식</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/board/chineseFood.do">중식</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/board/japaneseFood.do">일식</a></li>
				</ul>

				<div class="loginForm">
					<c:choose>
						<c:when test="${isLogOn == true  && member!= null}">

							<div class="dropdown">
								<button class="btn btn-secondary dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">
									<p>환영합니다. ${member.name}님!</p>
								</button>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item login"
										href="${contextPath}/member/logout.do">LOGOUT</a></li>
									<li><a class="dropdown-item modMember"
										href="${contextPath}/member/viewDetail.do">회원정보수정</a></li>
								</ul>
							</div>
							<!--
							<a class="login" href="${contextPath}/member/logout.do"><h3>LOGOUT</h3></a>
							<a class="modMember" href="${contextPath}/member/viewDetail.do"><h3>PROFILE</h3></a>
            			 
            			<a class="myLog" href="${contextPath}/member/.do"><h3>MY RECIPE</h3></a>
						 -->
						</c:when>
						<c:otherwise>
							<a class="login" href="${contextPath}/member/loginForm.do"><h3>LOGIN</h3></a>
							</c:otherwise>
					</c:choose>
				</div>

			<form class="d-flex" role="search" action="${contextPath}/board/searchArticle.do">
					<input class="form-control me-2" id="searchInput" type="search" name="searchWord"
						placeholder="Search" aria-label="Search" />
					<button class="btn btn-outline-success" id="searchBtn" name="search" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>