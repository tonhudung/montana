/**
 * Created by alex on 5/11/15.
 */
(function () {
    'use strict';
    var core = angular.module('app.core');
    core.config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider', 'stateHelperConfigProvider'];

    function configure($stateProvider, $urlRouterProvider, stateHelperConfigProvider) {

        configureRouting();

        function configureRouting() {
            var routeCfg = stateHelperConfigProvider;
            routeCfg.config.$stateProvider = $stateProvider;
            routeCfg.config.$urlRouterProvider = $urlRouterProvider;
            routeCfg.config.docTitle = 'CC: ';
        }
    }

})();