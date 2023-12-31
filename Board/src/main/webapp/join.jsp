<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <style>
        body {
            margin: 0 auto;
            
        }

        .container {
            padding: 10px;
            border: 1px solid;
            width: 300px;
        }

        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            width: 70px;
            float: left;
            font-weight: bold;
        }

        .input {
            float: left;
        }

        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgrey;
        }
    </style>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function() {
		let isIdCheck = false; // 중복 체크 확인 여부 변수 (중복 체크를 성공했다면 true로 변경)
		$("#idcheck").click(function() {
			$.ajax({
				url : "idcheck",
				type : "post",
				data : {id:$("#id").val()},
				success : function(res) {
					console.log(res);
					if(res=="notexist") {
						isIdCheck = true;
						console.log("isIdCheck 값 :  " + isIdCheck);
						alert("사용 가능합니다.");
					} else {
						alert("아이디가 중복됩니다.");
					}
				},
				error : function(err) {
					console.log(err);
					alert("아이디 중복체크 오류");
				}
			})
		})
		
		$("#id").change(function() {
			isIdCheck = false;
		})
		
		$("#form").submit(function(e) {
			if(isIdCheck==false) {
				alert("아이디 중복체크를 하세요.");
				e.preventDefault();		
			}
		})
	})
</script>
</head>
<body>
<center>
        <div class="header">
            <h3>회원가입</h3>
        </div>
        <div class="container" id='query'>
            <form id='form' action="join" method="post">
                <div class="row">
                    <div class="title">아이디</div>
                    <div class="input"><input type="text" name="id" id="id" required="required"></div>
                    <div><input type="button" id="idcheck" value="중복"></div>                    
                </div>
                <div class="row">
                    <div class="title">이름</div>
                    <div class="input"><input type="text" name="name" required="required"></div>
                </div>
                <div class="row">
                    <div class="title">비밀번호</div>
                    <div class="input"><input type="password" name="password" required="required"></div>
                </div>
                <div class="row">
                    <div class="title">이메일</div>
                    <div class="input"><input type="text" name="email"></div>
                </div>
                <div class="row">
                    <div class="title">주소</div>
                    <div class="input"><input type="text" name="address"></div>
                </div>
                <div class="button">
                    <input type="submit" value="회원가입">
                </div>
            </form>
        </div>	
</center>
</body>
</html>