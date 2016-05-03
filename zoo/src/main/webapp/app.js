var app = angular.module('app', ['ngRoute', 'ngResource', 'chart.js','ngAnimate']);
app.config(function($routeProvider, $httpProvider) {
	/*初始化时，header头如果获取不到，则给它赋值为{}*/
	if (!$httpProvider.defaults.headers.get) {
		$httpProvider.defaults.headers.get = {};
	}
	/*禁用IE对ajax的缓存--特别重要*/
	$httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
	$httpProvider.defaults.headers.get['Pragma'] = 'no-cache';

	$routeProvider
	.when('', {
			templateUrl: '<div></div>',
			controller: 'menuCtrl'
		})
	//	项目列表
		.when('/proList', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/pro/proList.html',
			controller: 'proListCtrl'
		})
		//  项目增加
		.when('/proAdd', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/pro/proAdd.html',
			controller: 'proAddCtrl'
		})
		//		项目修改
		.when('/proUpd', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/pro/proUpd.html',
			controller: 'proUpdCtrl'
		})
		//		分组列表
		.when('/groupList', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/group/groupList.html',
			controller: 'groupListCtrl'
		})
		//  分组增加
		.when('/groupAdd', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/group/groupAdd.html',
			controller: 'groupAddCtrl'
		})
		//		分组修改
		.when('/groupUpd', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/group/groupUpd.html',
			controller: 'groupUpdCtrl'
		})
		//		配置管理列表
		.when('/confList', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/conf/confList.html',
			controller: 'confListCtrl'
		})
		//		配置增加
		.when('/confAdd', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/conf/confAdd.html',
			controller: 'confAddCtrl'
		})
		//		配置修改
		.when('/confUpd', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/conf/confUpd.html',
			controller: 'confUpdCtrl'
		})
		//		展示图表 示例
		.when('/showChart', {
			templateUrl: 'statics/assets/awifi/md/1.0.1/showChart.html',
			controller: 'showChartCtrl'
		})
		.otherwise({
			redirectTo: '/'
		});
});