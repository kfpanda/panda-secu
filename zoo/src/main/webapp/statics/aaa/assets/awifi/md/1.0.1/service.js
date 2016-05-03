app.factory('confMngSer', function($rootScope, confMngDao) {
	var service = {};
	//  配置列表
	service.list = function($scope) {
		confMngDao.list($scope);
	};
	//  配置增加
	service.add = function($scope) {
		confMngDao.add($scope);
	};

	//配置修改
	service.upd = function($scope) {
		confMngDao.upd($scope);
	};
	//配置删除
	service.del = function(id,$scope) {
		console.log(id);
		confMngDao.del(id,$scope);
	};

	return service;
});;app.factory('groupSer',function($rootScope, groupDao){
    var service = {};
//  分组列表
service.list=function($scope){
	groupDao.list($scope);
};

//分组增加    
service.add=function($scope){
	groupDao.add($scope);
};

//分组删除
service.del=function(id,$scope){
	groupDao.del(id,$scope);
};

 //分组修改
  service.upd=function($scope){
    	groupDao.upd($scope);
   };
//验证name重复
	service.checkname = function($scope) {
		groupDao.checkname($scope);
	};
   
    return service; 
});;app.factory('proMngSer', function($rootScope, proMngDao) {
	var service = {};
	//项目列表
	service.getlist = function($scope) {
		proMngDao.getlist($scope);
	};
	//项目增加    
	service.add = function($scope) {
		proMngDao.add($scope);
	};
	//项目删除    
	service.del = function(id, $scope) {
		proMngDao.del(id, $scope);
	};
	//项目修改
	service.upd = function($scope) {
		proMngDao.upd($scope);
	};
	//验证code重复
	service.checkcode = function($scope) {
		proMngDao.checkcode($scope);
	};
	return service;
});;app.factory('showChartSer',function($rootScope, showChartDao){
    var service = {};
      service.getData=function($scope){
      	showChartDao.getData($scope);
      }
    return service; 
});