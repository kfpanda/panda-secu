<script type="text/template" id="buy_tpl">
	<header class="header back-blue">
		<nav>
			<a href="index.html">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/back.png">
				</div>
			</a>
			<div class="center-text row-5 left normal-text">套餐购买</div>
			<a href="javascript:void(0)">
				<div class="header-right right-text row-2-5 left small-text">

				</div>
			</a>
		</nav>
	</header>

	<div class="container buycontainer clr-fix">
		<div class="row-10  normal-text">
			<div class="row-9 clr-fix buy-padding">
				<div>
					<div class="row-5 left">充值账户</div>
					<div class="row-5 left right-text">13344445555</div>
				</div>
			</div>
		</div>
		<div class="title">
			<span class="title-text nomal-text gray-text"></span>
		</div>
		<div class="title">
			<span class="title-text nomal-text gray-text"></span>
		</div>
		<div class="row-10  normal-text">
			<div class="row-9 clr-fix buy-padding">
				<div>
					<div class="row-5 left">
						<span class="buy-day">1天</span> <span class="buy-unit">售价一元</span>
						<input type="hidden" value="1" id="unit" />
					</div>
					<div class="row-5 left right-text" style="line-height: 3rem;">
						<img src="img/buy/cut.png" class="buychoosenum" id="cutPic"/>
						<input type="text" class="buychoosetext" value="1" id="num"/>
						<img src="img/buy/add.png" class="buychoosenum" id="addPic"/>
					</div>
				</div>
			</div>
		</div>
		<div class="title">
			<span class="title-text nomal-text gray-text"></span>
		</div>
		<div class="title">
			<span class="title-text nomal-text gray-text"></span>
		</div>
		<div class="back-light-gray">
			<div class="row-10  small-text light-gray-text" >
				<p >
					购买须知：上网时间将在充值成功后立即生效，若您在当前上网套餐时长还未到期情况下继续充值，充值时长会累加。请根据个人需求合理充值！
				</p>
			</div>
			<div class="buy-save row-10 ">
				<div class="row-9">
					<button class="back-orange" id="buy" style="color: #fff;font-size: 1.5rem;">购买</button>
				</div>
			</div>
		</div>

		<footer class="row-10 footer light-gray-text " style="margin-top: 75px;">
			<div class="row-9 center-text footer-top">
				<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
			</div>
			<div class="row-9 center-text footer-bottom">
				<span class="small-text">400-8252-525</span>
			</div>
		</footer>
	</div>
	<div class="mask"></div>
	<div class="modal">
		<div class="row-9 buymodalrow">
			<div class="row-4 left text-indent">充值账户</div>
			<div class="row-6 left right-text" id="account">13344445555</div>
		</div>
		<div class="bottomline"></div>
		<div class="row-9 buymodalrow">
			<div class="row-4 left text-indent">充值金额</div>
			<div class="row-6 left right-text"><span class="red-text" id="totalPay">?</span>元</div>
		</div>
		<div class="bottomline"></div>
		<div class="row-9 buymodalrow">
			<div class="row-3 left text-indent">有效期</div>
			<div class="row-7 left right-text" id="undertime">
				<!--<span>2015-12-1</span>至<span>12-6</span>-->
			</div>
		</div>
		<div class="row-10 back-light-gray buymodalrow">
			<div class="row-5 left center-text light-gray-text">

				<span id="cancel">取消</span>
			</div>
			<div class="row-5 left center-text light-gray-text">
				<span class="blue-text" id="surePay">确认支付</span>
			</div>

		</div>
	</div>
</script><script type="text/template" id="index_tpl">
	<header class="header back-blue">
		<nav>
			<a id="login" href="#/login">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/wifi.png">
					<span class="header-left-span right-text">连网</span>
				</div>
			</a>
			<div class="center-text row-5 left normal-text">微站</div>
			<a href="#/userCenter">
				<div class="header-right center-text row-2-5 left small-text">
					<!--<span class="right-text">园区资料</span>-->
					<img class="header-right-img right" src="img/header/information.png">
				</div>
			</a>
		</nav>
	</header>

	<div class="container">

		<div class="carousel clr-fix">
			<ul class="carousel-ul">
				<li class="carousel-ul-li">
					<a href="post.html"><img class="carousel-img row-10" src="img/carousel/11.png" alt="1" id="img"></a>
				</li>
				<li class="carousel-ul-li">
					<a href="#"><img class="carousel-img row-10" src="img/carousel/2.png" alt="2"></a>
				</li>
				<li class="carousel-ul-li">
					<a href="#"><img class="carousel-img row-10" src="img/carousel/3.png" alt="3"></a>
				</li>
				<li class="carousel-ul-li">
					<a href="#"><img class="carousel-img row-10" src="img/carousel/4.png" alt="4"></a>
				</li>
			</ul>
		</div>

		<!-- app -->
		<div class="app clr-fix">
			<div class="row-2 left center-text">
				<div class="app-icon row-8">
					<a href="#"><img class="row-9" src="img/app/lunch.png"></a>
					<div class="small-text row-10">点餐</div>
				</div>
			</div>

			<div class="row-2 left center-text">
				<div class="app-icon row-8">
					<a href="#"><img class="row-9" src="img/app/services.png"></a>
					<div class="small-text row-10">服务</div>
				</div>
			</div>

			<div class="row-2 left center-text">
				<div class="app-icon row-8">
					<a href="#"><img class="row-9" src="img/app/order.png"></a>
					<div class="small-text row-10">买单</div>
				</div>
			</div>

			<div class="row-2 left center-text">
				<div class="app-icon row-8">
					<a href="#"><img class="row-9" src="img/app/cup.png"></a>
					<div class="small-text row-10">续杯</div>
				</div>
			</div>

			<div class="row-2 left center-text">
				<div class="app-icon row-8">
					<a href="#"><img class="row-9" src="img/app/share.png"></a>
					<div class="small-text row-10">分享</div>
				</div>
			</div>
		</div>
		<div class="bottomline"></div>
		<div class="row-10">
			<div class="row-9 " style="padding: 1rem 0;min-height: 60px;">
				<div class="row-2 left">
					<img src="img/index/shalouon.png" style="width:4rem" />
				</div>
				<div class="row-4 left small-text">
					<div><span>11</span>天<span>23:59:59</span></div>
					<div class="">剩余上网时间</div>
				</div>
				<div class="row-4 left right-text">
					<div class="row-9">
						<button class="back-orange" id="buy" style="color: #fff;font-size: 1.5rem;">套餐购买</button>
					</div>
				</div>
			</div>
		</div>

		<div class="title row-10">
			<div class="row-9">
				<span class="title-text small-text gray-text">园区介绍</span>
			</div>
		</div>
		<div class="information small-text">
			<div class="information-text">周末跟朋友聚会的地方，也是约会的好地方，更是喝咖啡的好地方！</div>
		</div>
	</div>

	<footer class="row-10 footer light-gray-text">
		<div class="row-9 center-text footer-top">
			<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
		</div>
		<div class="row-9 center-text footer-bottom">
			<span class="small-text">400-8252-525</span>
		</div>
	</footer>
	<!--根据角色显示与否-->
	<div class="nav row-10" style="display:block"> 
		<a href="index.html">
			<div class="left row-3-3 center-text">
				<div class="nav-img"><img src="img/nav/1.png"></div>
				<div class="nav-title small-text">首页</div>
			</div>
		</a>
		<a href="#/config">
			<div class="left row-3-3 center-text">
				<div class="nav-img"><img src="img/nav/2.png"></div>
				<div class="nav-title small-text">配置</div>
			</div>
		</a>
		<a href="#/statiscial">
			<div class="left row-3-3 center-text">
				<div class="nav-img"><img src="img/nav/3.png"></div>
				<div class="nav-title small-text">统计</div>
			</div>
		</a>
	</div>
