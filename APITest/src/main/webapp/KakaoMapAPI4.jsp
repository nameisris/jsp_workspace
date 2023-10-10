<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div id="map" style="width: 100%; height: 350px;"></div>
	<p>
		<button onclick="selectOverlay('MARKER')">마커</button>
		<button onclick="selectOverlay('POLYLINE')">선</button>
		<button onclick="selectOverlay('CIRCLE')">원</button>
		<button onclick="selectOverlay('RECTANGLE')">사각형</button>
		<button onclick="selectOverlay('POLYGON')">다각형</button>
	</p>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4a22a67c361ae1871a1a0166dd96f3df&libraries=drawing"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);

		var options = { // Drawing Manager를 생성할 때 사용할 옵션입니다
			map : map, // Drawing Manager로 그리기 요소를 그릴 map 객체입니다
			drawingMode : [ // drawing manager로 제공할 그리기 요소 모드입니다
			kakao.maps.drawing.OverlayType.MARKER,
					kakao.maps.drawing.OverlayType.POLYLINE,
					kakao.maps.drawing.OverlayType.RECTANGLE,
					kakao.maps.drawing.OverlayType.CIRCLE,
					kakao.maps.drawing.OverlayType.POLYGON ],
			// 사용자에게 제공할 그리기 가이드 툴팁입니다
			// 사용자에게 도형을 그릴때, 드래그할때, 수정할때 가이드 툴팁을 표시하도록 설정합니다
			guideTooltip : [ 'draw', 'drag', 'edit' ],
			markerOptions : { // 마커 옵션입니다 
				draggable : true, // 마커를 그리고 나서 드래그 가능하게 합니다 
				removable : true
			// 마커를 삭제 할 수 있도록 x 버튼이 표시됩니다  
			},
			polylineOptions : { // 선 옵션입니다
				draggable : true, // 그린 후 드래그가 가능하도록 설정합니다
				removable : true, // 그린 후 삭제 할 수 있도록 x 버튼이 표시됩니다
				editable : true, // 그린 후 수정할 수 있도록 설정합니다 
				strokeColor : '#39f', // 선 색
				hintStrokeStyle : 'dash', // 그리중 마우스를 따라다니는 보조선의 선 스타일
				hintStrokeOpacity : 0.5
			// 그리중 마우스를 따라다니는 보조선의 투명도
			},
			rectangleOptions : {
				draggable : true,
				removable : true,
				editable : true,
				strokeColor : '#39f', // 외곽선 색
				fillColor : '#39f', // 채우기 색
				fillOpacity : 0.5
			// 채우기색 투명도
			},
			circleOptions : {
				draggable : true,
				removable : true,
				editable : true,
				strokeColor : '#39f',
				fillColor : '#39f',
				fillOpacity : 0.5
			},
			polygonOptions : {
				draggable : true,
				removable : true,
				editable : true,
				strokeColor : '#39f',
				fillColor : '#39f',
				fillOpacity : 0.5,
				hintStrokeStyle : 'dash',
				hintStrokeOpacity : 0.5
			}
		};

		// 위에 작성한 옵션으로 Drawing Manager를 생성합니다
		var manager = new kakao.maps.drawing.DrawingManager(options);

		// 버튼 클릭 시 호출되는 핸들러 입니다
		function selectOverlay(type) {
			// 그리기 중이면 그리기를 취소합니다
			manager.cancel();

			// 클릭한 그리기 요소 타입을 선택합니다
			manager.select(kakao.maps.drawing.OverlayType[type]);
		}
	</script>
</body>
</html>