$(document).ready(function(){
	$(".bar").find('a[name=first]').on('click',function(){
		$(this).parent().find(".in-ul").slideToggle(600);
			//$(this).css("background","#e13c49");	
	});
	

});