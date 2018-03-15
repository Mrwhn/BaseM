var actionApp = angular.module('actionApp',['ngRoute']);
    //依赖路由模块ngRoute
actionApp.config(['$routeProvider' , function($routeProvider) {
    $routeProvider.when('/oper', {
        controller: 'View1Controller',
        templateUrl: 'view1.html'
    }).when('/directive', {
        controller: 'View2Controller',
        templateUrl: 'view2.html'
    });
}]);