<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<link href="/zftal-web/style-common/css/base.css" rel="stylesheet">
		<link href="/zftal-web/style-common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="/zftal-web/style-common/css/base_red.css" rel="stylesheet">
		
		<script src="/zftal-web/style-common/js/jquery-1.11.0.min.js"></script>
		<script src="/zftal-web/style-common/bootstrap/js/bootstrap.min.js"></script>
		<script src="/zftal-web/style-common/js/common.js"></script>
<script type="text/javascript">
	jQuery = $;
	
	//提示弹框
	function alerts(v){
		var d = dialog({
		    title: '提示',
		    content: v,
		    okValue: '确定',
		    ok: function () {}
		});
		d.show();
	}	
	
	//页面刷新
	function pageRefresh(){
		window.location.reload();
	}

	function _(id) {
		return document.getElementById(id);
	}
	
	function loginTo() {
		$("#yhmts").text("");
		$("#mmts").text("");
		$("#yzmts").text("");
		
		if (document.forms[0].yhm.value  == "") {
			//alerts('提示：登录名不能为空，请输入登录名！');
			$("#yhmts").text("用户名不能为空");
			//document.forms[0].yhm.focus();
			return false;
		} else {
			if (document.forms[0].mm.value == "") {
				//alerts('提示：密码不能为空，请输入密码！');
				$("#yhmts").text("");
				$("#mmts").text("密码不能为空");
				//document.forms[0].mm.focus();
				return false;
			} else {
				var loginNumVar = '<s:property value="#session.loginNum"/>';
				var loginNum = 0;
				if( loginNumVar!=null && loginNumVar!='' ){
					loginNum = Number(loginNumVar);
				}
				 
				if( loginNum > 3 ){
					if (document.forms[0].yzm.value == "" || document.forms[0].yzm.value.length != 4) {
						document.forms[0].yzm.select();
						//window.location.reload();
						//alerts('提示：验证码为空或格式不正确，请重新输入！');
						$("#yhmts").text("");
						$("#mmts").text("");
						$("#yzmts").text("验证码错误");
						yzmload();
						return false;
					}
				}
				
			}
		}
		return true;
	}
	
	function yzyh(){
		//alerts('抱歉，用户名或密码错误，请重新输入！');
		$("#yhmts").text("用户名或密码错误");
		yzmload();
		//window.location.reload();
		//document.forms[0].mm.focus();
	}
	function yzmcw(){
		//alerts('提示：验证码错误！');
		$("#yzmts").text("验证码错误");
		//document.forms[0].yzm.focus();
		$("#yzm").val("");
		yzmload();
		//window.location.reload();
	}
	
	function yzmcscw(){
		//alerts('提示：获取验证码超时！请点击验证码重新获取，然后重新登录！');
		$("#yzmts").text("验证码超时");
		$("#yzm").val("");
		window.location.reload();
	}
	function yhdl(){
		$("#yhmts").text("");
		$("#mmts").text("");
		$("#yzmts").text("");
		var yhm = $("#yhm").val();
		var mm = $("#mm").val();
		var yzm = $("#yzm").val();
		var yxq = $("#yxq").val();
		var xmid = $("#xmid").val();
		$.post("oou_login.action?sign2=1",{"yhm":yhm,"mm":mm,"yzm":yzm},function(respose){
		    if(respose=='dlcw'){
		       yzyh();
		    }else if(respose=='yzmcw'){
		       yzmcw();
		    }else if(respose=='yzmcs'){
		       yzmcscw();
		    }else if( respose=='ok' ){
			   window.location.href="oou_index.action";
		    }else{
		    	window.location.href="oou_index.action";
		    }
		});
	}
	function yznc(){
	  var yhnc = $("#yhnc").val();
		if(yhnc==''||yhnc==null ){
			$("#ncts").css("display","block");
			//jQuery("#yhnc").focus();
			$('#tj').attr('disabled',"true");
			return false;
		}else{
	      var url = "indexYznc.action";
		  $.post(url,{"YhModel.yhnc":yhnc},function(response){
			if(response=='exist'){
			    $("#ncts").css("display","block");
			    //jQuery("#yhnc").focus();
			    $('#tj').attr('disabled',"true");
			    return false;
			}else{
			  $("#ncts").css("display","none");
			  $('#tj').removeAttr("disabled"); 
			}
		  })
		}
	}
	
	
	function yhkszc(){
		$("#zcyhmts").text("");
		$("#zcmmts").text("");
		$("#fwts").text("");
		
	    var yhnc = $("#yhnc").val();
		var yhmm = $("#yhmm").val();
		var qrmm = $("#qrmm").val();
		
		if(yhnc==''||yhnc==null ){
			//alerts("用户名不能为空");
			$("#zcyhmts").text("用户名不能为空");
			return false;
		}
		
		if(yhmm==''||yhmm==null){
			//alerts("用户密码不能为空");
			$("#zcmmts").text("密码不能为空");
			return false;
		}else if(yhmm.indexOf(" ")!=-1){
			//alerts("密码有非法字符");
			$("#zcmmts").text("密码由非法字符");
			return false;
		}else if(yhmm.length<6||yhmm.length>16){
			//alerts("密码长度小于6或者大于16");
			$("#zcmmts").text("密码长度小于6或者大于16");
			return false;
		}
		
		var qrmm = $("#qrmm").val();
		if(qrmm=='' || qrmm==null|| qrmm.indexOf(" ")!=-1|| qrmm.length<6||qrmm.length>16){
			//alerts("确认密码不合法");
			$("#zcmmts").text("确认密码不合法");
			return false;
		}else{
			if(qrmm!=yhmm&&(yhmm!=null&&yhmm!='')){
				//alerts("两次密码不一致");
				$("#zcmmts").text("两次密码不一致");
				return false;
			}
		}
		
		if( $("input[type='checkbox']").is(':checked') ){
			
		}else{
			//alerts("请同意服务协议！");
			$("#fwts").text("请同意服务协议！");
			return false;
		}
		
		$.post("indexYznc.action",{"YhModel.yhnc":yhnc},function(response){
			$("#zcyhmts").text("");
			$("#zcmmts").text("");
			$("#fwts").text("");
			if(response=='exist'){
				//alerts("用户名已存在");
				$("#zcyhmts").text("用户名已存在");
			    return false;
			}else{
				var zcUrl = "oou_yhzc.action?time="+new Date().getTime();
				$.post(zcUrl,
						{"YhModel.yhnc":yhnc,
						 "YhModel.mm":yhmm
						},function(response){
						window.location.href = "oou_index.action";
				});
			}
		  });
		
	}
	
	
	function yzyhnc(){
		$("#zcyhmts").text("");
		$("#zcmmts").text("");
		$("#fwts").text("");
		var yhnc = $("#yhnc").val();
		var url = "indexYznc.action";
		  $.post(url,{"YhModel.yhnc":yhnc},function(response){
			if(response=='exist'){
				//alerts("用户名已存在");
				$("#zcyhmts").text("用户名已存在");
			    return false;
			}
		  });
	}
