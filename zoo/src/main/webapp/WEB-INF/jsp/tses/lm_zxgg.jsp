<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<input type="hidden" id="pageTypePage" value="${pageTypePage }" />
<div class="zj-crumbs"><span>你的位置：</span><a href="/zftal-web/web/index_index.html?cdid=N01">首页</a>-<a href="/zftal-web/web/lm_xxgg.html?cdid=N03">信息公告</a>-<a>中心公告</a></div>
<div class="zj-TypePageContent">
	<h3><span>中心公告</span></h3>
	<div class="typelist">
		<ul class="list">
			<s:if test="message=='yes'">
				<s:iterator value="xxggList" id="xxgg">
					<li>
						<s:if test="#xxgg.wzlj==1">
							<a target="_blank" href="${xxgg.wzdz}">${xxgg.notice_title }</a>
							<span class="time">${xxgg.issue_time }</span>
						</s:if>
						<s:else>
							<a target="_blank" href="/zftal-web/web/lm_newsContent.html?newId=${xxgg.notice_id}&pageType=zxgg">${xxgg.notice_title}</a>
							<span class="time">${xxgg.issue_time }</span>
						</s:else>
					</li>
				</s:iterator>
			</s:if>
			<s:else>
				<a style="color: red; font-size:20px; text-decoration:none;">
					<br/>对不起，你所查询的通知公告不存在。
				</a>
			</s:else>
		</ul>
	</div>
	<jsp:include page="page.jsp" flush="true"></jsp:include>
	<script type="text/javascript">
		//分页查询
		function turnPage(page){
			var pageType = jQuery("#pageTypePage").val();
			var url = 'lm_xxgg.html?pageType='+pageType;
			forwardPage(url,page);
		}
	</script>
</div>