<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 상세</title>
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
	
	#content {
		height: 200px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#heart').click(function() {
			// 비동기 ajax통신
			$.ajax({
				url : 'like', // 서블릿 url 매핑명
				type : 'post',
				dataType : 'json',
				data : {
					'num' : '<c:out value="${board.num}"/>'
				}, // 보낼 데이터 즉 파라미터(객체타입으로 보낸다)
				success : function(res) { // db에서 가져온 데이터를 받는다. res에 담아서 여기서 반영시키는것(뷰 없이 db와 통신하는 것이 비동기방식 통신이다) (서블릿의 response.getWriter().print("success"); 코드 참고)
					console.log(res); // 서블릿의 응답코드 response.getWriter().print("...success!...");의 문자열 "...success!..."가 출력됨
					console.log(res.select);
					console.log(res.likecount);
					if(res.select) {
						$("#heart").attr("src", "image?file=full_heart.png");
					} else {
						$("#heart").attr("src", "image?file=empty_heart.png");
					}
					$("#likecount").text(res.likecount);
				},
				error : function(err) {
					console.log(err);
				}
			})
		})
	})
</script>

</head>
<body>
	<section id="./writeForm">
		<h2>게시판 글 상세</h2>
			<table border="1">
				<tr>
					<td class="td_left"><label for="writer">글쓴이</label></td>
					<td class="td_right">
						<%-- <input type="text" name="writer" id="writer" readonly="readonly" value="${board.writer }"/> --%>
						<span>${board.writer}</span>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="subject">제목</label></td>
					<td class="td_right">
						<%-- <input name="subject" type="text" id="subject" readonly="readonly" value="${board.subject}"/> --%>
						<span>${board.subject}</span>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="content">내용</label></td>
					<td>
						<%-- <textarea id="content" name="content" readonly="readonly"  cols="40" rows="15" >${board.content}</textarea> --%>
						<div id="content">${board.content}</div>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="content">이미지</label></td>
					<td>
						<c:if test="${board.fileurl ne null }">
							<img src="image?file=${board.fileurl}" width="100px" height="100px"/>
						</c:if>
					</td>
				</tr>
			
			</table>
			<section id="commandCell">
				<c:if test="${user.id eq board.writer }">
					<a href="boardmodify?num=${board.num}">수정</a>&nbsp;&nbsp;
				</c:if>
				<a href="boardlist">목록</a>&nbsp;&nbsp;
				좋아요(<span id="likecount">${board.likecount}</span>)&nbsp;&nbsp;&nbsp;
				<c:if test="${user ne Empty}">
					<c:choose>
						<c:when test="${select==true}">
							<img src="image?file=full_heart.png" width="20px" height="20px" id="heart"/>
						</c:when>
						<c:otherwise>
							<img src="image?file=empty_heart.png" width="20px" height="20px" id="heart"/>
						</c:otherwise>
					</c:choose>
				</c:if>
			</section>
	</section>
</body>
</html>