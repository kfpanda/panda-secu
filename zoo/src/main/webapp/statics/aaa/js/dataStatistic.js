$(document).ready(function(){
	$(".sdbUl-li-span").click(function(){
		$(this).parent().parent().find(" .sdbUl-li-ul").slideToggle(600);

  });

	$("#caidan").click(function(){
		
		if($(".content").hasClass("content2")){
			$(".content").removeClass("content2");
		}else{
			$(".content").addClass("content2");
		}
		$(".sidebar").fadeToggle(100);
	});

	$("#nabLi2").click(function(){
		$(".nabLi2-ul").slideToggle(100);
	});

});