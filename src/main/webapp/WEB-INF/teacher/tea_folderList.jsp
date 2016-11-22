<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html lang="zh-cn">
<head>
	<title>录音列表</title>
	<base href="<%=basePath%>"/>
	<meta charset="UTF-8"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<!--[if IE]>
	<script src="https://github.com/aFarkas/html5shiv/blob/master/dist/html5shiv-printshiv.min.js"></script>
	<![endif]-->
	</style>
	<!-- 侧边栏 Style -->
	<style type="text/css">
		a,
		img {
			border: 0;
		}
		a,
		a:hover {
			color: #000;
			text-decoration: none;
		}
		.left {
			width: 200px;
			height: 100%;
			border-right: 1px solid #CCCCCC;
			color: #000000;
			position: relative;
			left: 0;
			top: 0;
		}
		.div1 {
			text-align: center;
			width: 200wpx;
			padding-top: 10px;
		}
		.div2 {
			height: 40px;
			line-height: 40px;
			cursor: pointer;
			font-size: 13px;
			position: relative;
			border-bottom: #ccc 1px dotted;
		}
		.sliderTitle {
			position: absolute;
			height: 20px;
			left: 40px;
			top: 10px;
			background: url(images/1.png);
		}
		.div3 {
			display: none;
			font-size: 13px;
		}
		.div3 ul {
			margin: 0;
			padding: 0;
		}
		.div3 li {
			height: 30px;
			line-height: 30px;
			list-style: none;
			border-bottom: #ccc 1px dotted;
			text-align: center;
		}
	</style>
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>
	<!-- 评分 Style -->
	<style type="text/css">
		/* all sign style */
		.ratyli .rate{color: #ccc; font-size: 24px;}

		/* empty sign style */
		.ratyli .rate-empty{color: #666;}

		/* full sign style after rating*/
		.ratyli.rated .rate-full{color: #fe5845;}

		/* active signs (hover)*/
		.ratyli .rate-active{color: #a94039;}
		.points{
			line-height:3;
			width:145px;
			margin:0;
		}
	</style>
	<!-- 播放条+去掉底部遮挡 -->
	<style type="text/css">
		@media(max-width:320px){
			.contain{
				margin-bottom:200px;
			}
		}
		@media(min-width:320px){
			.contain{
				margin-bottom:150px;
			}
		}
		@media(min-width:560px){
			.contain{
				margin-bottom:100px;
			}
		}
		@media(min-width:870px){
			.contain{
				margin-bottom:70px;
			}
		}
	</style>
</head>

<body class="container-fluid">
	<%@include file="tea_nav.jsp" %>
		<!--文件夹列表 -->
		<!-- 希望变成侧边栏 -->
		<div class="left col-sm-2 contain">
		
			<div class="div1">
			<c:forEach items="${folderList }" var="folder">
				<div class="div2">
					<div class="sliderTitle" data-folderId="${folder.getId() }" }>${folder.getFolderName() }</div>
				</div>
				<div class="div3">
					<ul>
					<c:forEach items="${classesList }" var="cla">
					<li data-classesId="${cla.getId() }">${cla.getClassName() }</li>
					</c:forEach>
					</ul>
				</div>
				</c:forEach>
			</div>
		
		</div>
		<!-- 班级中每个人的录音 -->

		<div class="panel panel-default col-sm-10 pull-right contain">
			<div class="panel-heading">
				某班某文件夹录音
				<span class="pull-right">顺序播放</span>
			</div>
			<div class="panel-body">
				<ul class="row list-unstyled">
					<li class="col-md-2 col-sm-5">
						<!-- 这里希望使用一个hover实现效果 滑过显示播放按钮，点击播放-->
						<!-- 还要增加是否播放过、评分 -->
						<div class="panel panel-default">
							<div class="panel-body">
								<h5>李强</h5>
								<span>201493106</span>
								<p>上传时间</p>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>

		<!-- 底部的播放条 -->
		<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
			<audio controls src="http://www.jq22.com/demo/bofq/audio.mp3" class="navbar-brand col-sm-8 pull-right" >
			</audio>
			<form class="navbar-form">
				<div class="nav navbar-nav btn-group col-sm-2">
					<button class="btn btn-default" type="button">上一个</button>
					<button class="btn btn-default" type="button">下一个</button>
				</div>
				<!-- 这里希望有一个评分星星的效果 -->
				<div id="points" class="nav navbar-nav points">
					<span>评分</span>
			        <span class="ratyli"></span>
		    	</div>
			</form>
			<textarea class="form-control" rows="2" cols="10" placeholder="在这里输入评价"></textarea>
		</nav>


		<!--import js of bootstrap and jQ must!-->
		<script src="js/jquery.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script src="js/jquery.ratyli.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			//侧边栏
			$(".div2").click(function(){ 
				$(this).next("div").slideToggle("slow").siblings(".div3:visible").slideUp("slow");
			});
			//评分
			$("#points .ratyli").ratyli({
				full:"<i class='fa fa-thumbs-up'></i>",
				empty:"<i class='fa fa-thumbs-o-up'></i>",
			});
		});
		</script>
</body>

</html>