<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("test", "Request Test");
	request.setAttribute("nickname", "홍홍");
%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=session.getAttribute("test") %></h3>
<h3>${ sessionScope.test }</h3>
<h3>${ requestScope.test }</h3>
<!-- session과 request에서 전부 동일한 이름을 가져올 경우, 가까운 것을 가져옴 -->
<h3>${ test }</h3>
<h3>${ nickname }</h3>
<h3>${ param.name }</h3>
</body>
</html>