<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style type="text/css">
h3, h5 {
	text-align: center;
}

table {
	margin: auto;
	width: 800px
}

#tr_top {
	background: orange;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 800px;
	text-align: center;
}

#emptyArea a {
	display: inline-block;
	width: 20px;
	height: 20px;
	text-decoration: none;
}

#emptyArea .btn {
	background: lightgray;
}

#emptyArea .select {
	background: lightblue;
}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
	/* onclick="callBtn"인 a태그를 가지는 페이징에 대해, id가 searchform인 form을 호출하지만, return은 onclick이 포함된 곳에서 처리 */
	function callBtn(num) {
		var keyword = $("#keyword").val();
		if(keyword!=null && keyword.trim()!='') {
			$('#page').val(num);
			$('#searchform').submit();
		}	
	}
</script>
</head>
<body>

	<h3>글 목록&nbsp;&nbsp;
		<%-- 로그인 상태에서만 글쓰기 버튼 보이게함 --%>
		<c:if test="${user ne Empty }">
			<a href="boardwrite">글쓰기</a>
		</c:if>
	</h3>
	<form action="./boardsearch" method="post" id="searchform">
		<input type="hidden" name="page" id="page" value="1">
		<h5>
			<select name="type">
				<option value="all">선택</option>
				<option value="subject" ${res.type eq 'subject'? 'selected':''}>제목</option>
				<option value="writer" ${res.type eq 'writer'? 'selected':''}>작성자</option>
				<option value="content" ${res.type eq 'content'? 'selected':''}>내용</option>
			</select>
			<input type="text" name="keyword" id="keyword" value="${res.keyword}"/>
			<input type="submit" value="검색" />
		</h5>
	</form>
	<table>
		<tr id="tr_top">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<td>삭제</td>
		</tr>

		<%-- res는 서블릿에서 request에 담아 넘긴 Map객체로, PageInfo객체와 BoardList객체가 벨류로 담겨있다 --%>
		<c:forEach items="${res.boardList }" var="board">
			<tr>
				<td>${board.num }</td>
				<td><a href="boarddetail?num=${board.num }">${board.subject }</a></td>
				<td>${board.writer }</td>
				<td>${board.writedate }</td>
				<td>${board.viewcount }</td>

				<%-- 작성자 본인일때만 삭제 버튼 노출 --%>
				<td><c:if test="${user.id == board.writer }">
						<a
							href="boarddelete?num=${board.num}&page=${res.pageInfo.curPage}">삭제</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>



	<%-- 페이징 영역--%>
	<div id="emptyArea">
		<c:choose>
			<c:when test="${res.pageInfo.curPage>1 }">
				<a href="boardlist?page=${res.pageInfo.curPage-1}">&lt;</a>
			</c:when>
			<c:otherwise>
               &lt;
            </c:otherwise>
		</c:choose>


		<%--startPage번호부터 endPage번호까지 돌면서 번호를 출력 --%>
		<c:forEach begin="${res.pageInfo.startPage}" end="${res.pageInfo.endPage}" var="i">
			<c:choose>
				<c:when test="${res.pageInfo.curPage==i}">
					<%-- callBtn에 대한 return 처리를 callBtn에서 하지 않고, 호출한 이곳에서 return --%>
					<a href="boardlist?page=${i}" class="select" onclick="callBtn(${i});return ${res.keyword==null};">${i}</a>&nbsp;
	         	</c:when>
				<c:otherwise>
					<a href="boardlist?page=${i}" class="btn" onclick="callBtn(${i});return ${res.keyword==null};">${i}</a>&nbsp;
	         	</c:otherwise>
			</c:choose>
		</c:forEach>



		<c:choose>
			<c:when test="${res.pageInfo.curPage<res.pageInfo.allPage }">
				<a href="boardlist?page=${res.pageInfo.curPage+1}">&gt;</a>
			</c:when>
			<c:otherwise>
               &gt;
            </c:otherwise>
		</c:choose>
	</div>
</body>
</html>