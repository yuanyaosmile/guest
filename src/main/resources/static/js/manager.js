'use strict'
var myApp = angular.module('myApp', ['ngMaterial']);

myApp.controller("ManagerController", function ($scope, $http) {
    $scope.Auth = false;
    $scope.login = function () {
        console.log($scope.manager);
        $http.post("/admin/login", $scope.manager).then(function success(response) {
            console.log(response.data)
            $scope.Auth = true;
        }, function error(error) {

        });
    };

    $scope.showAll = false;
    $scope.res = null;

    $scope.selectAll = function () {
        console.log("---查询所有来访信息");
        $http.get("/admin/getAll").then(function success(response) {
            console.log("success");
            console.log(response.data);
            $scope.res = response.data;
            $scope.showAll = true;
        },function error(reason) {
            console.log("error");
        });
    }

    $scope.selectByName = function (name) {
        console.log("按姓名查询");
        $http.get("/admin/name",{params:{"name":name}}).then(function success(value) {
            console.log(value.data);
            $scope.showAll = true;
            $scope.res = value.data;
        },function error(reason) {

        });
    }

    $scope.showEmails = false;

    $scope.checkEmails = function () {
        console.log("查询配置信息");
        $http.get("/admin/getEmails").then(function success(response) {
            $scope.showEmails = true;
            console.log("得到配置信息");
            var emails = response.data;
            $scope.sender = emails[0];
            $scope.receiver = emails[1];
        },function error(reason) {

        });
    }


    $scope.updateSender = function (senderEmail) {
        $http.post("/admin/updateSender",senderEmail,{params:{"name":senderEmail}}).then(function (value) {
            console.log("-----");
            alert("更新成功！");
        },function (reason) {

        });
    }

    $scope.updateReceiver = function (receiverEmail) {
        $http.post("/admin/updateReceiver",receiverEmail,{params:{"name":receiverEmail}}).then(function (value) {
            console.log("-----");
            alert("更新成功！");
        },function (reason) {

        });
    }
});