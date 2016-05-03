app.controller('ClickCtrl', function($scope, $timeout, showChartSer, $location, $rootScope) {
    console.log("ClickCtrl:"+$scope);
    var datas={};
    $scope.$on('to-child', function(event,data) {
        datas=data;
        $scope.labels = datas.statdate;//横坐标
        $scope.series = ['Click'];
        $scope.data = [
            datas.click

        ];

    });

});;app.controller('LostNumCtrl', function($scope, $timeout, showChartSer, $location, $rootScope) {
    console.log("LostNumCtrl:"+$scope);
    var datas={};
    $scope.$on('to-child', function(event,data) {
        datas=data;
        $scope.labels = datas.statdate;//横坐标
        $scope.series = ['LostNum'];
        $scope.data = [
            datas.lostnum

        ];

    });

});;app.controller('PVUVCtrl', function($scope, $timeout, showChartSer, $location, $rootScope) {
    console.log("PVUVCtrl:"+$scope);
    var datas={};
    $scope.$on('to-child', function(event,data) {
        datas=data;
        $scope.labels = datas.statdate;//横坐标
        $scope.series = ['PV', 'UV'];
        $scope.data = [
            datas.pv,
            datas.uv
        ];

    });

});;app.controller('StayTimeCtrl', function($scope, $timeout, showChartSer, $location, $rootScope) {
    console.log("StayTimeCtrl:"+$scope);
    var datas={};
    $scope.$on('to-child', function(event,data) {
        datas=data;
        $scope.labels = datas.statdate;//横坐标
        $scope.series = ['StayTime'];
        $scope.data = [
            datas.staytime

        ];

    });

});;app.controller('TestPieCtrl', function($scope, $timeout, showChartSer, $location, $rootScope) {
    console.log("TestDoughnutCtrl:"+$scope);
    var datas={};
    $scope.$on('to-child', function(event,data) {
        datas=data;
        $scope.labels =["PV","UV"];//横坐标

        $scope.data = [
           200,
            200
        ];

    });

});;app.controller('showChartCtrl', function($scope, $timeout, showChartSer, $location) {

	$scope.confid = $location.search().confid || '';

	showChartSer.getData($scope);

});;app.controller('confAddCtrl', function($scope, confMngSer,proMngSer,groupSer) {
//	获取所有的项目和分组
	 function getProAndGroup(){
		 proMngSer.getlist($scope);
		 groupSer.list($scope);
	 };
	getProAndGroup();
	$scope.add = function() {
		confMngSer.add($scope);
	};
});;app.controller('confListCtrl', function($scope, confMngSer) {
	function list() {
		confMngSer.list($scope);
	};
	$scope.list = list;
	list();
    $scope.del=function(id){
    	confMngSer.del(id,$scope);
    };
});;app.controller('confUpdCtrl', function($scope, $rootScope,$location,confMngSer,groupSer) {
//获取分组
	 groupSer.list($scope);


//	传入的对象

    $scope.oldconf=$location.search();
    $scope.conf=eval("("+$scope.oldconf.conf+")");
   
//  回填的对象
    $scope.pro={id:($scope.conf.pid||''),name:($scope.conf.pname||'')};
    $scope.group={id:($scope.conf.mgid||''),name:($scope.conf.mname||'')};

//修改
	$scope.upd=function(){
		confMngSer.upd($scope);
	}

});;app.controller('groupAddCtrl', function($scope, groupSer,proMngSer) {
	//$scope.pro={};
//	获取所有的项目
	
		 proMngSer.getlist($scope);

	$scope.add = function() {
		groupSer.add($scope);
	};
});;app.controller('groupListCtrl', function($scope, groupSer) {
	function list(){
		groupSer.list($scope);
	 };
	 $scope.list = list;
	 list();
	 //分组删除
	 $scope.del=function(id){
	 	groupSer.del(id, $scope);
	 };
	 
});;app.controller('groupUpdCtrl', function($scope, $rootScope,$location,groupSer) {
	var search=$location.search();
	$scope.group=eval("("+search.group+")");	
console.log($scope.group);
		
	$scope.oldgroup=$location.search();
	$scope.upd=function(){
		groupSer.upd($scope);
	}

//	$scope.goupd = function() {
//			proMngSer.goupd($location.search());
//		}
});;app.controller('menuCtrl', function($scope, proMngSer, groupSer, confMngSer,$location) {
	//项目列表 一级菜单
	function list() {
		proMngSer.getlist($scope);
	};
     list();
   //项目下分组列表 二级菜单
	$scope.tab = 0;
	$scope.menuToggle = function(proid) {
		$scope.menuProId=proid;
		//通过proid查分组
		groupSer.list($scope);

		if ($scope.tab == 0) {
			$scope.tab = proid;
		} else {
			$scope.tab = 0;
		}

	};
   
   //分组下配置列表 三级菜单
	$scope.grouptab = 0;
	$scope.groupToggle = function(groupid) {
		$scope.menuGroupId=groupid;
		//通过proid查分组
		confMngSer.list($scope);

		if ($scope.grouptab == 0) {
			$scope.grouptab = groupid;
		} else {
			$scope.grouptab = 0;
		}

	}

	

});;app.controller('proAddCtrl', function($scope, proMngSer) {
	//$scope.pro={};
	$scope.add = function() {
		proMngSer.add($scope);
	};
	$scope.checkcode=function(){
		proMngSer.checkcode($scope);
	}
});;app.controller('proListCtrl', function($scope, proMngSer) {
	//获得项目列表
	function list() {
		proMngSer.getlist($scope);
	};
	$scope.list = list; //查询调用list刷新数据
	list();
	
	//项目删除
	$scope.del = function(id) {
		proMngSer.del(id, $scope);
	};


});;app.controller('proUpdCtrl', function($scope, $rootScope,$location,proMngSer) {
	$scope.pro=$location.search();
	$scope.oldpro=$location.search();
	$scope.upd=function(){
		proMngSer.upd($scope);
	}


});