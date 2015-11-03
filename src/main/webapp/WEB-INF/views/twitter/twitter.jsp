<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="../lib/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="../css/style.css"> -->
<title>Alone Twitter</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>${appTitle}</h1>
		</div>
	</div>
	<div class="container">
		<div class="form-group">
			<textarea class="form-control"></textarea>
			<div class="pull-right">
				<button class="btn ctn-default">入力欄をクリア</button>
				<button class="btn btn-primary">書き込み</button>
			</div>
		</div>
	</div>
	<div id="post-content-render-block" class="container">
		<!-- sample -->
		<div class="panel panel-default" data-postId="1">
			<div class="panel-body">書き込み内容を表示</div>
			<div class="panel-footer">
				書き込み日時を表示 <i class="glyphicon glyphicon-trash pull-right"> </i>
			</div>
		</div>
	</div>

	<script src="../lib/bower_components/jquery/dist/jQuery.min.js"></script>
	<script
		src="../lib/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>