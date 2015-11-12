/**
 * Created by alext on 11/11/2015.
 */
(function () {
    'use strict';
    angular.module('app.authentication')
        .controller('Authentication', authentication);

    authentication.$inject = ['$http', '$rootScope'];

    function authentication($http) {
        var vm = this;
        vm.login = login;
        vm.loginError = false;

        function login() {
            $http.post('/api/users/authenticate', {email: vm.email, password: vm.password})
                .then(successCb, errorCb);

            function successCb(data) {
                alert(data);
                vm.loginError = false;
            }

            function errorCb() {
                vm.loginError = true;
            }
        }

    }
})();