</script><script type="text/template" id="config_tpl">
	<header class="header back-blue">
			<nav>
				<a href="index-edit.html">
					<div class="header-left center-text row-2-5 left small-text">
						<img class="header-left-img" src="img/header/back.png">
					</div>
				</a>
				<div class="center-text row-5 left normal-text">配置</div>
			</nav>
		</header>

		<div class="container">

			<div class="title text-indent">
				<span class="title-text small-text gray-text">广告位添加</span>
			</div>
			<!-- carousel-edit -->
			<div class="carousel-edit clr-fix">
				<div class="row-2-5 left">
					<div class="row-9 img-upload-arround">
						<!-- <input class="carousel-edit-input row-2-3" type="file"> -->
						<img class="row-10 img-upload" src="img/carousel/1.1.png" alt="1">
						<div class="small-text center-text">更改</div>
					</div>
				</div>
				<div class="row-2-5 left">
					<div class="row-9 img-upload-arround">
						<!-- <input class="carousel-edit-input row-2-3" type="file"> -->
						<img class="row-10 img-upload" src="img/carousel/1.1.png" alt="2">
						<div class="small-text center-text">更改</div>
					</div>
				</div>
				<div class="row-2-5 left">
					<div class="row-9 img-upload-arround">
						<!-- <input class="carousel-edit-input row-2-3" type="file"> -->
						<img class="row-10 img-upload" src="img/carousel/1.1.png" alt="3">
						<div class="small-text center-text">更改</div>
					</div>
				</div>
				<div class="row-2-5 left">
					<div class="row-9 img-upload-arround">
						<!-- <input class="carousel-edit-input row-2-3" type="file"> -->
						<img class="row-10 img-upload" src="img/carousel/add.png" alt="4">
						<div class="small-text center-text">添加</div>
					</div>
				</div>
			</div>

			<!-- app -->
			<div class="title text-indent">
				<span class="title-text small-text gray-text">添加应用</span>
			</div>
			<div class="app clr-fix">
				<div class="row-2 left center-text">
					<div class="app-icon row-8">
						<a href="#"><img class="row-9" src="img/app/lunch.png"></a>
						<div class="small-text row-10">点餐</div>
					</div>
				</div>

				<div class="row-2 left center-text">
					<div class="app-icon row-8">
						<a href="#"><img class="row-9" src="img/app/services.png"></a>
						<div class="small-text row-10">服务</div>
					</div>
				</div>

				<div class="row-2 left center-text">
					<div class="app-icon row-8">
						<a href="#"><img class="row-9" src="img/app/order.png"></a>
						<div class="small-text row-10">买单</div>
					</div>
				</div>

				<div class="row-2 left center-text">
					<div class="app-icon row-8">
						<a href="#"><img class="row-9" src="img/app/cup.png"></a>
						<div class="small-text row-10">续杯</div>
					</div>
				</div>

				<div class="row-2 left center-text">
					<div class="app-icon row-8">
						<a href="#"><img class="row-9" src="img/app/share.png"></a>
						<div class="small-text row-10">分享</div>
					</div>
				</div>

				<div class="row-2 left center-text">
					<div class="app-icon row-8">
						<a href="#"><img class="row-9" src="img/app/add.png"></a>
						<div class="small-text row-10">添加</div>
					</div>
				</div>
			</div>
			<div class="title text-indent">
				<span class="title-text small-text gray-text">园区介绍</span>
			</div>
			<div class=" small-text row-10">
				<div class="row-10 " >
					<!--<label style="color: darkgray;" for="introduce" id="forIntro">请输入园区介绍</label>-->
					<textarea class="row-10 light-gray-text" rows="3" style="border: none;" id="introduce"></textarea>
					<div class="inputlimit" id="introLimit">50</div>
				</div>

			</div>

			<div class="title text-indent">
				<span class="title-text small-text gray-text">园区动态</span>
			</div>
			<div class="row-10 clr-fix">
				<input class="row-10 setting-input left small-text" name="activeTitle" placeholder="请输入动态标题" 
					style="border: none;text-indent: 1rem;" maxlength="10">
			</div>
			<div class="title">
				<span class="title-text small-text gray-text"></span>
			</div>
			<div class=" small-text row-10">
				<div class="row-10 " >
					<!--<label style="color: darkgray;" for="activeMsg" id="forActive">请输入动态内容</label>-->
					<textarea class="row-10 light-gray-text" rows="3" style="border: none;" id="activeMsg"></textarea>
					<div class="inputlimit" id="activeLimit">50</div>
				</div>
			</div>
			<div class="row-10 edit-add">
				<div class="edit-inner-div">
					<button id="addActive" class="edit-save" style="font-size: 1.5rem;">保存并新增</button>
				</div>
			</div>
			<div class="title text-indent">
				<span class="title-text small-text gray-text">动态列表</span>
			</div>

			<div class="row-10  normal-text edit-margin">
				<div class="row-9 clr-fix">
					<div class="row-7 left">圣诞快乐圣诞快乐圣诞</div>
					<div class="row-3 left right-text">
						<!--这里渲染条目id-->
						<input type="hidden" value="" />
						<a href="javascript:void(0)" style="color: #2C8FFF;" name="delActive">删除</a>
					</div>
				</div>
			</div>
			<div class="row-10  bottomline"></div>
			<div class="row-10  normal-text edit-margin">
				<div class="row-9 clr-fix">
					<div class="row-7 left">圣诞快乐</div>
					<div class="row-3 left right-text">
						<!--这里渲染条目id-->
						<input type="hidden" value="" />
						<a href="javascript:void(0)" style="color: #2C8FFF;" name="delActive">删除</a>
					</div>
				</div>
			</div>
			<div class="row-10  bottomline"></div>
			<div class="setting-save row-10 " style="margin-top: 50px;">
				<div class="row-9">
					<button class="back-orange" style="font-size: 1.5rem;color:#fff;" id="saveConfig">保存</button>
				</div>
			</div>

		</div>

		<footer class="row-10 footer edit light-gray-text">
			<div class="row-9 center-text footer-top">
				<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
			</div>
			<div class="row-9 center-text footer-bottom">
				<span class="small-text">400-8252-525</span>
			</div>
		</footer>

		<div class="nav row-10" >
			<a href="index.html">
				<div class="left row-3-3 center-text">
					<div class="nav-img"><img src="img/nav/1.png"></div>
					<div class="nav-title small-text">首页</div>
				</div>
			</a>
			<a href="#/config">
				<div class="left row-3-3 center-text">
					<div class="nav-img"><img src="img/nav/2.png"></div>
					<div class="nav-title small-text">配置</div>
				</div>
			</a>
			<a href="#/statiscial">
				<div class="left row-3-3 center-text">
					<div class="nav-img"><img src="img/nav/3.png"></div>
					<div class="nav-title small-text">统计</div>
				</div>
			</a>
		</div>
		<div class="img-upload-dialog row-10 normal-text">
			<div class="img-upload-dialog-text row-9 center-text">
				<span>图片上传</span>
				<span class="light-gray-text">(大小不得超过1M)</span>
			</div>
			<div class="img-upload-dialog-text row-9 center-text">
				<span>拍摄</span>
				<input class="img-upload-dialog-input row-10" type="file">
			</div>
			<div class="img-upload-dialog-text row-9 center-text">
				<span>本地相册</span>
				<input class="img-upload-dialog-input row-10" type="file">
			</div>
			<div class="img-upload-dialog-bottom row-9 center-text">
				<button class="img-upload-dialog-button row-9">取消</button>
			</div>
		</div>
		<div id="overlay"></div>
