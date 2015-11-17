/**
 * Created by alex on 15/11/15.
 */
(function () {
    'use strict';
    angular.module('app.home')
        .config(configure);

    configure.$inject = ['$stateProvider'];

    function configure($stateProvider) {
        $stateProvider.state(
            'root', {
                url: '/',
                views: {
                    'header@': {
                        templateUrl: '/resources/app/navbar/navbar.html',
                        controller: 'NavBarCtrl',
                        controllerAs: 'vm'
                    }
                }
            }
        )
    }
})();