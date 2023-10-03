<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>풀랜테리어 작성</title>
<style>
.form-control {
	width: 700px;
}

ul {
	list-style: none;
}

li {
	float: left;
	margin: 5px 10px;
}

.remove-button {
	cursor: pointer;
	color: red;
}
</style>
</head>
<body>
	<%
	pageContext.include("header.jsp");
	%>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; width: 800px; margin-top: 100px; padding: 30px; border: 1px solid #dddddd">
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
						<td>
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
						<td><input type="submit" class="btn btn-primary pull-right"
							value="저장하기" style="text-align: center;" />
						</td>
					</tr>
				</tbody>
			</table>

			<script>
				var maxTexts = 5;

				function addText() {
					var textInput = document.getElementById("textInput");
					var text = textInput.value.trim();

					if (text !== "") {
						var textList = document.getElementById("textList");

						// 현재 텍스트 개수 확인
						var existingTextCount = textList
								.getElementsByTagName("li").length;

						if (existingTextCount < maxTexts) {
							var li = document.createElement("li");
							li.innerHTML = text
									+ " <span class='remove-button' onclick='removeText(this)'>X</span>";
							textList.appendChild(li);
							textInput.value = "";
						} else {
							alert("더 이상 텍스트를 추가할 수 없습니다. 최대 " + maxTexts + "개까지만 가능합니다.");
							textInput.value = "";
						}
					}
				}

				function removeText(element) {
					var listItem = element.parentNode;
					listItem.parentNode.removeChild(listItem);
				}
			</script>
		</div>
	</div>
</body>
</html>