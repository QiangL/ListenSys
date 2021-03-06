<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="zh-cn">
<head>
	<base href="<%=basePath%>">
	<title>找回密码</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid">

	<div class="row" style="margin-top:70px;">
		<form action="" method="POST" class="form-horizontal col-sm-8 col-sm-offset-2" role="form">
			<div class="form-group">
				<div class="col-sm-7 col-sm-offset-2">
					<legend>找回密码</legend>
				</div>
			</div>
			<c:if test="${not empty error }">
			<div class="alert  alert-danger text-center col-sm-8 col-sm-offset-2" role="alert">
			 ${error }
			</div>
			</c:if>
			<div class="form-group">
				<label for="userID" class="col-sm-3 control-label">用户名：</label>
				<div class="col-sm-6">
					<input type="text" name="userName" class="form-control" placeholder="" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">邮箱地址：</label>
				<div class="col-sm-4">
					<input type="email" name="email" class="form-control" placeholder="" readonly/>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-large btn-block btn-default">发送验证码</button>
				</div>
			</div>
			<div class="form-group">
				<label for="comfirCode" class="col-sm-3 control-label">验证码：</label>
				<div class="col-sm-4">
					<input type="text" name="comfirCode" class="form-control" placeholder="" />
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-large btn-block btn-default">验证</button>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">密码：</label>
				<div class="col-sm-6">
					<input type="password" name="password" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordComfir" class="col-sm-3 control-label">确认密码：</label>
				<div class="col-sm-6">
					<input type="passwordComfir" name="password" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-4">
					<button type="submit" class="btn btn-large btn-warning btn-block">确认</button>
				</div>
			</div>
		</form>
	</div>

	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>