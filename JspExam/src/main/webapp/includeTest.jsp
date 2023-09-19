<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 다른 jsp 파일을 현 jsp에 삽입하여 사용 (ex: 모든 페이지에 공통되는 부분) --%>
	<%@ include file="header.jsp" %>
	<h1>includeTest.jsp 파일 내용입니다.</h1>
	<%@ include file="footer.jsp" %>
</body>
</html>