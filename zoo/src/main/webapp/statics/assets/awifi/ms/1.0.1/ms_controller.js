/**
 * 购买控制
 */
var BuyController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},

	addEventListener: function() {
		var that = this;
		//增加
		$("#addPic").on("tap", function() {
			var num = $("#num").val() || '0';
			num++;
			if (num > 0) {
				$("#cutPic").attr("src", "img/buy/cut.png");
			}
			$("#num").val(num);
		});
		//减少
		$("#cutPic").on("tap", function() {
			var num = $("#num").val() || '0';
			num--;
			if (num == 0) {
				$("#cutPic").attr("src", "img/buy/cutnot.png");
			} else if (num < 0) {
				return;
			}
			$("#num").val(num);
		});

		//购买
		$("#buy").on("tap", function() {
			var num = $("#num").val() || '0';
			var unit = $("#unit").val() || '0';
			//总价
			var totalPay = unit * num;
			//充值账户
			var account = "15012345678";
			//有效期
			var undertime = '<span>2015-12-1</span>至<span>12-6</span>';

			$("#totalPay").text(totalPay);
			$("#account").html(account);
			$("#undertime").html(undertime);

			$(".mask").show();
			$(".modal").show();
		});
		//取消
		$("#cancel").on("tap", function() {
			$(".modal").hide();
			$(".mask").hide();
		});
		//确认支付
		$("#surePay").on("tap", function() {

			alert("调支付接口");
		});


	},


});;/**
 * 主页控制
 */
var IndexController = EasyController.extend({
	selector : {

	},
	request : function() {
		this._data = {
			mngPower:1
			//渲染数据
			}
	},
	
	addEventListener : function() {
	//购买
	$("#buy").on("tap",function(){
		mvc.href("#/buy");
	});

    
		
	},
	
	
});;




/**
 * 园区配置控制
 */
var ConfigController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},
	//动态新增回调
	addActiveRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {

		}
		loading.hide();
	},
	//动态删除回调
	delActiveRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {

		}
		loading.hide();
	},
	//保存配置回调
	saveConfigRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {

		}
		loading.hide();
	},
	addEventListener: function() {
		var that = this;
		var id = this.params["id"]; //园区id
		/**
		 * 图片上传
		 */
		
		/**
		 * 动态新增
		 */
		$("#addActive").on("tap", function() {
			var activeTitle = $("#activeTitle").val() || '';
			var activeMsg = $("#activeMsg").val() || '';
			//保存动态
			Protocol.request("mng.addActive", {
				parameter: {
					'id': id,
					'activeTitle': activeTitle,
					'activeMsg': activeMsg
				},
				success: that.addActiveRequest
			});
		});
		/**
		 * 动态删除
		 */
		$("a[name='delActive']").on("tap", function() {
			//动态条目id
			var activeId = $(this).parent().find("input").val() || '';
			Protocol.request("mng.delActive", {
				parameter: {
					'activeId': activeId
				},
				success: that.delActiveRequest
			});
		});
		/**
		 * 保存配置信息
		 */
		$("#saveConfig").on("tap", function() {
                 //1.图片url获取
                 var imgUrl=[];
                 var introduce=$("#introduce").val();
                 Protocol.request("mng.saveConfig", {
				parameter: {
					
				},
				success: that.saveConfigRequest
			});
		});

		//Service
		/**
		 * 字数限制
		 */
		$("#introduce").on("keyup", function() {
			limitText($(this), 50, $("#introLimit"));
		});
		$("#introduce").on("keydown", function() {
			limitText($(this), 50, $("#introLimit"));
		});
		$("#introduce").on("change", function() {
			limitText($(this), 50, $("#introLimit"));
		});
		$("#activeMsg").on("keyup", function() {
			limitText($(this), 50, $("#activeLimit"));
		});
		$("#activeMsg").on("keydown", function() {
			limitText($(this), 50, $("#activeLimit"));
		});
		$("#activeMsg").on("change", function() {
			limitText($(this), 50, $("#activeLimit"));
		});
		/**
		 * 
		 * @param {Object} field  输入框$对象 必须
		 * @param {Object} max    最大长度    必须
		 * @param {Object} num    限制提示$对象(div)
		 */
		function limitText(field, max, num) {
			var v = field.val() || '';
			if (v.length > max) {
				var n = v.substr(0, max);
				field.val(n);
			} else if (num) {
				var l = max - v.length;
				num.html(l);
			}
		}
	},


});;/**
 * 管理员资料控制
 */
