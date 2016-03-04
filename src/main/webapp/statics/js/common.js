/**
 * 对于模态框 tab页进行自动绑定触发事件
 */
var PATH="";
var AJAX_SUCC=1;
function pageinit(){
	$("*[data-toggle='modal']").each(function(){
		if($(this).attr("data-target")){
			$(this).on("click",function(){
				showMask();
				$($(this).attr("data-target")).show();
			});
		}
		
	});
	
	$("*[data-dismiss='modal']").each(function(){
		$(this).on("click",function(){
		$(".mask").hide();
		$(this).closest(".modal").hide();
		});
		
	});
	
	$(".menu li").each(function(){
		$(this).on("click",function(){
			$(".select").removeClass("select");
			$(this).addClass("select");
		});
	})
	
	$(".nav-tabs li").each(function(){
		$(this).on("click",function(){
			$(".active").removeClass("active");
			$(this).addClass("active");
		});
	});
}
/**
 * 
 */
function isNull(str) {
		if(typeof str != 'string'){
			//alert("isNull 使用错误,参数是" +(typeof str));
			if(typeof str == 'undefined' || null == str){
				return true
			}else{
				return false;
			}
		}else 
	if (typeof str == 'undefined' || str == null || str.trim() == '')
		return true;
	else
		return false;

}

function initGrid(gridParam){
	 $(grid_selector).jqGrid(gridParam);
	 return  $(grid_selector);
}
/*
function gridCallBack(result){
	this.data=result.data;
	result= eval("("+result+")");
	var html="<div><table class='table'> <tbody>  ";
	
	for(var i=0;i<result.data.length;i++){
		html+="<tr>";
		for(var j=0;j<this.gridParam.colModel.length;j++){
			var colName=this.gridParam.colModel[j].name;
			var value=result.data[i][colName];
			html+="<td width=\""+this.gridParam.colModel[j].width/this.width_sum*100+"%\">"+value+"</td>";
		}
		html+="</tr>";
	}
	html+="</tbody></table></div>";
	$(this.gridParam.grid_selector).find(".grid-content").html(html);
	
}*/

Function.prototype.Apply = function(thisObj)
{
    var _method = this;
    return function(data)
    {
        return _method.apply(thisObj,[data]);
    };
};

function goUrl(str){
	  mvc.routeRun(str);
}

function ajaxResultHandler(result){
	//权限问题
	//登陆问题
	if(typeof result =='string'){
		result= eval("("+result+")");
	}
	if(result.r!=1){
		if(result.r==504  ){
			alert(result.msg);
			window.location=WEBCONTEXT+"/login";
			
		}
		if(result.r==505  ){
			alert(result.msg);
		}
		return result;
	}
	else
	return result;
}

function changeForm2Jso(formId) {
	var jso = {};
	var arr = $( formId).serializeArray();
	for (var i = 0; i < arr.length; i++) {
		jso["" + arr[i].name] = arr[i].value;
	}

	return jso;
}

function filJso2Form(formId,jso){
	var arr = $( formId).serializeArray();
	for (var i = 0; i < arr.length; i++) {
		$(formId).find("input[name='"+ arr[i].name+"']").val(jso[ arr[i].name]);
	}
}
function showMask(){
	if($(".mask").length==0){
		$("body").append($("<div class=\"mask\" > </div>"));
	}
	$(".mask").show()
}

function showModal(id,w,h){
	if(typeof h !='undefined' && h!=null )
	$(id).css("height",h);
	if(typeof w !='undefined' && w!=null )
	$(id).css("width",w);
	$(id).show();
	showMask();
}



function hideModal(id){
	$(id).hide();
	$(".mask").hide()
}

function showErrorMsg(formid,msg){
	var div = $(formid).find(".alert");
	if(div.length==0){
		var div = $("<div class=\"alert alert-danger\"></div>");
		 $(formid).find(".modal-body").prepend(div);
	}
	div.eq(0).html(msg);
	div.eq(0).show();
}


function clearErrorMsg(formid){
	 $(formid).find(".alert").hide();
}