</script><script type="text/template" id="mngInfo_tpl">
	<header class="header back-blue">
		<nav>
			<a href="#/userCenter">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/back.png">
				</div>
			</a>
			<div class="center-text row-5 left normal-text">园区资料</div>
			<a href="javascript:void(0)">
				<div class="header-right right-text row-2-5 left small-text">

				</div>
			</a>
		</nav>
	</header>

	<div class="container clr-fix">
		<div class="row-9 info-avatar">
			<div class="row-3 left small-text"><span>园区LOGO</span></div>
			<div class="row-4 right">
				<input class="info-avatar-file info-input display-alpha right" type="file">
				<img class="info-avatar-img right row-5" src="img/messageboard/avatar.png" alt="头像">
			</div>
		</div>
		<div class="row-9 normal-height info-nick">
			<div class="row-3 left small-text"><span>园区名称</span></div>
			<div class="row-7 left ">
				<input class="info-input small-height small-text light-gray-text" type="text" readonly value="默认激活时信息" />
			</div>
		</div>

		<div class="row-9 normal-height info-nick">
			<div class="row-3 left small-text"><span>园区电话</span></div>
			<div class="row-7 left ">
				<input class="info-input small-height small-text light-gray-text" type="text" readonly value="默认激活时信息" />
			</div>
		</div>
		<div class="row-9 normal-height info-nick">
			<div class="row-3 left small-text"><span>管理员姓名</span></div>
			<div class="row-7 left">
				<input class="info-input small-height small-text" type="text" name="name" placeholder="请输入姓名" />
			</div>
		</div>
		<div class="row-9 normal-height info-nick">
			<div class="row-3 left small-text"><span>管理员昵称</span></div>
			<div class="row-7 left">
				<input class="info-input small-height small-text" type="text" name="nickName" placeholder="请输入昵称" />
			</div>
		</div>

		<div class="row-9 normal-height info-sex">
			<div class="row-3 left small-text"><span>性别</span></div>
			<div class="row-7 left">
				<div class="row-2-5 right">
					<input class="info-input info-checkbox-female left small-height" type="checkbox" id="female">
					<label class="left checkbox-label" for="female"></label>
					<span class="small-text">女</span>
				</div>
				<div class="row-2-5 right">
					<input class="info-input info-checkbox-male left small-height" type="checkbox" id="male">
					<label class="left checkbox-label" for="male"></label>
					<span class="small-text">男</span>
				</div>
				<div class="row-3-3 right">
					<input class="info-input info-checkbox-secrect left small-height" type="checkbox" id="secrect">
					<label class="left checkbox-label" for="secrect"></label>
					<span class="small-text">保密</span>
				</div>
			</div>
		</div>
		<div class="row-9 normal-height clr-fix info-birthday clr-fix">
			<div class="row-3 left small-text">生日</div>
			<div class="row-5 right right-text normal-text">
				<input class="info-birthday-input info-input normal-height" type="date" placeholder="请选择">
			</div>
		</div>
		<div class="row-9 normal-height clr-fix info-birthday clr-fix">
			<div class="row-3 left small-text">地址</div>
			<div class="row-5 right right-text normal-text">
				<input class="info-input small-height small-text light-gray-text" type="text" readonly value="默认激活时信息" />
			</div>
		</div>
	</div>
	<div class="information-save row-10 ">
		<div class="row-9">
			<span class="errorMsg"></span>
			<button class="back-orange" id="save" style="color: #fff;font-size: 1.5rem;">保存</button>
		</div>
	</div>
	</div>

	<footer class="row-10 footer light-gray-text">
		<div class="row-9 center-text footer-top">
			<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
		</div>
		<div class="row-9 center-text footer-bottom">
			<span class="small-text">400-8252-525</span>
		</div>
	</footer>

	<div id="overlay"></div>
