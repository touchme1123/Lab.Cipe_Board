<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROFILE</title>
<style>
.text_center {
	text-align: center;
}
</style>
</head>
<body>
<div class="loginContainer">

		<form class="frmLogin" novalidate method="post" action="${contextPath}/member/modMember.do">
			<h1 class="text_center">회원 정보 수정</h1>
			<div class="col-md-4 loginInput">
				<label for="validationCustom01" class="form-label">아이디</label> <input
					type="text" class="form-control" name="id" id="validationCustom01"
					required value=${member.id}>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 loginInput">
				<label for="validationCustom02" class="form-label">비밀번호</label> <input
					type="password" class="form-control" name="pwd" id="validationCustom02"
					required value=${member.pwd}>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 loginInput">
				<label for="validationCustom02" class="form-label">이름</label> <input
					type="text" class="form-control" name="name" id="validationCustom02"
					required value=${member.name}>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4 loginInput">
				<label for="validationCustom02" class="form-label">이메일</label> <input
					type="text" class="form-control" name="email" id="validationCustom02"
					required value=${member.email}>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-12 loginBtn">
				<button class="btn btn-primary" type="submit">수정하기</button>
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>