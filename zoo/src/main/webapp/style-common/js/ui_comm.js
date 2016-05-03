$(function() {
	/*中心公告新闻滚动*/
	var li_length = $(".notice_center ul li").length;
	var page = 1;
	var timer;
	if (li_length >= 2) {
		timer = setInterval(scrollNews, 3000);
	}
	function scrollNews() {
		if (page == li_length) {
			$(".notice_center ul").animate( {
				marginTop : 0
			}, 500)
			page = 1;
		} else {
			$(".notice_center ul").animate( {
				marginTop : '-' + page * 35 + 'px'
			}, 500)
			page++;
		}
	}
	$(".notice_center ul").mouseover(function() {
		if (timer != null) {
			window.clearInterval(timer);
		}
	})
	$(".notice_center ul").mouseout(function() {
		if (li_length >= 2) {
			timer = setInterval(scrollNews, 3000);
		}
	})
	/*选项卡*/
	function tabClick(xxk_id, cont_class) {
		$(xxk_id).children("li").children("a").click(function() {
			var li_eq = $(this).parent("li").index();
			$(this).parent("li").attr("class", "current");
			$(this).parent("li").siblings().removeClass("current");
			$(cont_class).eq(li_eq).show().siblings(cont_class).hide();
			return false;
		})
	}
	tabClick("#tab01", ".con_xxk");
	/*鼠标移上去显示*/
	$(".con_fwzn li").live('mouseover', function() {
		$(this).children(".detail,.download").show();
	})
	$(".con_fwzn li").live('mouseout', function() {
		$(this).children(".detail,.download").hide();
	})

	/*栏目导航*/
	$(".left_nav > li").click(function() {
		$(this).children("ul").show();
		$(this).siblings().children("ul").hide();
		$(this).addClass("top_cur")
		$(this).siblings().removeClass("top_cur")
	})
	$(".left_nav ul li").click(function() {
		$(this).addClass("cur")
		$(this).siblings().removeClass("cur")
		$(this).parent("li").siblings().children("li").removeClass("cur")
	})
	/*详情下拉*/
	for (i = 1; i < $(".box_menu_down").length; i++) {
		$(".box_menu_down").eq(i).css("zIndex", 999 - i);
	}
	$(".box_menu_down .btn_xq").each(function() {
		var that = $(this);
		that.hoverDelay( {
			hoverEvent : function() {
				that.next().show();
			},
			outEvent : function() {
				that.next().hide();
			}
		})
	})
	$(".menu_down").each(function() {
		var that = $(this);
		that.hoverDelay( {
			hoverEvent : function() {
				$(this).show();
			},
			outEvent : function() {
				$(this).hide();
			}
		})
	})

	/*选中*/
	function selected(parent_class, add_class) {
		$(parent_class).children("li,span").click(function() {
			$(this).addClass(add_class);
		})
	}

	$(".list_blsx li a").toggle(
		function(){
			var span = $("<span class='s' ></span>");
			var em = $("<em class='se'></em>");
			
//			var aa = $(this).attr("class");	
			$(this).find("div").show();
			
			var _url = $(this).parent().find("input").val();
			window.open(_url,'_blank');
			
			$(this).parent().append(span);
			$(this).parent().append(em);
			$(this).parent().addClass('selected');
			
			return false;
		},
		function(){
			
			$(this).parent().find(".s").remove();
			$(this).parent().find(".se").remove();
			$(this).parent().removeClass("selected");

			var handleRemark = $("#handleRemark").val();
			
			$("#handleRemark").val(
					handleRemark.replace(this.parent().id.split(":")[0], ''));
			return false;
		}
	)
	
//	//双击不选中
//	$(".list_blsx li").live('dblclick',function() {
//			
//	})
	
	$(".list_blsx li em").live('click', function() {
		$(this).siblings(".keywords").show();
	});

	$(".keywords .btn a").live('click', function() {
		$(this).parents(".keywords").hide();
		return false;
	});
	$(".list_blsx li").each(function() {
		var index = $(this).index();
		$(this).css("zIndex", 99999 - index);
	});
	selected(".list_blsx", "selected");
	//selected(".input_choose","selected");
	/*input获取焦点删除提示*/
	function inputFocus(obj) {
		$(obj).focus(function() {
			if ($(this).val() == this.defaultValue) {
				$(this).val("").css("color", "#000");
			}
		}).blur(function() {
			if ($(this).val() == "") {
				$(this).val(this.defaultValue).css("color", "#9a9a9a");
			}
		})
	}
	inputFocus("#input01");
})