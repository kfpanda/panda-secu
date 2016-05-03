<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*,validate.Base64"%>
<%ResourceBundle schoolpath = ResourceBundle.getBundle("schoolpath");%>
<%request.setAttribute("ckgg_type",schoolpath.getString("school.ckgg_type"));%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<link href="<%=request.getContextPath()%>/newcss/page.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/js/xxggnew.js"></script>
	<body>
		<div class="head">
			<input type="hidden" id="pageType" value="${pageType}"/>
			<input type="hidden" id="inputin" value="${bomber}" />
			<div class="zj-column-banner" style="background:url(../images/<%=schoolpath.getString("school.name")%>/win-banner.jpg) no-repeat center top;"></div>
			<div class="container zj-bg-white zj-pad-topbot20">
			<div class="row">
				<div class="col-sm-4 col-md-3">
					<div class="zj-TypePagelmNavigate">
					<h3>信息公告</h3>
						<ul>
							<s:iterator value="xtcdList" id="xtcd">
								<s:if test="#xtcd.cdid != null && #xtcd.cdid!=''">
									<li>
										<a style="cursor: pointer;" onclick="forwardPage('${xtcd.cdlj}');">${xtcd.cdmc}</a>
									</li>
								</s:if>
							</s:iterator>
						</ul>
					</div>
				</div>
				<div class="col-sm-8 col-md-9" id="rightHtml">
	
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</body>
</html>