function showWait(msg){
	
	showMask()
	$(".wait").show();
}
function hideWait(){
	hideWaitTrue();
	///setTimeout("hideWaitTrue()",100);
	
}
function hideWaitTrue(){
	$(".mask").hide()
	$(".wait").hide();
}
function zWidgetBase(){
	showMask();
	if($(".widget").length>0){
		
	}else{
		$("body").append("<div class='widget'></div>");
	}
}
function zconfirm(msg,title,fn){
	zWidgetBase();
	var html=$("<div class=\"zwidget_wrap\">"+
	"<div class=\"zwidget_header\"><span>"+title+"</span> <a onclick=\"$(this).parent().parent().hide();$('.mask').hide()\"><img class=\"zclose\" src=\"/static/img/closeIcon.png\"></img></a></div>"+
	"<div class=\"zbody\">"+
	"<div class=\"zinfo-icon\"><img src=\"/static/img/exclamation.png\"/></div>"+
	"<div class=\"zinfo\">"+msg+"</div>"+
	"<div class=\"zbutton_wrap\"><a onclick=\"$(this).parent().parent().parent().hide();$('.mask').hide()\">确定</a></div>"+
	"</div>"+
	"</div>");
	$(".widget").html(html);
	if (typeof(fn) != "undefined") 
	$(html).find(".zbutton_wrap").find("a").click(fn);
}


function zdialogue(msg,title,src,fontcolor,fn){
	zWidgetBase();
	var html=$("<div class=\"zwidget_wrap\">"+
	"<div class=\"zwidget_header\"><span>"+title+"</span> <a onclick=\"$(this).parent().parent().hide();$('.mask').hide()\"><img class=\"zclose\" src=\"/static/img/closeIcon.png\"></img></a></div>"+
	"<div class=\"zbody\">"+
	"<div class=\"zinfo-icon\"><img src=\""+src+"\"/></div>"+
	"<div class=\"zinfo\" style=\"color:"+fontcolor+"\">"+msg+"</div>"+
	"<div class=\"zbutton_wrap\"><a onclick=\"$(this).parent().parent().parent().hide();$('.mask').hide()\">确定</a></div>"+
	"</div>"+
	"</div>");
	$(".widget").html(html);
	if (typeof(fn) != "undefined") 
	$(html).find(".zbutton_wrap").find("a").click(fn);
}
function zdialogue(jso){
	zWidgetBase();
	var html=$("<div class=\"zwidget_wrap\">"+
	"<div class=\"zwidget_header\"><span>"+jso.title+"</span> <a class=\"zclose\" onclick=\"$(this).parent().parent().hide();$('.mask').hide()\"><img  src=\"/static/img/closeIcon.png\"></img></a></div>"+
	"<div class=\"zbody\">"+
	"<div class=\"zinfo-icon\"><img src=\""+jso.src+"\"/></div>"+
	"<div class=\"zinfo\" style=\"color:"+jso.fontcolor+"\">"+jso.msg+"</div>"+
	"<div class=\"zbutton_wrap\"><a onclick=\"$(this).parent().parent().parent().hide();$('.mask').hide()\">确定</a></div>"+
	"</div>"+
	"</div>");
	$(".widget").html(html);
	if (typeof(jso.okfn) != "undefined") 
		$(html).find(".zbutton_wrap").find("a").click(jso.okfn);
	
	if (typeof(jso.cancelfn) != "undefined") 
		$(html).find(".zwidget_header").find(".zclose").click(jso.cancelfn);
}
function zselect(jso){
	zWidgetBase();
	var html=$("<div class=\"zwidget_wrap\">"+
	"<div class=\"zwidget_header\"><span>"+jso.title+"</span> <a class=\"zclose\" onclick=\"$(this).parent().parent().hide();$('.mask').hide()\"><img  src=\"/static/img/closeIcon.png\"></img></a></div>"+
	"<div class=\"zbody\">"+
	
	"<div class=\"zinfo\" style=\"color:"+jso.fontcolor+"\">"+jso.html+"</div>"+
	"<div class=\"zbutton_wrap\"><a onclick=\"$(this).parent().parent().parent().hide();$('.mask').hide()\">确定</a></div>"+
	"</div>"+
	"</div>");
	$(".widget").html(html);
	if (typeof(jso.okfn) != "undefined") 
		$(html).find(".zbutton_wrap").find("a").click(jso.okfn);
	
	if (typeof(jso.cancelfn) != "undefined") 
		$(html).find(".zwidget_header").find(".zclose").click(jso.cancelfn);
}
function zalert(msg,title,fn){
	zWidgetBase();
	title=title||"提示";
	var html=$("<div class=\"zwidget_wrap\">"+
	"<div class=\"zwidget_header\"><span>"+title+"</span> <a  onclick=\"$(this).parent().parent().hide();$('.mask').hide()\"><img class=\"zclose\" src=\"/static/img/closeIcon.png\"></img></a></div>"+
	"<div class=\"zbody\">"+
	"<div class=\"zinfo-icon\"><img src=\"/static/img/nike.png\"/></div>"+
	"<div class=\"zinfo\">"+msg+"</div>"+
	"<div class=\"zbutton_wrap\"><a onclick=\"$(this).parent().parent().parent().hide();$('.mask').hide()\">确定</a></div>"+
	"</div>"+
	"</div>");
	$(".widget").html(html);
	if (typeof(fn) != "undefined") 
	$(html).find(".zbutton_wrap").find("a").click(fn);
}
function zerror(msg,title,fn){
	zdialogue({"msg":msg,"title":title,fontcolor:"#777777",src:"/static/img/exclamation.png",okfn:fn});
}
var Auth={
	permissions:"",
	init:function(){
		this.permissions=permissions;
	},
	hasPermission:function(permission){
		if(this.permissions.indexOf(permission)>0){
			return true;
		}else{
			return false;
		}
	}
}
function getEditHtml(value) {
	return "<a style='margin-left:2px' href=\"javascript:void(0)\" onclick=\"editinfo('"+value+"')\" >修改</a>";
}
function getDelHtml(value) {
	return "<a style='margin-left:2px' href=\"javascript:void(0)\" onclick=\"deleteinfo('"+value+"')\" >删除</a>";
}
function getViewHtml(value) {
	return "<a style='margin-left:2px' href=\"javascript:void(0)\" onclick=\"viewinfo('"+value+"')\" >查看</a>";
}
var StringUtil={};
StringUtil.isBlank=function(it){
	if(it==null || typeof it=='undefinded' || it==''){
		return true;
	}
	return null;
}


