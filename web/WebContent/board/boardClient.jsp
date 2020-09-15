<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardClient.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		// 목록조회
		function boardList() {
			$.ajax("../BoardSelectAllAjaxServ", {
				dataType : "json",
				success : function(datas) {
					for (i = 0; i < datas.length; i++) {
						console.dir(datas[i])
						$("<div>").append(datas[i].no)
								.append(datas[i].poster)
								.append(datas[i].subject)
								.data("no",datas[i].no)
								.append($("<button>").html("삭제").addClass("btnDel"))
								.appendTo($("#list"))
					}
				}
			})
		}
		// 삭제버튼
		$("#list").on("click",".btnDel",function(){
			no = $(this).parent().data("no");		// 삭제할번호
			div = $(this).parent();
			$.ajax("../BoardDeleteAjaxServ", {
				method : "get",
				dataType : "json",					// 서버에서 넘겨주는 데이터타입. text, html, json 등 타입을 적어줌
				data : {no:no},						// 보낼 파라미터. 아작스함수가 값을 쿼리 문자형태(no=)로 바꿔서 넘겨줌
				success : function(data) {
					alert(data)
					div.remove();
				}
			});
		});
		
		// 저장버튼
		$("#btnSave").on("click",function(){
			$.ajax("../BoardInsertAjaxServ",{
				dataType : "json",
				data : $("form").serialize(),		// serialize()은 form태그에 있는 모든 값을 쿼리 문자로 만들어줌
				success : function(data){
					$("<div>").append(data.no)
					.append(data.poster)
					.append(data.subject)
					.data("no",data.no)
					.append($("<button>").html("삭제").addClass("btnDel"))
					.append($("#list"))
				}
				
			})
		})
		
		
		boardList();
	});
</script>
</head>
<body>
	<div data-id="4" data-goods="book" id="divid">data 연습</div>
	<!-- 목록 -->
	<div id="list"></div>
	<form>
		<input type="text" name="poster" placeholder="작성자" /> 
		<input type="text" name="subject" placeholder="제목" />
		<textarea rows="4" cols="50" name="contents" placeholder="내용"></textarea>
		<button type="button" id="btnSave"></button>
	</form>
</body>
</html>