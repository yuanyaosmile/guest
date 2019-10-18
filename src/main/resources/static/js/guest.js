'use strict'
var myApp = angular.module('myApp', ['ngMaterial', 'wui.date']);

myApp.controller('DemoController', function ($scope, $http) {

    $scope.add = function () {
        //$scope.flag = true;
        console.log($scope.user)
        $http.post("http://localhost:10086/add", $scope.user).then(function (response) {
            console.log($scope.user);
            $scope.flag = true;
        }, function (error) {
            console.log($scope.user);
        });
    }
});