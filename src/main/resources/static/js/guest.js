'use strict'
var myApp = angular.module('myApp', ['ngMaterial', 'wui.date']);

myApp.controller('DemoController', function ($scope, $http) {
    $scope.showInput = true;
    $scope.add = function () {
        console.log($scope.user)
        $http.post("http://localhost:10086/add", $scope.user).then(function success(response) {
            //console.log($scope.user);
            //console.log(response.data);
            //var res = response.data;
            console.log("success");
            $scope.showInput = false;
            console.log($scope.showInput);
        }, function error(error) {

            console.log("error");
        });
    }
});