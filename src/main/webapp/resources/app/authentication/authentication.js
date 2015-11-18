/**
 * Created by alext on 11/11/2015.
 */
(function () {
    'use strict';
    angular.module('app.authentication')
        .controller('LoginController', loginController)
        .config(configure);

    loginController.$inject = ['$rootScope', '$http', '$state'];
    function loginController($rootScope, $http, $state) {
        var vm = this;
        vm.login = login;
        vm.loginError = false;

        $rootScope.authenticated = false;

        var authenticate = function (credentials, callback) {
            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.email + ":" + credentials.password)
            } : {};

            $http.get('api/users/current', {headers: headers}).success(function (data) {
                $rootScope.authenticated = true;
                $rootScope.currentUser = data;
                callback && callback();
            }).error(function () {
                $rootScope.currentUser = null;
                $rootScope.authenticated = false;
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

    configure.$inject = ['$httpProvider'];
    function configure($httpProvider) {
        configureHttpProvider();

        function configureHttpProvider() {
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            $httpProvider.interceptors.push(responseError);

            responseError.$inject = ['$q', '$injector'];
            function responseError($q, $injector) {
                return {
                    'responseError': function (rejection) {
                        var status = rejection.status;
                        if (status == 401) {
                            $rootScope.authenticated = false;
                            $rootScope.currentUser = null;
                            $injector.get('$state').go("root.login");
                        }
                        return $q.reject(rejection);
                    }
                };
            }
        }
    }

})();