</script><script type="text/template" id="statiscial_tpl">
	<header class="header back-blue">
		<nav>
			<a href="index.html">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/back.png">
				</div>
			</a>
			<div class="center-text row-5 left normal-text">统计</div>

		</nav>
	</header>

	<div class="container statiscontainer">
		<div class="row-10 clr-fix">
			<div class="row-5 left">
				<div class="visit-top-number row-9 center-text">
					
				</div>
				<div class="visit-top-text row-9 normal-text center-text"><%=data.id%>充值总金额(元)</div>
			</div>
			<div class="row-5 left">
				<div class="visit-top-number visit-top-border-left row-10 center-text ">
					
				</div>
				<div class="visit-top-text visit-top-border-left row-10 normal-text center-text "><%=data.name%>平均充值金额(元)</div>
			</div>
		</div>

		<!--<div class="information-save row-10 ">
				<div class="row-9">
					<button class="back-orange" id="send">一键发短信</button>
				</div>
			</div>-->
		<!-- 访客 -->
		<div class="title">
			<span class="title-text small-text gray-text"></span>
		</div>

		<div class="row-9 clr-fix visit-border-top">
			<div class="row-5 left">
				<div class="visit-top-padding small-text">当前付费用户</div>
			</div>
			<div class="row-5 left">
				<div class="visit-top-padding row-10 small-text right-text">
			
				</div>
			</div>
		</div>
		<div class="title">
			<span class="title-text small-text gray-text"></span>
		</div>
		<div class="row-9 clr-fix visit-border-top">
			<div class="row-5 left">
				<div class="visit-top-padding small-text">注册用户:</div>
			</div>
			<div class="row-5 left">
				<div class="visit-top-padding row-10 small-text right-text">
		
				</div>
			</div>
		</div>
		<div class="bottomline"></div>
		<div class="row-9 clr-fix visit-border-top">
			<div class="row-5 left">
				<div class="visit-top-padding small-text">付费用户:</div>
			</div>
			<div class="row-5 left">
				<div class="visit-top-padding row-10 small-text right-text">
				
					<span></span>
				</div>
			</div>
		</div>

		<div class="title row-10">
			<div class="row-9">
				<span class="title-text small-text gray-text">付费用户明细</span>
			</div>

		</div>
		<!-- 数据内容,重复渲染 -->
		<div id="visit-list">
			<%=data%>
				<div class="row-10 visit-border-top">
					<div class="row-9 clr-fix small-text light-gray-text">
						<span></span>
						<span>20:00:12</span>
					</div>
					<div class="row-9 clr-fix">
						<div class="row-5 left">
							<div class="normal-text">189****8981</div>
						</div>
						<div class="row-5 left">
							<div class=" row-9 normal-text right-text" id="">
								￥4
								<!--<img class="visit-next" src="img/visit/down.png">-->
							</div>
						</div>
					</div>
					<div class="bottomline"></div>
				</div>

		</div>
		<div class="row-10 clr-fix visit-border-top"></div>
		<!--END-->
		<div class="row-10 small-text center-text ">
			<a id="more" href="javascript:void(0)" class="blue-text">点击加载更多 </a>
		</div>
		<footer class="row-10 footer light-gray-text" style="padding-top: 45px;">
			<div class="row-9 center-text footer-top">
				<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
			</div>
			<div class="row-9 center-text footer-bottom">
				<span class="small-text">400-8252-525</span>
			</div>
		</footer>
		<div class="nav row-10">
			<a href="index.html">
				<div class="left row-3-3 center-text">
					<div class="nav-img"><img src="img/nav/1.png"></div>
					<div class="nav-title small-text">首页</div>
				</div>
			</a>
			<a href="#/config">
				<div class="left row-3-3 center-text">
					<div class="nav-img"><img src="img/nav/2.png"></div>
					<div class="nav-title small-text">配置</div>
				</div>
			</a>
			<a href="#/statiscial">
				<div class="left row-3-3 center-text">
					<div class="nav-img"><img src="img/nav/3.png"></div>
					<div class="nav-title small-text">统计</div>
				</div>
			</a>
		</div>
		<div id="overlay"></div>
