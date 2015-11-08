<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="../lib/bower_components/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/aloneTwitter.css">
	<link ref="stylesheet" href="../lib/bower_components/animate.css/animate.min.css">
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
			<div class="pull-right" id="post-control-buttons">
				<button class="btn ctn-default" id="delete-post">入力欄をクリア</button>
				<button class="btn btn-primary" id="execute-post">書き込み</button>
			</div>
		</div>
	</div>
	<div id="post-content-render-block" class="container">
		<!-- rendered by json -->
	</div>


	<script src="../lib/bower_components/jquery/dist/jQuery.min.js"></script>
	<script
		src="../lib/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="../lib/bower_components/remarkable-bootstrap-notify/dist/bootstrap-notify.min.js"></script>
	<script src="../js/package.js"></script>
	<script src="../js/common/Ajax.js"></script>
	<script src="../js/twitter.js"></script>
</body>
</html>