<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="zh-cn">
<head>
	<base href="<%=basePath%>">
	<title></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid">
		<!-- 导航栏 -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="collapsed navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-top">
					<span class="sr-only">切换下拉导航</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">userName</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-top">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="#">录音打分</a>
					</li>
					<!-- 希望加一个图表统计分析 -->
					<li>
						<a href="#">修改信息</a>
					</li>
				</ul>
				<div class="navbar-right">
					<button class="btn btn-default btn-block navbar-btn">登出</button>
				</div>
			</div>
		</div>
	</nav>
	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>