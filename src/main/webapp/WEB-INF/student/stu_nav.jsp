<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	<!-- 导航栏 -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-top">
					<span class="sr-only">切换下拉导航</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" >你好！${student.getStudentName() }, 今天也是美好的一天</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-top">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="student/${student.getStudentId()}/recordList">过往录音</a>
					</li>
					<li>
						<a href="student/${student.getStudentId()}/recordUpload">上传录音</a>
					</li>
					<li>
						<a href="student/${student.getStudentId()}/information">修改信息</a>
					</li>
				</ul>
				<div class="navbar-right">
					<button class="btn btn-default btn-block navbar-btn">登出</button>
				</div>
			</div>
		</div>
	</nav>