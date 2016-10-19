<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="zh-cn">

<head>
	<base href="<%=basePath%>">
	<title>修改信息</title>

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
					<legend>修改信息</legend>
				</div>
			</div>
			<div class="form-group">
				<label for="studentId" class="col-sm-3 control-label">用户名：</label>
				<div class="col-sm-6">
					<input type="text" name="studentId" class="form-control" placeholder="" readonly/>
					<span class="help-block">以上信息用于标识您的身份，不可更改</span>
				</div>
			</div>
			<div class="form-group">
				<label for="studentName" class="col-sm-3 control-label">姓名</label>
				<div class="col-sm-6">
					<input type="text" name="studentName" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<label for="studentEmail" class="col-sm-3 control-label">邮箱地址：</label>
				<div class="col-sm-6">
					<input type="email" name="studentEmail" class="form-control" placeholder="" />

				</div>
			</div>
			<div class="form-group">
				<label for="classesId" class="col-sm-3 control-label">班级：</label>
				<div class="col-sm-6">
					<select class="form-control" name="classesId">
						<option value="0">test</option>
					</select>
				</div>
			</div>
			<!-- 增加上传头像的功能-->
			<div class="form-group">
				<label for="studentPwd" class="col-sm-3 control-label">原始密码：</label>
				<div class="col-sm-6">
					<input type="password" name="studentPwd" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<label for="password2" class="col-sm-3 control-label">修改密码：</label>
				<div class="col-sm-6">
					<input type="password" name="password2" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordComfir" class="col-sm-3 control-label">确认修改密码：</label>
				<div class="col-sm-6">
					<input type="password" name="passwordComfir" class="form-control" placeholder="" />
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