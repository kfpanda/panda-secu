<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>银行借贷管理系统</title>
		<link href="/style-common/css/base.css" rel="stylesheet" />
		<link href="/style-common/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="/style-common/css/base_red.css" rel="stylesheet" />
		
		<script src="/style-common/js/jquery-1.11.0.min.js"></script>
		<script src="/style-common/bootstrap/js/bootstrap.min.js"></script>
		<script src="/style-common/js/common.js"></script>
		<script type="text/javascript">
			jQuery = $;
			
			//用户登录输入验证
			function loginTo() {
				$("#yhmts").text("");
				$("#mmts").text("");
				var yhm = $("#yhm").val();
				var mm = $("#mm").val();
				if (yhm == "") {
					$("#yhmts").text("用户名不能为空");
					return false;
				} else {
					if (mm == "") {
						$("#yhmts").text("");
						$("#mmts").text("密码不能为空");
						return false;
					}
				}
				return true;
			}
			
			//用户登录验证
			function yhdl(){
				$("#yhmts").text("");
				$("#mmts").text("");
				var yhm = $("#yhm").val();
				var mm = $("#mm").val();
				
				var url ="login";
				jQuery.ajax({
					type: 'POST',
					url: url,
					data: "name="+yhm+"&pwd="+mm,
					success: function(data){
						var obj = eval("(" + data + ")");
						if(obj.r==1) {
							//登录成功
							var login_url = "../order/list";
							window.location.href=login_url;
						}else {
							//登录失败或发生错误
							alert(obj.msg);
						}
					},
 					dataType: 'text'
 				});
			}
			
			//注册提交验证
			function yhkszc(){
				$("#zcyhmts").text("");
				$("#zcmmts").text("");
				$("#yzzcmmts").text("");
				$("#zcaqmts").text("");
				$("#yzzcaqmts").text("");
				
				var yhnc = $("#yhnc").val();
				var yhmm = $("#yhmm").val();
				var qrmm = $("#qrmm").val();
				var yhaqm = $("#yhaqm").val();
				var qraqm = $("#qraqm").val();
				
				//用户名输入验证
				if(yhnc==''||yhnc==null){
					$("#zcyhmts").text("用户名不能为空");
					return false;
				}
				
				/*
				 *限制只能输入数字或字母 
				 */
// 				function onlyNumWords(obj){
// 					obj.value = obj.value.replace(/[^\da-zA-Z]/g,"");
// 					return true;
// 				}
				
				//用户密码输入验证
				if(yhmm==''||yhmm==null){
					$("#zcmmts").text("密码不能为空");
					return false;
				}else if(yhmm.indexOf(" ")!=-1){
					$("#zcmmts").text("密码有非法字符");
					return false;
				}else if(yhmm.length<6||yhmm.length>16){
					$("#zcmmts").text("密码长度小于6或者大于16");
					return false;
				}
				
				//用户密码确认验证
				var qrmm = $("#qrmm").val();
				if(qrmm==''||qrmm==null||qrmm.indexOf(" ")!=-1|| qrmm.length<6||qrmm.length>16){
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
				
				//用户安全码输入验证
				if(yhaqm==''||yhaqm==null){
					$("#zcaqmts").text("密码不能为空");
					return false;
				}else if(yhaqm.indexOf(" ")!=-1){
					$("#zcaqmts").text("密码有非法字符");
					return false;
				}else if(yhaqm.length<6||yhmm.length>16){
					$("#zcaqmts").text("密码长度小于6或者大于16");
					return false;
				}
				
				//用户安全码确认验证
				var qraqm = $("#qraqm").val();
				if(qraqm==''||qraqm==null||qraqm.indexOf(" ")!=-1||qraqm.length<6||qraqm.length>16){
					$("#yzzcaqmts").text("确认安全码不合法");
					return false;
				}else{
					if(qraqm!=yhaqm&&(qraqm!=null&&yhaqm!='')){
						$("#yzzcaqmts").text("两次安全码不一致");
						return false;
					}
				}
				
				//用户注册验证
				var url ="register";
				jQuery.ajax({
					type: 'POST',
					url: url,
					data: "name="+yhnc+"&pwd="+yhmm+"&safepassword="+yhaqm,
					success: function(data){
						var obj = eval("(" + data + ")");
						if(alert(obj.msg)) {
							var login_url = "index";
							window.location.href=login_url;
						}
					},
 					dataType: 'text'
 				});
			}
		</script>
	</head>
	<body style="background:none;background-color:#fff;">
		<div class="login_main">
			<div class="container login_main1">
				<div class="login_box myLoginDiv">
						<div class="form-group">
							<h3 class="title"><span class="pull-left">登 录</span><a href="javascript:;" class="pull-right js-trun">注册 <i class="fa fa-arrow-circle-o-right"></i></a></h3>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>
								<input type="text" id="yhm" name="yhm" class="form-control" placeholder="请输入账号" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="yhmts"></span></p>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
								<input type="password" id="mm" onkeypress="if(event.keyCode==13){yhdl();return false;}" name="mm" class="form-control" placeholder="请输入密码" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="mmts"></span></p>
						</div>
						<div class="form-group">
							<button type="button" onclick="if(loginTo()){yhdl();}" class="btn btn-primary btn-block">登　录</button>
						</div>
				</div>
				<div class="login_box register myRegistDiv">
						<div class="form-group">
							<h3 class="title"><span class="pull-left">注 册</span><a href="javascript:;" class="pull-right js-trun">登录 <i class="fa fa-arrow-circle-o-right"></i></a></h3>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">用 户 名</label>
							<div class="col-sm-9">
								<input type="text" id="yhnc" name="yhnc" class="form-control" placeholder="请输入用户名" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="zcyhmts"></span></p>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">用户密码</label>
							<div class="col-sm-9">
								<input type="password" id="yhmm" name="yhmm" class="form-control" placeholder="请输入用户密码" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="zcmmts"></span></p>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">确认密码</label>
							<div class="col-sm-9">
								<input type="password" id="qrmm" name="qrmm" class="form-control" placeholder="请验证用户密码" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="yzzcmmts"></span></p>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">安全码</label>
							<div class="col-sm-9">
								<input type="password" id="yhaqm" name="yhaqm" class="form-control" placeholder="请输入安全码" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="zcaqmts"></span></p>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label f_18 p_0 f_w_n l_h_48 text-left">确认安全码</label>
							<div class="col-sm-9">
								<input type="password" id="qraqm" name="qraqm" class="form-control" placeholder="请验证安全码" />
							</div>
							<p class="text-danger col-xs-offset-3 col-xs-9 l_h_30" ><span id="yzzcaqmts"></span></p>
						</div>
						<div class="form-group">
							<button type="button" onclick="yhkszc();" class="btn btn-primary btn-block">注　册</button>
						</div>
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