function zprogress2(jso){
	var o={
		progress:function(now,total,msg){
			var jindu =parseInt(now*100/total);
			$(".progress-bar").css("width",jindu+"%");
			$(".progress-info").text(now+"/"+total);
			
			
			if(now==total){$(".progress").toggle();
				$(".progress-info").text(now+"/"+total);
				$(".zhead").text("发送完成");
				$(".progress-result").text(msg);
				
				$(".zbutton_wrap").removeClass("hide");
			}
			
		},
		
	};
	zWidgetBase();
	var html=$("<div class=\"zwidget_wrap progress_wrap\">"+
	"<div class=\"zbody\"><br><br>"+
	"<div class=\"zhead center\">"+jso.title+"</div>"+
    "<div class=\"zinfo\"><div class=\" progress\">"+
	 " <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 0%\">"+
	   " <span class=\"sr-only\">"+0+"Complete</span>"+
	 " </div>"+
	"</div></div>"+
		"<div class=\"progress-info right zinfo\">"+jso.msg+"</div>"+
		"<div class=\"progress-result zinfo\"></div>"+
	"<div class=\"zbutton_wrap hide\"><a onclick=\"$(this).parent().parent().parent().hide();$('.mask').hide()\">确定</a></div>"+
	"</div>"+
	"</div>");
	$(".widget").html(html);
	if (typeof(jso.okfn) != "undefined") 
	$(html).find(".zbutton_wrap").find("a").click(jso.okfn);
	return o;
}
function goPage(currentPage, everyPage) {
	console.log(currentPage);
	window.location=currentPage;
	return;
}
