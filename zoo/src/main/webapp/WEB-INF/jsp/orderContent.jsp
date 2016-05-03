<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.zoo.bean.Order"%>
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
			function Hksave(id) {
				var Hkmoney = $("#money").val();
				login_url = "refund?id="+id+"&money="+Hkmoney;
				if(Hkmoney)
				window.location.href=login_url;
			}
			
			function Tysave(id) {
				login_url = "approval?id="+id;
				window.location.href=login_url;
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
								<NOBR>用户姓名</NOBR>
							</th>
							<td style="width: 65%;">
								${order.username}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>联系电话</NOBR>
							</th>
							<td>
								${order.mobile}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>订单号</NOBR>
							</th>
							<td>
								${order.orderno}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>订单名称</NOBR>
							</th>
							<td>
								${order.ordername}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>借贷申请原因</NOBR>
							</th>
							<td>
								${order.reason}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>订单状态</NOBR>
							</th>
							<td>
								${status}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>订单创建时间</NOBR>
							</th>
							<td>
								${creattime}
							</td>
						</tr>
						<tr>
							<th>
								<NOBR>订单应还款截止时间</NOBR>
							</th>
							<td>
								${deadline}
							</td>
						</tr>
						<%
							String rom = (String) request.getSession().getAttribute("userRolenum");
							Order order = (Order)request.getSession().getAttribute("order");	
							if(rom == "1" && order.getStatus() != 1) {
								out.println("<tr><th><NOBR>订单还款</NOBR></th>");
								out.println("<td><input type=\"text\" name=\"money\" id=\"money\"/></td></tr>");
							}
						%>
					</table>
					<div class="btn">
						<span>(<font color="red">*</font>)为必填项</span>
						<p>
							<%
								if(rom == "1" && order.getStatus() != 1) {
									out.println("<button class=\"determine\" onclick=\"Hksave("+order.getId()+");return false;\">");
									out.println("还款");
									out.println("</button>");
								}else if(rom == "2") {
									out.println("<button class=\"determine\" onclick=\"Tysave("+order.getId()+");return false;\">");
									out.println("同意");
									out.println("</button>");
								}
							%>
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