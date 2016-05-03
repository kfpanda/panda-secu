<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.zoo.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="/style-common/css/public.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/module.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/global.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/windown.css" type="text/css" media="all" />
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<script type="text/javascript">
		function xgzl() {
			showWindow('修改资料', 460, 300, 'xgzl');
		}
		function xgmm() {
			showWindow('修改密码', 460, 300, '../pwd/xgmm');
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
									<a style="cursor: pointer;" onclick="forwardPage('../../order/list');">贷款单列表</a>
								</li>
								<li>
									<a style="cursor: pointer;" onclick="forwardPage('../../order/addorder');">申请贷款</a>
								</li>
								<li>
									<a style="cursor: pointer;" onclick="forwardPage('get');">个人资料</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-sm-8 col-md-9">
						<div class="sys_right">
							<div class="sys_bar">
								<h6><button style="cursor:pointer;" class="btn_xg" onclick="xgzl();">修改资料</button>
								<button style="cursor:pointer;" class="btn_xg" onclick="xgmm();">修改密码</button></h6>
								<input id="search_go" class="sear_bt" type="hidden" onclick="forwardPage('../userinfo/get');" />
							</div>
							<div class="sys_tb sys_hgt">
								<table>
									<tr>
										<th style="width: 20%;">
											<NOBR>用户账号</NOBR>
										</th>
										<td style="width: 20%;">
											${user.name}
										</td>
										<th style="width: 20%;">
											<NOBR>用户注册日期</NOBR>
										</th>
										<td style="width: 40%;">
											${zcrq}
										</td>
									</tr>
									<tr>
										<th>
											<NOBR>用户姓名</NOBR>
										</th>
										<td>
											${user.username}
										</td>
										<th>
											<NOBR>用户身份证号</NOBR>
										</th>
										<td>
											${user.idcard}
										</td>
									</tr>
									<tr>
										<th>
											<NOBR>用户地址</NOBR>
										</th>
										<td colspan="3">
											${user.adaress}
										</td>
									</tr>
									<tr>
										<th>
											<NOBR>联系电话</NOBR>
										</th>
										<td>
											${user.mobile}
										</td>
										<th>
											<NOBR>信用等级</NOBR>
										</th>
										<td>
											${user.lv}
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</body>
</html>