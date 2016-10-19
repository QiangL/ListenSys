<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html lang="zh-cn">

<head>
	<title>登录</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container-fluid">
	<div class="row" style="position:relative;top:110px;">
		<form action="" method="POST" class="form-horizontal col-sm-8 col-sm-offset-2" role="form">
			<div class="form-group">
				<div class="col-sm-7 col-sm-offset-2">
					<legend>登录</legend>
				</div>
			</div>
			<div class="form-group">
				<label for="userId" class="col-sm-3 control-label">用户名：</label>
				<div class="col-sm-6">
					<input type="text" name="userId" class="form-control" placeholder=""/>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">密码：</label>
				<div class="col-sm-6">
					<input type="password" name="password" class="form-control" placeholder=""/>
					<span  class="help-block pull-right"><a href="">忘记密码</a></span>
				</div>
			</div>
			<div class="form-group">
				<label for="roles" class="col-sm-3 control-label">角色:</label>
				<div class="col-sm-6 col-sm-offset-2">
					<div class="radio row">
						<label class="col-sm-3">
						<input type="radio" class="" name="roles"  value="student" checked="checked"/>学生
					</label>
						<label class="col-sm-3">
						<input type="radio" class="" name="roles"  value="teacher"/>教师
					</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-3">
					<button type="submit" class="btn btn-large btn-primary btn-block">登录</button>
				</div>
				<div class="col-sm-3">
					<button type="button" class="btn btn-large btn-block btn-warning">去注册</button>
				</div>
			</div>
		</form>
	</div>

	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>