<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.zoo.bean.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="/style-common/css/public.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/module.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/global.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/windown.css" type="text/css" media="all" />
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<script type="text/javascript">
		
		function to_refundmoney() {
			var amount = document.forms[0].amount.value;//申请金额
			var remoney = amount*1.06;
			$("#refundmoney").val(remoney+".00");
			$("#amount").val(amount+".00");
			alert("amount= "+amount+"  remoney= "+remoney);
		}
		
		function save() {
			var amount = document.forms[0].amount.value;//申请金额
			var reason = document.forms[0].reason.value;//原因
			var refundmoney = document.forms[0].refundmoney.value;//申请金额
			var ordername = document.forms[0].ordername.value;//申请金额
			
			if(amount==''||amount==null){
				msg("申请金额");
				return false;
			}
			if(reason==''||reason==null){
				msg("原因");
				return false;
			}
			if(refundmoney==''||refundmoney==null){
				msg("应还金额");
				return false;
			}
			if(ordername==''||ordername==null){
				msg("订单名称");
				return false;
			}
			submitForm('creat');
		}
		
		function msg(inputStr) {
			alert("请将必填信息: "+inputStr+" 填写完整！");
		}
		
		function qx() {
			$("#amount").text("");
			$("#refundmoney").text("");
			$("#reason").text("");
		}
		
	</script>
	<body>
		<script src="/style-common/js/jquery-1.8.0.min.js"></script>
		<script src="/style-common/js/ui_comm.js"></script>
		<script src="/style-common/js/message.js"></script>
		<script src="/style-common/js/jquery.hoverdelay.js"></script>
		<script src="/style-common/js/operation.js"></script>
		<div class="head">
			<div class="container zj-bg-white zj-pad-topbot20">
				<div class="row">
					<div class="col-sm-4 col-md-3">
						<div class="zj-TypePagelmNavigate">
							<ul>
								<li>
									<a style="cursor: pointer;" onclick="forwardPage('1');">贷款单列表</a>
								</li>
								<li>
									<a style="cursor: pointer;" onclick="forwardPage('2');">申请贷款</a>
								</li>
								<li>
									<a style="cursor: pointer;" onclick="forwardPage('3');">个人资料</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-sm-8 col-md-9">
						<div class="sys_right">
							<div class="zj-TypePageContent">
								<h3><span>申请贷款</span></h3>
								<input type="hidden" id="result" name="result" value="${result}"/>
								<form action="#" method="post">
									<div class="sys_tb sys_hgt">
										<table>
											<tr>
												<th style="width:20%">
													<NOBR>订单名称</NOBR>
												</th>
												<td style="width:30%">
													<input type="text" name="ordername" id="ordername" value="${ddmc}" readonly="true" style="width:220px;" />
												</td>
												<th>
													<NOBR>预约还款期限</NOBR>
												</th>
												<td>
													<NOBR>30天</NOBR>
												</td>
											</tr>
											<tr>
												<th style="width:20%">
													<font color="red">*</font><NOBR>申请人姓名</NOBR>
												</th>
												<td style="width:30%">
													<NOBR>${userName}</NOBR>
												</td>
												<th style="width:20%">
													<font color="red">*</font><NOBR>申请时间</NOBR>
												</th>
												<td style="width:30%">
													<NOBR>${sqsj}</NOBR>
												</td>
											</tr>
											<tr>
												<th style="width:20%">
													<font color="red">*</font><NOBR>申请金额</NOBR>
												</th>
												<td style="width:30%">
													<input type="text" name="amount" id="amount" onchange="to_refundmoney();"/>
												</td>
												<th>
													<NOBR>应还金额</NOBR>
												</th>
												<td>
													<input type="text" name="refundmoney" id="refundmoney" readonly="true" />
												</td>
											</tr>
											<tr>
												<th style="width:20%">
													<font color="red">*</font><NOBR>申请原因</NOBR>
												</th>
												<td colspan="3" style="width:80%">
													<textarea cols="83" rows="3" id="reason" name="reason"></textarea>
		<!-- 											<input type="text" name="reason" id="reason" /> -->
												</td>
											</tr>
											<tr>
												<th colspan="4">
													<NOBR>超出1-30天为拖欠，超出30天视为失去信用，请及时还款，以减少给您带来的损失！</NOBR>
												</th>
											</tr>
										</table>
										<div style="margin: 20px 0px 0px 0px; float:right;">
											<span>(<font color="red">*</font>)为必填项</span>
											<div class="btn">
												<p>
													<button class="determine" onclick="save();">确定</button>
													<button class="cancel" onclick="qx();">取消</button>
												</p>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
		<script type="text/javascript">
			$(function () {
				var resultor = $("#result").val();
				if(resultor != '' && resultor != null) {
					alert(resultor);
				}
			});
		</script>
	</body>
</html>