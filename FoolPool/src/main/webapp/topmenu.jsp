<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<style>
body {
	min-height: 100vh; /* A1. 최소 높이를 뷰포트(브라우저 화면 영역) 높이로 설정 */
	margin: 0;
	padding: 0;
	background-color: #466B55;
	display: flex;
	justify-content: center; /* 수평 가운데 정렬 */
	align-items: center; /* 수직 가운데 정렬 */
}

* {
	margin: 0px;
	padding: 0px;
}

.container {
	max-width: 1440px;
	min-height: 90vh; /* A2. 최소 높이를 뷰포트(브라우저 화면 영역) 높이의 90%로 설정 */
	background-color: #F6F5F8;
	border-radius: 15px;
	width: 100%;
	padding: 20px;
}

:root { -
	-accent-color: #f3ff87; -
	-text-color: #466b55; -
	-background-color: #fff;
}

.body {
	margin: 0;
	font-family: 'Montserrat';
}

a {
	text-decoration: none;
	color: var(- -text-color);
}

.navbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: var(- -background-color);
	padding: 8px 12px;
}

.nav_logo {
	font-size: 24px;
	color: var(- -text-color);
}

.nav_logo i {
	color: var(- -accent-color);
}

.nav_logo span {
	color: var(- -accent-color);
}

.nav_menu {
	position: absolute;
	display: flex;
	list-style: none;
	margin-top: 20px;
	text-color: #466b55;
	border: 1px;
	padding-left: 0;
}

.nav_menu li {
	padding: 8px 12px;
}

.nav_menu li:hover {
	color: var(- -background-color);
	background-color: var(- -accent-color);
	border-radius: 4px;
}

.nav_menu li a:hover {
	color: var(- -background-color);
}

.nav_icons {
	display: flex;
	color: #7dc0ff;
	list-style: none;
	padding-left: 0;
}

.nav_icons li {
	padding: 8px 5px;
}

.join {
	position: relative;
	display: flex;
	list-style: none;
	margin-top: 20px;
	text-color: #466b55;
	border: 1px;
	padding-left: 0;
}

.join li {
	padding: 8px 12px;
}

</style>
<body>
	<div class="container">
		<nav class="navbar">
			<div class="nav_logo">
				<i class="fa-solid fa-star"></i> <a href=""></a>
			</div>
			<ul class="nav_menu">
				<li><a href="">꽃검색</a></li>
				<li><a href="">풀랜테리어</a></li>
				<li><a href="">풀풀박사</a></li>
				<li><a href="">공지사항</a></li>
			</ul>
			<ul class="join">
				<li><a href="">회원가입</a></li>
				<li><a href="">로그인</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>