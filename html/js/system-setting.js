$(document).ready(function() {
	$(".bar").find('a[name=first]').on('click', function() {
		$(this).parent().find(".in-ul").slideToggle(600);
	});

	$(".top-right").on("click", function() {
		$("#logform").slideToggle(600);
	});


	$(window).resize(function() {
//		var wc = $(window).width() - $(".modal").width()-188;
//		var hc=$(".bottom").height()+15;
//		wc = wc / 2;
//		$(".modal").css('right', wc)
	});
});