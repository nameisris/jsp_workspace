<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style>
* { margin: 0 auto; }

a { text-decoration: none; }

.outerDiv {
   width: 100%;
   height: 100px;
   background-color: #466B55;
}

</style>
<div class="outerDiv">
    <h1 style="text-align: center;">풀풀</h1>
    <div class="container">
		<div style="text-align:left; margin-left: 10px;">
       		<a href="searchflowerlist">꽃검색</a>&nbsp;&nbsp;
       		<a href="poolentarierlist">풀랜테리어</a>&nbsp;&nbsp;
       		<a href="drfoolpoollist">풀풀박사</a>&nbsp;&nbsp;
       		<a href="noticelist">공지</a>&nbsp;&nbsp;
    	</div>
    	
    	<div style="float:right; margin-right: 10px;">
        	<a href="join">회원가입</a>&nbsp;&nbsp;
    		<c:choose>
    			<c:when test="${user eq Empty }">
    				<a href="login">로그인</a>&nbsp;&nbsp;
    			</c:when>
    			<c:otherwise>
    				${user.id }님 환영합니다.&nbsp;&nbsp;<a href="logout">로그아웃</a>&nbsp;&nbsp;
    			</c:otherwise>
    		</c:choose>
    	</div>
    </div>
</div>