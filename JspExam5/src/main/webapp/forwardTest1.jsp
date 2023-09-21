<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("tel", "034-1234-5678");
	pageContext.forward(request.getParameter("forwardPage"));
%>
 --%>
<% request.setCharacterEncoding("utf-8"); %>
<%--jsp:forward는 하나의 JSP 페이지에서 다른 JSP 페이지로 요청 처리를 전달할 때 사용 --%>
<%--jsp:param는 forward 및 include 태그에 데이터 전달을 목적으로 사용되는 태그 --%>
<%-- name과 value로 이루어짐 --%>
<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
	<jsp:param name="tel" value="034-1234-5678"/>
</jsp:forward>