</script><script type="text/template" id="login_tpl">
	<header>
		<nav>
			<div class="loginlogo row-10 back-blue center-text">
				<img class="row-5-2 loginlogo-icon" src="img/header/logo.png" alt="logo">
			</div>
		</nav>
	</header>

	<div class="logincontainer">
		<div class="row-9 loginErr">
			<span class="errorMsg"></span>
		</div>
		<div class="row-9">
			<input type="text" class="logininput" name="username" placeholder="输入手机号" maxlength="11" style="font-size: 1.5rem;">
		</div>
		<div class="row-9">
			<input type="password" class="logininput" name="password" placeholder="输入密码" style="font-size: 1.5rem;">
		</div>
		<div class="row-9">
			<a href="#/resetPwd"><span class="right small-text light-gray-text forget">忘记密码</span></a>
		</div>
		<div class="row-9 loginbutton">
			<div class="row-4-7 left">
				<a href="#/register">
					<button class="back-gray gray-text" style="color: #666;font-size: 1.5rem;">注册免费上网</button>
				</a>
			</div>
			<div class="row-4-7 right">
				<button class="back-orange" id="login" style="color: #fff;font-size: 1.5rem;">登录</button>
			</div>
		</div>
	</div>

	<footer class="row-10 footer light-gray-text">
		<div class="row-9 center-text footer-top">
			<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
		</div>
		<div class="row-9 center-text footer-bottom">
			<span class="small-text">400-8252-525</span>
		</div>
	</footer>
