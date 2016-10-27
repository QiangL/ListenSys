<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html lang="zh-cn">

<head>
	<title>录音列表</title>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container-fluid">
<%@include file="tea_nav.jsp" %>
	<!--文件夹列表 -->
	<!-- 希望变成侧边栏 -->
	<div class="dropdown">
		<button class="btn btn-block dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			文件夹列表
			<span class="caret"></span>
		</button>
		<ul class="row list-unstyled dropdown-menu" style="width:100%">
			<li class="col-sm-2 col-sm-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">文件夹名称</div>
					<div class="panel-body">
						文件夹描述
					</div>
				</div>
			</li>
			<li class="col-sm-2">
				<div class="panel panel-default">
					<div class="panel-heading">文件夹名称</div>
					<div class="panel-body">
						文件夹描述
					</div>
				</div>
			</li>
			<li class="col-sm-2">
				<div class="panel panel-default">
					<div class="panel-heading">文件夹名称</div>
					<div class="panel-body">
						文件夹描述
					</div>
				</div>
			</li>
			<li class="col-sm-2">
				<div class="panel panel-default">
					<div class="panel-heading">文件夹名称</div>
					<div class="panel-body">
						文件夹描述
					</div>
				</div>
			</li>
			<li class="col-sm-2">
				<div class="panel panel-default">
					<div class="panel-heading">文件夹名称</div>
					<div class="panel-body">
						文件夹描述
					</div>
				</div>
			</li>
		</ul>
	</div>
	<!-- 班级中每个人的录音 -->

	<div class="panel panel-default">
		<div class="panel-heading">
			某班某文件夹录音
			<span class="pull-right">顺序播放</span>
		</div>
		<div class="panel-body">
			<ul class="row list-unstyled">
				<li class="col-md-2 col-sm-5">
					<!-- 这里希望使用一个hover实现效果 滑过显示播放按钮，点击播放-->
					<!-- 还要增加是否播放过、评分 -->
					<div class="panel panel-default">
						<div class="panel-body">
							<h5>李强</h5>
							<span>201493106</span>
							<p>上传时间</p>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>

	<!-- 底部的播放条 -->
	<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
		<a class="navbar-brand" href="#">图片</a>

		<form class="navbar-form">
			<div class="nav navbar-nav btn-group pull-right">
				<button class="btn btn-default" type="button">上一个</button>
				<button class="btn btn-default" type="button">暂停/播放</button>
				<button class="btn btn-default" type="button">下一个</button>
			</div>
			<!-- 这里希望有一个评分星星的效果 -->
			<div class="start"></div>
		</form>
		<textarea class="form-control" rows="1" cols="10" placeholder="在这里输入评价"></textarea>
	</nav>


	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>