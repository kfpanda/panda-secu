$(document).ready(function(){
	$(".bar").find('a[name=first]').on('click',function(){
		$(this).parent().find(".in-ul").slideToggle(600);
	});
	 
	$(".top-right").on("click",function(){
			$("#logform").slideToggle(600);
	});
    
});