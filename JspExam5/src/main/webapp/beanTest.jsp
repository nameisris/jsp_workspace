<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String name = request.getParameter("name");
	Integer age = Integer.parseInt(request.getParameter("age"));
	bean.Person person = new bean.Person();
	person.setName(name);
	person.setAge(age);
%> --%>
<jsp:useBean id="person" class="bean.Person">
<!--  person 객체에 name이라는 키에 name이라는 파라미터 키의 값을 넣어줌-->
	<%--
	<jsp:setProperty name="person" property="name" param="name"/>
	<jsp:setProperty name="person" property="age" param="age"/>
	--%>
	<%-- property="*"를 해주면 모든 값을 그대로 넘겨줌 --%>
	<jsp:setProperty name="person" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h3><%=person.getName() %></h3>
<h3><%=person.getAge() %></h3> --%>
<h3><jsp:getProperty property="name" name="person"/></h3>
<h3><jsp:getProperty property="age" name="person"/></h3>
</body>
</html>