var MngInfoController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},
	//管理员信息修改回调
	mngInfoRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {
            
		} else {

		}
		loading.hide();
	},
	addEventListener: function() {
		var that = this;
		/**
		 * 头像上传
		 */
		$('.info-avatar-file').on('change', function() {
			loading.show();
			//这里发上传请求
		});
		/**
		 * 保存
		 */
		$("#save").on("tap", function() {
			var $errorMsg = $(".errorMsg");
			var imgUrl = $(".info-avatar-img").attr("src") || '/??'; //默认头像地址？？
			var nickName = $("input[name='nickName']").val() || '';
			var name=$("input[name='name']").val()||'';
			var sex;
			if ($("#female").is(':checked')) {
				sex = 2;
			} else if ($("#male").is(':checked')) {
				sex = 1;
			} else {
				sex = 0;
			}
			var birthday = $("input[type='date']").val() || '';
			if (nickName == '') {
				$errorMsg.text("请输入昵称");
				return;
			}
			loading.show();
			//保存园区资料
			Protocol.request("mng.mngInfo", {
				parameter: {
					'imgUrl': imgUrl,
					'nickName': nickName,
					'sex': sex,
					'birthday': birthday,
					'name': name
				},
				success: that.mngInfoRequest
			});


		});

		//Service		
		/**
		 * checkbox联动
		 */
		$('.info-sex').find('input[type=checkbox]').on('change', function() {
			$('.info-sex').find('input[type=checkbox]').not($(this)).each(function() {
				if ($(this).is(':checked')) {
					$(this).removeAttr('checked');
				}
			});
		});
		/**
		 * 性别回填
		 */
		function sexChecked(sex) {
			switch (sex) {
				case '0':
					$("#secrect").attr("checked", 'true');
					break;
				case '1':
					$("#male").attr("checked", 'true');
					break;
				case '2':
					$("#female").attr("checked", 'true');
					break;
			}
		};

	},


});;/**
 * 园区统计控制
 */
var StatiscialController = EasyController.extend({
	selector: {

	},
	request: function() {
        
//		var id = this.params["id"] || '';
        var datas={
        	id:1,
        	name:"ssss"
        	
        };
        
        this._data={"data":datas};
//      this.sendRequest("mng.statiscial", {
//			parameter : {
//				'id': id
//			},
//			success : this.statiscialRequest,
//		});
//var that = this;
//this.sendRequest("mng.statiscial",{parameter:{'id': id},success:that.statiscialRequest,scope:that});
//		加载统计信息
//		Protocol.request("mng.statiscial", {
//			parameter: {
//				'id': id
//			},
//			success: this.statiscialRequest,scope:that
//		});
//		this._data = {
//			//渲染数据
//		}
	},
	//统计信息回调
	statiscialRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {
			this._data={"data":result.data};
		} else {
            
		}
		loading.hide();
	},


	//付费用户明细回调
	userPayDetailRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {
			this._data={"data":result.data};
/*	      for(var i=0;i<result.data.length;i++){
	    	    html+="<div class='row-10 visit-border-top'>"+
				"<div class='row-9 clr-fix small-text light-gray-text'>"+
				"<span></span><span>"+data.statusDateEnd+
				"</span></div><div class='row-9 clr-fix'><div class='row-5 left'><div class='normal-text'>"+
				data.rechargeAccount+"</div></div><div class='row-5 left'><div class='row-9 normal-text right-text' id=''>￥"+
				data.payNum+"</div></div></div>";
		      }
		      return html;*/
		} else {

		}
		loading.hide();
	},

	addEventListener: function() {
	/*	Protocol.request("mng.statiscial", {
			parameter: {
				'id': id
			},
			success: this.statiscialRequest
		});*/
		var curpage = 1;
		var pagesize = 10;
		var that = this;
//		var id = that.params["id"] || '';//园区id
		var id= 123455;
		getDetail(id,curpage,pagesize);
//		点击加载更多
		$("#more").on("tap", function() {
			curpage++;
			console.log(curpage);
			getDetail(id,curpage,pagesize);
		});
		function getDetail(id,curpage,pagesize){
			Protocol.request("mng.userPayDetail", {
				parameter: {
					'id': id,
					'curpage': curpage,
					'pagesize': pagesize
				},
				success: that.userPayDetailRequest
			});
		}

	},


});;/**
 * 登录控制
 */
