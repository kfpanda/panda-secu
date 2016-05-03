;app.factory('confMngDao', function($location, $http, pageDao) {
	var dao = {};
	dao.list = function($scope) {
		var curpage = pageDao.getcurpage();
		var name = $scope.searchConfName || '';
		var mgid=$scope.menuGroupId||'';
		var pid=$scope.menuProId||'';
		var url = 'conf/show?name=' + name + "&curpage=" + curpage+"&mgid="+mgid+"&pid="+pid;
		$http.get(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {
					$scope.conflist = data.data;
					var page = data.page;
					pageDao.init($scope, page);
				}
			});
	};

	dao.add = function($scope) {
		var name = $scope.confName || '';
		var pid = $scope.pro.id || '';
		var mgid = $scope.group.id || '';
		var url = 'conf/add?name=' + name + "&pid=" + pid + "&mgid=" + mgid;
		$http.post(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {
					$location.path("/confList");
				}

			});
	};

	dao.upd = function($scope) {
		console.log($scope);
		var id = $scope.conf.id || '';
		var name = $scope.conf.name || '';
		var pid = $scope.pro.id || '';
		var mgid = $scope.group.id || '';
		var url = 'conf/update?id=' + id + '&pid=' + pid + '&mgid=' + mgid + "&name=" + name;
		$http.post(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {
					$location.path("/confList");
				}

			});
	};

	dao.del = function(id, $scope) {
		console.log(id);
		var url = "conf/del?id=" + id;
		$http.get(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {
					$scope.list();
				}

			});
	};



	return dao;
});;app.factory('groupDao', function($location, $http, pageDao) {
	var dao = {};
	dao.list = function($scope) {
		var curpage = pageDao.getcurpage();
		//var pid=$scope.menuProId||"";
		var searchName =$scope.searchName||'';
		//var url = 'mod/show?pid='+pid + "&curpage=" + curpage+"&name="+name;
		var url = '/mod/show?curpage=' + curpage+"&name="+searchName;
		//console.log("url:" + url);
		$http.get(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r == 1) {
					$scope.grouplist = data.data;
                    var page = data.page;
                    pageDao.init($scope, page);
				}
			});
	};
	//分组删除
	dao.del = function(id,$scope) {
		var url = '/mod/del?id=' + id;
		$http.get(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {	
					$scope.list();
				}
			});
	};
	//分组添加
	dao.add = function($scope) {
		var name = $scope.group.name;
		var desc = $scope.group.desc;
		var pid = $scope.pro.id;
		var url = '/mod/add?name=' + $scope.group.name + '&desc=' + $scope.group.desc + '&pid=' + pid;
		$http.post(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {
					$location.path("/groupList");
				} else {
					console.log(data.r);
				}

			});
	};
	//分组修改
	dao.upd = function($scope) {
		var url = '/mod/update?name=' + $scope.group.name + '&desc=' + $scope.group.desc + '&id=' + $scope.group.id+"&state=1";
		$http.post(url)
			.success(function(data, status, headers, config) {
				if (data && data.r == 1) {
					$location.path("/groupList");
				}

			});
	};
	
	//name重复校验
	dao.checkname = function($scope) {
		var name = $scope.group.name;
		var url = "mod/auth?name=" + name;
		$http.post(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r != 1) {
					$scope.checknameresult = true;
				} else {
					$scope.checknameresult = false;
				}
			});
	}

	return dao;
});;app.factory('pageDao',function($http, $compile){
    var dao = {};
    //初始化页码
    var initcurpage = function($scope, curpage, totalpage){
        var html = '';

        html += '<ul>';
            //1. 判断是否有 上一页
            if(curpage != 1){
                html += '<li class="pre_page">上一页</li>';
            }

            var maxPreNo = 5;
            var hasPreNo = (totalpage > 8) && curpage > maxPreNo;//有前省略号

            var maxSuffixNo = totalpage - 3;
            var hasSuffixNo = (totalpage > 8) && (curpage < maxSuffixNo);//有后省略号

            //2 判断是否有前后省略号
            //2.1 只有前省略号
            if(hasPreNo && !hasSuffixNo){
                //alert('2.1 只有前省略号');
                html += '<li class="page_one">1</li>';
                html += '<li id="pn-break">…</li>';
                var startIndex = totalpage - 6;
                for(var i=startIndex; i<=totalpage; i++){
                    if(i <= 0)
                        continue;
                    html += '<li ';
                    if(curpage == i){
                        html += 'id="page_selected" ';
                    }
                    html += 'class="page_one">'+ i +'</li>';
                }
            }
            //2.2 既有前省略号又有后省略号
            else if(hasPreNo && hasSuffixNo){
                //alert('2.2 既有前省略号又有后省略号');
                html += '<li class="page_one">1</li>';
                html += '<li id="pn-break">…</li>';
                var startIndex = curpage - 3;
                var endIndex = curpage + 2;
                for(var i=startIndex; i<=endIndex; i++){
                    if(i <= 0)
                        continue;
                    html += '<li ';
                    if(curpage == i){
                        html += 'id="page_selected" ';
                    }
                    html += 'class="page_one">'+ i +'</li>';
                }
                html += '<li id="pn-break">…</li>';
                html += '<li class="page_one">'+ totalpage +'</li>';
            }
            //2.3 只有后省略号
            else if(!hasPreNo && hasSuffixNo){
                //alert('2.3 只有后省略号');
                var maxSize = maxPreNo + 2;
                for(var i=1; i<=maxSize; i++){
                    html += '<li ';
                    if(curpage == i){
                        html += 'id="page_selected" ';
                    }
                    html += 'class="page_one">'+ i +'</li>';
                }
                html += '<li id="pn-break">…</li>';
                html += '<li class="page_one">'+totalpage+'</li>';
            }
            //2.4 没有前后省略号
            else if(!hasPreNo && !hasSuffixNo){
                //alert('2.4 没有前后省略号');
                for(var i=1; i<=totalpage; i++){
                    html += '<li ';
                    if(curpage == i){
                        html += 'id="page_selected" ';
                    }
                    html += 'class="page_one">'+ i +'</li>';
                }
            }

            //4. 判断是否有 下一页
            var lastcurpage = totalpage - 1;
            if(curpage != totalpage && curpage != totalpage){
                html += '<li class="next_page">下一页</li>';
            }

        html += '</ul>';
        var $curpageBar = $('.right_footer_page');
        $curpageBar.empty().append(html);

    };
    //初始化每页分页数量
    var initPageNum = function(pagesize){
        $('.show_page').each(function(){
            var $this = $(this);
            var num = $this.attr('value');
            if(num == pagesize){
                $this.attr('id', 'page_selected');
            }
        });
    };
    //绑定事件
    var bindPageEvent= function($scope){
        var $curpageBar = $('.right_footer_page');
        // 绑定 上一页 单击事件
        $curpageBar.find('.pre_page').bind('click', function(){
            var $curcurpage = $curpageBar.find('#page_selected');//当前页码
            var $prevcurpage = $curcurpage.prev();//上一个页码
            $curcurpage.attr('id','');//清除选中样式
            $prevcurpage.attr('id','page_selected');//将上一个页码的样式设置为选中
            $scope.list();
        });
        // 绑定 普通页码 单击事件
        $curpageBar.find('.page_one').bind('click', function(){
            // 清除旧的选中样式
            $curpageBar.find('#page_selected').attr('id','');
            var $this = $(this);
            // 将当前页码设置为选中样式
            $this.attr('id','page_selected');
            // 重新加载数据
            $scope.list();
        });
        // 绑定 下一页 单击事件
        $curpageBar.find('.next_page').bind('click', function(){
            var $curcurpage = $curpageBar.find('#page_selected');//当前页码
            var $nextcurpage = $curcurpage.next();//下一个页码
            $curcurpage.attr('id','');//清除选中样式
            $nextcurpage.attr('id','page_selected');//将下一个页码的样式设置为选中
            $scope.list();
        });

        // 绑定 每页记录数 单击事件
        var $pageNumBar = $('.page_num');
        var $show_page = $pageNumBar.find('.show_page');
        $show_page.off();//移除单击事件，防止重复绑定
        $show_page.on('click', function(){
            //清除选中样式
            $pageNumBar.find('#page_selected').attr('id','');
            var $this = $(this);
            //重新添加选中样式
            $this.attr('id','page_selected');
            //重置每页记录数
            var paramKey = 'page.pagesize';
            var paramValue = $this.val();
            var url = '/sysconfig/setvaluebykey?paramKey=' + paramKey + '&paramValue=' + paramValue;
            $http.get(url)
                .success(function(data, status, headers, config){
                    if(data.result == 'FAIL'){
                    	jDialog.alert(data.message);
                        return;
                    }
                    $scope.list();
                })
                .error(function(data, status, headers, config){
                    //alert('error：' + data);
                });
        });
    }
    //获取当前页码
    dao.getcurpage = function(){
        var curpage = $('.right_footer_page  li[id="page_selected"]').text();
        if(curpage == null || curpage == undefined || $.trim(curpage) == '')//为空时，默认为1
            curpage = 1;
        return curpage;
    };
    //初始化
    dao.init = function($scope, data){
        var curpage = data.curpage;//当前页码
        var totalpage = data.totalpage;//总页数
        var pagesize = data.pagesize;//每页记录数
        var totalcount = data.totalcount;//总数量
        $scope.showPageBar = totalcount > 0 ? true : false;
        initcurpage($scope, curpage, totalpage); //初始化页码
        initPageNum(pagesize);//初始化每页分页数量
        bindPageEvent($scope);//绑定事件
    };
    return dao;
});;app.factory('proMngDao', function($location, $http, pageDao) {
	var dao = {};
	//项目列表
	dao.getlist = function($scope) {
		var curpage = pageDao.getcurpage();
		var searchCode = $scope.searchCode || '';
		var url = 'project/show?code=' + searchCode + "&curpage=" + curpage;
		$http.get(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r == 1) {
					$scope.prolist = data.data;
					var page = data.page;
					pageDao.init($scope, page);
				}
			});
	};
	//项目增加
	dao.add = function($scope) {

		var code = $scope.pro.code;
		var name = $scope.pro.name;
		var desc = $scope.pro.desc;
		var url = 'project/add?code=' + code + '&name=' + name + '&desc=' + desc;
		$http.post(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r == 1) {
					$location.path("/proList");
				}

			});
	};
	//项目删除
	dao.del = function(id, $scope) {
		var url = 'project/update?id=' + id;
		$http.get(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r == 1) {
					$scope.list();
				}
			});
	};
	//项目修改
	dao.upd = function($scope) {
		//		var url = 'project/update?code=' + $scope.pro.code + '&name=' + $scope.pro.name + '&desc=' + $scope.pro.desc + '&id=' + $scope.pro.id + "&state=1";
		var url = 'project/update?name=' + $scope.pro.name + '&desc=' + $scope.pro.desc + '&id=' + $scope.pro.id + "&state=1";
		$http.post(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r == 1) {
					$location.path("/proList");

				}

			});
	};
	//code重复校验
	dao.checkcode = function($scope) {
		var code = $scope.pro.code;
		var url = "project/auth?code=" + code;
		$http.post(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r != 1) {
					$scope.checkcoderesult = true;
				} else {
					$scope.checkcoderesult = false;
				}
			});
	}


	return dao;
});;app.factory('showChartDao', function($location, $http, pageDao,$rootScope) {
	var dao = {};
	dao.getData = function($scope) {
		$scope.statdate = [];
		$scope.pv = [];
		$scope.uv = [];
		$scope.click = [];
		$scope.staytime = [];
		$scope.lostnum = [];
		$scope.scid = [];
		var curpage = pageDao.getcurpage();
		var scid = $scope.confid;
		var url = 'stat/show?scid=' + scid + "&curpage=" + curpage;
		$http.get(url)
			.success(function(data, status, headers, config) {
				console.log(data);
				if (data && data.r == 1) {
					var page = data.page;
					pageDao.init($scope, page);

					var data = data.data || [];
					if (data.length > 0) {
						for (var i = 0; i < data.length; i++) {
							$scope.statdate[i] = data[i].statdate;
							$scope.pv[i] = data[i].pv||'0';
							$scope.uv[i] = data[i].uv||'0';
							$scope.click[i] = data[i].click||'0';
							$scope.staytime[i] = data[i].staytime||'0';
							$scope.lostnum[i] = data[i].lostnum||'0';
							$scope.scid[i] = data[i].scid||'';
						}
						$scope.$broadcast('to-child', $scope);
						console.log($scope);
					}

				}

			});
	}

	return dao;
});