</script><script type="text/template" id="register_tpl">
	<div id="register">
		<header class="header back-blue">
			<nav>
				<a href="#/login">
					<div class="header-left center-text row-2-5 left small-text">
						<img class="header-left-img" src="img/header/back.png">
					</div>
				</a>
				<div class="center-text row-5 left normal-text">注册</div>
			</nav>
		</header>

		<div class="container regcontainer">
			<div class="row-9">
				<input type="text" placeholder="输入手机号" name="username" maxlength="11" style="font-size: 1.5rem;">
			</div>
			<div class="row-9 captcha">
				<input class="row-4-7" type="text" placeholder="输入验证码" name="captcha" maxlength="4" style="font-size: 1.5rem;">
				<button class="row-4-7 right clr-fix back-gray gray-text" style="font-size: 1.5rem;">获取验证码</button>
			</div>
			<div class="row-9">
				<input type="password" placeholder="输入密码" name="password" style="margin-bottom: 0;font-size: 1.5rem;">
				<span class="tipMsg">6-20位，包含数字和字母</span>
			</div>
			<div class="row-9">
				<input type="password" placeholder="确认密码" name="password_again" style="font-size: 1.5rem;">
			</div>

			<div class="row-9">
				<input class="regcheckbox regcheckbox row-1 left" type="checkbox" id="agree" checked="true" disabled="true">
				<label class="left checkbox-label" for="agree"></label>
				<span class="left register-agree-text">我已阅读并同意
    				<a href="javascript:void(0)" class="blue-text" id="showRule">《爱WIFI用户协议》</a>
				</span>
			</div>

			<div class="row-9 regsubmit" id="submit">
				<div class="row-9 regErr">
					<span class="errorMsg"></span>
				</div>
				<button class="back-orange" style="font-size: 1.5rem;color: #fff;" id="registerBtn">注册</button>
				<div style="text-align: center;margin-top: 0.7rem;">
					<span style="color: #999999;font-size: 1.2rem;">注册成功即可获得免费上网体验</span>
				</div>
			</div>
		</div>

		<footer class="row-10 footer light-gray-text">
			<div class="row-9 center-text footer-top">
				<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
			</div>
			<div class="row-9 center-text footer-bottom">
				<span class="small-text">400-8252-525</span>
			</div>
		</footer>
	</div>

	<div id="rule" style="display: none;">
		<header class="header back-blue">
			<nav>
				<a href="register.html">
					<div class="header-left center-text row-2-5 left small-text">
						<img class="header-left-img" src="img/header/back.png">
					</div>
				</a>
				<div class="center-text row-5 left normal-text">服务协议</div>
				<a href="javascript:void(0)" id="agreeRule">
					<div class="header-right right-text row-2-5 left small-text">
						<span class="header-right-span">同意</span>
					</div>
				</a>
			</nav>
		</header>

		<div class="container">
			<div class="row-9 center-text">
				<span class="big-text" style="padding: 15px 0;display:block;">爱WiFi用户服务协议</span>
			</div>

			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				<span>感谢您使用爱WiFi网络平台。</span>
				<br>
				<span></span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>爱WiFi网络平台由浙江省公众信息产业有限公司无线运营分公司开发并免费提供给用户使用，本平台的一切知识产权和相关信息内容均受到平台著作权法及其他知识产权法律法规的保护。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>为使用爱WiFi网络及服务，您应当阅读并遵守《爱WiFi用户服务协议》（以下简称“本协议”）。请您务必审慎阅读、充分理解各条款内容，特别是权利限制和免责条款，以及开通或使用某项服务的单独协议，并选择接受或不接受。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>除非您已阅读并接受本协议所有条款，否则您无权下载、安装、使用本平台及相关服务。您一旦安装、复制、下载、访问或以其它方式使用本平台的产品，将视为对本《协议》的接受，即表示您同意接受本《协议》各项条款的约束。如果您不同意本《协议》中的条款，请不要安装、复制或使用本平台。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>如果你未满18周岁，请在法定监护人的陪同下阅读本协议及其他上述协议。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<div class="row-9 normal-text">一、权利声明</div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>本平台的一切知识产权，以及相关的所有信息内容，包括但不限于：文字表述及其组合、图标、图饰、图像、图表、色彩、界面设计、版面框架、有关数据、附加程序、印刷材料或电子文档等均为中国电信所有，受著作权法和国际著作权条约以及其他知识产权法律法规的保护。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<div class="row-9 normal-text">二、用户权利</div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>2.1 复制、分发和传播：用户可以非商业性、无限制数量地复制、分发和传播本平台产品。但必须保证每一份复制、分发和传播都是完整和真实的, 包括所有有关本平台产品的平台、电子文档, 版权和商标，亦包括本协议。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>2.2 用户有权更改、删除在本平台上的个人资料、注册信息及传送内容等，但需注意，删除有关信息的同时也会删除任何您储存在系统中的文字和图片。用户需承担该风险。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>2.3 用户注册后将拥有本平台的账号相关信息，用户有责任妥善保管注册帐号信息及帐号密码的安全，需要对注册帐号以及密码下的行为承担法律责任。用户同意在任何情况下不使用其他成员的帐号或密码。在用户怀疑他人在使用您的帐号或密码时，应立即通知本公司。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<div class="row-9 normal-text">三、权利限制</div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>3.1 禁止反向工程、反向编译和反向汇编：用户不得对本平台产品进行反向工程（Reverse Engineering）、反向编译（Decompile）或反向汇编（Disassemble），同时不得改动编译在程序文件内部的任何资源。除法律、法规明文规定允许上述活动外，用户必须遵守此协议限制。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>3.2 组件分割:本平台产品是作为一个单一产品而被授予许可使用, 用户不得将各个部分分开用于任何目的。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>3.3 个别授权: 如需进行商业性的销售、复制、分发，包括但不限于平台销售、预装、捆绑等，必须获得中国电信的书面授权和许可。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>3.4 保留权利：本协议未明示授权的其他一切权利仍归中国电信所有，用户使用其他权利时必须获得中国电信的书面同意。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<div class="row-9 normal-text">四、用户使用须知</div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.1 平台的修改和升级：中国电信保留随时为用户提供本平台的修改、升级版本的权利。由用户选择确定后，平台会进行升级更新，若因此而产生相应的数据流量费，本公司概不负责。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.2本平台不含有任何旨在破坏用户数据和获取用户隐私信息的恶意代码，不含有任何监控、监视用户手机的功能代码，不会恶意收集用户个人文件、文档等信息，不会泄漏用户隐私。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.3 本公司保留因业务发展需要，单方面对本平台的全部或部分服务内容在任何时候不经任何通知的情况下进行变更、暂停、限制、终止或撤销本平台服务的权利，用户需承担此风险。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4 用户应在遵守法律及本协议的前提下使用本平台。用户无权实施包括但不限于下列行为：</span>
				<br>

				<div class="smaller-text">
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.1 删除或者改变本平台上的所有权利管理电子信息；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.2 故意避开或者破坏著作权人为保护本平台著作权而采取的技术措施；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.3 利用本平台误导、欺骗他人；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.4 违反国家规定，对计算机信息系统功能进行删除、修改、增加、干扰，造成计算机信息系统不能正常运行；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.5 未经允许，进入计算机信息网络或者使用计算机信息网络资源；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.6 未经允许，对计算机信息网络功能进行删除、修改或者增加的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.7 未经允许，对计算机信息网络中存储、处理或者传输的数据和应用程序进行删除、修改或者增加；</span>
					<br>
					<span><a href="javascript:" class="small-text"><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
					</a>4.4.8 破坏本平台系统或网站的正常运行，故意传播计算机病毒等破坏性程序；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.4.9 其他任何危害计算机信息网络安全的行为。</span>
					<br>
				</div>

				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5 用户不得利用本平台或本平台服务制作、上载、复制、发送如下内容：</span>
				<br>
				<div class="smaller-text">
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.1 反对宪法所确定的基本原则的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.2 危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.3 损害国家荣誉和利益的； </span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.4 煽动民族仇恨、民族歧视，破坏民族团结的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.5 破坏国家宗教政策，宣扬邪教和封建迷信的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.6 散布谣言，扰乱社会秩序，破坏社会稳定的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.7 散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.8 侮辱或者诽谤他人，侵害他人合法权益的；</span>
					<br>
					<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.5.9 含有法律、行政法规禁止的其他内容的信息。</span>
					<br>
				</div>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.6 本平台提供的服务中可能包括广告，用户同意在使用过程中显示本平台和第三方供应商、合作伙伴提供的广告并放弃向本公司索取任何广告费用或收益。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.7 用户应确保将通过中国电信免费WiFi所接入的热点资源用于恰当用途，严禁利用本平台服务从事任何违反法律法规或侵犯第三方合法权益的行为，严禁将从本平台所获上网时长运用于实现商业目的分享或推广。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.8本公司可依其合理判断，对违反有关法律法规或本协议约定；或侵犯、妨害、威胁任何人权利或安全的内容，或者假冒他人的行为，本公司有权依法停止传输任何前述内容，并有权依其自行判断对违反本条款的任何人士采取适当的法律行动，包括但不限于，从本平台服务中删除具有违法性、侵权性、不当性等内容，终止违反者的成员资格，阻止其使用本平台全部或部分服务，并且依据法律法规保存有关信息并向有关部门报告等。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.9 用户应遵守本协议的各项条款，正确、适当地使用本服务，如因用户违反本协议中的任何条款，本公司有权依据协议终止对违约用户本平台帐号提供服务。同时，本公司保留在任何时候收回本平台帐号、用户名的权利。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.10 用户注册本平台帐号后如果长期不登录该帐号，本公司有权回收该帐号，以免造成资源浪费，由此带来问题均由用户自行承担。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>4.11 本平台的所有权和运作权归本公司。本公司提供的服务将完全按照其发布的章程、服务条款和操作规则严格执行。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<div class="row-9 normal-text">五、免责条款</div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>用户在使用本平台时，若因下列情形而发生的任何可能侵权行为，均以本平台无关：</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.1 对于从非中国电信指定站点使用本平台产品以及从非中国电信发行的介质上获得的本平台产品，中国电信无法保证该平台是否感染计算机病毒、是否隐藏有伪装的特洛伊木马程序或者黑客平台，使用此类平台，将可能导致不可预测的风险，建议用户不要轻易下载、安装、使用，中国电信不承担任何由此产生的一切法律责任。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.2 用户在本平台服务中或通过本平台服务所传送的任何内容并不代表或暗示本公司的观点或政策，本公司对此不承担任何责任。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.3 用户须对在本平台上所传送信息的真实性、合法性、有效性等全权负责，与用户所传播的信息相关的任何法律责任由用户自行承担，与本公司无关。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.4 本平台涉及到WiFi联网和Internet服务，可能会受到各个环节不稳定因素的影响。因此服务存在因上述不可抗力、病毒或黑客攻击、系统不稳定、用户所在位置、用户关机以及其他任何技术、GSM网络、互联网络、通信线路原因等造成服务中断或不能满足用户要求的风险。开通服务的用户须承担以上风险，服务方对服务之及时性、安全性、准确性不作担保，对因此导致用户通信不畅，不承担任何责任。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.5 用户非本平台内（如：其他WiFi管理工具或手机系统WLAN）连接收费WiFi（通常会要求输入手机号码/帐号密码），并在第三方浏览器中输入手机号码/帐号密码而造成被第三方收取上网资费的情况，与本平台无关；</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.6 用户因与第三方收费WiFi（由其他运营商）已签订自动登录服务，导致系统WLAN一旦连接该收费WiFi便会自动收取用户上网资费的情况，与本平台无关；</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.7 用户通过本平台可免费接入中国电信WiFi，但将消耗已获得的免费时长，免费时长由爱WiFi客户端无偿赠与用户使用，但用户使用免费时长所产生的具体上网行为，与本平台无关。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.8 我们不建议用户在第三方WiFi平台进行资金方面的交易，故，用户在未经认证的第三方WiFi进行资金交易所可能存在的风险情况，与本平台无关；</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>5.9用户违反本《协议》或相关的服务条款的规定，导致或产生的任何第三方主张的任何索赔、要求或损失，包括合理的律师费，与本平台无关。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>上述情况的发生与本平台之间并无直接关联，故本平台不应承担上述情况的赔偿责任，但我们会努力协助用户并联合同相关执法部门严厉打击上述侵犯用户权益的责任方，并尽可能为营造一个更安全便捷的WiFi环境而努力！</span>
				<br>
			</div>

			<div class="row-9 normal-text">六、其他条款</div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>6.1 本公司郑重提醒用户注意本《协议》中免责条款和权利限制的条款，请用户仔细阅读，自主考虑风险。未成年人应在法定监护人的陪同下阅读本《协议》。以上各项条款内容的最终解释权及修改权归本公司所有。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>6.2 本《协议》所定的任何条款的部分或全部无效者，不影响其它条款的效力。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>6.3 本《协议》签订地为浙江省杭州市。本《协议》的解释、效力及纠纷的解决，适用于中华人民共和国法律。若用户和本公司之间发生任何纠纷或争议，首先应友好协商解决，协商不成的，用户在此完全同意将纠纷或争议提交本公司住所地即浙江省杭州市有管辖权的人民法院管辖。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>6.4 本《协议》的版权由本公司所有，爱WiFi保留对上述条例的最终解释权。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>6.5 若您对本公司及本服务有任何意见，欢迎垂询本公司客服中心。</span>
				<br>
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<div class="row-9 normal-text"></div>
			<div class="row-9 small-text">
				<span><a href="javascript:" class="small-text"><span class="display-hidden">开头</span></a>
				</span>
				<br>
			</div>

			<footer class="row-10 footer light-gray-text">
				<div class="row-9 center-text footer-top">
					<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
				</div>
				<div class="row-9 center-text footer-bottom">
					<span class="small-text">400-8252-525</span>
				</div>
			</footer>
		</div>

