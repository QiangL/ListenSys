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
	<title>录音上传</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid">
<%@include file="stu_nav.jsp" %>
	<!-- 录音文件上传区-->
	<div style="margin-top:70px;">
		<form action="" enctype="multipart/form-data" method="POST" class="form-horizontal col-sm-8 col-sm-offset-2" role="form">
			<div class="form-group">
				<legend>录音上传</legend>
			</div>
			<c:if test="${not empty error }">
			<div class="alert  alert-danger text-center col-sm-8 col-sm-offset-2" role="alert">
			 ${error }
			</div>
			</c:if>
			<c:if test="${not empty success }">
			<div class="alert  alert-success text-center col-sm-8 col-sm-offset-2" role="alert">
			 ${success }
			</div>
			</c:if>
			<div class="form-group">
				<label for="record" class="control-label col-sm-3">选择录音文件：</label>
				<div class="col-sm-2">
					<input type="file" name="record" accept="">
				</div>
			</div>
			<div class="form-group">
				<label for="folder" class="control-label col-sm-3">选择上传文件夹：</label>
				<div class="col-sm-5">
					<select name="folder" class="form-control">
							<option value="1">test</option>
						</select>
				</div>
			</div>
			<!-- 希望用个进度条 -->
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3">
					<button type="submit" class="btn btn-block btn-lg btn-primary">上传</button>
				</div>
			</div>
		</form>

	</div>
	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>