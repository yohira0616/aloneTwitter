<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache">
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
			<textarea class="form-control" id="tweet-contents"></textarea>
			<div class="pull-right">
				<button class="btn ctn-default" id="delete-post">入力欄をクリア</button>
				<button class="btn btn-primary" id="execute-post">書き込み</button>
			</div>
		</div>
	</div>
	<div id="post-content-render-block" class="container">
		<!-- sample -->
		<div class="panel panel-default" data-postId="1">
			<div class="panel-body">
				<div class="post-contents">書き込み内容を表示</div>
			</div>
			<div class="panel-footer">
				<span class="post-date">書き込み日時を表示</span> <a href="#"
					class="post-delete"><i
					class="glyphicon glyphicon-trash pull-right"> </i></a>
			</div>
		</div>
	</div>

	<!-- alerts-->

	<script src="../lib/bower_components/jquery/dist/jQuery.min.js"></script>
	<script
		src="../lib/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../js/package.js"></script>
	<script src="../js/common.Ajax.js"></script>
	<script src="../js/twitter.js"></script>
</body>
</html>