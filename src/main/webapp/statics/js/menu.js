/**@author 宋展辉
 * 动态生成菜单
 * @param menulists
 * @returns
 */

//根据session中menuList的递归生成菜单html
function creatMenus(menulists){
	var _MENU=[];
	for(var i=0;i<menulists.length;i++){
		var data = menulists[i];
		_MENU[_MENU.length]=creatMenuDiv(data);
		if(data.subMenus){
			_MENU[_MENU.length]=creatMenus(data.subMenus);
		}
	}
	return _MENU.join('');
}

//拼装html 子方法
function creatMenuDiv(data){
	var menuHtml=[];
	if(data.parentId==0){
	
		menuHtml[menuHtml.length]='<div class="menu_row menu_root"  id="'+(data.path||'')+'"><h2 class="menu_title">';
		menuHtml[menuHtml.length]='<a name="'+(data.url||'')+'" target="'+(data.target||'')+'" onclick="'+(data.onclick+"(this)"||'')+'">';
		menuHtml[menuHtml.length]='<img  src="'+(data.imageUrl||'')+'">';
		menuHtml[menuHtml.length]='<p>'+(data.name||'')+'</p></a></h2></div>';
		
	}else{
		menuHtml[menuHtml.length]='<div class="menu_row hidden" id="'+(data.path||'')+'" ><h2 class="menu_title">';
		menuHtml[menuHtml.length]='<a name="'+(data.url||'')+'" target="'+(data.target||'')+'" onclick="'+(data.onclick+"(this)"||'')+'">';
		menuHtml[menuHtml.length]='<p>'+(data.name||'')+'</p></a></h2></div>';
	}
	return menuHtml.join('');
}

//刷新菜单 传入父菜单对象
function refreshMenu(that){
    id = '_'+that.parentNode.parentNode.id;
	$(".menu_row:not(.menu_root)").each(function(){
		var subid = '_'+$(this).attr("id");
		var reg = /^\d+\_/;
		if((subid.indexOf(id)!=-1)&&(reg.test(subid.substr(subid.indexOf(id)+id.length)))){
			$(this).toggle();
		}
	});
	return false;
}

//刷新菜单 传入所在div的id 即refreshMenu中的that.parentNode.parentNode.id;
function refreshMenuAfter(id){
    id = '_'+id;
	$(".menu_row:not(.menu_root)").each(function(){
		var subid = '_'+$(this).attr("id");
		var reg = /^\d+\_$/;
		if((subid.indexOf(id)!=-1)&&(reg.test(subid.substr(subid.indexOf(id)+id.length)))){
			$(this).toggle();
		}
	});
	return false;
}

//点击子菜单跳转刷新数据
function refreshData(event){
		
		window.location.href=event.name+"?path="+event.parentNode.parentNode.id;
	
	
}




//菜单初始化+默认展开
function initMenuStatus(path){

	if(path){
		$("#"+path).addClass("active");
		$(".menu_row").each(function(){
			var subid = $(this).attr("id");
			if((('_'+path).indexOf('_'+subid)!=-1)&&(subid!=path)){
				refreshMenuAfter(subid);
			}
		});
	}
}

//截取url中的参数，得到菜单初始化需要的path
function geturlParam(name) {
	var reg = new RegExp("(^|\\?|&)"+ name +"=([^&]*)(\\s|&|$)", "i");
	if (reg.test(location.href)) {
		return unescape(RegExp.$2.replace(/\+/g, " "));			
	}else{		
		return "";	
	}

	};

	//页面加载任务
$(document).ready(function(){
	$(".left_menu").html(creatMenus(menulists));//动态生成菜单
	initMenuStatus(path);//初始化菜单,传入path控制菜单默认展开
})