<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>银行借贷管理系统</title>
		<link href="/style-common/css/base.css" rel="stylesheet" />
		<link href="/style-common/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="/style-common/css/base_red.css" rel="stylesheet" />
		
		<script src="/style-common/js/jquery-1.11.0.min.js"></script>
		<script src="/style-common/bootstrap/js/bootstrap.min.js"></script>
		<script src="/style-common/js/common.js"></script>
		<script type="text/javascript">
		
		var url ="check";
		jQuery.ajax({
			type: 'POST',
			url: url,
			data: "amount="+amount,
			success: function(data){
				var obj = eval("(" + data + ")");
				if(obj.r != '1') {
					alert(obj.msg);
				}
			},
			dataType: 'text'
		});
		
			jQuery = $;
			
			var yqljwz = document.getElementById("yqljwz");
			submitForm('info_zjBcYqlj.html');
			
// 			//页面刷新
// 			function pageRefresh(){
// 				window.location.reload();
// 			}
			
			function loginTo() {
				$("#yhmts").text("");
				$("#mmts").text("");
				$("#yzmts").text("");
				
				if (document.forms[0].yhm.value  == "") {
					//alerts('提示：登录名不能为空，请输入登录名！');
					$("#yhmts").text("用户名不能为空");
					//document.forms[0].yhm.focus();
					return false;
				} else {
					if (document.forms[0].mm.value == "") {
						//alerts('提示：密码不能为空，请输入密码！');
						$("#yhmts").text("");
						$("#mmts").text("密码不能为空");
						//document.forms[0].mm.focus();
						return false;
					}
				}
				return true;
			}
			
			function yzyh(){
				//alerts('抱歉，用户名或密码错误，请重新输入！');
				$("#yhmts").text("用户名或密码错误");
				//window.location.reload();
				//document.forms[0].mm.focus();
			}
			function yzmcw(){
				//alerts('提示：验证码错误！');
				$("#yzmts").text("验证码错误");
				//document.forms[0].yzm.focus();
				$("#yzm").val("");
				//window.location.reload();
			}
			
			function yhdl(){
				$("#yhmts").text("");
				$("#mmts").text("");
				var yhm = $("#yhm").val();
				var mm = $("#mm").val();
				
				var url ="login";
				jQuery.ajax({
					type: 'POST',
					url: url,
					data: "name="+yhm+"&pwd="+mm,
					success: function(data){
						var obj = eval("(" + data + ")");
						if(obj.r==1) {
							var login_url = "list";
							window.location.href=login_url;
						}else {
							alert(obj.msg);
						}
					},
 					dataType: 'text'
 				});
						//alert("obj.r= " + data);
// 						var obj = eval("(" + data + ")");
// 						var obj1 = eval( data);

// 						var obj = eval("(" + data + ")");
// 						alert("obj.r= " + obj.r);
// 						alert("obj.msg= " + obj.msg);
						
// 							var obj = eval("(" + data + ")");//转换为json对象 
// 								alert("obj.r= " + obj.r);
// 								alert("obj.msg.length= " + obj.msg.length);//输出root的子对象数量 
// 								$.each(obj.msg,function(i, item) {
// 									//输出每个root子对象的名称和值 
// 									alert("name:"+item.name+",value:"+item.value); 
// 								})
								
// 							alert("用户名密码错误！"); 
// 							var login_url = obj.msg;
// 							window.location.href=login_url;

// 							{"comments":[{"content":"很不错嘛","id":1,"nickname":"纳尼"},{"content":"哟西哟西","id":2,"nickname":"小强"}],"content":"你是木头人，哈哈。","infomap":{"性别":"男","职业":"程序员","博客":"http://www.php100.com/codeplus/"},"title":"123木头人"}
// 							function loadInfo() {
// 							    $.getJSON("loadInfo", function(data) {
// 									data.title
// 									data.content
// 									//jquery解析map数据
// 									$.each(data.infomap,function(key,value){
// 										key + "-" + value
// 									});
// 									//解析数组
// 									$.each(data.comments, function(i, item) {
// 											item.id
// 											item.nickname
// 											item.content
// 									});
// 									});
// 							}
// 					},
// 					dataType: 'text'
// 				});
				
// 				$.post("user/login",{"name":yhm,"pwd":mm},function(respose){
// 					if(respose=='dlcw'){
// 						yzyh();
// 					}else if(respose=='yzmcw'){
// 						yzmcw();
// 				    }else if(respose=='yzmcs'){
// 				       yzmcscw();
// 				    }else if( respose=='ok' ){
// 					   window.location.href="oou_index.action";
// 				    }else{
// 				    	window.location.href="oou_index.action";
// 				    }
// 				});
			}
			
			
			function yznc(){
			  var yhnc = $("#yhnc").val();
				if(yhnc==''||yhnc==null ){
					$("#ncts").css("display","block");
					//jQuery("#yhnc").focus();
					$('#tj').attr('disabled',"true");
					return false;
				}else{
			      var url = "indexYznc.action";
				  $.post(url,{"YhModel.yhnc":yhnc},function(response){
					if(response=='exist'){
					    $("#ncts").css("display","block");
					    //jQuery("#yhnc").focus();
					    $('#tj').attr('disabled',"true");
					    return false;
					}else{
					  $("#ncts").css("display","none");
					  $('#tj').removeAttr("disabled"); 
					}
				  })
				}
			}
			
			//注册提交验证
			function yhkszc(){
				$("#zcyhmts").text("");
				$("#zcmmts").text("");
				$("#yzzcmmts").text("");
				$("#zcaqmts").text("");
				$("#yzzcaqmts").text("");
				
				var yhnc = $("#yhnc").val();
				var yhmm = $("#yhmm").val();
				var qrmm = $("#qrmm").val();
				var yhaqm = $("#yhaqm").val();
				var qraqm = $("#qraqm").val();
				
				//用户名输入验证
				if(yhnc==''||yhnc==null){
					$("#zcyhmts").text("用户名不能为空");
					return false;
				}
				
				//用户密码输入验证
				if(yhmm==''||yhmm==null){
					$("#zcmmts").text("密码不能为空");
					return false;
				}else if(yhmm.indexOf(" ")!=-1){
					$("#zcmmts").text("密码有非法字符");
					return false;
				}else if(yhmm.length<6||yhmm.length>16){
					$("#zcmmts").text("密码长度小于6或者大于16");
					return false;
				}
				
				//用户密码确认验证
				var qrmm = $("#qrmm").val();
				if(qrmm==''||qrmm==null||qrmm.indexOf(" ")!=-1|| qrmm.length<6||qrmm.length>16){
					//alerts("确认密码不合法");
					$("#zcmmts").text("确认密码不合法");
					return false;
				}else{
					if(qrmm!=yhmm&&(yhmm!=null&&yhmm!='')){
						//alerts("两次密码不一致");
						$("#zcmmts").text("两次密码不一致");
						return false;
					}
				}
				
				//用户安全码输入验证
				if(yhaqm==''||yhaqm==null){
					$("#zcaqmts").text("密码不能为空");
					return false;
				}else if(yhaqm.indexOf(" ")!=-1){
					$("#zcaqmts").text("密码有非法字符");
					return false;
				}else if(yhaqm.length<6||yhmm.length>16){
					$("#zcaqmts").text("密码长度小于6或者大于16");
					return false;
				}
				
				//用户安全码确认验证
				var qraqm = $("#qraqm").val();
				if(qraqm==''||qraqm==null||qraqm.indexOf(" ")!=-1||qraqm.length<6||qraqm.length>16){
					$("#yzzcaqmts").text("确认安全码不合法");
					return false;
				}else{
					if(qraqm!=yhaqm&&(qraqm!=null&&yhaqm!='')){
						$("#yzzcaqmts").text("两次安全码不一致");
						return false;
					}
				}
				
				////////////////////
				register
				
				
				
			}
			
			function yzyhnc(){
				$("#zcyhmts").text("");
				$("#zcmmts").text("");
				$("#fwts").text("");
				var yhnc = $("#yhnc").val();
				var url = "indexYznc.action";
				$.post(url,{"YhModel.yhnc":yhnc},function(response){
					if(response=='exist'){
						//alerts("用户名已存在");
						$("#zcyhmts").text("用户名已存在");
						return false;
					}
				});
			}
		</script>
</head>
<body>
		<%
			String result = (String) request.getSession().getAttribute("result");
			if(result != null && result != "") {
				out.println("<script>");
				out.println("alert(result);");
				out.println("window.parent.location.reload();");
				out.println("iFClose();");
				out.println("</script>");
			}
		%>
</body>
</html>