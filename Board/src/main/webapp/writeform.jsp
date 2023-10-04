<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 등록</title>
<style type="text/css">
h2 {
   text-align: center;
}
table {
   margin: auto;
   width: 450px;
}
.td_left {
   width: 150px;
   background: orange;
}
.td_right {
   width: 300px;
   background: skyblue;
}
#commandCell {
   text-align: center;
}
</style>
</head>
<body>
   <section id="./writeForm">
      <h2>게시판 글 등록</h2>
      <%--
      1. 
      <form action="/boardwrite"로 하면 context root를 빼고 포트번호 뒤에 url매핑을 붙여버림
      <form action="boardwrite"로 한 것은 ./boardwrite와 같으므로 문제 없이 서블릿을 찾아감
      2. 
      form태그 안에서 파일업로드하고 싶으면 반드시 enctype="multipart/form-data"해야함
       --%>
      <form action="./boardwrite" method="post" enctype="multipart/form-data" name="boardform">
         <table>
            <tr>
               <td class="td_left"><label for="writer">글쓴이</label></td>
               <td class="td_right"><input type="text" name="writer"
                  id="writer" readonly="readonly" value="${user.name }" /></td>
               <%-- 세션에 있는 닉네임을 자동으로 넣어주고 읽기전용으로 함 --%>
            </tr>
            <tr>
               <td class="td_left"><label for="subject">제목</label></td>
               <td class="td_right"><input name="subject" type="text"
                  id="subject" required="required" /></td>
            </tr>
            <tr>
               <td class="td_left"><label for="content">내용</label></td>
               <td><textarea id="content" name="content"
                     cols="40" rows="15" required="required"></textarea></td>
            </tr>
            <tr>
               <td class="td_left"><label for="file">이미지 파일 첨부</label></td>
               <td class="td_right"><input name="file" type="file"
                  id="file" accept="image/*"/></td>
               <%-- 3. 파일 선택할때 이미지파일만 선택가능하게함 accept="image/*" --%>   
            </tr>
         </table>
         <section id="commandCell">
            <input type="submit" value="등록">&nbsp;&nbsp; <input
               type="reset" value="다시쓰기" />
         </section>
      </form>
   </section>
</body>
</html>