

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>留言板</title>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var pageNum = "${p}"
		var maxPage = "${maxPage}"
		$("input[value='上一页']").click(function() {
			pageNum = pageNum == 1 ? 1 : pageNum - 1;
			location.href = "show?p=" + pageNum;
		});
		$("input[value='下一页']").click(
				function() {
					pageNum = parseInt(pageNum) == maxPage ? maxPage
							: parseInt(pageNum) + 1;
					location.href = "show?p=" + pageNum;
				});

	});
</script>
<style>
div {
	margin: 0;
	padding: 0;
	font-size: 12px;
	margin: 0 auto;
}

h3 {
	text-align: center
}

#container {
	width: 500px;
}

.article {
	border: 1px solid #a6cbe7;
	margin-top: 5px;
}

.author {
	background-color: #0099FF;
	width: 100%;
	height: 24px;
	line-height: 24px;
}

.content {
	height: 40px;
	padding: 10px;
}

.author span {
	float: right;
	padding-right: 10px;
}

.time {
	border-top: solid 1px #a6cbe7;
}

.page {
	text-align: right;
	height: 30px;
	line-height: 30px;
	padding-right: 10px;
}
</style>

</head>

<body>
	<div id="container">
		<div>
			<h3>留言板</h3>
		</div>
		<form action="SearchServlet" method="post">
		<div>
			标题：<input type="text" name="title" size="55"><br> 起始时间：<input
				type="date" name="beginTime">结束时间：<input type="date"
				name="endTime"><input type="submit" value="提交">
		</div>
		</form>
		<c:forEach items="${mesList}" var="mes">
			<div>
				<div class="article">
					<div class="author">
						用户:${mes.name}<span>${mes.id}#</span>
					</div>
					<div class="content">${mes.content}</div>
					<div class="time page">
						发表于:
						<fmt:formatDate value="${mes.date}" pattern="yyyy-MM-dd" />
					</div>
				</div>

			</div>
		</c:forEach>
		<div class="page">
			<input class="btn1" type="button" value="上一页" onclick=""> <input
				class="btn1" type="button" value="下一页">
		</div>
		<br>
		<div>
			<form action="InsertServlet" method="post">

				<input type="hidden" name="id" value="${mes.id}"> <input
					type="hidden" name="max" value="${maxPage}">
				<div>
					用户: <input type="text" name="author" value="" />
				</div>
				<br>
				<div>
					留言:
					<textarea name="message" rows="5" cols="72"></textarea>
				</div>
				<div align="center">
					<input type="reset" value="清除" /> <input type="submit" value="发表" />
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>
