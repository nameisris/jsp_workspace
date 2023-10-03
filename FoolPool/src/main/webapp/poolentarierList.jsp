<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="bean.Poolentarier"%>
<% pageContext.setAttribute("poolentariers", new Poolentarier()); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0 auto;
}

#pl_title {
	
}

.list_container {
	text-align: center;
}

.header {
	text-align: right;
	height: 40px;
}

#imgWrap {
	width: 300px;
	height: 300px;
	position: relative;
	transform-style: preserve-3d;
	perspective: 1000;
	cursor: pointer;
}

.face {
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	color: white;
	/* line-height: 200px; */
	text-align: center;
	backface-visibility: hidden;
	transition: all 1s;
}

.front {
	position: relative;
	background: red;
	z-index: 2;
	opacity: 1;
	transform: rotateY(0deg);
}

.back {
	position: absolute;
	background: green;
	z-index: 1;
	opacity: 0;
	transform: rotateY(180deg);
}

#imgWrap:hover>.front {
	z-index: 1;
	opacity: 0;
	transform: rotateY(180deg);
}

#imgWrap:hover>.back {
	z-index: 2;
	opacity: 1;
	transform: rotateY(0)
}
</style>
</head>
<body>
	<% pageContext.include("header.jsp"); %>
	<div id="pl_title">
		<h3>풀랜테리어</h3>
	</div>
	<div id="container">
		<div class="header">
			<input type="button" id="sort_new" value="최신순" /> <input
				type="button" id="sort_view" value="조회순" />
		</div>
		
		<div class="list_container" id='query'>
			<div id="imgWrap">
				<img class="face front" src="flower.jpeg">
				<div class="face back">
					<h1>제목</h1>
					<br>
					<h3>식물 이름</h3>
					<p>내용</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>