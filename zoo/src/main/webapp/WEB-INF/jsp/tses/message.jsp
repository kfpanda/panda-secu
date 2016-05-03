<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.zoo.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="/style-common/css/public.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/module.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/global.css" type="text/css" media="all" />
	<link rel="stylesheet" href="/style-common/css/windown.css" type="text/css" media="all" />
	<jsp:include page="header.jsp" flush="true"></jsp:include>
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
									<a style="cursor: pointer;" onclick="forwardPage('../../user/userinfo/get');">个人资料</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-sm-8 col-md-9">
						<div class="sys_right">
							<div class="sys_bar">
								<h6><button style="cursor:pointer;" class="btn_zj" onclick="addYqlj();">修改资料</button></h6>
								<input id="search_go" class="sear_bt" type="hidden" onclick="queryYqlj(0);" value="搜索" />
							</div>
							<div class="sys_tb sys_hgt">
								<table>
									<tr>
										<th style="width: 30%;">
											<NOBR>友情链接名称</NOBR>
										</th>
										<th style="width: 60%;">
											<NOBR>友情链接网址</NOBR>
										</th>
										<th style="width: 10%;">
											<NOBR>操作</NOBR>
										</th>
									</tr>
									<tr>
										<td>
											1111
										</td>
										<td>
											2222
										</td>
										<td>
											<div class="box_menu_down">
												<a style="cursor: pointer;" class="btn_xq">详情</a>
												<div class="menu_down">
													<ul>
														<li class="border_top">
															<a style="cursor: pointer;" onclick="modYqlj('id')">修改</a>
														</li>
														<li class="border_bottom">
															<a style="cursor: pointer;" onclick="delYqlj('id')">删除</a>
														</li>
													</ul>
												</div>
											</div>
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