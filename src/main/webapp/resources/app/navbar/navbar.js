/**
 * Created by Alex To on 11/13/2015.
 */
(function () {
    'use strict';
    angular.module('app.navbar')
        .controller('NavBarCtrl', navBarCtrl)

    navBarCtrl.$inject = ['$rootScope'];

    function navBarCtrl($rootScope) {
        var vm = this;
        vm.loggedIn = $rootScope.currentUser;
        vm.userName = $rootScope.currentUser.user_name;
        vm.firstName = $rootScope.currentUser.first_name;
    }
})();