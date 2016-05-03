URIList = {

	context : {
		homeURI : '#/home', // 主页地址配置
		templateSuffix : "tpl", // 模版后缀名配置
		// before_controller : BeforeController, //所有uri请求执行之前执行的controller
		before_controller : null,
		// after_controller : AfterController, //所有uri请求执行之后执行的controller
		after_controller : null,
		refresh : true, // uri跳转，如果uri已经访问过是否刷新。
		refreshFlag : "true" // uri参数中存在该参数，则将会刷新页面，否则不刷新。
	},
	//主页
	index_uri : {
		extend : null,
		uri : '#/',
		layout : [ {
			selector : '#MainContent',
			template : "index_tpl",
			controller : IndexController,
			append : false
		} ]
	},
	//登录
	login_uri : {
		extend : null,
		uri : '#/login',
		layout : [ {
			selector : '#MainContent',
			template : "login_tpl",
			controller : LoginController,
			append : false
		} ]
	},
	//注册
	register_uri : {
		extend : null,
		uri : '#/register',
		layout : [ {
			selector : '#MainContent',
			template : "register_tpl",
			controller : RegisterController,
			append : false
		} ]
	},
	//忘记密码
	resetPwd_uri : {
		extend : null,
		uri : '#/resetPwd',
		layout : [ {
			selector : '#MainContent',
			template : "resetPwd_tpl",
			controller : ResetPwdController,
			append : false
		} ]
	},
	//购买套餐
	buy_uri : {
		extend : null,
		uri : '#/buy',
		layout : [ {
			selector : '#MainContent',
			template : "buy_tpl",
			controller : BuyController,
			append : false
		} ]
	},
	//用户个人中心
	userCenter_uri : {
		extend : null,
		uri : '#/userCenter',
		layout : [ {
			selector : '#MainContent',
			template : "userCenter_tpl",
			controller : UserCenterController,
			append : false
		} ]
	},
	//用户个人信息
	userInfo_uri : {
		extend : null,
		uri : '#/userInfo',
		layout : [ {
			selector : '#MainContent',
			template : "userInfo_tpl",
			controller : UserInfoController,
			append : false
		} ]
	},
	//管理员个人信息
	mngInfo_uri : {
		extend : null,
		uri : '#/mngInfo',
		layout : [ {
			selector : '#MainContent',
			template : "mngInfo_tpl",
			controller : MngInfoController,
			append : false
		} ]
	},
	//园区配置
	config_uri : {
		extend : null,
		uri : '#/config',
		layout : [ {
			selector : '#MainContent',
			template : "config_tpl",
			controller : ConfigController,
			append : false
		} ]
	},
	//园区统计
	statiscial_uri : {
		extend : null,
		uri : '#/statiscial',
		layout : [ {
			selector : '#MainContent',
			template : "statiscial_tpl",
			controller : StatiscialController,
			append : false
		} ]
	}
};

