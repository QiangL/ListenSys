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
	<title>修改信息</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid">
<%@include file="tea_nav.jsp" %>
	<div class="row" style="margin-top:70px;">
		<form action="" method="POST" class="form-horizontal col-sm-8 col-sm-offset-2" role="form">
			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-2">
					<legend>修改信息</legend>
				</div>
			</div>
			<c:if test="${not empty error }">
			<div class="alert  alert-danger text-center col-sm-8 col-sm-offset-2" role="alert">
			 ${error }
			</div>
			</c:if>
			<div class="form-group">
				<label for="teacherId" class="col-sm-3 control-label">用户名：</label>
				<div class="col-sm-6">
					<input type="text" name="teacherId" class="form-control" value="${teacher.getTeacherId() }" readonly/>
					<span class="help-block">以上信息用于标识您的身份，不可更改</span>
				</div>
			</div>
			<div class="form-group">
				<label for="teacherName" class="col-sm-3 control-label">姓名</label>
				<div class="col-sm-6">
					<input type="text" name="teacherName" class="form-control" value="${teacher.getTeacherName() }" />
				</div>
			</div>
			<div class="form-group">
				<label for="teacherEmail" class="col-sm-3 control-label">邮箱地址：</label>
				<div class="col-sm-6">
					<input type="email" name="teacherEmail" class="form-control" value="${teacher.getTeacherEmail() }"/>
				</div>
			</div>
			<!-- 增加上传头像的功能-->
			<div class="form-group">
				<label for="teacherPwd" class="col-sm-3 control-label">原始密码：</label>
				<div class="col-sm-6">
					<input type="password" name="teacherPwd" class="form-control" placeholder="每一次修改都需要填写原始密码哦" />
				</div>
			</div>
			<div class="form-group">
				<label for="password2" class="col-sm-3 control-label">修改密码：</label>
				<div class="col-sm-6">
					<input type="password" name="password2" class="form-control" placeholder="若无修改，无需填写；密码需以字母开头，6-18位，只能包含字符、数字和下划线" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordComfir" class="col-sm-3 control-label">确认修改密码：</label>
				<div class="col-sm-6">
					<input type="password" name="passwordComfir" class="form-control" placeholder="若无修改，无需填写；密码需以字母开头，6-18位，只能包含字符、数字和下划线" />
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