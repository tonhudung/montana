/**
 * Created by alex on 5/11/15.
 */

(function () {
    'use strict';
    var core = angular.module('app.core');
    core.config(configure);

    configure.$inject = ['$stateProvider', '$urlRouteProvider'];

    function configure($stateProvider) {
        $stateProvider
            .state(home)
            .state(profile);

        var home = {
            url: '/',
            controller: 'HomeController',
            controllerAs: 'home',
            templateUrl: '/resources/app/home/home.html'
        };
        var profile = {
            url: '/{username}',
            controller:'ProfileController',
            controllerAs: 'profile',
            template: ''
        };
    }

})();