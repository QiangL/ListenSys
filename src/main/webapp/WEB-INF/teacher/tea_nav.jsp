<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<!-- 导航栏 -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="collapsed navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-top">
					<span class="sr-only">切换下拉导航</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">你好！${teacher.getTeacherName() }, 今天也是美好的一天</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-top">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="teacher/${teacher.getTeacherId() }/folderList">录音打分</a>
					</li>
					<!-- 希望加一个图表统计分析 -->
					<li>
						<a href="teacher/${teacher.getTeacherId() }/information">修改信息</a>
					</li>
				</ul>
				<div class="navbar-right">
					<button class="btn btn-default btn-block navbar-btn">登出</button>
				</div>
			</div>
		</div>
	</nav>
