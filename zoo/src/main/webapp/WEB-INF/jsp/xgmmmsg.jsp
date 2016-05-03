<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.zoo.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" /> 
		<link rel="stylesheet" href="/style-common/css/public.css" type="text/css" media="all" />
		<link rel="stylesheet" href="/style-common/css/module.css" type="text/css" media="all" />
		<link rel="stylesheet" href="/style-common/css/global.css" type="text/css" media="all" />
		<script src="/style-common/js/validate.js"></script>
		<script src="/style-common/js/operation.js"></script>
		<script src="/style-common/js/message.js"></script>
		<script src="/style-common/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
			function to_newpwd() {
				var newpwd = document.forms[0].newpwd.value;//新密码
				
				//用户密码输入验证
				if(newpwd==''||newpwd==null){
					alert("密码不能为空!");
					return false;
				}else if(newpwd.indexOf(" ")!=-1){
					alert("密码有非法字符!请重新输入！");
					return false;
				}else if(newpwd.length<6||newpwd.length>16){
					alert("密码长度小于6或者大于16!请重新输入！");
					return false;
				}
			}
			
			function to_qrnewpwd() {
				var newpwd = document.forms[0].newpwd.value;//新密码
				var qrnewpwd = document.forms[0].qrnewpwd.value;//新密码
				
				//用户密码确认验证
				if(qrnewpwd==''||qrnewpwd==null||qrnewpwd.indexOf(" ")!=-1|| qrnewpwd.length<6||qrnewpwd.length>16){
					alert("确认密码不合法!请重新输入！");
					return false;
				}else{
					if(newpwd!=qrnewpwd&&(qrnewpwd!=null&&qrnewpwd!='')){
						alert("两次密码不一致!请重新输入！");
						return false;
					}
				}
			}
			
			function save() {
				var newpwd = document.forms[0].newpwd.value;//新密码
				var qrnewpwd = document.forms[0].qrnewpwd.value;//新密码
				var safepassword = document.forms[0].safepassword.value;//安全码
				
				if(newpwd==''||newpwd==null){
					msg("新密码");
					return false;
				}
				if(qrnewpwd==''||qrnewpwd==null){
					msg("确认新密码");
					return false;
				}
				if(safepassword==''||safepassword==null){
					msg("安全码");
					return false;
				}
				submitForm('update');
			}
		</script>
	</head>
	<body style="background: none;">
		<form action="#" method="post">
			<input type="hidden" name="result" id="result" value="${result}" />
			<div id="add-window">
				<div class="add_window">
					<table width="100%" border="0">
						<tr>
							<th style="width: 35%;">
								<NOBR>用户账号</NOBR>
							</th>
							<td style="width: 65%;">
								<input type="hidden" name="name" id=name value="${user.name}" />${user.name}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>新密码</NOBR>
							</th>
							<td>
								<input type="text" name="newpwd" id="newpwd" onchange="to_newpwd();"/>
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>确认新密码</NOBR>
							</th>
							<td>
								<input type="text" name="qrnewpwd" id="qrnewpwd" onchange="to_qrnewpwd();"/>
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>安全码确认</NOBR>
							</th>
							<td>
								<input type="text" name="safepassword" id="safepassword" />
							</td>
						</tr>
					</table>
					<div class="btn">
						<span>(<font color="red">*</font>)为必填项</span>
						<p>
							<button class="determine" onclick="save();return false;">
								确定
							</button>
							<button class="cancel" onclick="iFClose();">
								取消
							</button>
						</p>
					</div>
				</div>
			</div>
		</form>
		<script type="text/javascript">
			$(function () {
				var resultor = $("#result").val();
				if(resultor != "" && resultor != null) {
					alert(resultor);
					refershParent();
				}
			});
		</script>
	</body>
</html>