var LoginController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},
	//登录系统回调
	loginRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {
//登录失败，请重新操作！error？
		}
		loading.hide();
	},
	addEventListener: function() {
		var that = this;
		var $username = $('input[name=username]');
		var $password = $('input[name=password]');
		var $loginmsg = $(".errorMsg");
		/**
		 * 登录系统
		 */
		$('#login').on('tap', function() {
			var self = $(this);
			var username = $username.val() || '';
			var password = $password.val() || '';
			if (username == '' || password == '' || mobileStyle(username) || pwdStyle(password)) {
				$loginmsg.text('请输入正确的帐号或密码');
				return false;
			}
			loading.show();
			//请求
			Protocol.request("user.login", {
				parameter: {
					'username': username,
					'password': password
				},
				success: that.loginRequest
			});

			//					//获取uri信息
			//					var uri = Uri.query(); //  js/comm/uri.js 
			//					var deviceIda = $("#userMac").val();
			//					self.text('认证中...');
			//					if (deviceIda == undefined || deviceIda == null || deviceIda == "") {
			//						loginWeizhan("登录成功！");
			//						return false;
			//					} else {
			//
			//					}
			//					var data;
			//					data = {
			//						username: username,
			//						password: $.md5(password),
			//						deviceId: $("#devId").val(),
			//						terMac: $("#userMac").val(),
			//						terIp: $("#userIp").val(),
			//						acName: $("#acName").val(),
			//						acIp: $("#acIp").val()
			//					};
			//					console.log(data);
			//					var accessUrl = $("#access_url").val();
			//
			//					//同步请求
			//					//					that.sendRequest("user.", {
			//					//						parameter: {
			//					//
			//					//						},
			//					//						requestWrapper: function(data) {
			//					//							return data;
			//					//						},
			//					//						success: that.mysuccess,
			//					//						scope: that,
			//					//						complete: that.complete,
			//					//						failure: that.failure
			//					//
			//					//					});
			//					$.ajax({
			//						url: url,
			//						dataType: 'JSONP',
			//						jsonp: 'callback',
			//						header: {
			//							'cache-control': 'no-cache'
			//						},
			//						data: data,
			//						async: false,
			//						success: function(data, textStatus, jqXHR) {
			//							if (data.resultCode == '0') {
			//								var gw_address = typeof($("#gw_address").val()) == "undefined" ? '' : $("#gw_address").val();
			//								gw_address += typeof($("#gw_port").val()) == "undefined" ? '' : ':' + $("#gw_port").val();
			//								if ($("#portal_type").val() == 'authFatAP') {
			//									var url = 'http://' + gw_address + '/smartwifi/auth?url=' + encodeURIComponent($("#url").val());
			//									url += '&user_mac=' + (typeof($("#userMac").val()) == "undefined" ? '' : $("#userMac").val());
			//									url += '&ac_name=' + (typeof($("#acName").val()) == "undefined" ? '' : $("#acName").val());
			//									url += '&token=' + data.data;
			//								} else {
			//									var url = $("#host").val() + '?dev_id=' + $("#devId").val() + '&dev_mac=' + $("#ap_mac").val() + '&site_id=' + '1';
			//									url += '&user_mac=' + (typeof($("#userMac").val()) == "undefined" ? '' : $("#userMac").val());
			//									url += '&ac_name=' + (typeof($("#acName").val()) == "undefined" ? '' : $("#acName").val());
			//									url = url
			//										//+ '&' + $.param(ps);
			//								}
			//								$.ajax({
			//									url: url,
			//									async: true,
			//									dataType: 'JSONP',
			//									jsonp: 'callback',
			//									header: {
			//										'cache-control': 'no-cache'
			//									},
			//									success: function(data, textStatus, jqXHR) {},
			//									error: function(xhr, status, error) {}
			//								});
			//								loginWeizhan("登录成功,您现在可以上网了！");
			//								return false;
			//
			//							} else {
			//								console.log(data);
			//								alert("用户名或密码错误(或用户不存在)");
			//								return false;
			//							}
			//						},
			//						error: function(XHR, textStatus,
			//							errorThrown) {
			//							self.attr('disabled', false);
			//							alert(textStatus || '系统异常，请稍后再试...');
			//						},
			//						complete: function(XHR, textStatus) {
			//							self.attr('disabled', false);
			//							self.text('登录');
			//						}
			//					});
			//					self.attr('disabled', false);
			//				});
			//
			//				function loginWeizhan(msg) {
			//					var username = $username.val() || '';
			//					var password = $password.val() || '';
			//					var data = {
			//						username: username,
			//						password: password
			//					};
			//
			//					$.ajax({
			//						url: PATH + 'ms/login/save.shtml',
			//						dataType: 'JSON',
			//						data: data,
			//						async: false,
			//						success: function(rs, textStatus, jqXHR) {
			//							if (rs.success) {
			//								if ($("#devId").val() != null && $("#devId").val() != "") {
			//									alert("您现在可以上网了");
			//									window.location.href = '/ms/index';
			//								} else {
			//									alert("登录成功");
			//									window.location.href = '/ms/index';
			//								}
			//							} else {
			//								alert(rs.message);
			//							}
			//						},
			//						error: function(XHR, textStatus, errorThrown) {
			//							console.log(XHR, textStatus, errorThrown);
			//							alert("登录微站出错了");
			//						},
			//						complete: function(XHR, textStatus) {
			//							$('#login').text('登录');
			//						}
			//					});

			//Service
			/**
			 * 用户输入去除错误信息
			 */
			$username.on("change", function() {
				$loginmsg.text('');
			});
			$password.on("change", function() {
				$loginmsg.text('');
			});
			/**
			 * 验证手机号格式
			 */
			function mobileStyle(str) {
				var re = /^1\d{10}$/;
				if (!re.test(str)) {
					return true;
				}
			};
			/**
			 * 验证密码格式
			 */
			function pwdStyle(str) {
				var re = /^[0-9 | A-Z | a-z]{6,20}$/;
				if (!re.test(str)) {
					return true;
				}
			};
		});
	}
});/**
 * 注册控制
 */
