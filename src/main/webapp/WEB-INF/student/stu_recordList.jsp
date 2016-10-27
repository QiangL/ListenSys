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

<%@include file="stu_nav.jsp" %>
	<!-- 文件夹display -->
<div class="panel panel-default">
		<div class="panel-heading">
			<h3>过往录音</h3>
		</div>
		<table class="table table-hover table-condensed text-center">
			<thead>
				<tr>
					<th class="text-center">文件夹</th>
					<th class="text-center">文件名</th>
					<th class="text-center">分数</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${recordMap}" var="record">
				<c:forEach items="${record.value }" var="sound">
					<tr>
					<td>${record.key.getFolderName() }</td>
					<td>${sound.getName() }</td>
					<td>${sound.getPoints() }</td>
				</tr>
				</c:forEach>
			</c:forEach>
			<!--
				//对每一个Map的Folder进行迭代
				//对每个Folder的Sound进行迭代
				//对每个增加一个处理事件
				//对于每个处理事件，得到folder的id以及下面各个sound的id，然后ajax到后台，返回数据，填充录音列表
			-->
			</tbody>
		</table>
	</div>

	<!-- 录音列表 -->
	<div class="recordDetail">
		<ul class="media-list">
			<!-- 文件夹列表-->
			<li class="media">
				<a  class="media-left">//这里是一个文件夹图标
					<img src="" alt="">
				</a>
				<div class="media-body">
					<h4 class="media-heading" id="folderName">fold Name</h4>//这一行向下的folder部分，是js请求返回的一个folder对象
					<p id="folderDescription">Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio,
						vestibulum in vulputate at, tempus viverra turpis.Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
						ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.Cras sit amet nibh libero,
						in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
						tempus viverra turpis.</p>
					<!-- 录音列表
					//这里向下是js返回回来的一个folder下的多个sound部分
					 -->
					<div class="media">
						<a  class="media-left"><img src="" alt=""></a>//这里是一个音乐图标
						<div class="media-body">
							<h5 class="media-heading" >record Name</h5>
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