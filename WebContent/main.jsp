<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8">
	function testButton() {
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/user/getDefaultAddress",
			data : {
				userId : "1",
			},
			dataType : "json",
			contentType : "application/json",
			success : function(json) {
				$("#queryOrderP").html(JSON.stringify(json));
			},
			error : function(json) {
				alert("error");
			}
		});
	}

	function queryButton() {
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/merchants/getMerchantsListById",
			data : {
				merchantsId : "123"
			},
			success : function(json) {
				$("#queryOrderP").html(JSON.stringify(json));
			},
			error : function(json) {
				alert("error");
			}
		});
	}
</script>
<body>
	<button id="testButton" onclick="testButton()">保存订单</button>
	<button id="testButton" onclick="queryButton()">查询订单</button>
	<p id="queryOrderP"></p>
</body>
</html>