<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<head>
	<meta charset="utf-8"></meta>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	<title>啦啦啦啦啦</title>
	<link rel="stylesheet" href="/style-common/bootstrap/css/bootstrap.min.css"></link>
<!-- 	<link rel="stylesheet" href="/zftal-web/style-common/bootstrap/css/font-awesome/css/font-awesome.min.css"></link> -->
	<link rel="stylesheet" href="/style-common/fonts/font-awesome/css/font-awesome.min.css"></link>
	<link rel="stylesheet" href="/style-common/css/index.css" type="text/css" media="all"></link>
	<link rel="stylesheet" href="/style-common/css/module.css">
	<script src="/style-common/js/jquery-1.11.0.min.js"></script>
	<style>
		a:link, a:visited {
			font-size: 14px;
		}
	</style>
	<script language="JavaScript">
		function logout() {
			if(confirm("确认要退出吗?"))
			{
				return true;
			}else {
				return false;
			}
		}
	</script>
	<script type="text/javascript">
	function forwardPage(cdNum) {
		var login_url = "";
		if(cdNum!="") {
			if(cdNum == 1) {
				login_url = "../order/list";
				window.location.href=login_url;
			}else if(cdNum == 2) {
				login_url = "../order/addorder";
				window.location.href=login_url;
			}else if(cdNum == 3) {
				login_url = "../user/userinfo/get";
				window.location.href=login_url;
			}else {
				window.location.href=cdNum;
			}
		}
	}
	</script>
</head>
<header>
	<div class="container zj-container">
		<div class="col-sm-8">
			<div class="zj-mar-left15">
				<img class="img-responsive pull-left" src="/style-common/images/logo.png"/>
<!-- 				<img class="img-responsive" src="/zftal-web/style-common/images/img2.jpg"/> -->
			</div>
		</div>
		<div class="col-sm-4 pull-right">
			<a class="pull-right sl_login" href="../../user/index" onclick="return logout();">退出</a>
		</div>
	</div>
</header>