</script>
	</head>
	<body style="background:none;background-color:#fff;">
		<div class="login_main">
			<div class="container login_main1">
				<div class="login_box myLoginDiv">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<h3 class="title"><span class="pull-left">登 录</span><a href="javascript:;" class="pull-right js-trun">注册 <i class="fa fa-arrow-circle-o-right"></i></a></h3>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>
								<input type="text" id="yhm" name="yhm" class="form-control" placeholder="请输入账号">
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="yhmts"></span></p>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
								<input type="password" id="mm" onkeypress="if(event.keyCode==13){yhdl();return false;}" name="mm" class="form-control" placeholder="请输入密码">
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="mmts"></span></p>
						</div>
						
						<div class="form-group"><label class="pull-left"><input type="checkbox" class="pull-left">下次自动登录</label> <a href="#" class="pull-right">忘记密码？</a> </div>
						<div class="form-group">
							<button type="button" onclick="if(loginTo()){yhdl();}" class="btn btn-primary btn-block">登　录</button>
						</div>
					</form>
				</div>
				
				<div class="login_box register myRegistDiv">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<h3 class="title"><span class="pull-left">注 册</span><a href="javascript:;" class="pull-right js-trun">登录 <i class="fa fa-arrow-circle-o-right"></i></a></h3>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">用 户 名</label>
							<div class="col-sm-9">
								<input type="text" id="yhnc" name="yhnc" class="form-control" placeholder="">
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="zcyhmts"></span></p>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">用户密码</label>
							<div class="col-sm-9">
								<input type="password" id="yhmm" name="yhmm" class="form-control" placeholder="">
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="zcmmts"></span></p>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">确认密码</label>
							<div class="col-sm-9">
								<input type="password" id="qrmm" name="qrmm" class="form-control" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<button type="button" onclick="yhkszc();" class="btn btn-primary btn-block">注　册</button>
						</div>
						<div class="form-group login_text"><label class="pull-left"><input type="checkbox" checked="checked" id="agreeServer" class="pull-left">我已阅读并同意<a href="#">《服务协议》</a></label></div>
						<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="fwts"></span></p>
					</form>
				</div>
			</div>
		</div>
<script>
$(document).ready(function(e) {
	
	//登录页面切换
	$(".js-trun").click(function() {
		var $loginbox = $(this).closest(".login_box");
		if($loginbox.hasClass("register")){         
		  $loginbox.siblings().addClass("login-delay");
		  $(".login_box").removeClass("active");
		   return;
		}
		$(".login_box").addClass('active').removeClass("login-delay");
	})
});
</script>
</body>
</html>