URI.addURI(URIList);
window.logger = {
	log : function(msg) {
		console.log(msg);
	},
	error : function(msg) {
		console.log(msg);
	}
};MngParam = (function() {
	name = "user"; // 命名空间
	return {
		getName: function() {
			return name;
		},
		paramList: {
			/**
			 * @Comments : 默认请求参数。
			 */
			defaultParam: {
				url: '', //ajax请求的url。
				parameter: { //ajax请求的参数。
//					curpage: 1,
//					pagesize: 15
				},
				requestType: 'ajax', //默认请求方式，请求类型(HexinExeType:调用客户端程序, HexinRequestType:调用长连接, NormalRequestType:调用短连接)
				//success : function(options, result, textStatus, jqXHR),						//ajax请求成功后调用的方法。
				//failure : function(options, jqXHR, textStatus, errorThrown),						//ajax请求失败后调用的方法。
				//complete : function(options, jqXHR, textStatus),						//请求结束后执行的方法。
				resultWrapper: function(result) { //如果配置了该方法，ajax请求成功后首先走该方法
					return result;
				},
				forceRefresh: false, //是否强制刷新,
				dataType: 'json', //(HexinRequestType、NormalRequestType)数据类型(默认json)
				type: 'GET', //GET,POST请求
				result: {}
			},
			
			//管理员信息
			mngInfo:{
				url: '/',
				parameter: {
					'imgUrl': '',//头像地址
					'nickName': '',//昵称
					'sex': '',//性别
					'birthday': '',//生日
					'name': ''//姓名
				},
				type: 'POST'
			},
			//统计信息
			statiscial:{
				url: '/ms/member/merchant/visit/info',
				parameter: {
					'id':'' //园区id
				},
				type: 'POST'
			},
			//付费用户明细
			userPayDetail:{
				url: '/ms/member/merchant/visit/payinfo',
				parameter: {
					'id': '',//园区id
					'curpage': '',
					'pagesize': ''
				},
				type: 'POST'
			},
			//动态新增
			addActive:{
				url: '/',
				parameter: {
					'id': '',//园区id
					'activeTitle': '',//标题
					'activeMsg': ''//内容
				},
				type: 'POST'
			},
			//动态删除
			delActive:{
				url: '/',
				parameter: {
					'activeId': '',//动态条目id
					
				},
				type: 'POST'
			},
			//保存配置
			saveConfig:{
				url: '/',
				parameter: {
					
					
				},
				type: 'POST'
			},
			

		}
	}

})();

URLParam.addParamObj(MngParam);UserParam = (function() {
	name = "user"; // 命名空间
	return {
		getName: function() {
			return name;
		},
		paramList: {
			/**
			 * @Comments : 默认请求参数。
			 */
			defaultParam: {
				url: '', //ajax请求的url。
				parameter: { //ajax请求的参数。
					//					curpage: 1,
					//					pagesize: 15
				},
				requestType: 'ajax', //默认请求方式，请求类型(HexinExeType:调用客户端程序, HexinRequestType:调用长连接, NormalRequestType:调用短连接)
				//success : function(options, result, textStatus, jqXHR),						//ajax请求成功后调用的方法。
				//failure : function(options, jqXHR, textStatus, errorThrown),						//ajax请求失败后调用的方法。
				//complete : function(options, jqXHR, textStatus),						//请求结束后执行的方法。
				resultWrapper: function(result) { //如果配置了该方法，ajax请求成功后首先走该方法
					return result;
				},
				forceRefresh: false, //是否强制刷新,
				dataType: 'json', //(HexinRequestType、NormalRequestType)数据类型(默认json)
				type: 'GET', //GET,POST请求
				result: {}
			},
			// 登录
			login: {
				url: 'ms/login/save',
				parameter: {
					username: '', //用户名
					password: '' //密码
				},
				type: 'POST'
					//				dataType: 'json',
					//				result: {}
			},
			//注册
			register: {
				url: 'ms/reg/save',
				parameter: {
					username: '', //用户名
					password: '', //密码
					captcha: '' //验证码
				},
				type: 'POST'
			},
			//找回密码
			resetPwd: {
				url: 'ms/password/savePwd',
				parameter: {
					username: '', //用户名
					password: '', //密码
					captcha: '' //验证码
				},
				type: 'POST'
			},
			//用户个人中心
			center: {
				url: '/',
				parameter: {
					'id': '' //用户id
				},
				type: 'POST'
			},
			//加载更多消费记录
			payRecords: {
				url: '/',
				parameter: {
					'id': '', //用户id
					'curpage': '', //当前页
					'pagesize': '' //单页显示条数
				},
				type: 'POST'
			},
			//普通用户信息
			userInfo: {
				url: '/',
				parameter: {
					'imgUrl': '',//头像地址
					'nickName': '',//昵称
					'sex': '',//性别
					'birthday': '',//生日
					'address': ''//地址
				},
				type: 'POST'
			},


		}
	}

})();

URLParam.addParamObj(UserParam);