</script><script type="text/template" id="resetPwd_tpl">
	<header class="header back-blue">
		<nav>
			<a href="#/login">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/back.png">
				</div>
			</a>
			<div class="center-text row-5 left normal-text">忘记密码</div>
		</nav>
	</header>

	<div class="container pwdcontainer">
		<div class="row-9">
			<input type="text" placeholder="输入手机号" name="username" maxlength="11" style="font-size: 1.5rem;">
		</div>
		<div class="row-9 captcha">
			<input class="row-4-7" type="text" placeholder="输入验证码" name="captcha" maxlength="4" style="font-size: 1.5rem;">
			<button class="row-4-7 right clr-fix back-gray gray-text" style="font-size: 1.5rem;">获取验证码</button>
		</div>
		<div class="row-9">
			<input type="password" placeholder="输入密码" name="password" style="margin-bottom: 0;font-size: 1.5rem;">
			<span class="tipMsg">6-20位，包含数字和字母</span>
		</div>

		<div class="row-9">
			<input type="password" placeholder="确认密码" name="password_again" style="font-size: 1.5rem;">
		</div>
		<div class="row-9 pwdError"><span class="errorMsg"></span></div>
		<div class="row-9 pwdsubmit" id="submit">
			<button class="back-orange" style="font-size: 1.5rem;color: #fff;">确定</button>
		</div>
	</div>

	<footer class="row-10 footer light-gray-text">
		<div class="row-9 center-text footer-top">
			<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
		</div>
		<div class="row-9 center-text footer-bottom">
			<span class="small-text">400-8252-525</span>
		</div>
	</footer>