var RegisterController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},
	//注册回调
	registerRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {
//注册失败，请重新操作！ error？
//您的手机号已注册，请登录！
		}
		loading.hide();
	},
	addEventListener: function() {
		var that=this;
		var cutdownTime = 61;
		var $username = $('input[name=username]');
		var $captcha = $('input[name=captcha]');
		var $password = $('input[name=password]');
		var $passwordAgain = $('input[name=password_again]');
		var $regmsg = $(".errorMsg");

		/**
		 * 注册
		 */
		$("#registerBtn").on("tap", function() {
			var username = $username.val() || '';
			var captcha = $captcha.val() || '';
			var password = $password.val() || '';
			var passwordAgain = $passwordAgain.val() || '';
			if (username == '' || mobileStyle(username)) {
				$regmsg.text("请输入正确的手机号");
				return false;
			}
			if (captcha == '' || !(/^[0-9]{4}$/).test(captcha)) {
				$regmsg.text("请输入正确的验证码");
				return false;
			}
			if (password == '' || pwdStyle(password)) {
				$regmsg.text("请输入正确的密码格式");
				return false;
			}
			if (passwordAgain == '' || (password != passwordAgain)) {
				$regmsg.text('两次输入的密码不一致');
				return false;
			}
//			if (!$('#agree').is(':checked')) {
//				$regmsg.text('请阅读并同意《爱WIFI用户协议》');
//				return false;
//			} //默认选中 不可点击修改
			loading.show();
			//请求
			Protocol.request("user.register", {
				parameter: {
					'username': username,
					'password': password,
					'captcha': captcha
				},
				success: that.registerRequest
			});
		});
		/**
		 * 验证码
		 */
		$('.captcha').find('button').on('tap', function() {
			var self = $(this);
			var username = $username.val() || '';
			if (username == '' || mobileStyle(username)) {
				$regmsg.text("请输入正确的手机号");
				return false;
			}
			self.attr('disabled', true);
			self.text('发送中');
			var time = cutdownTime;
			var sI = setInterval(function() {
				time = time - 1;
				if (time !== 0) {
					self.text(time + '秒后重试');
				} else {
					window.clearInterval(sI);
					time = cutdownTime;
					self.text('重新获取');
					self.attr('disabled', false);
				}
			}, 1000);

			// 调用API
			//		var uri = Uri.query(),
			//			var data;
			//			var username = $username.val().trim() || '';
			//			data = {
			//				mobile: username,
			//				type: 'ms_reg'
			//			};
			//
			//			$.ajax({
			//				url: PATH + 'ms/sms/send',
			//				dataType: 'JSONP',
			//				jsonp: 'callback',
			//				header: {
			//					'cache-control': 'no-cache'
			//				},
			//				data: data,
			//				success: function(data, textStatus, jqXHR) {
			//					if (data[0].success) {} else {
			//						alert(data[0].message);
			//					}
			//				},
			//				error: function(XHR, textStatus, errorThrown) {
			//					alert(textStatus || '系统异常，请稍后再试...');
			//				}
			//			});
		});
		//Service
		/**
		 * 验证手机号格式
		 */
		function mobileStyle(str) {
			var re = /^1\d{10}$/;
			if (!re.test(str)) {
				return true;
			}
		};
		/**
		 * 验证密码格式
		 */
		function pwdStyle(str) {
			var re = /^[0-9 | A-Z | a-z]{6,20}$/;
			if (!re.test(str)) {
				return true;
			}
		};
		//用户协议
		$("#showRule").on("tap", function() {
			$("#register").hide();
			$("#rule").show();
		});
		//同意
		$("#agreeRule").on("tap", function() {
			$("#rule").hide();
//			$("#agree").attr("checked", "true");
			$("#register").show();
		});


	}


});;/**
 * 忘记密码控制
 */
