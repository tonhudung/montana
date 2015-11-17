/**
 * Created by alex on 15/11/15.
 */
(function(){
    'use strict';
    angular.module('app')
        .run(initialize)
        .config(configure);

    initialize.$inject = ['$rootScope', '$state', '$stateParams'];

    function initialize($rootScope, $state, $stateParams)
    {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];

    function configure($urlRouterProvider)
    {
        $urlRouterProvider.otherwise('/');
    }
})();