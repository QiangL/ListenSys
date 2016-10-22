<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="zh-cn">

<head>
	<base href="<%=basePath%>">
	<title>注册</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container-fluid">
	<div class="row">
		<form action="regsiter" method="POST" class="form-horizontal col-sm-8 col-sm-offset-2" role="form">
			<div class="form-group">
				<div class="col-sm-7 col-sm-offset-2">
					<legend>注册</legend>
				</div>
			</div>
			<div class="form-group">
				<label for="studentId" class="col-sm-3 control-label">用户名：</label>
				<div class="col-sm-6">
					<input type="text" name="studentId" class="form-control" placeholder="注册后不可更改，请填写正确" />
				</div>
			</div>
			<div class="form-group">
				<label for="studentName" class="col-sm-3 control-label">姓名：</label>
				<div class="col-sm-6">
					<input type="text" name="studentName" class="form-control" placeholder="将会显示在导航栏" />
				</div>
			</div>
			<div class="form-group">
				<label for="studentClasses" class="col-sm-3 control-label">班级：</label>
				<div class="col-sm-6">
					<select class="form-control" name="studentClasses">
				<option value="0001">test</option>
			</select>
				</div>
			</div>
			<div class="form-group">
				<label for="studentEmail" class="col-sm-3 control-label">邮箱地址：</label>
				<div class="col-sm-4">
					<input type="email" name="studentEmail" class="form-control" placeholder="如果忘记密码的话需要使用该邮箱" />
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-block btn-default">发送验证码</button>
				</div>
			</div>
			<div class="form-group">
				<label for="comfirCode" class="col-sm-3 control-label">验证码：</label>
				<div class="col-sm-4">
					<input type="text" name="comfirCode" class="form-control" placeholder="" />
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-block btn-default">验证</button>
				</div>
			</div>
			<div class="form-group">
				<label for="studentPwd" class="col-sm-3 control-label">密码：</label>
				<div class="col-sm-6">
					<input type="password" name="studentPwd" class="form-control" placeholder="以字母开头，6-18位，只能包含字符、数字和下划线" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordComfir" class="col-sm-3 control-label">确认密码：</label>
				<div class="col-sm-6">
					<input type="password" name="passwordComfir" class="form-control" placeholder="以字母开头，6-18位，只能包含字符、数字和下划线" />
				</div>
			</div>
			<!--
	<div class="form-group">
		<label for="roles" class="col-sm-3 control-label">角色</label>
		<div class="col-sm-6 col-sm-offset-1">
			<div class="radio row">
				<label class="col-sm-3">
				<input type="radio" class="" name="roles"  value="student" checked="checked" />学生
			</label>
				<label class="col-sm-3">
				<input type="radio" class="" name="roles"  value="teacher" />教师
			</label>
			</div>
		</div>
	</div>
	-->
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-4">
					<button type="submit" class="btn btn-large btn-warning btn-block">注册</button>
				</div>
			</div>
		</form>
	</div>

	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>