<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/menubar.jsp" %>

			<div class="poolentarierLabel">풀랜테리어</div>
			<div class="poolentarierDicLine">
            	<div class="poolentarierTopBorder"></div>
				<div class="row">
					<table class="table table-striped">
						<thead>
							<tr>
								<th colspan="2"
									style="background-color: #eeeeee; text-align: center;"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" class="form-control"
									placeholder="제목" name="boardTitle" maxlength="50" /></td>
							</tr>
							<tr>
								<td>
									<textarea class="form-control" placeholder="본문"
										name="boardContent" maxlength="3000" style="height: 350px;"></textarea>
								</td>
							</tr>
							<tr>
								<td>
									사진 선택: <input type="file" name="photo"><br>
								</td>
							</tr>
							<tr>
								<td style="height: 40px;">
									<ul id="textList">
										<!-- 여기에 추가된 텍스트가 나타납니다. -->
									</ul>
								</td>
							</tr>
							<tr>
								<td>
									<input type="text" id="textInput" placeholder="키워드 입력">
									<button onclick="addText()">추가</button>
								</td>
							</tr>
							<tr>
								<td><input type="submit" class="btn btn-primary pull-right" value="저장하기"/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="poolentarierBottomBorder"></div>
			</div>
		</div>
	</div>
</body>
</html>