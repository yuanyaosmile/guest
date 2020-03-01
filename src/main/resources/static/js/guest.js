'use strict'
var myApp = angular.module('myApp', ['ngMaterial', 'wui.date']);

myApp.controller('DemoController', function ($scope, $http) {
    $scope.showInput = false;
    $scope.add = function () {
        alert("确定提交吗？");
        console.log($scope.user)
        $http.post("/add", $scope.user).then(function success(response) {
            console.log("success");
            $scope.showInput = true;
            console.log($scope.showInput);
        }, function error(error) {
            //alert("出错啦！");
            var errorInfo = error.data;
            console.log(error);
            console.log(errorInfo);
        });
    }
});

myApp.directive('guest',function ($q, $http) {
    return {
        require : 'ngModel',
        link : function (scope, ele, attr, ctrl) {
            ctrl.$validators.username = function (modelValue, viewValue) {
                if (modelValue){
                    return modelValue.length > 0 ? true : false;
                }
                return false;
            }
        }
    }
});

myApp.directive('phone',function ($q, $http) {
    var focusClass = 'ng-focused';
    return {
        restrict:'AE',
        require : 'ngModel',
        link : function (scope, element, attr, ctrl) {
            ctrl.$focused = false;
            element.bind('focus',function(e){
                element.addClass(focusClass);
                scope.$apply(function(){
                    ctrl.$focused = true;
                });
                element.bind('blur',function(e){
                    element.removeClass(focusClass);
                    scope.$apply(function(){
                        ctrl.$focused = false;
                    });
                });
            })

        }
    }
});