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

            console.log("error");
        });
    }
});