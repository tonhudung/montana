/**
 * Created by alext on 11/11/2015.
 */
(function () {
    'use strict';
    angular.module('app.authentication')
        .controller('LoginCtrl', loginCtrl);

    loginCtrl.$inject = ['$rootScope', '$http', '$state'];

    function loginCtrl($rootScope, $http, $state) {
        var vm = this;
        vm.login = login;
        vm.loginError = false;

        var authenticate = function (credentials, callback) {
            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.email + ":" + credentials.password)
            } : {};

            $http.get('api/users/current', {headers: headers}).success(function (data) {
                $rootScope.currentUser = !!data;
                callback && callback();
            }).error(function () {
                $rootScope.currentUser = null;
                callback && callback();
            });

        };

        function login() {
            authenticate(vm, function () {
                if ($rootScope.currentUser) {
                    $state.go("root");
                    vm.loginError = false;
                } else {
                    $state.go("root.login");
                    vm.loginError = true;
                }
            });
        }
    }
})();
