<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>

<body>
	<div id="indexContainer">
		<div class="introduction">
			<h2 style="font-size: 45px" class="introductionH2">레시피를 연구하다</h2>
			<p  style="font-size: 25px" class="introductionP">
				Lab.Cipe는 단순 레시피 기록 사이트에 그치지 않습니다.<br>찾아낸 레시피를 발전 시키고 수정하여 더
				맛있는 요리를 만들 수 있게 도와줍니다.
			</p>
			<h2 style="font-size: 45px" class="introductionH2">맛있는 음식을 언제, 어디서나</h2>
			<p  style="font-size: 25px" class="introductionP">
				Lab.Cipe를 버스에서도, 지하철에서도 우리 생활 어디서나 <br>Lab.Cipe를 만날 수 있도록 모든
				기기에서 호환되는 사이트를 만들고 있습니다.
			</p>
		</div>
		<!-- 홈페이지 슬라이드 -->
		<div id="carouselExampleDark" class="carousel carousel-dark slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleDark"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleDark"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleDark"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div id="carousel1" class="carousel-item active"
					data-bs-interval="5000"></div>
				<div id="carousel2" class="carousel-item" data-bs-interval="2000"></div>
				<div id="carousel3" class="carousel-item"></div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleDark" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleDark" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<!-- 홈페이지 슬라이드 -->
		<script>
			let mostView = {};
			let bookmarkArr = [];

			<c:forEach var="mostView" items="${mostViewList}">
			bookmarkArr
					.push('${contextPath}/download.do?recipe_id=${mostView.recipe_id}&file_path=${mostView.file_path}');
			console.log(bookmarkArr[0]);

			</c:forEach>
			console.log(bookmarkArr);
		</script>

		<script src="${contextPath}/resources/js/carousel.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
			crossorigin="anonymous"></script>
</body>
</html>