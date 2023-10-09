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