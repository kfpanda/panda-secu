<%@page import="java.text.SimpleDateFormat"%>
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
		function look(userId,orderNo) {
			showWindow('订单详情', 600, 400, 'content?userid='+userId+'&orderno='+orderNo);
		}
		
		function black(userId) {
			var url ="../user/black/add";
			jQuery.ajax({
				type: 'POST',
				url: url,
				data: "userid="+userId,
				success: function(data){
					var obj = eval("(" + data + ")");
					if(obj.r==1) {
						//添加成功
						alert("添加黑名单成功！");
					}else {
						//添加失败或发生错误
						alert(obj.msg);
					}
				},
				dataType: 'text'
			});
		}
	</script>
	<style type="text/css">
		h2 {
			margin-top: 10px;
		}
	</style>
	<body>
		<script src="/style-common/js/jquery-1.8.0.min.js"></script>
		<script src="/style-common/js/ui_comm.js"></script>
		<script src="/style-common/js/message.js"></script>
		<script src="/style-common/js/jquery.hoverdelay.js"></script>
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
									<a style="cursor: pointer;" onclick="forwardPage('addorder');">申请贷款</a>
								</li>
								<li>
									<a style="cursor: pointer;" onclick="forwardPage('../user/userinfo/get');">个人资料</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-sm-8 col-md-9">
						<div class="zj-TypePageContent">
							<h3><span>贷款单列表</span></h3>
							<input id="search_go" class="sear_bt" type="hidden" onclick="forwardPage('list');" />
							<div class="typelist">
								<ul class="list">
									<%
											List<Order> list = (List<Order>) request.getSession().getAttribute("orderList");
											String rom = (String) request.getSession().getAttribute("userRolenum");
											if(rom == "1") {
												out.println("<li><span class=\"col-sm-2 odr\">订单编号</span><span class=\"col-sm-4 odr\" style=\"padding-left: 40px;\">订单名称</span><span class=\"col-sm-3 odr\">审核通过时间</span><span class=\"col-sm-1 odr\">状态</span><span class=\"col-sm-2 odr\" style=\"padding-left: 60px;\">操作</span></li>");
											}else {
												out.println("<li><span class=\"col-sm-2 odr\">订单编号</span><span class=\"col-sm-4 odr\" style=\"padding-left: 40px;\">订单名称</span><span class=\"col-sm-3 odr\">用户申请时间</span><span class=\"col-sm-1 odr\">状态</span><span class=\"col-sm-2 odr\" style=\"padding-left: 60px;\">操作</span></li>");
											}
											if(list.size() > 0) {
												for(int i=0;i<list.size();i++){
													String strutsMsg = "";
													out.println("<li>");
													out.println("<span class=\"col-sm-2 odor\">"+list.get(i).getOrderno()+"</span>");
													out.println("<span class=\"col-sm-4 odor\" style=\"padding-left: 40px;\">"+list.get(i).getOrdername()+"</span>");
													if(rom == "1") {
														if(list.get(i).getApprovaltime() != null) {
															SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
															String times = sdf.format(list.get(i).getApprovaltime());
															out.println("<span class=\"col-sm-3 odor\">"+times+"</span>");
// 															out.println("<span class=\"col-sm-3 odor\">"+list.get(i).getApprovaltime()+"</span>");
														}else {
															out.println("<span class=\"col-sm-3 odor\">管理员未审核</span>");
														}
														if(list.get(i).getStatus() == 1) {
															strutsMsg = "未审核";
														} else if(list.get(i).getStatus() == 2) {
															strutsMsg = "待还款";
														}
														out.println("<span class=\"col-sm-1 odor\">"+strutsMsg+"</span>");
														out.println("<a style=\"cursor: pointer; padding-left: 60px;\" class=\"col-sm-2\" onclick=\"look('"+list.get(i).getUserid()+"','"+list.get(i).getOrderno()+"')\" >详情</a>");
													}else if(rom == "2") {
														SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
														String times = sdf.format(list.get(i).getCreattime());
														out.println("<span class=\"col-sm-3 odor\">"+times+"</span>");
														if(list.get(i).getStatus() == 1) {
															strutsMsg = "未审核";
														} else if(list.get(i).getStatus() == 2) {
															strutsMsg = "待还款";
														}
														out.println("<span class=\"col-sm-1 odor\">"+strutsMsg+"</span>");
														out.println("<a style=\"cursor: pointer;\" class=\"col-sm-1\" onclick=\"look('"+list.get(i).getUserid()+"','"+list.get(i).getOrderno()+"')\">审核</a>");
														out.println("<a style=\"cursor: pointer;\" class=\"col-sm-1\" onclick=\"black('"+list.get(i).getUserid()+"')\">拉黑</a>");
													}
													out.println("</li>");
												}
											}else {
												out.println("<a style=\"color: red; font-size:20px; text-decoration:none;\"><br/>暂无贷款信息</a>");
											}
									%>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</body>
	<style type="text/css">
		.odr {
			color: #003274;
			font: 600 18px/35px microsoft yahei;
		}
		.odor {
			font: 14px/32px microsoft yahei;
			color: #666;
		}
	</style>
</html>