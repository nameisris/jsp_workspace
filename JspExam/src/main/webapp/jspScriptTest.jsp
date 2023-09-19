<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
	// <%! 선언문에서 함수 정의 가능
	private String str1 = "선언문";
	private String getStr() {
		str1 += " 테스트입니다.";
		return str1;
	}
%>

<%
	// <%에서는 함수 정의 불가능
	// <%는 service 안의 자바 코드
	String str2 = "스크립틀릿 테스트입니다.";
%>
</head>
<body>
<%=getStr() %><br>
<%=str2 %>

</body>
</html>