var ResetPwdController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},
	//找回密码回调
	resetPwdRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {
//操作失败，请重新操作！ error？
//您的手机号未注册
		}
		loading.hide();
	},
	addEventListener: function() {
		var that = this;
		var cutdownTime = 61;
		var $username = $('input[name=username]');
		var $captcha = $('input[name=captcha]');
		var $password = $('input[name=password]');
		var $passwordAgain = $('input[name=password_again]');
		var $regmsg = $(".errorMsg");
		/**
		 * 提交
		 */
		$('#submit').on('tap', function() {
			$regmsg.text("");
			var username = $username.val() || '';
			var captcha = $captcha.val() || '';
			var password = $password.val() || '';
			var passwordAgain = $passwordAgain.val() || '';
			if (username == '' || mobileStyle(username)) {
				$regmsg.text("请输入正确的手机号");
				return false;
			}
			if (captcha == '' || !(/^[0-9]{4}$/).test(captcha)) {
				$regmsg.text("请输入正确的验证码");
				return false;
			}
			if (password == '' || pwdStyle(password)) {
				$regmsg.text("请输入正确的密码格式");
				return false;
			}
			if (passwordAgain == '' || (password != passwordAgain)) {
				$regmsg.text('两次输入的密码不一致');
				return false;
			}

			loading.show();
			//请求
			Protocol.request("user.resetPwd", {
				parameter: {
					'username': username,
					'password': password,
					'captcha': captcha
				},
				success: that.resetPwdRequest
			});
		});
		/**
		 * 
		验证码 */
		$('.captcha').find('button').on('tap', function() {
			$regmsg.text("");
			var self = $(this);
			var username = $username.val() || '';
			if (username == '' || mobileStyle(username)) {
				$regmsg.text("请输入正确的手机号");
				return false;
			}
			self.attr('disabled', true);
			self.text('发送中');
			var time = cutdownTime;
			var sI = setInterval(function() {
				time = time - 1;
				if (time !== 0) {
					self.text(time + '秒后重试');
				} else {
					window.clearInterval(sI);
					time = cutdownTime;
					self.text('重新获取');
					self.attr('disabled', false);
				}
			}, 1000);

			// 调用API
			//		var username = $('input[name=username]').val().trim()||'';
			//		data = {
			//				mobile: username,
			//				type: 'ms_changepwd',
			//			},
			//			$.ajax({
			//				url: '/ms/sms/send',
			//				dataType: 'JSONP',
			//				jsonp: 'callback',
			//				header: {
			//					'cache-control': 'no-cache'
			//				},
			//				data: data,
			//				success: function(data, textStatus, jqXHR) {
			//					if (data[0].success) {} else {
			//						window.clearInterval(sI);
			//						time = cutdownTime;
			//						self.text('重新获取');
			//						self.attr('disabled', false);
			//						alert(data[0].message);
			//					}
			//				},
			//				error: function(XHR, textStatus, errorThrown) {
			//					alert(textStatus || '系统异常，请稍后再试...');
			//				}
			//			});
		});
		//Service
		/**
		 * 验证手机号格式
		 */
		function mobileStyle(str) {
			var re = /^1\d{10}$/;
			if (!re.test(str)) {
				return true;
			}
		};
		/**
		 * 验证密码格式
		 */
		function pwdStyle(str) {
			var re = /^[0-9 | A-Z | a-z]{6,20}$/;
			if (!re.test(str)) {
				return true;
			}
		};
	},


});;/**
 * 用户个人中心控制
 */
