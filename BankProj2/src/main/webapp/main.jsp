<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% pageContext.include("header.jsp"); %>
<%
	// page란 파라미터 값을 가져옴
	// 다만, localhost:8090/BankProj/main과 같이 파라미터가 없는 경우가 있음(null)
	String ipage = (String) request.getAttribute("page");
%>
</body>
</html>