</script><script type="text/template" id="userCenter_tpl">
	<header class="header back-blue">
		<nav>
			<a href="index.html">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/back.png">
				</div>
			</a>
			<div class="center-text row-5 left normal-text">个人中心</div>
		</nav>
	</header>

	<div class="container">
		<div class="row-10">
			<!--这里根据角色渲染不同的地址-->
			<a href="#/mngInfo">
				<div class="row-9 clr-fix">
					<div class="left personal-img"><img src="img/messageboard/avatar.png"></div>
					<div class="row-6 left">
						<div class="personal-info normal-text">个人头像</div>
						<div class="personal-info normal-text">13345678900</div>
					</div>
					<div class="personal-next right">
						<img class="personal-next-img" src="img/visit/next.png">
					</div>
				</div>
			</a>
		</div>
		<!--套餐信息-->
		<div class="title">
			<div class="row-9 clr-fix small-text">
				<span class="title-text" style="color: #999999;"> 套餐信息</span>
			</div>
		</div>
		<div class="row-10 normal-height normal-text personal-border-bottom">
			<a href="javascript:void(0);">
				<div class="row-9 clr-fix small-text">
					套餐:<span>1元/天X1</span>
				</div>
				<div class="row-10  bottomline"></div>
			</a>
		</div>
		<div class="row-10  normal-text">
			<div class="row-9 clr-fix">
				<div style="padding-top: 0.7rem;">
					<span class="small-text minspan ">有效期：</span>
				</div>
				<div style="padding-bottom: 0.7rem;">
					<span class="small-text "> 2015-12-01-12:12</span>-<span class="small-text">2015-12-01-12-12</span>
				</div>
			</div>
		</div>
		<!--套餐信息end-->
		<!--消费记录-->
		<div class="title">
			<div class="row-9 clr-fix small-text">
				<span class="title-text" style="color: #999999;"> 消费记录</span>
			</div>
		</div>
		<div id="xiaofeijilu">
			<div class="row-10  normal-text">
				<div class="row-9 clr-fix">
					<div style="padding-top: 0.7rem;">
						<span class="little-text minspan " style="font-size: 1.2rem;color:#999">2015/06/01 21：00：12</span>
					</div>
					<div style="padding: 0.7rem 0;">
						<div class="row-5 left">上网时长：7天</div>
						<div class="row-5 left right-text">￥7</div>
					</div>
				</div>
			</div>
			<div class="row-10  bottomline"></div>

			<div class="row-10  normal-text">
				<div class="row-9 clr-fix">
					<div style="padding-top: 0.7rem;">
						<span class="little-text minspan " style="font-size: 1.2rem;color:#999">2015/06/01 21：00：12</span>
					</div>
					<div style="padding: 0.7rem 0;">
						<div class="row-5 left">上网时长：7天</div>
						<div class="row-5 left right-text">￥7</div>
					</div>
				</div>
			</div>
			<div class="row-10  bottomline"></div>

			<div class="row-10  normal-text">
				<div class="row-9 clr-fix">
					<div style="padding-top: 0.7rem;">
						<span class="little-text minspan " style="font-size: 1.2rem;color:#999">2015/06/01 21：00：12</span>
					</div>
					<div style="padding: 0.7rem 0;">
						<div class="row-5 left">上网时长：7天</div>
						<div class="row-5 left right-text">￥7</div>
					</div>
				</div>
			</div>
			<div class="row-10  bottomline"></div>
		</div>
		<div class="row-10 small-text center-text ">
			<a id="more" href="javascript:void(0)" class="blue-text">点击加载更多 </a>
		</div>
	</div>

	<footer class="row-10 footer light-gray-text">
		<div class="row-9 center-text footer-top">
			<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
		</div>
		<div class="row-9 center-text footer-bottom">
			<span class="small-text">400-8252-525</span>
		</div>
	</footer>
</script><script type="text/template" id="userInfo_tpl">
	<header class="header back-blue">
		<nav>
			<a href="#/userCenter">
				<div class="header-left center-text row-2-5 left small-text">
					<img class="header-left-img" src="img/header/back.png">
				</div>
			</a>
			<div class="center-text row-5 left normal-text">个人资料</div>
			<a href="javascript:void(0)">
				<div class="header-right right-text row-2-5 left small-text">

				</div>
			</a>
		</nav>
	</header>

	<div class="container infocontainer clr-fix">
		<div class="row-9 info-avatar">
			<div class="row-3 left small-text"><span>个人头像</span></div>
			<div class="row-4 right">
				<input class="info-avatar-file info-input display-alpha right" type="file">
				<img class="info-avatar-img right row-5" src="img/messageboard/avatar.png" alt="头像">
			</div>
		</div>
		<div class="row-9 normal-height info-nick">
			<div class="row-3 left small-text"><span>昵称</span></div>
			<div class="row-7 left">
				<input class="info-input small-height" type="text" name="nickName" placeholder="请输入不超过8位的昵称" style="font-size: 1.5rem;" maxlength="8">
			</div>
		</div>
		<div class="row-9 normal-height info-sex">
			<div class="row-3 left small-text"><span>性别</span></div>
			<div class="row-7 left">
				<div class="row-2-5 right">
					<input class="info-input info-checkbox-female left small-height" type="checkbox" id="female">
					<label class="left checkbox-label" for="female"></label>
					<span class="small-text">女</span>
				</div>
				<div class="row-2-5 right">
					<input class="info-input info-checkbox-male left small-height" type="checkbox" id="male">
					<label class="left checkbox-label" for="male"></label>
					<span class="small-text">男</span>
				</div>
				<div class="row-3-3 right">
					<input class="info-input info-checkbox-secrect left small-height" type="checkbox" id="secrect">
					<label class="left checkbox-label" for="secrect"></label>
					<span class="small-text">保密</span>
				</div>
			</div>
		</div>
		<div class="row-9 normal-height clr-fix info-birthday clr-fix">
			<div class="row-3 left small-text"><span>生日</span></div>
			<div class="row-5 right right-text normal-text">
				<input class="info-birthday-input info-input normal-height" type="date" placeholder="请选择">
				<!-- <span id="birthday">请选择</span> -->
			</div>
		</div>
		<div class="row-9 info-address clr-fix">
			<div class="row-3 left small-text normal-height"><span>地址</span></div>
			<div class="row-7 left">
				<textarea class="row-9 info-input small-height info-input-address right-text" placeholder="请输入地址" style="font-size: 1.5rem;"></textarea>
			</div>
		</div>

		<div class="information-save row-10 ">
			<div class="row-9 loginErr">
				<span class="errorMsg"></span>
			</div>
			<div class="row-9">
				<button class="back-orange" id="save" style="color: #fff;font-size: 1.5rem;">保存</button>
			</div>
		</div>
	</div>

	<footer class="row-10 footer light-gray-text">
		<div class="row-9 center-text footer-top">
			<span class="small-text">本系统由中国电信爱WiFi运营中心提供支持</span>
		</div>
		<div class="row-9 center-text footer-bottom">
			<span class="small-text">400-8252-525</span>
		</div>
	</footer>

	<div id="overlay"></div>
</script>