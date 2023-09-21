<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	// page란 파라미터 값을 가져옴
	// 다만, localhost:8090/BankProj/main과 같이 파라미터가 없는 경우가 있음(null)
	String ipage = (String) request.getAttribute("page");
%>

<table style="width: 100%">
	<thead>
		<tr>
			<td>
				<%-- <% pageContext.include("header.jsp"); %> --%>
				<jsp:include page="header.jsp"/>
			</td>
		</tr>
	</thead>
	<%if(ipage!=null) {%>
	<tbody>
        <tr>
            <td>
            	<jsp:include page='<%=ipage + ".jsp" %>'/>
            	<%--
            	<%
					// 즉, 파라미터 값이 있을 경우(null이 아닐 경우)
					// 지정한 상대경로 페이지를 현재 JSP 페이지에 포함(덧붙여줌)
					if(ipage!=null) {
	           			pageContext.include(ipage + ".jsp");
	           		}
				%>
            	 --%>
            </td>
        </tr>
        <tr>
        	<td>
        		<jsp:include page="footer.jsp"/>
        	</td>
        </tr>
    </tbody>
    <%}%>
</table>

</body>
</html>