var UserCenterController = EasyController.extend({

	selector: {

	},
	request: function() {
		//url获取参数
		var id = this.params["id"] || '';
		//loading.show();
		//加载请求个人中心信息
		//		Protocol.request("user.center", {
		//			parameter: {
		//				'id': id
		//			},
		//			success: this.userCenterRequest
		//		});
		//判断管理员或普通用户确定个人资料页 默认为普通用户#/userInfo！
	},
	//个人中心回调
	registerRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {
			this._data = {
				//渲染模板  注意传递用户id 在#/userInfo
			}
		} else {

		}
		loading.hide();
	},
	//消费记录回调
	payRecordsRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {

		}
		loading.hide();
	},
	addEventListener: function() {
		var curpage = 0;
		var pagesize = 8;
		var that = this;
		//点击加载更多
		$("#more").on("tap", function() {
			curpage++;
			console.log(curpage);
			var id = that.params["id"] || '';
			Protocol.request("user.payRecords", {
				parameter: {
					'id': id,
					'curpage': curpage,
					'pagesize': pagesize
				},
				success: that.payRecordsRequest
			});
		});



	},


});;/**
 * 用户资料控制
 */
var UserInfoController = EasyController.extend({
	selector: {

	},
	request: function() {
		this._data = {
			//渲染数据
		}
	},
	//用户信息修改回调
	userInfoRequest: function(options, result, textStatus, jqXHR) {
		if (result.r == 1) {

		} else {

		}
		loading.hide();
	},
	addEventListener: function() {
		var that = this;
		/**
		 * 头像上传
		 */
		$('.info-avatar-file').on('change', function() {
			loading.show();
			//这里发上传请求
		});
		/**
		 * 保存
		 */
		$("#save").on("tap", function() {
			var $errorMsg = $(".errorMsg");

			var imgUrl = $(".info-avatar-img").attr("src") || '/??'; //默认头像地址？？
			var nickName = $("input[name='nickName']").val() || '';
			var sex;
			if ($("#female").is(':checked')) {
				sex = 2;
			} else if ($("#male").is(':checked')) {
				sex = 1;
			} else {
				sex = 0;
			}
			var birthday = $("input[type='date']").val() || '';
			var address = $("textarea").val() || '';
			if (nickName == '') {
				$errorMsg.text("请输入昵称");
				return;
			}
			loading.show();
			//保存个人资料
			Protocol.request("user.userInfo", {
				parameter: {
					'imgUrl': imgUrl,
					'nickName': nickName,
					'sex': sex,
					'birthday': birthday,
					'address': address
				},
				success: that.userInfoRequest
			});


		});

		//Service		
		/**
		 * checkbox联动
		 */
		$('.info-sex').find('input[type=checkbox]').on('change', function() {
			$('.info-sex').find('input[type=checkbox]').not($(this)).each(function() {
				if ($(this).is(':checked')) {
					$(this).removeAttr('checked');
				}
			});
		});
		/**
		 * 性别回填
		 */
		function sexChecked(sex) {
			switch (sex) {
				case '0':
					$("#secrect").attr("checked", 'true');
					break;
				case '1':
					$("#male").attr("checked", 'true');
					break;
				case '2':
					$("#female").attr("checked", 'true');
					break;
			}
		};

	},


});;