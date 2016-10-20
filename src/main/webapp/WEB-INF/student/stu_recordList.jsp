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
	<title>录音列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid">

<c:forEach items="${recordList }" var="tmp">
      ${tmp.getId()}
</c:forEach>

	<!-- 文件夹display -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>过往录音</h3>
		</div>
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>文件夹</th>
					<th>上传时间</th>
					<th>分数</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>example</td>
					<td>example</td>
					<td>example</td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- 录音列表 -->
	<div>
		<ul class="media-list">
			<!-- 文件夹列表-->
			<li class="media">
				<a href="#" class="media-left">
					<img src="" alt="">
				</a>
				<div class="media-body">
					<h4 class="media-heading">fold Name</h4>
					<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio,
						vestibulum in vulputate at, tempus viverra turpis.Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
						ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.Cras sit amet nibh libero,
						in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
						tempus viverra turpis.</p>
					<!-- 录音列表 -->
					<div class="media">
						<a href="" class="media-left"><img src="" alt=""></a>
						<div class="media-body">
							<h5 class="media-heading">record Name</h5>
							<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio,
								vestibulum in vulputate at, tempus viverra turpis.Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
								ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.</p>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>

	<!--import js of bootstrap and jQ must!-->
	<script src="js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>