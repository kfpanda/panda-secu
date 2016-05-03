<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<body>
		<script src="/style-common/js/jquery-1.8.0.min.js"></script>
		<script src="/style-common/js/jquery.hoverdelay.js"></script>
		<script src="/style-common/js/ui_comm.js"></script>
		
		<link rel="stylesheet" href="/style-common/css/public.css" type="text/css" media="all" />
		<link rel="stylesheet" href="/style-common/css/module.css" type="text/css" media="all" />
		<link rel="stylesheet" href="/style-common/css/global.css" type="text/css" media="all" />
		<link rel="stylesheet" href="/style-common/css/windown.css" type="text/css" media="all" />
		<script src="/style-common/js/jquery-1.8.0.min.js"></script>
		<script src="/style-common/js/jquery.hoverdelay.js"></script>
		<script src="/style-common/js/ui_comm.js"></script>
		<script src="/style-common/js/message.js"></script>
			
		<div class="sys_bar">
			<h3><button style="cursor:pointer;" class="btn_zj" onclick="addYqlj();">增加友情链接</button></h3>
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
				<s:iterator value="queryModel.items" id="yqlj">
					<tr>
						<td>
							<s:property value="#yqlj.yqljmc"></s:property>
						</td>
						<td>
							<s:property value="#yqlj.yqljwz"></s:property>
						</td>
						<td>
							<div class="box_menu_down">
								<a style="cursor: pointer;" class="btn_xq">详情</a>
								<div class="menu_down">
									<ul>
										<li class="border_top">
											<a style="cursor: pointer;" onclick="modYqlj('${id}')">修改</a>
										</li>
										<li class="border_bottom">
											<a style="cursor: pointer;" onclick="delYqlj('${id}')">删除</a>
										</li>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<jsp:include page="page.jsp" flush="true"></jsp:include>
		<script type="text/javascript">
			//分页查询
			function turnPage(page){
				queryYqlj(page);
			}
		</script>
	</body>
</html>