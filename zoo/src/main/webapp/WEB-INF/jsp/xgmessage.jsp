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
			function save() {
				var username = document.forms[0].username.value;//用户姓名
				var idcard = document.forms[0].idcard.value;//用户身份证号
				var adaress = document.forms[0].adaress.value;//用户地址
				var mobile = document.forms[0].mobile.value;//联系电话
				
				if(username==''||username==null){
					msg("用户姓名");
					return false;
				}
				if(idcard==''||idcard==null){
					msg("用户身份证号");
					return false;
				}
				if(adaress==''||adaress==null){
					msg("用户地址");
					return false;
				}
				if(mobile==''||mobile==null){
					msg("联系电话");
					return false;
				}
				submitForm('update');
			}
			
			function msg(inputStr) {
				alert("请将必填信息: "+inputStr+" 填写完整！");
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
								<font color="red">*</font><NOBR>用户姓名</NOBR>
							</th>
							<td style="width: 65%;">
								<input type="text" name="username" id="username" value="${user.username}"/>
							</td>
						</tr>
						<tr>
							<th>
								<font color="red">*</font><NOBR>用户身份证号</NOBR>
							</th>
							<td>
								<input type="text" name="idcard" id="idcard" value="${user.idcard}"/>
							</td>
						</tr>
						<tr>
							<th>
								<font color="red">*</font><NOBR>用户地址</NOBR>
							</th>
							<td>
								<textarea rows="3" id="adaress" name="adaress">${user.adaress}</textarea>
							</td>
						</tr>
						<tr>
							<th>
								<font color="red">*</font><NOBR>联系电话</NOBR>
							</th>
							<td>
								<input type="text" name="mobile" id="mobile" value="${user.mobile}"/>
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