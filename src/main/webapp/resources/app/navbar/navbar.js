/**
 * Created by Alex To on 11/13/2015.
 */
(function () {
    'use strict';
    angular.module('app.navbar')
        .controller('NavBarController', navBarController)

    navBarController.$inject = ['$rootScope'];
    function navBarController($rootScope) {
        var vm = this;
    }
})();